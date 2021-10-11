import items.Drink;

public class Main {
    public static void main(String[] args) {
        Drink k1 = new Drink("Cola", "Вкусная, сладкая, холодная");
        Drink k2 = new Drink(67,"Pepsi","Холодная, Сладкая, вкусная");
        System.out.println(k1.getPrice() + " " + k1.getName() + " " + k1.getDescription());
        System.out.println(k2.getPrice() + " " + k2.getName() + " " + k2.getDescription());
    }
}