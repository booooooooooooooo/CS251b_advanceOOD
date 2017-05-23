import pipe.*;

import java.util.Random;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

class Note {
  private int frequency, duration, amplitude;

  public Note(int frequency, int duration, int amplitude) {
    this.frequency = frequency;
    this.duration = duration;
    this.amplitude = amplitude;
  }

  @Override
  public String toString() {
    return "Note [frequency=" + frequency + ", duration=" + duration +
        ", amplitude=" + amplitude + "]";
  }

  public int getFrequency() { return frequency; }

  public void setFrequency(int frequency) { this.frequency = frequency; }

  public int getDuration() { return duration; }

  public void setDuration(int duration) { this.duration = duration; }

  public int getAmplitude() { return amplitude; }

  public void setAmplitude(int amplitude) { this.amplitude = amplitude; }
}

public class GarbageBand extends PipeLine<Note> {

  class FrequencyFilter extends Tester {
    public int maxFrequency = 127;
    public int minFrequency = 0;
    public boolean test(Note n) {
      System.out.println("testing frequency");
      return minFrequency <= n.getFrequency() &&
          n.getFrequency() <= maxFrequency;
    }
  }

  class DurationFilter extends Tester {
    public int maxDuration = 1500;
    public int minDuration = 10;
    public boolean test(Note n) {
      System.out.println("testing duration");
      return minDuration <= n.getDuration() && n.getDuration() <= maxDuration;
    }
  }

  class Amplifier extends Transformer {
    public int boost = 3;
    public Note transform(Note n) {
      System.out.println("amplifying");
      n.setAmplitude(boost * n.getAmplitude());
      return n;
    }
  }

  class Composer extends Producer {
    private Random generator;
    private int scoreSize = 20;
    private int numNotes = 0;
    public Composer(int scoreSize) {
      this.scoreSize = scoreSize;
      numNotes = 0;
      generator = new Random(System.nanoTime());
    }
    public Note produce() {
      if (scoreSize < numNotes++)
        return null;
      Note n = new Note(Math.abs(generator.nextInt(200)),
                        Math.abs(generator.nextInt(3000)),
                        Math.abs(generator.nextInt(200)));
      System.out.println("new note = " + n);
      return n;
    }
  }

  public class Player extends Consumer {
    private Synthesizer synth;
    private MidiChannel instrument; // misnamed?
    public Player() {
      try {
        synth = MidiSystem.getSynthesizer();
        synth.open();
        instrument = synth.getChannels()[5];
      } catch (Exception e) {
        System.err.println(e);
      }
    }

    public void setChannel(int i) { instrument = synth.getChannels()[i]; }
    public void consume(Note n) {
      try {
        System.out.println("playing: " + n);
        instrument.noteOn(n.getFrequency(), n.getAmplitude());
        Thread.sleep(n.getDuration());
        instrument.noteOff(n.getFrequency());
      } catch (Exception e) {
        System.err.println(e);
      }
    }
  }

  public static void main(String[] args) {

		GarbageBand gb = new GarbageBand();
    Composer composer = gb.new Composer(50);
    Player player = gb.new Player();
    Amplifier amplifier = gb.new Amplifier();
    FrequencyFilter ff = gb.new FrequencyFilter();
    DurationFilter df = gb.new DurationFilter();


    System.out.println("data-driven mode");
    DemandDriven = false;
    gb.connect(composer, ff);
    gb.connect(ff, amplifier);
    gb.connect(amplifier, df);
    gb.connect(df, player);
    composer.start();
		System.out.println("done");

		System.out.println("demand-driven mode");
		DemandDriven = true;
		gb.connect(composer, ff);
    gb.connect(ff, amplifier);
    gb.connect(amplifier, df);
    gb.connect(df, player);
    player.consume();
    System.out.println("done");
  }
}
