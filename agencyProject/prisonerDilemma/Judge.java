import agency.*;

public class Judge extends Facilitator{
  private int[][] record;
  private int[] score;
  public Judge(){
    super();
    for(int i = 0; i < 16; i++){
      Strategy stgy = new Strategy(i);
      Agent ag = new Agent(this, i, stgy);
      agents.add(ag);
    }
    record = new int[16][2];
    for(int i = 0; i < 16; i++){
      Arrays.fill(record[i], -1);
    }
    score = new int[16];
    Arrays.fill(score, 0);
  }
  @Override
  public void react(Agent a1, Agent a2){
    int id1 = a1.getID();
    int id2 = a2.getID();
    Strategy stgy1 = (Strategy)a1.getMessage();
    Strategy stgy2 = (Strategy)s2.getMessage();
    int choice1 = stgy1.getChoice(record[id2][0], record[id2][1]);
    int choice2 = stgy2.getChoice(record[id1][0], record[id1][1]);
    int acc1 = 0;
    int acc2 = 0;
    if(choice1 == 1 && choice2 == 1){
      acc1 = 3;
      acc2 = 3;
    }else if(choice1 == 1 && choice2 == 0){
      acc1 = 0;
      acc2 = 5;
    }else if(choice1 == 0 && choice2 == 1){
      acc1 = 5;
      acc2 = 0;
    }else if(choice1 == 0 && choice2 == 0){
      acc1 = 1;
      acc2 = 1;
    }else{
      //TODO: throw erro
    }
    score[id1] += acc1;//TODO: check overflow
    score[id2] += acc2;
    record[id1][0] = record[id1][1];
    record[id1][1] = choice1;
    record[id2][0] = record[id2][1];
    record[id2][1] = choice2;

  }
}