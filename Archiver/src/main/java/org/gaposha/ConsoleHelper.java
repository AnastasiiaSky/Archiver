package org.gaposha;

import java.util.Scanner;

public class ConsoleHelper {

    public static void writeMessage(String message) {
        System.out.println(message);
    }


    public static String readString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }
}
