import mvc.*;

public class CommandSetHeight extends Command {
  public CommandSetHeight(Model model, boolean undoable) {
    super(model, undoable);
  }
  @Override
  public void action() {
    double height = Double.parseDouble(Utilities.askUser("Enter height:")) ;
    BrickModel bm = (BrickModel)model; // TODO check isinstanceof
    bm.setHeight(height);
  }
}
