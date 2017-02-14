package org.lynxlake._11JavaAdvancedWorkshopOopPreludeDemo;

public class Mage extends Hero {

    private final static int HEALTH = 100;
    private final static int POWER = 20;
    private final static int ENERGY = 50;
    private final static int ATTACK_COST = 10;

    private int health;
    private int power;
    private int energy;
    private int atackCost;
    private String name;

    public Mage(String name) {
        this(HEALTH,POWER,ENERGY,ATTACK_COST,name);
    }


    public Mage(int health, int power, int energy, int atackCost, String name) {
        super(health,power,energy,atackCost,name);
    }

    @Override
    public void atack(Hero hero) throws OutOfEnergyExcpetion {

        if (hero.equals(this)) {
            throw new IllegalStateException("Tva nema da stane!");
        }

        if (this.getEnergy() >= this.getAtackCost()) {
            hero.respond(this.getPower());
            this.setEnergy(this.getEnergy() - this.getAtackCost());
        } else {
            throw new OutOfEnergyExcpetion("Ne moga bace ... nema poVer");
        }

    }

    @Override
    public void respond(int damage) {

        boolean hasTeleported = Math.random() < 0.5;

        if (hasTeleported) {
            System.out.println("Propusnaaa ... Na Na Na Na!!");
        } else {
            this.setHealth(this.getHealth() - damage);
        }

        if (this.getHealth() <= 0) {
            throw new IllegalStateException("Sorry ... umreh!");
        }
    }
}
