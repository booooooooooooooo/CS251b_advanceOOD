package mvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.io.*;

public class MVCApp extends JFrame {

  private JDesktopPane desktop;
  private AppFactory factory;
  private Model model;
  private CommandProcessor commandProcessor;

  public MVCApp(AppFactory factory) {

    this.factory = factory;
    this.model = factory.makeModel();
    this.commandProcessor = new CommandProcessor();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setDefaultLookAndFeelDecorated(true);
    desktop = new JDesktopPane(); // a specialized layered pane

    int inset = 50;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(inset, inset, screenSize.width - inset * 2,
              screenSize.height - inset * 2);

    // create first "window" here (I forgot to do this) TODO

    setContentPane(desktop);
    setJMenuBar(createMenuBar());

    // Make dragging a little faster but perhaps uglier.
    desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
  }

  public static void run(AppFactory factory) {
    try {
      MVCApp app = new MVCApp(factory);
      app.setSize(800, 600);
      app.setTitle(factory.getTitle());
      app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      app.setVisible(true);
    } catch (Exception e) {
      Utilities.error("" + e);
    }
  }

  protected JMenuBar createMenuBar() {
    JMenuBar menubar = new JMenuBar();
    String[] fileItems = {"Save", "SaveAs", "Open", "New", "Exit"};
    String[] editItems = {"Undo", "Redo", "SetHeight", "SetWidth", "SetLength"};
    String[] viewItems = {"Front", "Top", "Side","Dimension"};
    String[] helpItems = {"Help"};
    String[] aboutItems = {"About"};
    JMenu filemenu = Utilities.makeMenu("File", fileItems, new FileHandler()) ;
    JMenu editmemu = Utilities.makeMenu("Edit", editItems, new EditHandler());
    JMenu viewmenu = Utilities.makeMenu("View", viewItems, new ViewHandler());
    JMenu helpmenu = Utilities.makeMenu("Help", helpItems, new HelpHandler());
    JMenu aboutmenu = Utilities.makeMenu("About", aboutItems, new AboutHandler());
    menubar.add(filemenu);
    menubar.add(editmemu);
    menubar.add(viewmenu);
    menubar.add(helpmenu);
    menubar.add(aboutmenu);
    return menubar;
  }

  class FileHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String cmmd = e.getActionCommand();
      if (cmmd == "Save") {
        Utilities.save(model);
      } else if (cmmd == "SaveAs") {
        Utilities.error("Sorry, not yet implemented");
      } else if (cmmd == "Open") {
        Utilities.error("Sorry, not yet implemented");
      } else if (cmmd == "New") {
        Utilities.saveChanges(model);
        model = factory.makeModel();
      } else if (cmmd == "Exit") {
        Utilities.saveChanges(model);
        System.exit(1);
      } else {
        Utilities.error("Unrecognized command: " + cmmd);
      }
    }
  }

  // sort of works
  class ViewHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String cmmd = e.getActionCommand();
      View panel = factory.makeView(cmmd, model);
      ViewFrame vf = new ViewFrame(panel);
      vf.setVisible(true);
      desktop.add(vf);
      try {
        vf.setSelected(true);
      } catch (java.beans.PropertyVetoException ex) {
      }
    }
  }

  class EditHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String cmmd = e.getActionCommand();
      // make a command and ask command processor to execute it TODO
      if (cmmd == "Undo") {
        commandProcessor.undo();
      } else if (cmmd == "Redo") {
        commandProcessor.redo();
      } else if (cmmd == "SetHeight") {
        commandProcessor.execute(factory.makeCommand(cmmd, model) );
      } else if (cmmd == "SetWidth") {
        commandProcessor.execute(factory.makeCommand(cmmd, model) );
      } else if (cmmd == "SetLength") {
        commandProcessor.execute(factory.makeCommand(cmmd, model) );
      } else {
        Utilities.error("Unrecognized command: " + cmmd);
      }
    }
  }
	class HelpHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
      String cmmd = e.getActionCommand();
      if (cmmd == "Help") {
        Utilities.informUser(factory.getHelp());
      } else {
        Utilities.error("Unrecognized command: " + cmmd);
      }
    }
	}
  class AboutHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String cmmd = e.getActionCommand();
      if (cmmd == "About") {
        Utilities.informUser(factory.about());
      } else {
        Utilities.error("Unrecognized command: " + cmmd);
      }
    }
  }
}
