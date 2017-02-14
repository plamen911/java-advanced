package org.lynxlake._11PreludeToJavaOopBasicsLab;

import org.lynxlake._11PreludeToJavaOopBasicsLab.exceptions.OutOfEnergyException;

public class Wizard extends GameCharacter {
    private static final int BASE_HEALTH = 5000;
    private static final int BASE_POWER = 150;
    private static final int BASE_ENERGY = 2500;
    private static final int BASE_ATTACK_COST = 250;

    private static final double CRITICAL_HIT_THRESHOLD = 0.5;
    private static final double TELEPORTATION_ABILITY = 0.5;

    public Wizard(String name) {
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

        boolean isCritical = Math.random() < CRITICAL_HIT_THRESHOLD;

        int damage = this.getPower();
        if (isCritical) {
            System.out.println("Critical hit by the wizard!");
            damage *= 2;
        }

        this.setEnergy(this.getEnergy() - this.getAttackCost());
        other.respond(damage);
    }

    @Override
    public void respond(int damage) {
        boolean hasTeleported = Math.random() < TELEPORTATION_ABILITY;

        if (hasTeleported) {
            System.out.println("The wizard teleported and evaded the attack.");
        } else {
            this.setHealth(this.getHealth() - damage);
            System.out.println("Successful attack. " + damage + " damage dealt!");
        }
    }
}
