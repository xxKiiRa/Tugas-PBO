public class Drink extends Menu {
    public Drink(String name, int price) {
        super(name, price);
    }

    @Override
    public void displayMenuType() {
        System.out.println("Tipe: Minuman");
    }
}
