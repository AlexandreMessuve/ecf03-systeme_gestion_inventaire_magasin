package controller;

import entity.Client;
import entity.Item;
import entity.Sale;
import entity.SaleState;
import service.OrderService;
import service.SaleService;
import util.Function;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SaleController {
    protected static final SaleService saleService = new SaleService();
    private static final Scanner scanner = new Scanner(System.in);
    public static void menu(){
        while(true){
            String prompt = """
                        __________________________
                       |####  Sale Management ####|
                       |__________________________|
                       |                          |
                       |1. Add Sale               |
                       |2. Show Sale              |
                       |3. Show All Sales         |
                       |4. Update SaleState       |
                       |5. Delete Sale            |
                       |0. Return to main menu    |
                       |                          |
                       |__________________________|
                       """;
            int choice = Function.checkInputInt(scanner, prompt);
            switch(choice){
                case 1:
                    createSale();
                    break;
                case 2:
                    showSale();
                    break;
                case 3:
                    showAllSales();
                    break;
                case 4:
                    updateSale();
                    break;
                case 5:
                    deleteSale();
                    break;
                case 0:
                    return;
            }
        }
    }

    protected static void createSale(){
        String choice = "";
        while (choice.isEmpty()){
            System.out.println("1. Old client");
            System.out.println("2. New client");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    break;
                case "2":
                    ClientController.createClient();
                    break;
                default:
                    choice = "";
                    break;
            }

        }
        Client client = null;
        while (client == null){
            ClientController.showAllClient();
            int clientId = Function.checkInputInt(scanner, "Please enter client id");
            client = ClientController.clientService.findById(clientId);
        }
        Sale sale = Sale.builder()
                .client(client)
                .dateSale(new Date())
                .state(SaleState.IN_PROGRESS)
                .build();
        if (saleService.create(sale)){
            OrderController.createOrder(sale);
            System.out.println("Sale registred successfully");
        }
    }
    protected static void showSale(){
        int saleId = Function.checkInputInt(scanner, "Please enter sale id");
        Sale sale = saleService.findById(saleId);
        if (sale == null){
            System.out.println("Sale not found");
            return;
        }
        System.out.println(sale);
    }
    protected static void showAllSales(){
        List<Sale> sales = saleService.findAll();
        if (sales.isEmpty()){
            System.out.println("No sales found");
            return;
        }
        sales.forEach(System.out::println);
    }
    protected static void updateSale(){
        int saleId = Function.checkInputInt(scanner, "Please enter sale id");
        Sale sale = saleService.findById(saleId);
        if (sale == null){
            System.out.println("Sale not found");
            return;
        }
        System.out.println("Choose state");
        SaleState state = null;
        while (state == null){
            String prompt = "1."+SaleState.IN_PROGRESS+
                    "\n2."+SaleState.COMPLETED+
                    "\n3."+SaleState.CANCELLED;
            int choice = Function.checkInputInt(scanner, prompt);
            state = switch (choice){
                case 1 -> SaleState.IN_PROGRESS;
                case 2 -> SaleState.COMPLETED;
                case 3 -> SaleState.CANCELLED;
                default -> null;
            };
        }
    }
    protected static void deleteSale(){
        int saleId = Function.checkInputInt(scanner, "Please enter sale id");
        Sale sale = saleService.findById(saleId);
        if (sale == null){
            System.out.println("Sale not found");
            return;
        }
        if (saleService.delete(sale)){
            System.out.println("Sale deleted");
        }
    }
}
