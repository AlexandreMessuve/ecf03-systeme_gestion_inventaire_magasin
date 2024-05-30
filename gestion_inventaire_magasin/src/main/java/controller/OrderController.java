package controller;

import entity.Item;
import entity.Order;
import entity.Sale;
import service.OrderService;
import util.Function;

import java.util.List;
import java.util.Scanner;

public class OrderController {
    protected static final OrderService orderService = new OrderService();
    private static final Scanner scanner = new Scanner(System.in);

    protected static void createOrder(Sale sale) {
        System.out.println("Choose item : ");
        Item item = null;
        int itemQuantity = 0;
        while (item == null || itemQuantity == 0){
            ItemController.showAllItems();
            int itemId = Function.checkInputInt(scanner, "Please enter item id");
            item = ItemController.itemService.findById(itemId);
            itemQuantity = item.getQuantity();
            if (itemQuantity == 0){
                System.out.println("Please enter an other item");
            }
        }
        int quantity = 0;
        while (quantity > itemQuantity || quantity <= 0){
            System.out.println("Item quantity : "+ itemQuantity);
            quantity = Function.checkInputInt(scanner, "Please enter quantity of item");
        }
        Order order = Order.builder()
                .sale(sale)
                .item(item)
                .quantity(quantity)
                .build();

        item.setQuantity(itemQuantity - quantity);
        ItemController.itemService.update(item);
        orderService.create(order);
    }
}
