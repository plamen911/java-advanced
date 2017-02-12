// https://judge.softuni.bg/Contests/Practice/Index/201#10
package org.lynxlake._09StreamApiExercises._11OfficeStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        TreeMap<String, LinkedHashMap<String, Long>> companies = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().split(" - ");
            String company = params[0].substring(1);
            Long amount = Long.parseLong(params[1]);
            String product = params[2].substring(0, params[2].length() - 1);

            companies.putIfAbsent(company, new LinkedHashMap<>());

            if (!companies.get(company).containsKey(product)) {
                companies.get(company).put(product, 0L);
            }
            companies.get(company).put(product, companies.get(company).get(product) + amount);
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> company : companies.entrySet()) {
            System.out.printf("%s: ", company.getKey());
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> product : company.getValue().entrySet()) {
                sb.append(product.getKey()).append("-").append(product.getValue()).append(", ");
            }
            System.out.printf("%s%n", sb.toString().substring(0, sb.length() - 2));
        }
    }
}
