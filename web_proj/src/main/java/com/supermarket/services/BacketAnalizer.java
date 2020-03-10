package com.supermarket.services;

import com.supermarket.enums.Preferences;
import com.supermarket.models.ProductUnit;
import com.supermarket.models.User;

import java.util.ArrayList;
import java.util.List;

public class BacketAnalizer {

    public List<String> analize(User customer, List<ProductUnit> purchases) {
        List<String> warnings = new ArrayList<>();
        for (ProductUnit item:purchases) {
            for (Preferences pref: item.getProductInfo().getProdProperties()) {
                if (customer.getPreferences().contains(pref)) {
                    warnings.add("Внимание, продукт " + item.getProductInfo().getName()
                            + "подпадает под " + pref);
                }
            }
        }
        return warnings.size() > 0? warnings : null;
    }
}
