CoffeeMachineInterface.java

public interface CoffeeMachineInterface {
  public void FirstSelection();
  public void SecondSelection();

}

OldCoffeeMachine.java

public class OldCoffeeMachine {
  public void selectA() {
    System.out.println("A - Selected");
  }
  public void selectB();
    System.out.println("B - Selected");
}

CoffeeTouchscreenAdapter.java

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {
  OldCoffeeMachine theMachine;

  public CoffeeTouchscreenAdapter(OldCoffeeMachine newMachine) {
    theMachine = newMachine;
  }

  public void FirstSelection() {
    theMachine.selectA();
  }

  public void SecondSelection() {
    theMachine.selectB();
  }
}
