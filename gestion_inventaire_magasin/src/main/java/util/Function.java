package util;

import java.util.Scanner;

public class Function {
    public static int checkInputInt(Scanner scanner, String prompt){
        boolean flag = true;
        int integer = 0;
        while(flag){
            try {
                System.out.println(prompt);
                String value = scanner.nextLine();
                integer = Integer.parseInt(value);
                flag = false;
            }catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }

        }
        return integer;
    }
    public static double checkInputDouble(Scanner scanner, String prompt){
        boolean flag = true;
        double doubleDouble = 0;
        while(flag){
            try {
                System.out.println(prompt);
                String value = scanner.nextLine();
                doubleDouble = Double.parseDouble(value);
                flag = false;
            }catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
        return doubleDouble;
    }
}
