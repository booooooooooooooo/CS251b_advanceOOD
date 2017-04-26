import mvc.*;

public class Test{
  public static void main(String args[]){
    BrickModel bmodel = new BrickModel();
    bmodel.setHeight(5);
    System.out.println(bmodel.getHeight());

    CommandProcessor processor = new CommandProcessor();
    CommandSetHeight cmmd = new CommandSetHeight(bmodel, true, 10);
    processor.execute(cmmd);
    System.out.println(bmodel.getHeight());


  }
}
