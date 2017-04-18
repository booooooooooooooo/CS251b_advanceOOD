import pipe.*;

public class Amplifier extends Transformer<Note>{
  public Amplifier(Pipe<Note> pin,Pipe<Note> pout){
    super(pin, pout);
  }
  public Note transform(Note m){
    System.out.println("Amplifier starts!");
    m.increaseVolume(100);
    return m;
  }

}
