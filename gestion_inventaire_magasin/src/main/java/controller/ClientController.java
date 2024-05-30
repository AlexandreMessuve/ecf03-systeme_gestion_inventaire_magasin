package controller;

import entity.Client;
import service.ClientService;
import util.Function;

import java.util.List;
import java.util.Scanner;

public class ClientController {
    protected static final ClientService clientService = new ClientService();
    private static final Scanner scanner = new Scanner(System.in);
    public static void menu(){
        while(true){
            String prompt = """
                    __________________________
                   |###  Client Management ###|
                   |__________________________|
                   |                          |
                   |1. Add Client             |
                   |2. Show Client            |
                   |3. Show All Clients       |
                   |4. Update Client          |
                   |5. Delete Client          |
                   |0. Return to main menu    |
                   |                          |
                   |__________________________|
                   """;
            int choice = Function.checkInputInt(scanner, prompt);
            switch(choice){
                case 1:
                    createClient();
                    break;
                case 2:
                    showClient();
                    break;
                case 3:
                    showAllClient();
                    break;
                case 4:
                    updateClient();
                    break;
                case 5:
                    deleteClient();
                    break;
                case 0:
                    return;

            }
        }
    }

    protected static void createClient(){
        System.out.println("Enter name of Client: ");
        String nameClient = scanner.nextLine();
        System.out.println("Enter email of Client: ");
        String emailClient = scanner.nextLine();

        Client client = Client.builder()
                .name(nameClient)
                .email(emailClient)
                .build();
        if(clientService.create(client)){
            System.out.println("Client added successfully");
        }
    }
    protected static void showAllClient(){
        List<Client> clientList = clientService.findAll();
        if(clientList.isEmpty()){
            System.out.println("No clients found");
            return;
        }
        clientList.forEach(System.out::println);
    }
    protected static void showClient(){
        int id = Function.checkInputInt(scanner, "Enter id of client: ");
        Client client = clientService.findById(id);
        if(client != null){
            System.out.println(client);
        }else {
            System.out.println("Client not found");
        }
    }

    protected static void updateClient(){
        int id = Function.checkInputInt(scanner, "Enter id of client: ");
        Client client = clientService.findById(id);
        if(client == null){
            System.out.println("Client not found");
            return;
        }
        System.out.println("Enter new name of Client: ");
        String clientName = scanner.nextLine();
        System.out.println("Enter new email of Client: ");
        String clientEmail = scanner.nextLine();
        client.setName(clientName);
        client.setEmail(clientEmail);
        if(clientService.update(client)){
            System.out.println("Client successfully updated");
        }
    }
    protected static void deleteClient(){
        int id = Function.checkInputInt(scanner, "Enter id of client: ");
        Client client = clientService.findById(id);
        if(client == null){
            System.out.println("Client not found");
            return;
        }
        if(clientService.delete(client)){
            System.out.println("Client deleted successfully");
        }
    }
}
