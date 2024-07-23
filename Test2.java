abstract class Pen {
    public String refil;
    public String tube;

    Pen(String refil, String tube) {
        this.refil = refil;
        this.tube = tube;
    }

    abstract public String getRefil();

    abstract public String getTube();

    public void write() {
        System.out.println("these pen can write");
    }

}

class Gel extends Pen {

    Gel(String refil, String tube) {
        super(refil, tube);
    }

    public String getRefil() {
        return this.refil;
    }

    public String getTube() {
        return this.tube;
    }

}

class Sketch extends Pen {

    Sketch(String refil, String tube) {
        super(refil, tube);
    }

    public String getRefil() {
        return this.refil;
    }

    public String getTube() {
        return this.tube;
    }

}

public class Test2 {
    public static void main(String[] args) {

        Gel gel = new Gel("plastice", "metal");

        System.out.println("these is for gel pen : -> ");
        System.out.println("gel pen has refil of : " + gel.getRefil());
        System.out.println("gel pen has tube of : " + gel.getTube());
        gel.write();
        Sketch sketch = new Sketch("sponge", "fibre");

        System.out.println("these is for sketch pen: ->");
        System.out.println("sketch pen has refil of : " + sketch.getRefil());
        System.out.println("sketch pen has tube of : " + sketch.getTube());
    }
}
