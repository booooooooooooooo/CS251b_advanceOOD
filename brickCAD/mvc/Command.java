package mvc;

public abstract class Command {
  private boolean undoable;
  protected Model model;
  private Memento m;
  public Command(Model model, boolean undoable) {
    this.model = model;
    this.undoable = undoable;
  }

  public boolean getUndoable() { return undoable; }

  public void undo() {
    if (undoable && Memento != null)
      model.accept(m);
  }
  public void execute() {
    this.m = model.makeMemento();
    // TODO: change model?
  }
}
