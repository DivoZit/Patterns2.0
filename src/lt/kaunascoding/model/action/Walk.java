package lt.kaunascoding.model.action;

public class Walk implements IAction {
    @Override
    public void doAction() {
        System.out.println("I walk");
    }
}
