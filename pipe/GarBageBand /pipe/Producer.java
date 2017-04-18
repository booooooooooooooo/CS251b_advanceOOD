package pipe;

public abstract class Producer<T> extends Filter<T>{
  public Producer(Pipe<T> pout){
    super(null, pout);

  }

  public void update(){
    pout.isDemandDriven = false;
    produce();

  }

  public void start(){
    pout.isDemandDriven = false;
    produce();
  }
  //produce
  public abstract void produce();


}
