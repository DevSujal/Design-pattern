import java.util.ArrayList;

public abstract class Packing {
    String p;
}

class Wrapper extends Packing {

    Wrapper() {
        this.p = "wrapper";
    }

    public String toString() {
        return p;
    }

}

class Bottle extends Packing {

    Bottle() {
        this.p = "bottle";
    }

    public String toString() {
        return p;
    }
}

abstract class Items {
    String name;
    Packing p;
    float price;

    Items(String name, Packing p, float price) {
        this.name = name;
        this.p = p;
        this.price = price;
    }

    public String toString() {
        return name + " " + p + " " + price;
    }
}

class Burger extends Items {

    Burger(String name, float price) {
        super(name, new Wrapper(), price);
    }
}

class VegBurger extends Burger {
    VegBurger() {
        super("veg burger", 99);
    }
}

class ChickenBurger extends Burger {
    ChickenBurger() {
        super("chicken burger", 199);
    }
}

class ColdDrink extends Items {

    ColdDrink(String name, float price) {
        super(name, new Bottle(), price);
    }
}

class Pepsi extends ColdDrink {
    Pepsi() {
        super("pepsi", 299);
    }
}

class Coke extends ColdDrink {
    Coke() {
        super("coke", 399);
    }
}

class Meal {
    ArrayList<Items> items = new ArrayList<>();

    void addItem(Items item) {
        items.add(item);
    }

    float getCost() {
        float sum = 0;
        for (Items i : items) {
            sum += i.price;
        }
        return sum;
    }

    void showItems() {
        for (Items i : items) {
            System.out.println(i);
        }

        System.err.println("Total cost : " + getCost());
    }
}

class MealBuilder {
    Meal m;

    MealBuilder() {
        m = new Meal();
    }

    Meal prepareVegMeal() {
        m.addItem(new VegBurger());
        m.addItem(new Pepsi());
        return m;
    }

    Meal prepareNonVegMeal() {
        m.addItem(new ChickenBurger());
        m.addItem(new Coke());
        return m;
    }
}

class Test {

    public static void main(String[] args) {

        MealBuilder mb = new MealBuilder();

        Meal m = mb.prepareVegMeal();
        m.showItems();
    }
}
