package pipe;
public abstract class Transformer<T> extends Filter<T>{
  public Transformer(Pipe<T> pin,Pipe<T> pout){
    super(pin, pout);
  }
  public void update(){
    T m = transform(pin.read());
    pout.write(m);
  }
  //transform
  public abstract T transform(T m);
}
