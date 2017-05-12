package agency;

public class Agent extends Thread {
  private Facilitator facilitator;
  private int id;
  private Message message;
  private boolean isDead;
  public Agent(Facilitator f, int id, Message m){
    this.facilitator = f;
    this.id = id;
    this.message = m;
    this.isDead = false;
  }
  public void halt(){
    this.isDead = true;
  }
  public Message getMessage(){return this.message;}

  public boolean isDead(){return this.isDead};

  public int getID(){return this.id;}

  public void run(){
    while(!isDead){
      facilitator.update(this);
      sleep(500);
    }
  }
}
