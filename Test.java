
interface Shape {

    double calculateArea();
    void printDescription();

}

class Circle implements Shape {

    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double calculateArea() {
        return 3.14 * radius * radius;
    }

    public void printDescription() {
        System.out.println("Circle with radius " + radius);
    }

}

class Rectangle implements Shape {

    private double length;
    private double breadth;

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    public double getBreadth() {
        return breadth;
    }

    public double calculateArea() {
        return length * breadth;
    }

    public void printDescription() {
        System.out.println("Rectangle with length " + length + " and breadth " + breadth);
    }

}

class Triangle implements Shape {

    private double base;
    private double height;

    public void setBase(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }

    public void printDescription() {
        System.out.println("Triangle with base " + base + " and height " + height);
    }
}

class Square extends Rectangle {

    private double side;

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public double calculateArea() {
        return side * side;
    }

    public void printDescription() {
        System.out.println("Square with side " + side);
    }

}

public class Test {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        Square square = new Square();

        rectangle.setLength(10);
        rectangle.setBreadth(10);

        rectangle.printDescription();
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());

        circle.setRadius(10);
        circle.printDescription();
        System.out.println("Area of Circle: " + circle.calculateArea());

        triangle.setBase(10);
        triangle.setHeight(10);
        triangle.printDescription();
        System.out.println("Area of Triangle: " + triangle.calculateArea());

        square.setSide(10);
        square.printDescription();
        System.out.println("Area of Square: " + square.calculateArea());
    }
}