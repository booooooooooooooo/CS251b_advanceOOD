import mvc.*;

public class CommandSetCursor extends Command {
  public CommandSetCursor(Model model, boolean undoable) {
    super(model, undoable);
  }
  @Override
  public void action() {
    double cursor = Integer.parseInteger(Utilities.askUser("Enter position of cursor:")) ;

    ProcessorModel pm = (ProcessorModel)model; // TODO check isinstanceof
    pm.setCursor(cursor);
  }
}
