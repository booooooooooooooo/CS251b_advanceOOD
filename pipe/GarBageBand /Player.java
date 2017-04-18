import pipe.*;
import  javax.sound.midi.*;

public class Player extends Customer<Note>{
  public Player(Pipe<Note> pin){
    super(pin);
  }
  public void consume(){
    System.out.println("Player plays! ");
    try{
      Note note = pin.read();

      Synthesizer synth = MidiSystem.getSynthesizer();
      synth.open();
      MidiChannel channel = synth.getChannels()[0];

      channel.noteOn( note.frequency, note.amplitude );
      Thread.sleep( 1000);
      channel.noteOff(note.frequency);
    }catch(MidiUnavailableException e1){

    }catch(InterruptedException e2){

    }


  }
}
