package de.simagdo.simagdoRPG.utils;

public class Logger {

    public static void startMessages() {
        System.out.println("[SimagdoRPG] Find partners");
        System.out.println("[SimagdoRPG] Created by Simon Agethen and Michael Maciolek");
        System.out.println("[SimagdoRPG] Starting up...");
    }

    public static void startSuccess() {
        System.out.println("[SimagdoRPG] Load success!");
    }

    public static void info(String message) {
        System.out.println("[SimagdoRPG - INFO] " + message);
    }

    public static void severe(String message) {
        System.out.println("[SimagdoRPG - SEVERE] " + message);
    }

    public static void error(String message) {
        System.out.println("[SimagdoRPG - ERROR] " + message);
    }
    
}
