import pipe.*;
import java.util.*;
public class Main{
  public static void main(String[] args){
    Pipe<Note> pipe1 = new Pipe<Note>();
    Pipe<Note> pipe2 = new Pipe<Note>();
    Pipe<Note> pipe3 = new Pipe<Note>();
    Pipe<Note> pipe4 = new Pipe<Note>();
    Pipe<Note> pipe5 = new Pipe<Note>();
    DigitalComposer composer = new DigitalComposer(pipe1);
    Amplifier amplifier = new Amplifier(pipe1, pipe2);
    DurationFilters durtionFilter = new DurationFilters(pipe2, pipe3);
    NoiseFilter noiseFilter = new NoiseFilter(pipe3, pipe4);
    Player player = new Player(pipe4);
    // composer.start();
    player.start();
  }
}
