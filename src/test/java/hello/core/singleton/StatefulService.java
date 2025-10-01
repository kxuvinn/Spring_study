package hello.core.singleton;

public class StatefulService {
    private int price; // 공유 상태 (문제 발생)

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
