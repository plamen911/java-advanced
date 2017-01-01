// https://judge.softuni.bg/Contests/Practice/Index/188#13
package org.lynxlake.setsAndMaps.dragonArmy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, TreeMap<String, Dragon>> army = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().trim().split("\\s+");
            String type = params[0];
            String name = params[1];
            if (params[2].equalsIgnoreCase("null")) {
                params[2] = "45";
            }
            if (params[3].equalsIgnoreCase("null")) {
                params[3] = "250";
            }
            if (params[4].equalsIgnoreCase("null")) {
                params[4] = "10";
            }
            double damage = Double.valueOf(params[2]);
            double health = Double.valueOf(params[3]);
            double armor = Double.valueOf(params[4]);

            Dragon dragon = new Dragon(name, damage, health, armor);

            if (!army.containsKey(type)) {
                army.put(type, new TreeMap<>());
            }

            army.get(type).put(name, dragon);
        }

        for (Map.Entry<String, TreeMap<String, Dragon>> type : army.entrySet()) {

            int len = army.get(type.getKey()).values().size();
            double damageAvg = 0.0;
            double healthAvg = 0.0;
            double armorAvg = 0.0;
            for (Dragon dragon : army.get(type.getKey()).values()) {
                damageAvg += dragon.getDamage();
                healthAvg += dragon.getHealth();
                armorAvg += dragon.getArmor();
            }

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
                    type.getKey(),
                    damageAvg / len,
                    healthAvg / len,
                    armorAvg / len);

            for (Dragon dragon : type.getValue().values()) {
                System.out.printf("%s%n", dragon);
            }
        }
    }
}

class Dragon {
    private String name;
    private double damage;
    private double health;
    private double armor;

    Dragon(String name, double damage, double health, double armor) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    String getName() {
        return name;
    }

    double getDamage() {
        return damage;
    }

    double getHealth() {
        return health;
    }

    double getArmor() {
        return armor;
    }

    @Override
    public String toString() {
        return String.format("-%s -> damage: %.0f, health: %.0f, armor: %.0f",
                this.name,
                this.damage,
                this.health,
                this.armor);
    }
}
