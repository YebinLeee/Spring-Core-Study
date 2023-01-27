package hello.core.singleton;

public class StatelessService {

    // 가격 상태 필드 제거
    // private int price

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

    /*
    public int getPrice() {

        return price;
    }
     */
}
