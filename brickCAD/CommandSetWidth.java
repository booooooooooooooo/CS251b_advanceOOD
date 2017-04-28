import mvc.*;

public class CommandSetWidth extends Command {
  public CommandSetWidth(Model model, boolean undoable) {
    super(model, undoable);
  }
  @Override
  public void action() {
    double width = Double.parseDouble(Utilities.askUser("Enter width:")) ;
    if(width <= 0){
      Utilities.error("Invalid value!");
      return;
    }
    BrickModel bm = (BrickModel)model; // TODO check isinstanceof
    bm.setWidth(width);
  }
}
