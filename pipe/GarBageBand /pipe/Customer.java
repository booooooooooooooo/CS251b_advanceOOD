package pipe;

public abstract class Customer<T> extends Filter<T>{
  public Customer(Pipe<T> pin){
    super(pin, null);

  }

  public void update(){
    run();
  }

  //consume
  public abstract void run();
}
