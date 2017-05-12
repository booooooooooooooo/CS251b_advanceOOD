import agency.*;


public class Status implements Message{
  private double health;
  private Weapon weapon;
  private Shield shield;
  private boolean isDead;

  public Status(){
    health = 100;
    weapon = Weapon.Iron;
    shield = new Shield(Skin.IronSkin, null);
    isDead = false;
  }
  public double getHealth(){return this.health;}
  public void setHealth(double health){this.health = health;}

  public Weapon getWeapon(){return this.weapon;}
  public void setWeapon(Weapon weapon){this.weapon = weapon;}

  public Shield getShield(){return this.shield;}
  public void setShield(Shield shield){this.shield = shield;}

  public void halt(){this.isDead = true;}
  public boolean isDead(){return this.isDead;}



}
