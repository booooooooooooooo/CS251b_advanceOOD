package agency;

public class Agent extends Thread {
  private Facilitator facilitator;
  private int id;
  private Message message;
  public Agent(Facilitator f, int id, Message m){
    this.facilitator = f;
    this.id = id;
    this.message = m;
  }

  public Message getMessage(){return this.message;}


  public int getID(){return this.id;}

  public void run() {
    while(true){
      facilitator.update(this);
      try{
        sleep(500);
      }catch( InterruptedException e){

      }
    }
  }
}
