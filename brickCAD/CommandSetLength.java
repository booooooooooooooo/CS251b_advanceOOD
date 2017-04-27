import mvc.*;

public class CommandSetLength extends Command {
  public CommandSetLength(Model model, boolean undoable) {
    super(model, undoable);
  }
  @Override
  public void action() {
    double length = Double.parseDouble(Utilities.askUser("Enter height:")) ;
    BrickModel bm = (BrickModel)model; // TODO check isinstanceof
    bm.setLength(length);
  }
}
