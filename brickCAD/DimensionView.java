import mvc.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class DimensionView extends View {
  public DimensionView(Model model) {
    super(model);
    // TODO: add elements to panel and set it visible

    JLabel titleLabel = new JLabel("Brick Attributes");

    JLabel heightLabel = new JLabel("Height");
    JLabel widthLabel = new JLabel("Width");
    JLabel lengthLabel = new JLabel("Length");

    BrickModel bm = (BrickModel)this.model;

    JTextField heightField = new JTextField(String.valueOf(bm.getHeight()));
    JTextField widthField = new JTextField(String.valueOf(bm.getWidth()));
    JTextField lengthField = new JTextField(String.valueOf(bm.getLength()));

    // //TODO: add ActionListener to JTextField
    // heightField.addActionListener(new ActionListener() {
    //   @Override
    //   public void actionPerformed(ActionEvent e) {
    //     String s = heightField.getText();
    //     double height = Double.parseDouble(s);
    //     ((BrickModel)model).setHeight(height);
    //   }
    // });
    // widthField.addActionListener(new ActionListener() {
    //   @Override
    //   public void actionPerformed(ActionEvent e) {
    //     String s = widthField.getText();
    //     double width = Double.parseDouble(s);
    //     ((BrickModel)model).setWidth(width);
    //   }
    // });
    // lengthField.addActionListener(new ActionListener() {
    //   @Override
    //   public void actionPerformed(ActionEvent e) {
    //     String s = lengthField.getText();
    //     double length = Double.parseDouble(s);
    //     ((BrickModel)model).setLength(length);
    //   }
    // });

    JLabel hintLabel = new JLabel("Type text in fields and press enter!");

    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 1;
    add(heightLabel, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 0;
    c.gridwidth = 1;
    add(heightField, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth = 1;
    add(widthLabel, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 1;
    c.gridwidth = 1;
    add(widthField, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 2;
    c.gridwidth = 1;
    add(lengthLabel, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 2;
    c.gridwidth = 1;
    add(lengthField, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 3;
    c.gridwidth = 2;
    add(hintLabel, c);

  }

  public void paintComponent(Graphics g){

  }
  @Override
  public void update(Observable arg0, Object arg1) {
    // TODO: change data in panel and repaint
    repaint();
  }
}
