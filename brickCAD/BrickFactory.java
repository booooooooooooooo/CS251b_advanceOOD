import mvc.*;

public class BrickFactory implements AppFactory {
  private Model model;
  @Override
  public Model makeModel() {
    // TODO
    this.model = new BrickModel();
    return this.model;
  }
  @Override
  public View makeView(String viewType) {
    // TODO
    return new ViewSide(this.model);
  }
  @Override
  public Command makeCommand(String cmmdName) {
    // TODO
    return new CommandSetHeight(this.model, true, 10);
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
