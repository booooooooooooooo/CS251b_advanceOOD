public enum Skin{
  IronSkin(Weapon.Iron), MagicSkin(Weapon.Magic), ChemicalSkin(Weapon.Chemical), FireSkin(Weapon.Fire);
  private Weapon weapon;
  Skin(Weapon weapon){
    this.weapon = weapon;
  }
  public Weapon getTargetWeapon(){
    return this.weapon;
  }
}
