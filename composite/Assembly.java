import java.util.ArrayList;

interface Component {

    @Override
    String toString();
}

class Assembly implements Component {
    ArrayList<Component> al = new ArrayList<>();

    public void addComponent(Component obj) {
        al.add(obj);
    }
    @Override
    public String toString() {
        return "Assembly";
    }

    public static int sumCost(Component a) {

        if (a instanceof Part) {
            return ((Part) a).cost;
        }

        int sum = 0;
        for (Component component : ((Assembly)a).al) {
                if(component instanceof Assembly) {
                    sum += sumCost(component);
                } else {
                    sum += ((Part) component).cost;
                }
        }
        return sum;
    }
}

class Part implements Component {
    int cost;
    Part(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Part";
    }
}

class Test {
    public static void main(String[] args) {
        Assembly a = new Assembly();
        Assembly b = new Assembly();
        a.addComponent(b);
        a.addComponent(new Part(99));
        a.addComponent(new Part(199));

        b.addComponent(new Part(9));
        b.addComponent(new Part(19));
        System.out.println(Assembly.sumCost(a));
    }
}