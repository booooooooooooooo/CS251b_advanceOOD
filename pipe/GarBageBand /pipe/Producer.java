package pipe;

public abstract class Producer<T> extends Filter<T>{
  private final int AMOUNTOFMESSAGE = 5;//amount of data to produce

  public Producer(Pipe<T> pout){
    super(null, pout);
  }

  public void start(){
    pout.isDemandDriven = false;
    run();
  }

  public void update(){
    pout.isDemandDriven = false;
    run();
  }

  public void run(){
    int i = 0;
    while(i++ < AMOUNTOFMESSAGE){
      Message<T> m = produce();
      pout.write(m);
    }
  }

  //produce one message
  public abstract Message<T> produce();


}
