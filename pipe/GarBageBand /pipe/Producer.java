package pipe;

public abstract class Producer<T> extends Filter<T>{
  public Producer(Pipe<T> pout){
    super(null, pout);

  }

  public void update(){}

  //produce
  public abstract void start(T[] input);

}
