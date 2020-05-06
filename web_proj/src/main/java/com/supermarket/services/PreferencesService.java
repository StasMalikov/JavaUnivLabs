package com.supermarket.services;

import com.supermarket.domain.SupermarketUser;
import com.supermarket.domain.UserPreferences;
import com.supermarket.domain.preferences.CaloriesPreference;
import com.supermarket.domain.preferences.Preference;
import com.supermarket.repos.SupermarketUserRepo;
import com.supermarket.repos.UserPreferencesRepo;
import com.supermarket.repos.preferences.AlcoholPreferenceRepo;
import com.supermarket.repos.preferences.CaloriesPreferenceRepo;
import com.supermarket.repos.preferences.PropertyPreferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreferencesService {

    private AlcoholPreferenceRepo alcoholPreferenceRepo;
    private CaloriesPreferenceRepo caloriesPreferenceRepo;
    private PropertyPreferenceRepo propertyPreferenceRepo;
    private UserPreferencesRepo userPreferencesRepo;
    private SupermarketUserRepo supermarketUserRepo;

    @Autowired
    public PreferencesService(AlcoholPreferenceRepo alcoholPreferenceRepo,
                              CaloriesPreferenceRepo caloriesPreferenceRepo,
                              PropertyPreferenceRepo propertyPreferenceRepo,
                              UserPreferencesRepo userPreferencesRepo,
                              SupermarketUserRepo supermarketUserRepo){

        this.alcoholPreferenceRepo = alcoholPreferenceRepo;
        this.caloriesPreferenceRepo = caloriesPreferenceRepo;
        this.propertyPreferenceRepo = propertyPreferenceRepo;
        this.userPreferencesRepo = userPreferencesRepo;
        this.supermarketUserRepo = supermarketUserRepo;
    }

    public void addCaloriesPreference(int minC, int maxC, SupermarketUser supermarketUser) {
        CaloriesPreference preference =  caloriesPreferenceRepo.save(new CaloriesPreference(minC, maxC));
        addPreference(preference, supermarketUser);
    }

    private void addPreference(Preference preference, SupermarketUser supermarketUser) {
        UserPreferences userPreferences = userPreferencesRepo.findByUser(supermarketUser);
        if(userPreferences == null){
            userPreferences = userPreferencesRepo.save(new UserPreferences(supermarketUser));
            supermarketUser.setUserPreferences(userPreferences);
            supermarketUserRepo.save(supermarketUser);
        }
        userPreferences.addPreference(preference);
        userPreferencesRepo.save(userPreferences);
    }

    public void deletePreference(Long preference_id, SupermarketUser supermarketUser) {
        Preference preference = caloriesPreferenceRepo.findById(preference_id).get();
        UserPreferences userPreferences = userPreferencesRepo.findByUser(supermarketUser);
        if(userPreferences != null) {
            userPreferences.deletePreference(preference);
            userPreferencesRepo.save(userPreferences);
        }
    }

    public List<Preference> getPreferences(SupermarketUser supermarketUser){
        List<Preference> result = new ArrayList<>();
        UserPreferences preferences = userPreferencesRepo.findByUser(supermarketUser);
        if (preferences != null){
            result.addAll(preferences.getPreferences());
            return result;
        }
        return null;
    }

    public CaloriesPreference getCalories(List<Preference> list){
        for(Preference p : list){
            if(p instanceof CaloriesPreference){
                return (CaloriesPreference) p;
            }
        }
        return null;
    }

}
