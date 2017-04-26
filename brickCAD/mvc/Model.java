package mvc;

import java.io.Serializable;
import java.util.Observable;

public abstract class Model extends Observable implements Serializable {
  private String filename;

  public Model() {
    super();
  }

  //CALL 	addObserver(Observer o) to add obsevers.....
  public void setFileName(String filename) {
    this.filename = filename;
  }
  public String getFileName(){
    return this.filename;
  }


  public void changed() {
    this.setChanged();      // set the status to changed so that notifyObservers can execute
    this.notifyObservers(); // it calls clearChanged automatically
  }

  public abstract Memento makeMemento();
  public abstract void accept(Memento m);
}
