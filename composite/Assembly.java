import java.util.ArrayList;

interface Component {

    @Override
    String toString();
}

class Assembly implements Component {
    ArrayList<Component> al = new ArrayList<>();
    String type;
    Assembly() {
        this.type = "assembly";
    }

    public void addComponent(Component obj) {
        al.add(obj);
    }
    @Override
    public String toString() {
        return type;
    }

    public int sumCost(Component a) {
        int sum = 0;
        for (Component component : ((Assembly)a).al) {
                sum += (part)component.cost + sumCost(component);
        }

        return sum;
    }
}

class Part implements Component {
    int cost;
    String type;
    Part(int cost) {
        this.cost = cost;
        this.type = "part";
    }

    @Override
    public String toString() {
        return type;
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

    }
}