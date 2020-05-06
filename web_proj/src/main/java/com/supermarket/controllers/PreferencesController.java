package com.supermarket.controllers;

import com.supermarket.domain.SupermarketUser;
import com.supermarket.domain.preferences.CaloriesPreference;
import com.supermarket.domain.preferences.Preference;
import com.supermarket.services.PreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/preferences")
@PreAuthorize("hasAuthority('USER')")
public class PreferencesController {

    @Autowired
    PreferencesService preferencesService;

    @GetMapping("/")
    public String getPreferences(@AuthenticationPrincipal SupermarketUser user, Map<String, Object> model) {
           List<Preference> preferences = preferencesService.getPreferences(user);
           if(preferences.size() == 0) {
               model.put("messageNoPreferences", ".");
           } else {
               CaloriesPreference c = preferencesService.getCalories(preferences);
               if(c != null){
                   model.put("caloriesPreference", c);
               }
           }
        return "preferences";
    }

    @PostMapping("/add_calories")
    public String addCalories(@AuthenticationPrincipal SupermarketUser user,
                              @RequestParam String min, @RequestParam String max,
                              Map<String, Object> model){

        if("".equals(max) && "".equals(min)){
            model.put("messageBadCalories", ".");
        }else{
            if(max.equals(""))
                max = "0";

            if(min.equals(""))
                min = "0";
            if(preferencesService.haveCalorie(user)){

            } else {
                preferencesService.addCaloriesPreference(Integer.valueOf(min), Integer.valueOf(max) , user);
            }
        }

        List<Preference> preferences =  preferencesService.getPreferences(user);
        if(preferences.size() == 0) {
            model.put("messageNoPreferences", ".");
        } else {
            CaloriesPreference c = preferencesService.getCalories(preferences);
            if(c != null){
                model.put("caloriesPreference", c);
            }
        }

        return "preferences";
    }

}
