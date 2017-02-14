package org.lynxlake._11JavaAdvancedWorkshopOopPreludeDemo;

public abstract class Hero {

    private int health;
    private int power;
    private int energy;
    private int atackCost;
    private String name;

    protected Hero(int health, int power, int energy, int atackCost, String name) {
        this.health = health;
        this.power = power;
        this.energy = energy;
        this.atackCost = atackCost;
        this.name = name;
    }

    public abstract void atack(Hero hero) throws OutOfEnergyExcpetion;

    public abstract void respond(int damage);

    public int getHealth() {
        return this.health;
    }

    public int getPower() {
        return power;
    }

    public int getEnergy() {
        return energy;
    }

    public int getAtackCost() {
        return atackCost;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setAtackCost(int atackCost) {
        this.atackCost = atackCost;
    }

    public void setName(String name) {
        this.name = name;
    }
}
