package org.lynxlake._11PreludeToJavaOopBasicsLab;

import org.lynxlake._11PreludeToJavaOopBasicsLab.exceptions.OutOfEnergyException;

public class Warrior extends GameCharacter {
    private static final int BASE_HEALTH = 5000;
    private static final int BASE_POWER = 200;
    private static final int BASE_ENERGY = 1000;
    private static final int BASE_ATTACK_COST = 150;

    private static final double CRITICAL_SURGE_OF_POWER = 0.5;
    private static final double BLOCK_ABILITY = 0.5;

    public Warrior(String name) {
        super(BASE_HEALTH, BASE_POWER, BASE_ENERGY, BASE_ATTACK_COST, name);
    }

    @Override
    public void attack(GameCharacter other) throws OutOfEnergyException {
        if (other == this) {
            throw new IllegalStateException("Cannot attack itself.");
        }

        if (this.getEnergy() < this.getAttackCost()) {
            throw new OutOfEnergyException(this.getName() + " is out of energy. Battle over.");
        }

        boolean surgeOfPower = Math.random() < CRITICAL_SURGE_OF_POWER;
        if (surgeOfPower) {
            System.out.println(this.getName() + " was lucky! Free attack.");
        } else {
            this.setEnergy(this.getEnergy() - this.getAttackCost());
        }

        other.respond(this.getPower());
    }

    @Override
    public void respond(int damage) {
        boolean hasBlocked = Math.random() < BLOCK_ABILITY;

        if (hasBlocked) {
            System.out.println("Attack was blocked.");
            damage /= 2;
        }

        System.out.println(damage + " damage dealt!");
    }
}
