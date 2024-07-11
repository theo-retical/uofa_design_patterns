// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

--------------------
  [Subject.java]
--------------------
  public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();

  }

  --------------------
  Channel.java
  --------------------
  private ArrayList<Observer> observers = new ArrayList<Observer>();
  private String channelName;
  private String status;
    
    public Channel(String channelName, String status) {
      this.channelName = channelName;
      this.status = status;
    } 
  
    public String getChannelName() {
      return channelName;
    }
  
    public String getStatus() {
      return status;
    }
  
    public void setStatus(String status) {
      this.status = status;
      notifyObservers();
    }
  
    public void notifiyObservers() {
      for (Observer observer : observers) {
        observer.update(this);
      }
    }
  
    public void registerObserver(Observer o) {
      observers.add(o);
    }
  
    public void removeObserver(Observer o) {
      observers.remove(o);
    }
  

  --------------------
  Observer.java
  --------------------
  public interface Observer {
    public void update(String status);
  }

  --------------------
  Follower.java
  --------------------
  public class Follower implements Observer {
    private String name;

    public Follower(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
    
    public void setName(String name) {
      this.name = name;
    }

    public void update(String status) {
      System.out.println("Follower: " + status);
    }

    public void play() {
      System.out.println("Follower: " + name + " is playing");
    }
  }
