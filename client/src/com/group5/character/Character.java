package com.group5.character;

import java.util.Random;

//Character class is abstract and every character extends Character class
public abstract class Character {

    String name;
    int health;


    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // allows all characters to decrease their health while in battle.

    public void decreaseHealth() {
        this.health = health - randomInt(15, 30);
    }

    // generates a random numbers to be used in the decrease health, and dance methods.

    protected int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // dialogue the characters will have before the dance battles

    public abstract void beginningDialogue() throws InterruptedException;

    // dialogue the characters will have after the dance battles

    public abstract void endingDialogue() throws InterruptedException;

    // dance method for each character.

    public abstract void dance (Character soulStepper, Character enemy) throws InterruptedException;

    public abstract String getName();

    public abstract int getHealth();





}