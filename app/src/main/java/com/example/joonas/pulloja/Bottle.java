package com.example.joonas.pulloja;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bottle {

    private static Bottle pullondeerus = new Bottle();
    public static Bottle getInstance(){
        return pullondeerus;
    }

    private int bottles;
    private double money;
    private String name;
    private String manu;
    private double total_energy;
    private double size;
    private double prize;
    private int valinta;
    private String rahat;
    float result;


    public ArrayList<Pulloja> pullo_array;
    public ArrayList<String> pullo_lista;

    public Bottle() {
        money = 0;
        bottles = 5;
        pullo_array = new ArrayList<Pulloja>();
        pullo_lista = new ArrayList<String>();
        pullo_lista.add("Choose Cateory");
        for (int i = 0; i <= bottles; i++) {
            if (i < 1) {
                name = "Pepsi Max";
                manu = "Pepsi";
                total_energy = 1;
                if (i < 1) {
                    size = 0.5;
                    prize = 1.80;
                } else {
                    size = 1.5;
                    prize = 2.2;
                }
            } else if (i < 2) {
                name = "Coca-Cola Zero";
                manu = "Coca-Cola";
                total_energy = 1;
                if (i < 3) {
                    size = 0.5;
                    prize = 2.00;
                } else {
                    size = 1.5;
                    prize = 2.5;
                }
            } else {
                name = "Fanta Zero";
                manu = "Coca-Cola";
                total_energy = 1;
                size = 0.5;
                prize = 1.95;
            }
            pullo_array.add(i, new Pulloja(name, manu, total_energy, size, prize));
            pullo_lista.add(name+" "+prize+"€");
        }
    }

    public ArrayList getlista(){
        return pullo_lista;

    }

    public void addMoney(double luku) {
        money += luku;
        System.out.println("Klink! Lisää rahaa laitteeseen!");
    }

    public int buyBottle(int luku) {
        valinta = luku;
        if (money <= 0) {
            return 0;
        } else if (money <= pullo_array.get(valinta).getPrize()) {
            return 0;

        } else {
            pullo_array.remove(valinta);
            pullo_lista.remove(valinta+1);
            money -= pullo_array.get(valinta).getPrize();
            return 1;

        }
    }


    public void returnMoney() {
        money = 0;
        System.out.println("KlinkKlink! Sinne menivät rahat!");
    }

    public void listBottle() {
        for (int i = 0; i <= bottles; i++) {
            System.out.println(i + 1 + ". Nimi: " + pullo_array.get(i).getName());
            System.out.print("\tKoko: " + pullo_array.get(i).getSize());
            System.out.println("\tHinta: " + pullo_array.get(i).getPrize());
        }


    }
    public String getMoney(){
        rahat =  Double.toString(money);
        DecimalFormat df = new DecimalFormat("####0.00");
        rahat = df.format(money);
        return rahat;

    }
}
