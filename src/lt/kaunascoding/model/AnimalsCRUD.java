package lt.kaunascoding.model;

import lt.kaunascoding.model.action.Fly;
import lt.kaunascoding.model.action.IAction;
import lt.kaunascoding.model.action.Sneak;
import lt.kaunascoding.model.action.Walk;
import lt.kaunascoding.model.animal.Animal;
import lt.kaunascoding.model.animal.Cat;
import lt.kaunascoding.model.animal.Dog;
import lt.kaunascoding.model.animal.Pigeon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalsCRUD {
    private static final String ACTION_WALK = "walk";
    private static final String ACTION_SNEAK = "sneak";
    private static final String ACTION_FLY = "FLY";
    private static final String ANIMAL_CAT = "cat";
    private static final String ANIMAL_DOG = "dog";
    private static final String ANIMAL_PIGEON = "pigeon";
    private static AnimalsCRUD instance;
    private String fileName;
    private ArrayList<Animal> animals;

    private AnimalsCRUD() {
    }

    public static AnimalsCRUD getInstance() {
        if (instance == null) {
            instance = new AnimalsCRUD();
        }
        return instance;
    }

    public void setFileName(String parFileName) {
        fileName = parFileName;
    }

    public void addAnimal(Animal obj) {
        animals.add(obj);
    }

    public void loadAllAnimals() {
        //susikurti gyvunu array list;
        animals = new ArrayList<>();
        // atsidaryti faila
        File file = new File(fileName);
        try {
            //susikurti scaneri
            Scanner sc = new Scanner(file);
            //eiti per failo eilutes
            while (sc.hasNext()) {
                Animal obj = null;
                //paversti teksto eilute i gyvūno objekta

                //magic happens here

                //gauta objekta pasideti i animals ArrayList

                addAnimal(obj);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private IAction makeAction(String action) {
        IAction result = null;
        switch (action.toLowerCase()) {
            case ACTION_WALK:
                result = new Walk();
                break;
            case ACTION_SNEAK:
                result = new Sneak();
                break;
            case ACTION_FLY:
                result = new Fly();
                break;
            default:
                System.out.println("Tokio veiksmo nėra");
        }
        return result;
    }

    private Animal makeAnimal(String line) {
        Animal result = null;
        String[] zodziai = line.split(" ");
        String animalClass = zodziai[0];
        String animalType = zodziai[1];
        String animalName = zodziai[2];
        float animalWeight = Float.parseFloat(zodziai[3]);
        float animalHeight = Float.parseFloat(zodziai[4]);
        String animalAction = zodziai[5];

        switch (animalClass.toLowerCase()) {
            case ANIMAL_CAT:
                result = new Cat(makeAction(animalAction));
                break;
            case ANIMAL_DOG:
                result = new Dog(makeAction(animalAction));
                break;
            case ANIMAL_PIGEON:
                result = new Pigeon(makeAction(animalAction));
                break;
            default:
                System.out.println("Šito žvėriaus nepažystu");
        }
        result.setName(animalName);
        result.setType(animalType);
        result.setHeight(animalHeight);
        result.setWeight(animalWeight);

        return result;
    }
}
