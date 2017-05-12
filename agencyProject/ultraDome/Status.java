import agency.*;


public class Status implements Message{
  private int health;
  private Weapon weapon;
  private Skin skin;
  private boolean isDead;

  public int getHealth(){return this.health;}
  public void setHealth(int h){this.health = h;}


  public Weapon getWeapon(){return this.weapon;}
  public void setWeapon(Weapon wp){this.weapon = wp;}

  public Skin getSkin(){return this.skin;}
  public void setSkin(Skin sk){this.skin = sk;}

  public void halt(){this.isDead = true;}
  public boolean isDead(){return this.isDead;}



}
