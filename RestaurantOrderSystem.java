import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Menu> menuList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();

        menuList.add(new Food("Nasi Goreng", 20000));
        menuList.add(new Drink("Es Teh", 5000));
        menuList.add(new Food("Mie Goreng", 15000));
        menuList.add(new Drink("Es Jeruk", 7000));

        while (true) {
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Tampilkan Semua Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Masukkan kontak pelanggan: ");
                    String customerContact = scanner.nextLine();
                    Customer customer = new Customer(customerName, customerContact);

                    System.out.println("Pilih tipe pesanan (1. Dine-In, 2. Take-Away): ");
                    int orderTypeChoice = scanner.nextInt();
                    OrderType orderType = (orderTypeChoice == 1) ? OrderType.DINE_IN : OrderType.TAKE_AWAY;

                    Order newOrder = new Order(customer, orderType);

                    System.out.println("Pilih item menu (0 untuk selesai): ");
                    for (int i = 0; i < menuList.size(); i++) {
                        System.out.println((i + 1) + ". " + menuList.get(i).getName() + " - Rp" + menuList.get(i).getPrice());
                    }
                    int menuChoice;
                    do {
                        System.out.print("Pilih nomor menu: ");
                        menuChoice = scanner.nextInt();
                        if (menuChoice > 0 && menuChoice <= menuList.size()) {
                            newOrder.addMenuItem(menuList.get(menuChoice - 1));
                        }
                    } while (menuChoice != 0);

                    orderList.add(newOrder);
                    System.out.println("Pesanan berhasil ditambahkan!\n");
                    break;

                case 2:
                    if (orderList.isEmpty()) {
                        System.out.println("Tidak ada pesanan.");
                    } else {
                        for (Order order : orderList) {
                            order.displayOrderDetails();
                            System.out.println("-----------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}
