package agency;

import java.util.*;

public abstract class Facilitator{
  private List<Agent> agents;
  public Facilitator(){
    agents = new ArrayList<Agent>();
  }
  public add(Agent a){
    agents.add(a);
  }
  public start(){
    for(int i = 0; i < agents.size(); i++){
      agents.get(i).start();
    }
  }
  public Agent getPartner(Agent a){
    if(agents.size() <= 1) ;//TODO: throw error
    while(true){
      int id =  (new Random()).nextInt() % agents.size();
      if( id != a.getID() ) return agents.get(id);
    }
  }

  public synchronized void update(Agent a1){
    Agent a2 = getPartner(a1);
    react(a1, a1);
  }
  //To be overriden
  public abstract void react(Agent a1, Agent a2);

}
