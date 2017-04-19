package pipe;

public class Pipe<T> implements Publisher<T>{
  public static boolean isDemandDriven;
  private Filter<T> fin;
  private Filter<T> fout;
  private Message<T> message;

  public Pipe(){
    this.isDemandDriven = false;
    this.fin = null;
    this.fout = null;
    this.message = null;
  }

  public void connetInputFilter(Filter<T> fin){
    this.fin = fin;
  }
  public void connetOutputFilter(Filter<T> fout){
    this.fout = fout;
  }

  public Message<T> read(){
    return this.message;
  }
  public void write(Message<T> m){
    this.message = m;
    if( !m.quit && !m.fail){
      notifyFilters();
    }

  }
  public void notifyFilters(){
    if(isDemandDriven){
      fin.update();
    }else{
      fout.update();
    }

  }
}
