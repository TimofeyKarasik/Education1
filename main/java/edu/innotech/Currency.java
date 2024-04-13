package edu.innotech;

public class Currency {
    private String vidCurrency;
    private Integer quantity;

    public Currency(String vidCurrencyIn, Integer quantityIn){
        vidCurrency = vidCurrencyIn;
        quantity = quantityIn;
    }

    public String getVidCurrency() {

        return  this.vidCurrency;
    }

    public Integer getQuantity() {

        return this.quantity;
    }

    public void setVidCurrency(String vidCurrencyIn) {

        this.vidCurrency = vidCurrencyIn;
    }

    public void setQuantity(Integer quantityIn) {
        if (quantityIn < 0){
            throw new IllegalArgumentException("Количество валюты не может быть меньше нуля");
        }
        this.quantity = quantityIn;
    }


}
