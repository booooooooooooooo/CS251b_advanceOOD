import mvc.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class BrickFactory implements AppFactory {
  private ArrayList<String> cmdList;
  private ArrayList<String> viewList;

  public BrickFactory(){
    this.cmdList = new ArrayList<String>();
    this.viewList = new ArrayList<String>();
  }
  @Override
  public Model makeModel() {
    return new BrickModel();
  }
  @Override
  public View makeView(String viewType, Model model) {
    viewList.add(viewType);
    if(viewType.equals("Dimension")) return new ViewDimension(model);
    else if(viewType.equals("Side1"))return new ViewSide1(model);
    else if(viewType.equals("Side2")) return new ViewSide2(model);
    else if(viewType.equals("Top")) return new ViewTop(model);
    else if(viewType.equals("Front")) return new ViewFront(model);
    else return null;
  }
  @Override
  public Command makeCommand(String cmmdName, Model model) {
    cmdList.add(cmmdName);
    if(cmmdName.equals("SetLength")) return new CommandSetLength(model, true);
    else if(cmmdName.equals("SetHeight")) return new CommandSetHeight(model, true);
    else if(cmmdName.equals("SetWidth")) return new CommandSetWidth(model, true);
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
