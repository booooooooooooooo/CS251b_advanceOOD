import pipe.*;
public class NoiseFilter extends Transformer<Note>{
  public NoiseFilter(Pipe<Note> pin,Pipe<Note> pout){
    super(pin, pout);
  }
  public Message<Note> transform(Message<Note> m){
    System.out.println("NoiseFilter starts!");
    if(m.getContent().frequency > 10000){
      m.quit = true;
    }
    return m;
  }
}
