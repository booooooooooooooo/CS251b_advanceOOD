import pipe.*;
public class DurationFilters<T> extends Transformer<T>{
  public DurationFilters(Pipe<T> pin,Pipe<T> pout){
    super(pin, pout);
  }
  public T transform(T m){
    System.out.println("DurationFilters starts!");
    return m;
  }
}
