import pipe.*;
import  javax.sound.midi.*;

public class Player extends Customer<Note>{
  public Player(Pipe<Note> pin){
    super(pin);
  }
  public void consume(){
    System.out.println("Player plays! ");
    try{
      Message<Note> m = pin.read();

      Synthesizer synth = MidiSystem.getSynthesizer();
      synth.open();
      MidiChannel channel = synth.getChannels()[0];

      channel.noteOn( m.getContent().frequency, m.getContent().amplitude );
      Thread.sleep( 1000);
      channel.noteOff(m.getContent().frequency);
    }catch(MidiUnavailableException e1){

    }catch(InterruptedException e2){

    }


  }
}
