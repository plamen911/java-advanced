package org.lynxlake._11PreludeToJavaOopBasicsLab;

import org.lynxlake._11PreludeToJavaOopBasicsLab.exceptions.OutOfEnergyException;

public class Main {
    public static void main(String[] args) {
        GameCharacter goshoTheWarrior = new Warrior("Gosho");
        GameCharacter peshoTheWizard = new Wizard("Pesho");

        int roundCount = 0;
        while (true) {
            System.out.println("Round " + ++roundCount);
            try {
                goshoTheWarrior.attack(peshoTheWizard);
                peshoTheWizard.attack(goshoTheWarrior);

            } catch (OutOfEnergyException e) {
                System.out.println(e.getMessage());
                break;
            }

            System.out.println();
        }
    }
}
