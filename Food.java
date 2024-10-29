public class Food extends Menu {
    public Food(String name, int price) {
        super(name, price);
    }

    @Override
    public void displayMenuType() {
        System.out.println("Tipe: Makanan");
    }
}
