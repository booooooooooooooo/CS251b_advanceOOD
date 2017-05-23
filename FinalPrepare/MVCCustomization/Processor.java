import mvc.*;

public class Processor {
  public static void main(String args[]) {
    MVCApp.run(new ProcessorFactory());
  }
}
