public class Skin{
  private Skin oldSkin;
  public Skin(Skin oldSkin){
    this.oldSkin = oldSkin;
  }
  public int defend(Weapon weapon){
    int harm = weapon.getStrikeHarm();
    int reduce = this.reduce(harm);
  }
  public int reduce(int harm){
    
  }
}
