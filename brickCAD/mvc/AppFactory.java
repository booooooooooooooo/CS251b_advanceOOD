package mvc;

public interface AppFactory{
  public Model makeModel();
  public View makeView(String viewType, Model model);
  public Command makeCommand(String cmmdName, Model model);
  public String getViews();
  public String getCommands();
  public String getTitle();
  public String getHelp();
  public String about();
}
