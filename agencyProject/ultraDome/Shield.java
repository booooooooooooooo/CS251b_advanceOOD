public class Shield{
  private Skin skin;
  private Shield oldShield;
  public Shield(Skin skin, Shield oldShield){
    this.skin = skin;
    this.oldShield = oldShield;
  }
  public double getHarmAfterDefense(Weapon weapon){
    return solve(weapon, weapon.getHarm());
  }
  public double solve(Weapon weapon, double harm){
    if(skin.getTargetWeapon() == weapon) harm = harm * 0.95;

    if(oldShield == null) return harm;
    else{
      return oldShield.solve(weapon, harm);
    }
  }
}
