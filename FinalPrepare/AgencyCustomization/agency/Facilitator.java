package agency;

public class Facilitator{
  private List<Agent> agents;

  public Facilitator(){
    this.agents = new ArrayList<Agent>();
  }
  public void add(Agent a){
    agents.add(a);
  }
  public void send(Agent a, Message m){
    a.addToMessageQueue(m);
  }

  public void start(){
    // for(int i = 0; i < agents.size(); i++) agents.get(i).start();//For multithread

    //for single thread
    while(true){
      int id =  (new Random()).nextInt(agents.size());
      agents.get(i).update();
    }
  }
}
