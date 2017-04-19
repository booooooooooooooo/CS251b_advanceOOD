package pipe;

public class Message<T>{
  public boolean fail;
  public boolean quit;
  public T content;
  public Message(boolean fail, boolean quit, T content){
    this.fail = fail;
    this.quit = quit;
    this.content = content;
  }
  public T getContent(){
    return content;
  }
}
