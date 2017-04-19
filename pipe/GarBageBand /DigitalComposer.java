import pipe.*;

import java.util.*;

public class DigitalComposer extends Producer<Note>{
  public DigitalComposer(Pipe<Note> pout){
    super(pout);
  }
  public Message<Note> produce(){
    System.out.println("DigitalComposer produces one message!");
    Random random = new Random();
    int frequency = random.nextInt(1000);
    int amplitude = random.nextInt(1000);
    int duration = random.nextInt(1000);
    Note note = new Note(frequency, amplitude, duration);
    Message<Note> m = new Message(false, false, note);
    return m;

  }
}
