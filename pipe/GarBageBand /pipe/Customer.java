package pipe;

public abstract class Customer<T> extends Filter<T>{
  public Customer(Pipe<T> pin){
    super(pin, null);

  }

  public void start(){
    pin.isDemandDriven = true;
    pin.notifyFilters();
  }

  public void update(){
    consume();
  }

  //consume
  public abstract void consume();
}
