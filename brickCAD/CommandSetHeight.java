import mvc.*;

public class CommandSetHeight extends Command {
  public CommandSetHeight(Model model, boolean undoable) {
    super(model, undoable);
  }
  @Override
  public void action() {
    double height = Double.parseDouble(Utilities.askUser("Enter height:")) ;
    if(height <= 0){
      Utilities.error("Invalid value!");
      return;
    }
    BrickModel bm = (BrickModel)model; // TODO check isinstanceof
    bm.setHeight(height);
  }
}
