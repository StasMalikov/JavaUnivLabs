package com.supermarket.domain.enums;

public enum WeightType {
    PIECE("шт"),
    LITER("л"),
    KILOGRAM("кг");

    private String russianValue;
    WeightType(String russianValue){
        this.russianValue = russianValue;
    }

    public String getRussianValue(){return  russianValue;}

    public WeightType getTypeOnValue(String russianValue){
        switch (russianValue) {
            case "шт":
                return WeightType.PIECE;
            case "л":
                return WeightType.LITER;
            case "кг":
                return WeightType.KILOGRAM;
        }
        return null;
    }
}
