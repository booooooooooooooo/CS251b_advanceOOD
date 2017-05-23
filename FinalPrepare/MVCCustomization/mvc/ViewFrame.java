package mvc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class ViewFrame extends JInternalFrame {
  private static int openFrameCount = 0;
  public ViewFrame(View view) {
    super("View #" + (++openFrameCount),
          true,  // resizable
          true,  // closable
          true,  // maximizable
          true); // iconifiable
    setContentPane(view);
    setSize(600, 600);
    setLocation(30 * openFrameCount, 30 * openFrameCount);
    pack();
  }
}
