package edu.innotech;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String nameClient;
    private List<Currency> listCurrency = new ArrayList<>();
    private List<Account> bekUpAccount = new ArrayList<>();

    public Account(String nameClientIn)
    {
        Currency tmpCurrency = new Currency("810",0);
        if (nameClientIn == null || nameClientIn == ""){
            throw new NullPointerException();
        }
        nameClient = nameClientIn;
        listCurrency.add(tmpCurrency);
    }



    public String getName() {

        return nameClient;
    }

    public List<Currency> getlistCurrency() {

        return listCurrency;
    }

    public void setName(String nameClientIn) {
        if (nameClientIn == null || nameClientIn == ""){
            throw new NullPointerException();
        }
        this.addBekUp();
        this.nameClient = nameClientIn;
    }

    public void setlistCurrency(List<Currency> listCurrencyIn) {

        this.listCurrency = listCurrencyIn;
    }

    public void setCurrency(Currency currencyIn) {

        for (Currency tmpCur:this.listCurrency){
           if (tmpCur.getVidCurrency() == currencyIn.getVidCurrency()){
               this.addBekUp();
               tmpCur.setQuantity(currencyIn.getQuantity());
               return;
           }
        }
        this.addBekUp();
        this.listCurrency.add(currencyIn);
    }

    public void addBekUp()  {
        Account cloneAccount = new Account(this.nameClient);
        List<Currency> cloneListCurrency = new ArrayList<>();
        for (Currency cur: this.listCurrency){
            Currency tmpCur = new Currency(null,null);
            tmpCur.setQuantity(cur.getQuantity());
            tmpCur.setVidCurrency(cur.getVidCurrency());
            cloneListCurrency.add(tmpCur);

        }
        cloneAccount.listCurrency = cloneListCurrency;
        bekUpAccount.add(cloneAccount);
    }

    public void undo(){
        if (bekUpAccount.isEmpty()){
            throw new IllegalArgumentException("Не куда откатывать");
        }
        if (this.nameClient != bekUpAccount.get(bekUpAccount.size() - 1).nameClient){
            this.nameClient =  bekUpAccount.get(bekUpAccount.size() - 1).nameClient;
            bekUpAccount.remove(bekUpAccount.size() - 1);
            return;
        }
        this.listCurrency = bekUpAccount.get(bekUpAccount.size() - 1).listCurrency;
        bekUpAccount.remove(bekUpAccount.size() - 1);

    }

    public void printlnCurrency(){
        for (Currency cur: this.listCurrency){
            System.out.println("Валюта "+cur.getVidCurrency()+" сумма "+cur.getQuantity());
        }

    }

}
