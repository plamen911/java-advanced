// https://judge.softuni.bg/Contests/Practice/Index/457#1
package org.lynxlake._06ManualStringProcessingLab._02ParseURLs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine().trim();

        String protocol;
        String server;
        String resource;

        String[] tokens = url.split("://");
        if (tokens.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        protocol = tokens[0];
        int serverLastIdx = tokens[1].indexOf("/");
        server = tokens[1].substring(0, serverLastIdx);
        resource = tokens[1].substring(serverLastIdx + 1);

        System.out.printf("Protocol = %s%n", protocol);
        System.out.printf("Server = %s%n", server);
        System.out.printf("Resources = %s%n", resource);
    }
}
