// package Factory Design Pattern;

interface Shape {
    public abstract void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("I am drawing circle");
    }

}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("I am drawing rectangle");
    }

}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("I am drawing square");
    }

}

class ShapeFactory {

    public static Shape getShape(String str) {
        switch (str) {
            case "circle":
                return new Circle();

            case "rectangle":
                return new Rectangle();

            case "square":
                return new Square();

            default:
                return null;
        }
    }
}

class Test8 {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("circle");
        circle.draw();
        Shape rectangle = ShapeFactory.getShape("rectangle");
        rectangle.draw();
        Shape square = ShapeFactory.getShape("square");
        square.draw();

        
    }
}
