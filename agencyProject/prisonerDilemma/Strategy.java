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
    return String.format("0 0 %d\n0 1 %d\n1 0 %d\n1 1 %d\n", (stgy>>0) & 1, (stgy>>1) & 1, (stgy>>2) & 1,(stgy>>3) & 1 );
  }
}
