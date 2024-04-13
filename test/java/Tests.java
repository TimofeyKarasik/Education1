//package edu.innotech;
import edu.innotech.SaveAccount;
import org.junit.jupiter.api.Test;
import edu.innotech.Account;
import edu.innotech.Currency;

public class Tests {

    @Test
    public void testAccountNotNull() {
        String name = "Вася";
        try {
            Account tmpAccount = new Account(name);
            System.out.println("testAccountNotNull Account создан");

        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testAccountNull() {
        String name = null;
        try {
            Account tmpAccount = new Account(name);

        } catch (NullPointerException e) {
            System.out.println("testAccountNull Исключение пустое имя");
        }
    }

    @Test
    public void testCurrencyQuantity() {
        String name = null;
        Currency tmpCurrency = new Currency("810",12);
        tmpCurrency.setQuantity(82);
        System.out.println("testCurrencyQuantity положительная сумма Успех");
        try {
            tmpCurrency.setQuantity(-25);

        } catch (IllegalArgumentException e) {
            System.out.println("testCurrencyQuantity Исключение отрицательная сумма Успех");
        }
    }

    @Test
    public void testUndo() {
        Account acc = new Account("Вася");
        Currency cur = new Currency("810",0);
        cur.setVidCurrency("810");
        cur.setQuantity(100);
        acc.setCurrency(cur);
        acc.setName("Петя");
        cur.setVidCurrency("810");
        cur.setQuantity(300);
        acc.setCurrency(cur);
        acc.undo();
        acc.undo();
        acc.undo();
        System.out.println("testUndo успех");
    }

    @Test
    public void testCopyAndBeak() {
        Account acc = new Account("Вася");
        Currency cur = new Currency("810",0);
        SaveAccount accCopy = new SaveAccount();
        cur.setVidCurrency("810");
        cur.setQuantity(100);
        acc.setCurrency(cur);
        accCopy.copyAccount(acc);
        System.out.println("testCopy успешен");
        acc.setName("Федя");
        accCopy.beakAccount(acc);
        System.out.println("testBeak успешен");
    }
}
