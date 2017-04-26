package mvc;

import java.util.Stack;

// use singleton pattern
public class CommandProcessor {
  private Stack<Command> undoStack, redoStack;

  public CommandProcessor() {}
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
}
