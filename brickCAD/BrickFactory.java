import mvc.*;

public class BrickFactory implements AppFactory {
  @Override
  public Model makeModel() {
    // TODO
    return new BrickModel();
  }
  @Override
  public View makeView(String viewType, Model model) {
    // TODO
    if(viewType.equals("Dimension")) return new DimensionView(model);
    else if(viewType.equals("Side"))return new ViewSide(model);
    else return new ViewSide(model);
  }
  @Override
  public Command makeCommand(String cmmdName, Model model) {
    // TODO
    if(cmmdName.equals("CommandSetLength")) return new CommandSetLength(model, true);
    else return new CommandSetHeight(model, true);
  }
  @Override
  public String getViews() {
    // TODO
    return "";
  }
  @Override
  public String getCommands() {
    // TODO
    return "";
  }
  @Override
  public String getTitle() {
    // TODO
    return "";
  }
  @Override
  public String getHelp() {
    // TODO
    return "Call 911 to get help!!";
  }
  @Override
  public String about() {
    // TODO
    return "There is a CAD called BrickCAD";
  }
}
