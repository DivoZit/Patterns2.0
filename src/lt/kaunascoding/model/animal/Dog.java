package lt.kaunascoding.model.animal;

import lt.kaunascoding.model.action.IAction;

public class Dog extends Animal {
    public Dog(IAction action) {
        changeAction(action);

    }
}
