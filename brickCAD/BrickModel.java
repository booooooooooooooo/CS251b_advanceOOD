import mvc.*;

public class BrickModel extends Model {
  private double height;
  private double width;
  private double length;

  public BrickModel() {
    super();
    this.height = 5;
    this.width = 5;
    this.length = 5;
  }

  @Override
  public Memento makeMemento() {
    BrickMemento m = new BrickMemento(height, width, length);
    return m;
  }
  @Override
  public void accept(Memento m) {
    BrickMemento bm = (BrickMemento)m; //!!
    this.height = bm.getHeight();
    this.width = bm.getWidth();
    this.length = bm.getLength();
    changed();
  }

  public void setHeight(double height) {
    this.height = height;
    changed();
    // System.out.printf("Height: %f", this.getHeight());
    // System.out.printf("Length: %f", this.getLength());
    // System.out.printf("Width: %f", this.getWidth());

  }
  public double getHeight() { return this.height; }
  public void setWidth(double width) {
    this.width = width;
    changed();
  }
  public double getWidth() { return this.width; }
  public void setLength(double length) {
    this.length = length;
    changed();
  }
  public double getLength() { return this.length; }
}
