import agency.*;
import java.util.*;

public class UltraDome extends Facilitator{
  private Stack<Weapon> weaponStack;
  private Stack<Skin> skinStack;
  private Stack<Double> medicineStack;
  private final int AMOUNT_EQUIPMENT = 100;
  private final int AMOUNT_WARRIOR = 50;

  public UltraDome(){
    super();
    weaponStack = new Stack<Weapon>();
    skinStack = new Stack<Skin>();
    medicineStack = new Stack<Double>();


    for(int i = 0; i < AMOUNT_WARRIOR; i++){
      add(new Agent(this, i, new Status()));
    }

    Random random = new Random();
    for(int i = 0; i < AMOUNT_EQUIPMENT; i++){
      int rd = random.nextInt(4);
      if(rd == 0) weaponStack.push(Weapon.Iron);
      if(rd == 1) weaponStack.push(Weapon.Magic);
      if(rd == 2) weaponStack.push(Weapon.Chemical);
      if(rd == 3) weaponStack.push(Weapon.Fire);
    }

    for(int i = 0; i < AMOUNT_EQUIPMENT; i++){
      int rd = random.nextInt(4);
      if(rd == 0) skinStack.push(Skin.IronSkin);
      if(rd == 1) skinStack.push(Skin.MagicSkin);
      if(rd == 2) skinStack.push(Skin.ChemicalSkin);
      if(rd == 3) skinStack.push(Skin.FireSkin);
    }

    for(int i = 0; i < AMOUNT_EQUIPMENT; i++){
      int rd = random.nextInt(100);
      medicineStack.push((double)rd);
    }
  }

  @Override
  public void react(Agent attacker){
    if(((Status)(attacker.getMessage())).isDead()) return;

    int luck = (new Random()).nextInt(40);
    if(0 <= luck && luck < 10){
      drinkMedicine(attacker);
    }else if(10 <= luck && luck < 20){
      changeWeapon(attacker);
    }else if(20 <= luck && luck < 30){
      strenghtenSkin(attacker);
    }else{
      performAttack(attacker);
    }
  }
  private void drinkMedicine(Agent attacker){
    if(medicineStack.isEmpty()){
      System.out.println("Out of medicine!");
      return;
    }

    Status status = (Status)(attacker.getMessage());
    double medicine = medicineStack.pop();
    double health = status.getHealth() + medicine;
    if(health > 100) status.setHealth(100);
    else status.setHealth(health);
    System.out.printf("Warrior %d increases health to %.0f\n", attacker.getID(), status.getHealth());
  }
  private void changeWeapon(Agent attacker){
    if(weaponStack.isEmpty()){
      System.out.println("Out of weapon!");
      return;
    }

    Status status = (Status)(attacker.getMessage());
    status.setWeapon(weaponStack.pop());
    System.out.printf("Warrior %d changes weapon to %s\n", attacker.getID(),status.getWeapon().toString() );
  }
  private void strenghtenSkin(Agent attacker){
    if(skinStack.isEmpty()){
      System.out.println("Out of skin!");
      return;
    }

    Skin skin = skinStack.pop();
    Status status = (Status)(attacker.getMessage());
    status.setShield(new Shield(skin, status.getShield()));
    System.out.printf("Warrior %d gets new skin %s\n", attacker.getID(), skin.toString());
  }
  private void performAttack(Agent attacker){
    Agent target = getPartner(attacker);
    Status statusAttacker = (Status)(attacker.getMessage());
    Status statusTarget = (Status)(target.getMessage());


    if(((Status)(target.getMessage())).isDead()) return;


    Weapon wAttacker = statusAttacker.getWeapon();
    Shield sTarget = statusTarget.getShield();
    double harm = sTarget.getHarmAfterDefense(wAttacker);
    double healthTarget = statusTarget.getHealth() - harm;
    statusTarget.setHealth(healthTarget);
    System.out.printf("Warrior %d is attacked!\n", target.getID());
    System.out.printf("Warrior %d's health after attack: %.0f\n", target.getID(), statusTarget.getHealth());
    if(healthTarget <= 0){
      System.out.printf("Warrior %d died!\n", target.getID());
      statusTarget.halt();
    }
  }
}
