package org.lynxlake._11JavaAdvancedWorkshopOopPreludeDemo;

public class Game {
    public static void main(String[] args) {
        Hero warrior = new Warrior("Stamat");
        Hero mage = new Mage("Haralampi");

        while (true) {
            try {
                warrior.atack(mage);
                mage.atack(warrior);
            } catch (OutOfEnergyExcpetion e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
