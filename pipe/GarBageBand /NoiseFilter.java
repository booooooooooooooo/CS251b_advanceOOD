import pipe.*;
public class NoiseFilter<T> extends Transformer<T>{
  public NoiseFilter(Pipe<T> pin,Pipe<T> pout){
    super(pin, pout);
  }
  public T transform(T m){
    System.out.println("NoiseFilter starts!");
    return m;
  }
}
