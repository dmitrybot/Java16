package Orders;

import Orders.Order;
import Orders.RestaurantOrder;
import exeptions.IllegalTableNumber;
import items.Item;

import java.util.HashMap;

public class OrderManager {
    private Order[] orders = new Order[20];
    private HashMap<String, Order> hashmap = new HashMap<>();
    public void add(Order order, int tableNumber) {
        orders[tableNumber] = order;
    }

    public void add(String adress, Order order) {
        hashmap.put(adress, order);
    }

    public Order getOrders(int tableNumber) {
        return orders[tableNumber];
    }

    public Order getOrders(String adress) {
        return hashmap.get(adress);
    }

    public void addItem(Item item, int tableNumber) throws IllegalTableNumber {
        if (tableNumber < 0 || tableNumber  >= orders.length) throw new IllegalTableNumber();
        orders[tableNumber].add(item);
    }

    public void addItem(Item item, String adress){
        hashmap.get(adress).add(item);
    }

    public void removeOrder(int tableNumber) {
        orders[tableNumber] = null;
    }

    public void removeOrder(String adress) {
        hashmap.remove(adress);
    }

    public int freeTableNumber(){
        for (int i = 0; i < 20;i++){
            if (orders[i] == null)
                return i;
        }
        return -1;
    }
    public int[] freeTabelNumbers(){
        int[] a = new int[20];
        int j = 0;
        for (int i = 0; i < 20;i++)
            if (orders[i] == null) {
                a[j] = i;
                j++;
            }
        return a;
    }

    public Order[] getOrders() {
        return orders;
    }

    public Order[] getHashOrders() {
        return hashmap.values().toArray(new Order[0]);
    }

    public double ordersCostSummary() {
        int count = 0;
        for (int i = 0; i < 20; i++)
            if (orders[i] != null) count += orders[i].costTotal();
        return count;
    }

    public double hashCostSummary() {
        int count = 0;
        for(Order i: hashmap.values())
            count += i.costTotal();
        return count;
    }
    public int itemQuantity(String itemName){
        int count = 0 ;
        for (int i = 0; i < 20; i++)
            if (orders[i] != null) count += orders[i].itemQuantity(itemName);
        return count;
    }

    public int itemHashQuantity(String itemName){
        int count = 0 ;
        for (Order i: hashmap.values())
            count += i.itemQuantity(itemName);
        return count;
    }
}