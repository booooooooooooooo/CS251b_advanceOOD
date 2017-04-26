package mvc;

import java.util.*;
import javax.swing.*;

// TODO: why abstract?
public abstract class View extends JPanel implements Observer {
  protected Model model;

  public View(Model model) {
    this.model = model;
    this.model.addObserver(this);
  }

  // public Model getModel() { return this.model; }

  public void setModel(Model model) {
    this.model.deleteObserver(this);
    this.model = model;
    this.model.addObserver(this);
  }
  @Override
  public abstract void update(Observable arg0, Object arg1);
}
