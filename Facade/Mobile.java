
interface Mobile {

    public void mobileName();
    public void price();
}

class Iphone implements Mobile {


    public void mobileName() {
        System.out.println("Iphone");
    }

    public void price() {
        System.out.println("Rs " + 100000);
    }

    public int getPrice() {
        return 100000;
    }
}
class Samsung implements Mobile {


    public void mobileName() {
        System.out.println("Samsung");
    }

    public void price() {
        System.out.println("Rs " + 50000);
    }

    public int getPrice() {
        return 50000;
    }
}
class Blackbery implements Mobile {


    public void mobileName() {
        System.out.println("Blackbery");
    }

    public void price() {
        System.out.println("Rs " + 999);
    }

    public int getPrice() {
        return 999;
    }
}

class ShopKeeper {
    private Iphone m = new Iphone();
    private Samsung s = new Samsung();
    private Blackbery b = new Blackbery();

    public void iphoneInfo() {
        m.mobileName();
        m.price();
    }
    public void samsungInfo() {
        s.mobileName();
        s.price();
    }
    public void blackberyInfo() {
        b.mobileName();
        b.price();
    }

    public void priceRangeMobile(int budget) {
        if (m.getPrice() <= budget) {
            iphoneInfo();
        }
        if (s.getPrice() <= budget) {
            samsungInfo();
        }
        if(b.getPrice() <= budget) {
            blackberyInfo();
        }
        else {
            System.out.println("There are no phones below this price");
        }
    }
}

class Test {    
    public static void main(String[] args) {
        ShopKeeper s = new ShopKeeper();

        // s.iphoneInfo();
        // s.samsungInfo();
        // s.blackberyInfo();
        s.priceRangeMobile(100000);
    }
}