package controller;

import entity.CategoryItem;
import entity.Item;
import entity.SizeItem;
import service.ItemService;
import util.Function;
import java.util.List;
import java.util.Scanner;

public class ItemController {
    private static final ItemService itemService = new ItemService();
    private static final Scanner scanner = new Scanner(System.in);
    public static void menu(){
        while(true){
            System.out.println("1. Add Item");
            System.out.println("2. Show Item");
            System.out.println("3. Show All Items");
            System.out.println("4. Update Item");
            System.out.println("5. Delete Item");
            System.out.println("0. Return to main menu");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    createItem();
                    break;
                case 2:
                    showItem();
                    break;
                case 3:
                    showAllItems();
                    break;
                case 4:
                    updateItem();
                    break;
                case 5:
                    deleteItem();
                    break;
                case 0:
                    return;

            }
        }
    }

    private static void createItem(){
        int itemCount = 0;
        while (itemCount <= 0){
            itemCount = Function.checkInputInt(scanner, "Enter number of items to add: ");
        }
        for(int i = 0; i < itemCount; i++){
            System.out.println("Enter item description: ");
            String itemDescription = scanner.nextLine();
            System.out.println("Select category: ");
            CategoryItem categoryItem = selectCategory();
            System.out.println("Enter size:");
            SizeItem sizeItem = selectSize();
            double price = 0;
            while(price <= 0){
                price = Function.checkInputDouble(scanner, "Enter price: ");
            }
            int quantity = 0;
            while(quantity <= 0){
                quantity = Function.checkInputInt(scanner, "Enter quantity: ");
            }
            Item item = Item.builder()
                    .description(itemDescription)
                    .category(categoryItem)
                    .size(sizeItem)
                    .price(price)
                    .quantity(quantity).build();
            if(itemService.create(item)){
                System.out.println("Item added successfully");
            }
        }
    }
    private static void showAllItems(){
        List<Item> itemList = itemService.findAll();
        if(itemList.isEmpty()){
            System.out.println("No items found");
            return;
        }
        itemList.forEach(System.out::println);
    }
    private static void showItem(){
        int id = Function.checkInputInt(scanner, "Enter id of item: ");
        Item item = itemService.findById(id);
        if(item != null){
            System.out.println("Item: " + item);
        }else {
            System.out.println("Item not found");
        }
    }

    private static void updateItem(){
        int id = Function.checkInputInt(scanner, "Enter id of item: ");
        Item item = itemService.findById(id);
        if(item == null){
            System.out.println("Item not found");
            return;
        }
            System.out.println("Enter new item description: ");
            String itemDescription = scanner.nextLine();
            System.out.println("Select new category: ");
            CategoryItem categoryItem = selectCategory();
            System.out.println("Enter new size:");
            SizeItem sizeItem = selectSize();
            double price = 0;
            while(price <= 0){
                price = Function.checkInputDouble(scanner, "Enter new price: ");
            }
            int quantity = 0;
            while(quantity <= 0){
                quantity = Function.checkInputInt(scanner, "Enter new quantity: ");
            }
            item.setDescription(itemDescription);
            item.setCategory(categoryItem);
            item.setSize(sizeItem);
            item.setPrice(price);
            item.setQuantity(quantity);
            if(itemService.update(item)){
                System.out.println("Item successfully updated");
            }
    }
    private static void deleteItem(){
        int id = Function.checkInputInt(scanner, "Enter id of item: ");
        Item item = itemService.findById(id);
        if(item == null){
            System.out.println("Item not found");
            return;
        }
        if(itemService.delete(item)){
            System.out.println("Item deleted successfully");
        }
    }

    private static CategoryItem selectCategory(){
        CategoryItem categoryItem = null;
        while(categoryItem == null){
            String prompt = "1."+CategoryItem.MAN +
                    "\n2."+CategoryItem.WOMAN+
                    "\n3."+CategoryItem.CHILDREN;

            int choice = Function.checkInputInt(scanner, prompt);
            scanner.nextLine();
            categoryItem = switch (choice) {
                case 1 -> CategoryItem.MAN;
                case 2 -> CategoryItem.WOMAN;
                case 3 -> CategoryItem.CHILDREN;
                default -> null;
            };
        }
        return categoryItem;
    }
    private static SizeItem selectSize(){
        SizeItem sizeItem = null;
        while(sizeItem == null){
            String prompt = "1."+SizeItem.XS+
                    "\n2."+SizeItem.S+
                    "\n3."+SizeItem.M+
                    "\n4."+SizeItem.L+
                    "\n5."+SizeItem.XL+
                    "\n6."+SizeItem.XXL;
            int choice = Function.checkInputInt(scanner, prompt);
            sizeItem = switch (choice){
                case 1 -> SizeItem.XS;
                case 2 -> SizeItem.S;
                case 3 -> SizeItem.M;
                case 4 -> SizeItem.L;
                case 5 -> SizeItem.XL;
                case 6 -> SizeItem.XXL;
                default -> null;
            };
        }
        return sizeItem;
    }
}
