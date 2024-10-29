import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCount = 0; // Static counter untuk order ID
    private int orderId;
    private Customer customer;
    private OrderType orderType;
    private List<Menu> menuItems;
    private boolean isCompleted;
    private boolean isPaid; // Menyimpan status pembayaran

    public Order(Customer customer, OrderType orderType) {
        this.orderId = ++orderCount;
        this.customer = customer;
        this.orderType = orderType;
        this.menuItems = new ArrayList<>();
        this.isCompleted = false;
        this.isPaid = false; // Inisialisasi status pembayaran sebagai belum dibayar
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

    public boolean isPaid() {
        return isPaid;
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

    // Metode untuk pembayaran
    public void payOrder() {
        if (isPaid) {
            System.out.println("Pesanan sudah dibayar.");
        } else {
            this.isPaid = true;
            this.isCompleted = true; // Tandai pesanan selesai setelah dibayar
            System.out.println("Pembayaran berhasil. Status pesanan: Success.");
        }
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
        System.out.println("Status: " + (isPaid ? "Success (Paid)" : "In Progress"));
    }
}
