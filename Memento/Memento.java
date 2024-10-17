import java.util.*;
class Player{
  int life,cp;
  Player(int l,int c){
    life=l;
    cp=c;
  }
}

class Originator{
   Player player;
  public Originator(Player player){
    this.player=player;
  }
  public Memento createMemento(){
    return new Memento(player.life,player.cp);
  }
  public void restoreMemento(Memento memento){
    if(memento==null) {
      player = null;
      return;
    }
    player.life=memento.life;
    player.cp=memento.cp;
  }

  public void setState(int life,int cp){
    player.life=life;
    player.cp=cp;
  }

  @Override
  public String toString(){
    if(player==null) return "No State";
    return "Life: "+player.life+" CP: "+player.cp;
  }
}

class Memento{
  int life,cp;
  Memento(int l,int c){
    life=l;
    cp=c;
  }
}

class CareTaker{
  private Stack<Memento> mementos;
  public CareTaker(){
    mementos=new Stack<Memento>();
  }
  public void addMemento(Memento memento){
    mementos.push(memento);
  }
  public Memento getMemento(){
     mementos.pop();
    if(mementos.isEmpty()) {
      return null;
    }
    return mementos.peek();
  }
}
class test{
  public static void main(String[] args){
      Originator o=new Originator(new Player(1,1));
      CareTaker c=new CareTaker();
      c.addMemento(o.createMemento());
      System.out.println(o);
      o.setState(2,2);
      c.addMemento((o.createMemento()));

      System.out.println(o);
      o.restoreMemento(c.getMemento());
      System.out.println(o);
    
      o.restoreMemento(c.getMemento());
      System.out.println(o);
  }
}