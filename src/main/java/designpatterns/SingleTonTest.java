package designpatterns;

public class SingleTonTest {

    public static void main(String[] args) {
        SingleTonEntity obj = SingleTonEntity.getInstance();

        obj.setName("sankar");
        System.out.println(obj.getName());

        SingleTonEntity obj1 = SingleTonEntity.getInstance();
        System.out.println(obj1.getName());
    }
}
