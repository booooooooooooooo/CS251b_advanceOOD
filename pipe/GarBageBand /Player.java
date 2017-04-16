import pipe.*;
public class Player<T> extends Customer<T>{
  public Player(Pipe<T> pin){
    super(pin);
  }
  public void run(){
    System.out.printf("Customer(player) eats: ");
    System.out.println(pin.read());
  }
}
