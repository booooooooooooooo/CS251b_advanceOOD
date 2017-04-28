import mvc.*;
import java.util.*;
import java.awt.*;

public class ViewTop extends View {
  public ViewTop(Model model) {
    super(model);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.red);
    BrickModel bm = (BrickModel)this.model;
    double height = bm.getHeight();
    double length = bm.getLength();
    g.fillRect(0, 0, (int)length, (int)height);
  }


  @Override
  public void update(Observable arg0, Object arg1) {
    this.repaint();
  }
}
