import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCount = 0; // Static counter untuk order ID
    private int orderId;
    private Customer customer;
    private OrderType orderType;
    private List<Menu> menuItems;
    private boolean isCompleted;

    public Order(Customer customer, OrderType orderType) {
        this.orderId = ++orderCount;
        this.customer = customer;
        this.orderType = orderType;
        this.menuItems = new ArrayList<>();
        this.isCompleted = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void addMenuItem(Menu menu) {
        menuItems.add(menu);
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Menu menu : menuItems) {
            total += menu.getPrice();
        }
        return total;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Contact: " + customer.getContact());
        System.out.println("Order Type: " + (orderType == OrderType.DINE_IN ? "Dine-In" : "Take-Away"));
        System.out.println("Menu Items:");
        for (Menu menu : menuItems) {
            System.out.println("- " + menu.getName() + " : Rp" + menu.getPrice());
            menu.displayMenuType();
        }
        System.out.println("Total Price: Rp" + calculateTotalPrice());
        System.out.println("Status: " + (isCompleted ? "Completed" : "In Progress"));
    }
}
