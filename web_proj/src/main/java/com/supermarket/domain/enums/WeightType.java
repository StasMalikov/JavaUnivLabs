package com.supermarket.domain.enums;

public enum WeightType {
    PIECE("шт", 1),
    LITER("л", 0.1),
    KILOGRAM("кг", 0.1);

    private String russianValue;
    private double minValue;
    WeightType(String russianValue, double minValue){
        this.russianValue = russianValue;
        this.minValue = minValue;
    }

    public String getRussianValue(){return  russianValue;}

    public double getMinValue() {
        return minValue;
    }

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
