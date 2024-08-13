import java.util.Arrays;

public class Phone {
    String os;
    int ram, screenSize;

    public String toString() {
        return "\nOperating system :"+os + "\nRam :" + ram + "\nScreensize :" + screenSize;
    }
}

class BuilderPhone {
    Phone p;

    BuilderPhone() {
        this.p = new Phone();
    }

    BuilderPhone setOs(String os) {
        p.os = os;
        return this;
    }

    BuilderPhone setRam(int ram) {
        p.ram = ram;
        return this;
    }

    BuilderPhone setScreenSize(int size) {
        p.screenSize = size;
        return this;
    }

    Phone getGadget() {
        return p;
    }
}

class Test {

    public static void main(String[] args) {

        BuilderPhone bp = new BuilderPhone();

        Phone p = bp.setOs("windows").setRam(8).setScreenSize(40).getGadget();
        System.out.println(p);
        int max[] = {1, 2, 3, 4, 5};


    }
}
