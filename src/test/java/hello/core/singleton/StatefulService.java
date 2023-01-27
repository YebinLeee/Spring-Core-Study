package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 가격 필드

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 문제가 발생하는 위치
    }

    public int getPrice() {
        return price;
    }
}
