import mvc.*;
import java.util.*;
import java.awt.*;

public class ViewFront extends View {
  public ViewFront(Model model) {
    super(model);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.red);
    BrickModel bm = (BrickModel)this.model;
    double width = bm.getWidth();
    double height = bm.getHeight();
    g.fillRect(0, 0, (int)height, (int)width);
  }


  @Override
  public void update(Observable arg0, Object arg1) {
    this.repaint();
  }
}
