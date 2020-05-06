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
        if (supermarketUser.getUserPreferences() == null) {
            supermarketUser.setUserPreferences(userPreferencesRepo.save(new UserPreferences(supermarketUser)));
        }

        supermarketUser.getUserPreferences().getPreferences().add(preference);
        userPreferencesRepo.save(supermarketUser.getUserPreferences());
    }

    public void deletePreference(Long preference_id, SupermarketUser supermarketUser) {
        supermarketUser.getUserPreferences().getPreferences().remove(caloriesPreferenceRepo.findById(preference_id).get());
        userPreferencesRepo.save(supermarketUser.getUserPreferences());
    }

    public List<Preference> getPreferences(SupermarketUser supermarketUser){
        List<Preference> result = new ArrayList<>();
        if (supermarketUser.getUserPreferences() == null) {
            supermarketUser.setUserPreferences(userPreferencesRepo.save(new UserPreferences(supermarketUser)));
            result.addAll(supermarketUserRepo.save(supermarketUser).getUserPreferences().getPreferences());
        } else {
            result.addAll(supermarketUser.getUserPreferences().getPreferences());
        }

        return result;
    }

    public boolean haveCalorie(SupermarketUser supermarketUser){
        List<Preference> list = new ArrayList<>();
        if (supermarketUser.getUserPreferences() == null) {
            supermarketUser.setUserPreferences(userPreferencesRepo.save(new UserPreferences(supermarketUser)));
            supermarketUserRepo.save(supermarketUser);
        }
        list.addAll(supermarketUser.getUserPreferences().getPreferences());
        for(Preference p : list){
            if(p instanceof CaloriesPreference){
                return true;
            }
        }
        return false;
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
