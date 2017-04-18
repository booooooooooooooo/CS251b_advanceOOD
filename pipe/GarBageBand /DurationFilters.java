import pipe.*;
public class DurationFilters extends Transformer<Note>{
  public DurationFilters(Pipe<Note> pin,Pipe<Note> pout){
    super(pin, pout);
  }
  public Note transform(Note m){
    System.out.println("DurationFilters starts!");
    if(m.getDuration() > 1000) return null;
    return m;
  }
}
