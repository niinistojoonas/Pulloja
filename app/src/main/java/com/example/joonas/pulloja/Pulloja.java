package com.example.joonas.pulloja;

public class Pulloja {
    private final String name;
    private final String manufacturer;
    private final double total_energy;
    private final double prize;
    private final double size;

    public Pulloja(String n, String m, double t, double s, double p) {
        name = n;
        manufacturer = m;
        total_energy = t;
        size = s;
        prize = p;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getEnergy() {
        return total_energy;
    }
    public double getPrize() {
        return prize;
    }
    public double getSize() {
        return size;
    }

}
