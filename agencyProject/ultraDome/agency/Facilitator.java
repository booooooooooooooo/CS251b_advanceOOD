package agency;

import java.util.*;

public abstract class Facilitator{
  private static int count;
  protected List<Agent> agents;
  public Facilitator(){
    agents = new ArrayList<Agent>();
    count = 0;
  }
  protected void add(Agent a){
    agents.add(a);
  }
  public void start(){
    for(int i = 0; i < agents.size(); i++){
      agents.get(i).start();
    }
  }
  protected Agent getPartner(Agent a){
    if(agents.size() <= 1) System.out.println("Less than or equal to one agents");//TODO: throw error
    while(true){
      int id =  (new Random()).nextInt(agents.size());
      System.out.printf("Agent ID: %d\n", id);
      if( agents.get(id).getID() != a.getID() ) {

        return agents.get(id);
      }
    }
  }

  public synchronized void update(Agent a1){
    System.out.printf("%dth Update\n", count);
    count++;
    Agent a2 = getPartner(a1);
    react(a1, a1);
  }
  //To be overriden
  public abstract void react(Agent a1, Agent a2);

}
