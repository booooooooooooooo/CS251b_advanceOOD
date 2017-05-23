class Collaborator extends Agent {
   private Oracle oracle;
   public Collaborator(int id, Facilitator fac){
     super(id, fac);
   }
   void enhanceOracle(OracleDecorator od) {
     this.oracle = od;
   }
   @Override
   public void update(){
     if(messageQueue.isEmpty()){
       this.askQuestion();

     }else{
       Message m = this.messageQueue.poll();
       if(m.answer == null) this.answerQuestion(m);
       else this.receiveAnswer(m);
     }

   }
   private void askQuestion(){
     Agent partner = fac.getPartner(this);
     Message m = new Mail(this);
     fac.send(partner, m);
   }
   private void answerQuestion(Message m){
     m.answer = oracle.answer(m.question);
     //TODO: ask instructor about how to process null answer cases: send back to asker; send to other agents for further answer
   }
   private void receiveAnswer(Message m){
     //TODO: ask instructor about enhancing decorator or store answer in map
     System.out.printf("%s%s", m.question, m.answer);
     QuestionType = m.questionType;
     if(QuestionType == MathType){
       enhanceOracle(new MathOracle(this.oracle));
     }else if(){
       //....
     }
   }

}
