import mvc.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ViewWindow extends View {
  //TODO: JComponent
  private BrickModel bm;
  public ViewDimension(Model model) {
    super(model);

    //TODO: make window according data in model

  }

  // public void paintComponent(Graphics g){
  //
  // }
  @Override
  public void update(Observable arg0, Object arg1) {
    // TODO: change data in panel and repaint
    //TODO: update field variables
    repaint();
  }


}
