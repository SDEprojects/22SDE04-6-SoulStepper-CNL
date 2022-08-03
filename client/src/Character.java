

import java.util.ArrayList;
import java.util.Random;

public abstract class Character {

    String name;
    int health;


    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void decreaseHealth() {
        this.health = health - randomInt(15, 30);
    }

    public int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public abstract void beginningDialogue() throws InterruptedException;

    public abstract void endingDialogue() throws InterruptedException;

    public abstract void dance (Character soulStepper, Character enemy) throws InterruptedException;

    public abstract String getName();

    public abstract int getHealth();





}