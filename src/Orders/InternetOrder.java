package Orders;

import items.Item;

import java.util.LinkedList;

public class InternetOrder implements Order{
    LinkedList<Item> list = new LinkedList<Item>();

    public InternetOrder() {
    }
    public InternetOrder(Item[] k) {
        for (int i = 0; i < k.length;i++)
            list.add(k[i]);
    }
    public boolean add(Item item) {
        list.add(item);
        return true;
    }

    public boolean remove(String itemName){
        for (Item it: list) {
            if (it.getName().equals(itemName)) {
                list.remove(it);
                return true;
            }
        }
        return false;
    }

    public int removeAll(String dishName){
        int count = 0 ;
        for (Item it: list) {
            if (it.getName().equals(dishName)) {
                list.remove(it);
                count++;
            }
        }
        return count;
    }
    public int itemQuantity(){
        return list.size();
    }

    public Item[] getItems(){
        Item[] items = new Item[list.size()];
        int i = 0;
        for (Item it: list) {
            items[i] = it;
            i++;
        }
        return items;
    }
    public double costTotal() {
        double count = 0;
        for (Item it: list) {
            count += it.getPrice();
        }
        return count;
    }
    public int itemQuantity(String itemName){
        int count = 0;
        for (Item it: list) {
            if (it.getName().equals(itemName))
                count++;
        }
        return count;
    }
    public String[] dishesNames(){
        String[] ret = new String[list.size()];
        int i = 0;
        for (Item it: list) {
            ret[i] = it.getName();
            i++;
        }
        return ret;
    }
    public Item[] sortedDishesByCostDesc(){
        Item[] k = getItems();
        for (int out = list.size() - 1; out >= 1; out--)  //Внешний цикл
            for (int in = 0; in < out; in++)    //Внутренний цикл
                if(k[in].getPrice() < k[in + 1].getPrice()) {
                    Item t = k[in];
                    k[in] = k[in+1];
                    k[in+1] = t;
                }
        return k;
    }
}