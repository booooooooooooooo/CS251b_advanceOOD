package pipe;

import java.util.Observable;
import java.util.Observer;

public class PipeLine<T> {
	public static boolean DemandDriven = false;

  public class Message<T> {
    private T content;
    private boolean quit = false;
    private boolean fail = false;
    public Message(T content) {
      quit = false;
      fail = false;
      this.content = content;
    }
    public T getContent() { return content; }
    public void setContent(T content) { this.content = content; }
    public boolean isQuit() { return quit; }
    public void setQuit(boolean quit) { this.quit = quit; }
    public boolean isFail() { return fail; }
    public void setFail(boolean fail) { this.fail = fail; }
    public String toString() {
      return "<" + content + ", quit = " + quit + ", fail = " + fail + ">";
    }
  }

  public class Pipe extends Observable {

    private Message data;
    public Message read() {
      if (DemandDriven) {
        this.setChanged();
        this.notifyObservers();
      }
      return data;
    }

    public void write(Message data) {
      this.data = data;
      if (!DemandDriven) {
        this.setChanged();
        this.notifyObservers();
      }
    }
  }

  public abstract class Filter implements Observer {
    protected Pipe input;
    protected Pipe output;
    public void setInput(Pipe input) {
      this.input = input;
      if (!DemandDriven) {
        input.addObserver(this);
      }
    }
    public void setOutput(Pipe output) {
      this.output = output;
      if (DemandDriven) {
        output.addObserver(this);
      }
    }
  }

  public abstract class Producer extends Filter {

    @Override
    public void update(Observable o, Object arg) {
      T item = produce();
      Message msg = new Message(item);
      if (item == null)
        msg.setQuit(true);
      output.write(msg);
    }

    public abstract T produce();

    public void start() {
      while (true) {
        T item = produce();
        Message msg = new Message(item);
        if (item == null)
          msg.setQuit(true);
        output.write(msg);
        if (item == null)
          break;
      }
      System.out.println("bye");
    }
  }

  protected abstract class Tester extends Filter {

    @Override
    public void update(Observable arg0, Object arg1) {
      Message item = input.read();
      if (!item.isFail() && !item.isQuit()) {
        item.setFail(!test(item.getContent()));
      }
      // System.out.println(item.toString());
      output.write(item);
    }

    public abstract boolean test(T content);
  }

  public abstract class Transformer extends Filter {

    @Override
    public void update(Observable arg0, Object arg1) {
      Message item = input.read();
      if (!item.isFail() && !item.isQuit()) {
        item.setContent(transform(item.getContent()));
      }
      // System.out.println(item.toString());
      output.write(item);
    }

    public abstract T transform(T content);
  }

  public abstract class Consumer extends Filter {

    @Override
    public void update(Observable arg0, Object arg1) {
      Message item = input.read();
      System.out.println(item.toString());
      if (!item.isFail() && !item.isQuit()) {
        consume(item.getContent());
      }
    }

    public void start() {
      while (true) {
        Message msg = input.read();
        if (msg.isFail())
          continue;
        if (msg.isQuit())
          break;
        consume(msg.getContent());
      }
      System.out.println("bye");
    }

    public abstract void consume(T content);
  }

  // connects 2 filters with a pipe
  public void connect(Filter f1, Filter f2) {
    Pipe pipe = new Pipe();
    f1.setOutput(pipe);
    f2.setInput(pipe);
  }
}
