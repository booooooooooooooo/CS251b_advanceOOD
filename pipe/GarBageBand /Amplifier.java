import pipe.*;

public class Amplifier extends Transformer<Note>{
  public Amplifier(Pipe<Note> pin,Pipe<Note> pout){
    super(pin, pout);
  }
  public Message<Note> transform(Message<Note> m){
    System.out.println("Amplifier starts!");
    m.getContent().increaseVolume(100);
    return m;
  }

}
