package com.supermarket.domain.enums;

public enum ProdType {
    MEAT("мясной продукт"),
    MILK("молочный продукт"),
    BREAD("хлебобулочное изделие"),
    VEGETABLES("овощи"),
    CHEMISTRY_FOR_HOME("бытовая химия"),
    ALCOHOL("алкоголь");

    private String russianValue;
    ProdType(String russianValue) {this.russianValue = russianValue;}

    public String getRussianValue(){return  russianValue;}

    public ProdType getTypeOnValue(String russianValue){
        switch (russianValue) {
            case "мясной продукт":
                return ProdType.MEAT;
            case "молочный продукт":
                return ProdType.MILK;
            case "хлебобулочное изделие":
                return ProdType.BREAD;
            case "овощи":
                return ProdType.VEGETABLES;
            case "бытовая химия":
                return ProdType.CHEMISTRY_FOR_HOME;
            case "алкоголь":
                return ProdType.ALCOHOL;
        }
        return null;
    }
}
