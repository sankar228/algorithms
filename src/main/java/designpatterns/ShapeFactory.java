package designpatterns;

public class ShapeFactory {
    public int sides;

    public ShapeFactory(int sides){
        this.sides = sides;
    }

    public Shape getShapeInstance(){
        if(sides == 0) return new Circle();
        else if(sides == 4) return new Square();
        else return new Circle();
    }
}
