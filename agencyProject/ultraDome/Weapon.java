public enum Weapon{
  Iron(50), Magic(100), Chemical(150), Fire(200);

  private final double harm;

  Weapon(double harm){
    this.harm = harm;
  }
  public double getHarm(){
    return this.harm;
  }
}
