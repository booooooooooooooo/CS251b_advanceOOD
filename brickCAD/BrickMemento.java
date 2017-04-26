import mvc.*;

public class BrickMemento implements Memento{
  public double height;
  public double width;
  public double length;
  public BrickMemento(double height, double width, double length){
    this.height = height;
    this.width = width;
    this.length = length;
  }

  public void setHeight(double height){
    this.height = height;
  }
  public double getHeight(){
    return this.height;
  }
  public void setWidth(double width){
    this.width = width;
  }
  public double getWidth(){
    return this.width;
  }
  public void setLength(double length){
    this.length = length;
  }
  public double getLength(){
    return this.length;
  }
}
