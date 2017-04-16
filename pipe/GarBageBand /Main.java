import pipe.*;
import java.util.*;
public class Main{
  public static void main(String[] args){
    Integer[] input = {1,2,3};
    System.out.println(Arrays.toString(input));
    Pipe<Integer> pipe1 = new Pipe<Integer>();
    Pipe<Integer> pipe2 = new Pipe<Integer>();
    Pipe<Integer> pipe3 = new Pipe<Integer>();
    Pipe<Integer> pipe4 = new Pipe<Integer>();
    Pipe<Integer> pipe5 = new Pipe<Integer>();
    DigitalComposer<Integer> composer = new DigitalComposer<Integer>(pipe1);
    Amplifier<Integer> amplifier = new Amplifier<Integer>(pipe1, pipe2);
    DurationFilters<Integer> durtionFilter = new DurationFilters<Integer>(pipe2, pipe3);
    NoiseFilter<Integer> noiseFilter = new NoiseFilter<Integer>(pipe3, pipe4);
    Player<Integer> player = new Player<Integer>(pipe4);
    composer.start(input);
  }
}
