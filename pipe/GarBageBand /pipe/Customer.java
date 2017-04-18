package pipe;

public abstract class Customer<T> extends Filter<T>{
  public Customer(Pipe<T> pin){
    super(pin, null);

  }

  public void update(){
    if(! pin.isDemandDriven){
      consume();
    }
  }

  public void start(){
    pin.isDemandDriven = true;
    pin.notifyFilters();
  }

  //consume
  public abstract void consume();
}
