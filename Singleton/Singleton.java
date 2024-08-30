// package Singleton;

public final class Singleton {
    private int data; 

    private Singleton() {

    }
    // eager instantiation
    private static Singleton singleton;

    public static Singleton getInstance() {
        synchronized(Singleton.class) {
        if(singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    public void setData(int data) {
        this.data = data;
    }
    public int getData () {
        return data;
    }


}

class Test {
    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if (s1.hashCode() == s2.hashCode()) {
            System.out.println("Object created are same");
        } else {
            System.out.println("different");
        }

        s1.setData(10);
        s2.setData(30);

        System.out.println(s1.getData());
        System.out.println(s2.getData());
    }
}

