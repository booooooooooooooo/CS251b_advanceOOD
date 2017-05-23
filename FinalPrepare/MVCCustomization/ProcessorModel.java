import mvc.*;

public class ProcessorModel extends Model {
  private String text;
  private int cursor;

  public ProcessorModel() {
    super();
    this.text = "";
    this.cursor = 0;
  }

  @Override
  public Memento makeMemento() {
    ProcessorMemento m = new ProcessorMemento(text, cursor);
    return m;
  }
  @Override
  public void accept(Memento m) {
    ProcessorMemento pm = (ProcessorMemento)m; //!!
    this.text = pm.getText();
    this.cursor = pm.getCursor();
    changed();
  }

  public void setCursor(int cursor){
    this.cursor = cursor;
    changed();
  }

}
