package mvc;

import java.util.Observable;

// TODO: why abstract?
public abstract class View extends JPanel implements Observer {
  protected Model model;

  public View(Model model) { this.model = model; }

  public Model getModel() { return this.model; }

  public void setModel(Model model) { this.model = model; }
  @Override public abstract void update(Observable arg0, Object arg1);
}
