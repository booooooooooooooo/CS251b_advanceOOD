package pipe;

public interface Publisher<T>{
  public void notifyFilters();
}
