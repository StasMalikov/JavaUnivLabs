package com.supermarket.domain.preferences;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.IOException;

@Data
@Entity
public class JSONPreference {

    @Id
    @Column(name = "preference_id")
    protected String id;

    private String response;

    public JSONPreference(String id, Preference preference) throws JsonProcessingException {
        this.id = id;
        ObjectMapper mapper = new ObjectMapper();
        response =  mapper.writeValueAsString(preference);
    }

    public JSONPreference(){}

    public Preference getPreference() throws IOException {
        JSONObject preferenceJson = new JSONObject(response);
        ObjectMapper mapper = new ObjectMapper();
        String type = preferenceJson.getString("preferenceType");
        Preference preference = null;

        switch (type)
        {
            case "AlcoholPreference":{
                preference = mapper.readValue(response, AlcoholPreference.class);
                break;
            }

            case "CaloriesPreference":{
                preference = mapper.readValue(response,  CaloriesPreference.class);
                break;
            }

            case "PropertyPreference":{
                preference = mapper.readValue(response, PropertyPreference.class);
                break;
            }
        }

        return  preference;
    }
}
