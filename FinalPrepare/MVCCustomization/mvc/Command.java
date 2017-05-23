package mvc;

public abstract class Command {
  private boolean undoable;
  protected Model model;
  private Memento m;
  public Command(Model model, boolean undoable) {
    this.model = model;
    this.undoable = undoable;
  }

  public boolean getUndoable() {
    return this.undoable;
  }

  public void undo() {
    if (undoable && m != null){
      Memento temp = model.makeMemento();
      model.accept(m);
      this.m = temp;
    }
  }
  public void redo(){
    Memento temp = model.makeMemento();
    model.accept(m);
    m = temp;
  }
  public void execute() {
    this.m = model.makeMemento();
    action();

  }
  //specific actions vary by applications
  public abstract void action();
}
