// https://judge.softuni.bg/Contests/Practice/Index/187#5
package org.lynxlake.stacksAndQueues.___06Robotics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static int ONE_SECOND = 1000;

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> robotNames = new ArrayList<>();
        ArrayList<Integer> processTimes = new ArrayList<>();
        LinkedHashMap<String, Long> processMap = new LinkedHashMap<>();

        String[] input = scanner.nextLine().trim().split(";");
        for (String entry : input) {
            String[] params = entry.split("\\-");
            String robotName = params[0];
            int processTime = Integer.parseInt(params[1]);
            robotNames.add(robotName);
            processTimes.add(processTime);
            processMap.put(robotName, 0L);
        }

        DateFormat df = new SimpleDateFormat("hh:mm:ss");
        Date date = df.parse(scanner.nextLine());
        long ts = date.getTime();
/*


        System.out.printf("ts: %d, before: %s%n", ts, df.format(date));
        ts += ONE_SECOND;
        date.setTime(ts);
        System.out.println("time, after round trip: " + df.format(date));
*/

        ArrayList<String> products = new ArrayList<>();
        while (true) {
            String product = scanner.nextLine();
            if (product.equalsIgnoreCase("End")) {
                break;
            }
            products.add(product);
        }

        int i = 0;

        while (true) {
            ts += ONE_SECOND;

            try {
                String product = products.get(i);

                // check for available robot
                int j = 0;
                for (Map.Entry<String, Long> entry : processMap.entrySet()) {
                    String robotName = entry.getKey();
                    int processTime = processTimes.get(j);
                    Long processEndTime = entry.getValue();
                    if (processEndTime == 0 || processEndTime < ts) {
                        date.setTime(ts + processTime * ONE_SECOND);
                        System.out.printf("%s - %s [%s]%n", robotName, product, df.format(date));
                        processMap.put(robotName, ts + processTime * ONE_SECOND);
                        break;
                    }
                    j++;
                }

                i++;

            } catch (IndexOutOfBoundsException ex) {
                break;
            }
        }

        /*for (Map.Entry<String, Integer> robot : robots.entrySet()) {
            System.out.printf("%s - %d%n", robot.getKey(), robot.getValue());
        }*/



    }
}
