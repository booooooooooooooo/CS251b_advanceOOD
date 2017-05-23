package agency;

public abstract class Agent{
  private int id;
  Queue<Message> messageQueue;
  Facilitator fac;
  public Agent(int id, Facilitator fac){
    this.id = id;
    messageQueue = new LinkedList<Message>();
    this.fac = fac;
  }
  public void addToMessageQueue(Message m){
    messageQueue.add(m);
  }
  
  //For multithread

  // public void run(){
  //   while(true){
  //     synchoronize(fac) {
  //       this.update();
  //     }
  //   }
  // }
  public abstract void update();

}
