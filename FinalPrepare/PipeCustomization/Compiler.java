import pipe.*;

import java.util.Random;


class TokenArray {
  private List<String> tokens;

  public TokenArray(String[] input) {
    this.tokens = new ArrayList<String>(input);
  }

  @Override
  public String toString() {
    return "Note [frequency=" + frequency + ", duration=" + duration +
        ", amplitude=" + amplitude + "]";
  }
  public List<String> getTokenArray(){
    return this.tokens;
  }
  public void setTokenArray(List<String> tokens){
    this.tokens = tokens;
  }

}

public class Compiler extends PipeLine<TokenArray> {

  public class Tokenizer extends Producer{
    public TokenArray produce(){
      String code = generateCode();//TODO: generateCode()
      String[] result = code.split("//s");
      return new TokenArray(result);
    }
  }
  public class AlphaNumeric extends Transformer{
    public TokenArray transform(TokenArray content){
      //TODO
    }
  }

  public class Printer extends Consumer{
    public  void consume(TokenArray content){
      //TODO print content
    }
  }

  public static void main(String[] args) {

    GarbageBand gb = new GarbageBand();
    Composer composer = gb.new Composer(50);//Caution: gb.new
    Player player = gb.new Player();
    Amplifier amplifier = gb.new Amplifier();
    FrequencyFilter ff = gb.new FrequencyFilter();
    DurationFilter df = gb.new DurationFilter();


    System.out.println("data-driven mode");
    DemandDriven = false;
    gb.connect(composer, ff);
    gb.connect(ff, amplifier);
    gb.connect(amplifier, df);
    gb.connect(df, player);
    composer.start();
		System.out.println("done");

		System.out.println("demand-driven mode");
		DemandDriven = true;
		gb.connect(composer, ff);
    gb.connect(ff, amplifier);
    gb.connect(amplifier, df);
    gb.connect(df, player);
    player.start();
    System.out.println("done");
  }
}
