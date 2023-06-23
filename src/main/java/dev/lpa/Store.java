package dev.lpa;

import java.util.ArrayList;

public class Store {

    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {

        storeProducts.add(new ArtObject("Oil painting", 1350, "Impressionistic work by ABF painted in 2010"));
        storeProducts.add(new ArtObject("Sculpture", 2000, "Bronze work by JFK, produced in 1950"));

        listProducts();
//        ------------------------------
//        This Oil painting is a beautiful reproduction
//        The price of the piece is $1350,00
//        Impressionistic work by ABF painted in 2010
//        ------------------------------
//        This Sculpture is a beautiful reproduction
//        The price of the piece is $2000,00
//        Bronze work by JFK, produced in 1950

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);
//        Order 1
//        2 quantity at $8.2f each, 2000.0          Sculpture
//        1 quantity at $8.2f each, 1350.0          Oil painting
//        Sales total = $5350,00

        storeProducts.add(new Furniture("Desk", 500, "Mahogany desk"));
        storeProducts.add(new Furniture("Lamp", 200, "Tiffany lamp with hummingbirds"));

        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
//        Order 2
//        5 quantity at $8.2f each, 200.0           Lamp
//        1 quantity at $8.2f each, 1350.0          Oil painting
//        1 quantity at $8.2f each, 500.0           Desk
//        Sales total = $2850,00
    }

    public static void listProducts() {

        for (var item : storeProducts) {
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int quantity) {
        order.add(new OrderItem(quantity, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order) {

        double salesTotal = 0;
        for (var item : order) {
            item.product().printPricedLineItem(item.quantity());
            salesTotal += item.product().getSalesPrice(item.quantity());
        }
        System.out.printf("Sales total = $%6.2f%n", salesTotal);
    }
}
