import pipe.*;

public class Amplifier<T> extends Transformer<T>{
  public Amplifier(Pipe<T> pin,Pipe<T> pout){
    super(pin, pout);
  }
  public T transform(T m){
    System.out.println("Amplifier starts!");
    return m;
  }

}
