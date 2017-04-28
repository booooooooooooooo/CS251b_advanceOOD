import mvc.*;
import java.util.*;
import java.awt.*;

public class ViewSide1 extends View {
  public ViewSide1(Model model) {
    super(model);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.red);
    BrickModel bm = (BrickModel)this.model;
    double width = bm.getWidth();
    double length = bm.getLength();
    g.fillRect(0, 0, (int)length, (int)width);
  }


  @Override
  public void update(Observable arg0, Object arg1) {
    this.repaint();
  }

}
