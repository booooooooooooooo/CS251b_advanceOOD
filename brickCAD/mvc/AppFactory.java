package mvc;

public interface AppFactory{
  public Model makeModel();
  public View makeView(String viewType);
  public Command makeCommand(String cmmdName);
  public String getViews();
  public String getCommands();
  public String getTitle();
  public String getHelp();
  public String about();
}
