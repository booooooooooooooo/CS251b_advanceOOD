package pipe;

public abstract class Filter<T> implements Subscriber<T>{
  public Pipe<T> pin;
  public Pipe<T> pout;
  public Filter(Pipe<T> pin,Pipe<T> pout){
    this.pin = pin;
    this.pout = pout;

    if(pin != null) pin.connetOutputFilter(this);
    if(pout != null) pout.connetInputFilter(this);
  }
  public abstract void update();
}
