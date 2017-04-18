public class Note{
  public int frequency;
  public int amplitude;
  public int duration;
  public Note(int frequency, int amplitude, int duration){
    this.frequency = frequency;
    this.amplitude = amplitude;
    this.duration = duration;
  }
  public void increaseVolume(int amount){
    this.amplitude += amount;
  }
  public int getDuration(){
    return duration;
  }
}
