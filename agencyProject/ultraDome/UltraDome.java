import agency.*;
import java.util.*;
public UltraDome extends Facilitator{
  public UntroDome(){
    super();
    //TODO: make list of agents
    //TODO: make list of weapons, list of skins, list of medical bowelds......
  }
  @Override
  public void react(Agent a1){
    if(((Status)(a1.getMessage())).isDead()) return;

    int luck = (new Random()).nextInt(40);
    if(0 <= luck && luck < 10){
      drinkMedicine(a1);
    }else if(10 <= luck && luck < 20){
      changeWeapon(a1);
    }else if(20 <= luck && luck < 30){
      strenghtenSkin(a1);
    }else{
      makeAttack(a1);
    }
  }
  private void drinkMedicine(Agent a1){
    //TODO
  }
  private void changeWeapon(Agent a1){
    //TODO
  }
  private void strenghtenSkin(Agent a1){
    //TODO
  }
  private void makeAttack(Agent a1){
    Agent a2 = getPartner(a1);
    if(((Status)(a2.getMessage())).isDead()) return;

    Weapon w1 = ((Status)(a1.getMessage())).getWeapon();
    Skin s2 = ((Status)(a2.getMessage())).getSkin();
    int harm = s2.defend(w1);
    int health1 = ((Status)(a1.getMessage())).getHealth() - harm;
    ((Status)(a1.getMessage())).setHealth(health1);
    if(health1 <= 0){
      System.out.printf("Warrior %d died!", a1.getID());
      ((Status)(a1.getMessage())).halt();
    }
  }
}
