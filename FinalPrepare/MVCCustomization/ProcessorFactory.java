import mvc.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class ProcessorFactory implements AppFactory {
  private ArrayList<String> cmdList;
  private ArrayList<String> viewList;

  public ProcessorFactory(){
    this.cmdList = new ArrayList<String>();
    this.viewList = new ArrayList<String>();
  }
  @Override
  public Model makeModel() {
    return new ProcessorModel();
  }
  @Override
  public View makeView(String viewType, Model model) {
    viewList.add(viewType);
    if(viewType.equals("Window")) return new ViewWindow(model);
    else return null;
  }
  @Override
  public Command makeCommand(String cmmdName, Model model) {
    cmdList.add(cmmdName);
    if(cmmdName.equals("InsertText")) return new CommandInsertText(model, true);
    else if(cmmdName.equals("SetCursor")) return new CommandSetCursor(model, true);
    else return null;
  }
  @Override
  public String getViews() {
    return viewList.toString();
  }
  @Override
  public String getCommands() {
    return cmdList.toString();
  }
  @Override
  public String getTitle() {
    // TODO
    return "Brick CAD";
  }

  @Override
  public String getHelp() {
    // TODO
    return "Call 0000000000 to get help!!";
  }
  @Override
  public String about() {
    // TODO
    return "There is a CAD called BrickCAD";
  }
}
