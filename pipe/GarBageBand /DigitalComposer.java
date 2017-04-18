import pipe.*;

import java.util.*;

public class DigitalComposer extends Producer<Note>{
  public DigitalComposer(Pipe<Note> pout){
    super(pout);
  }
  public void produce(){

    int i = 0;
    while(i++ < 5){
      System.out.println(i);
      System.out.println("DigitalComposer startes!");
      Random random = new Random();
      int frequency = random.nextInt(1000);
      int amplitude = random.nextInt(1000);
      int duration = random.nextInt(1000);
      Note note = new Note(frequency, amplitude, duration);
      pout.write(note);
    }
  }
}
