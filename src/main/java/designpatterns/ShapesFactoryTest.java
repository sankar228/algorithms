package designpatterns;

public class ShapesFactoryTest {
    public static void main(String[] args) {
        Shape shape = new ShapeFactory(4).getShapeInstance();

        System.out.println(shape.getShape());
    }
}
