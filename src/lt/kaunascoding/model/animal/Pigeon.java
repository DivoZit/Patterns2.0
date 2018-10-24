package lt.kaunascoding.model.animal;

import lt.kaunascoding.model.action.IAction;

public class Pigeon extends Animal {
    public Pigeon(IAction action) {
        changeAction(action);
    }
}
