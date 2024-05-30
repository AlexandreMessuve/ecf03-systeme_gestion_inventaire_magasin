package controller;

import util.Function;

import java.util.Scanner;

public class MainController {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            String prompt = """
                    __________________________
                   |#### Main Menu Option ####|
                   |__________________________|
                   |                          |
                   | 1.Item Management        |
                   | 2.Client Management      |
                   | 3.Sale Management        |
                   | 0.Exit                   |
                   |                          |
                   |__________________________|
                   """;
            int choice = Function.checkInputInt(scanner, prompt);
            switch (choice) {
                case 1:
                    ItemController.menu();
                    break;
                case 2:
                    ClientController.menu();
                    break;
                case 3:
                    SaleController.menu();
                    break;
                case 0:
                    System.out.println("End of program");
                    System.exit(0);
                    break;
            }
        }
    }
}
