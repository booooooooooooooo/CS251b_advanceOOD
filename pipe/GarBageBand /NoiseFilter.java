import pipe.*;
public class NoiseFilter extends Transformer<Note>{
  public NoiseFilter(Pipe<Note> pin,Pipe<Note> pout){
    super(pin, pout);
  }
  public Note transform(Note m){
    System.out.println("NoiseFilter starts!");
    return m;
  }
}
