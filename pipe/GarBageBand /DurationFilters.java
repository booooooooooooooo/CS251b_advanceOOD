import pipe.*;
public class DurationFilters extends Transformer<Note>{
  public DurationFilters(Pipe<Note> pin,Pipe<Note> pout){
    super(pin, pout);
  }
  public Message<Note> transform(Message<Note> m){
    System.out.println("DurationFilters starts!");
    if(m.getContent().getDuration() > 1000){
      m.quit = true;
    } 
    return m;
  }
}
