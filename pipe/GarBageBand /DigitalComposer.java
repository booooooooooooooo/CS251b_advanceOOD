import pipe.*;

public class DigitalComposer<T> extends Producer<T>{
  public DigitalComposer(Pipe<T> pout){
    super(pout);
  }
  public void start(T[] input){
    System.out.println("Producer(DigitalComposer) startes!");
    for(int i = 0; i < input.length; i++){
      pout.write(input[i]);
    }
  }
}
