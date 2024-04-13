package edu.innotech;

import java.util.ArrayList;
import java.util.List;

public final class SaveAccount {
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void copyAccount(Account accIn) {
        Account tmpAccount = new Account(accIn.getName());
        List<Currency> tmpListCurrency = new ArrayList<>();
        for (Currency cur:accIn.getlistCurrency()){
            Currency tmpCur = new Currency(null,null);
            tmpCur.setQuantity(cur.getQuantity());
            tmpCur.setVidCurrency(cur.getVidCurrency());
            tmpListCurrency.add(tmpCur);
        }
        tmpAccount.setlistCurrency(tmpListCurrency);
        this.account = tmpAccount;

    }

    public void beakAccount(Account accIn) {
        accIn.setName(this.account.getName());
        List<Currency> tmpListCurrency = new ArrayList<>();
        for (Currency cur:this.account.getlistCurrency()){
            Currency tmpCur = new Currency(null,null);
            tmpCur.setQuantity(cur.getQuantity());
            tmpCur.setVidCurrency(cur.getVidCurrency());
            tmpListCurrency.add(tmpCur);
        }
        accIn.setlistCurrency(tmpListCurrency);
    }
}