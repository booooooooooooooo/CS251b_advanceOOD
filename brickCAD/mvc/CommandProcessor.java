package mvc;

import java.util.Stack;

// use singleton pattern TODO: how
//CommandProcessor stands between controller and model.
//It proveds uniform method for controller.
public class CommandProcessor {
  private Stack<Command> undoStack, redoStack;

  public CommandProcessor() {
    this.undoStack = new Stack<Command>();
    this.redoStack = new Stack<Command>();
  }
  public void execute(Command cmmd) {
    cmmd.execute();
    if (cmmd.getUndoable()) {
      undoStack.push(cmmd);
      redoStack.clear(); // caution!
    }
  }

  public void undo() {
    if (!undoStack.isEmpty()) {
      Command cmd = undoStack.pop();
      cmd.undo();
      redoStack.push(cmd);
    }
  }
  public void redo() {
    if (!redoStack.isEmpty()) {
      Command cmd = redoStack.pop();
      cmd.execute();
      undoStack.push(cmd);
    }
  }
  public void clear(){
    this.undoStack = new Stack<Command>();
    this.redoStack = new Stack<Command>();
  }

}
