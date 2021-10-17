import Orders.InternetOrder;
import Orders.OrderManager;
import Orders.RestaurantOrder;
import items.Dish;
import items.Drink;
import items.Item;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        Item i1 = new Drink("Cola", "Вкусная, сладкая, холодная");
        Item i2 = new Dish(67,"Pepsi","Холодная, Сладкая, вкусная");
        System.out.println(i1.getPrice() + " " + i1.getName() + " " + i1.getDescription());
        System.out.println(i2.getPrice() + " " + i2.getName() + " " + i2.getDescription());

        OrderManager orderManager = new OrderManager();

        InternetOrder internetOrder = new InternetOrder();
        RestaurantOrder restaurantOrder = new RestaurantOrder();

        internetOrder.add(i1);
        internetOrder.add(i2);

        restaurantOrder.add(i1);
        restaurantOrder.add(i2);

        orderManager.add("Moscow", internetOrder);
        orderManager.add(restaurantOrder, 4);

        System.out.println(orderManager.itemQuantity("Cola"));
        System.out.println(orderManager.itemHashQuantity("Cola"));
        System.out.println(orderManager.hashCostSummary());
        System.out.println(orderManager.ordersCostSummary());
    }
}