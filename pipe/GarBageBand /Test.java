import  javax.sound.midi.*;
public class Test{
  public static void main(String args[]) throws MidiUnavailableException, InterruptedException{
    Synthesizer synth = MidiSystem.getSynthesizer();
    synth.open();
    MidiChannel channel = synth.getChannels()[0];

    channel.noteOn( 60, 10000 );
    Thread.sleep( 1000);
    channel.noteOff(60);


  }
}
