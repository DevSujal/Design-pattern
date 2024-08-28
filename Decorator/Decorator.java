
abstract class Pizza {
    String desc = "pizza";

    public String getDesc() {
        return desc;
    }

    abstract public int getCost();
}

class VegPizza extends Pizza {
    int cost;

    public VegPizza(int cost) {
        this.cost = cost;
        this.desc = "veg Pizza";
    }

    public int getCost() {
        return cost;
    }
}

class NonVegPizza extends Pizza {
    int cost;

    public NonVegPizza(int cost) {
        this.cost = cost;
        this.desc = "nonveg Pizza";
    }

    public int getCost() {
        return cost;
    }
}

class TomatoTopping extends Decorator {

    public TomatoTopping(Pizza p) {
        super(p);
    }

    public String getDesc() {
        return p.getDesc() + ", Decorated with tomato toppings!";
    }

    public int getCost() {
        return p.getCost() + 5;
    }
}

class OlivesTopping extends Decorator {

    public OlivesTopping(Pizza p) {
        super(p);
    }

    public String getDesc() {
        return p.getDesc() + ", Decorated with olives toppings!";
    }

    public int getCost() {
        return p.getCost() + 10;
    }
}

class CapsicumTopping extends Decorator {

    public CapsicumTopping(Pizza p) {
        super(p);
    }

    public String getDesc() {
        return p.getDesc() + ", Decorated with capsicum toppings!";
    }

    public int getCost() {
        return p.getCost() + 4;
    }
}

abstract public class Decorator extends Pizza {
   Pizza p;

   Decorator(Pizza p) {
    this.p = p;
   }
}

class Test {
    public static void main(String[] args) {

        Pizza p = new CapsicumTopping(new OlivesTopping(new TomatoTopping(new NonVegPizza(210))));
        // p = new VegPizza(200);
        System.out.println("description = " + p.getDesc());
        System.out.println("cost = " + p.getCost());
    }
}
