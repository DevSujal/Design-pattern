import java.util.*;
abstract public class Mediator {
    ArrayList<Colleague> arrC = new ArrayList<Colleague>();

    public void addColleague(Colleague c) {
        arrC.add(c);
    }

    abstract public void send(String message, Colleague cl);
}

class ConcreteMediator extends Mediator {

  @Override
  public void send(String message, Colleague cl) {
    for(Colleague c : arrC) {
      if(cl != c)
        c.receive(message);
    }
  }
}

abstract class Colleague {
  protected Mediator m;
  Colleague(Mediator m) {
    this.m = m;
  }

  abstract void receive(String message);
  public void sendMediator(String message) {
    m.send(message, this);
  }
}
class Desktop extends Colleague {

  Desktop(Mediator m) {
    super(m);
    m.addColleague(this);
  }

  @Override
  public void receive(String message) {
    System.out.println("message receivd by desktop : " + message);
  }
}
class Mobile extends Colleague {

  Mobile(Mediator m) {
    super(m);
    m.addColleague(this);
  }
  @Override
  public void receive(String message) {
    System.out.println("message receivd by mobile : " + message);
  }
}

class Test {
  public static void main(String[] args) {
    ConcreteMediator m = new ConcreteMediator();
    Colleague d = new Desktop(m);
    Colleague m1 = new Mobile(m);
    System.out.println("Desktop sends a message : ");
    d.sendMediator("Hello");

    System.out.println("Mobile sends a message : ");
    m1.sendMediator("Hi!");
  }
}
