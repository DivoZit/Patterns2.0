package lt.kaunascoding.model.animal;

import lt.kaunascoding.model.action.IAction;

public class Animal implements IAnimal {
    private IAction action;

    private String name;
    private String type;
    private float weight;
    private float height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public void doAction() {
        action.doAction();
    }

    public void changeAction(IAction obj) {
        action = obj;
    }
}
