import mvc.*;

public class CommandSetHeight extends Command{
  private double height;
  public CommandSetHeight(Model model, boolean undoable, double height){
    super(model, undoable);
    this.height = height;
  }
  @Override
  public void action(){
    BrickModel bm = (BrickModel)model;//TODO check isinstanceof
    bm.setHeight(height);
  }
}
