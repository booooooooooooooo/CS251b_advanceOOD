package pipe;

public class Pipe<T> implements Publisher<T>{
  private Filter<T> fin;
  private Filter<T> fout;
  private T message;

  public Pipe(){
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

  public T read(){
    return this.message;
  }
  public void write(T m){
    this.message = m;
    notifyFilters();
  }
  public void notifyFilters(){
    fout.update();
  }
}
