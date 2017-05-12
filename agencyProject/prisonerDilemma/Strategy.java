import agency.*;

public class Strategy implements Message{
  private int stgy;
  public Strategy(int order){
    this.stgy = order;
  }
  public int getChoice(int rec){
    return ( (stgy >> rec) & 1 );
  }
  @Override
  public String toString(){
    //TODO
    return "not support yet";
  }
}
