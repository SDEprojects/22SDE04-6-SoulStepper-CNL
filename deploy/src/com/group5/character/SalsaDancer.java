package com.group5.character;

import com.group5.character.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SalsaDancer extends Character {


    public SalsaDancer(String name, int health) {
        super(name, health);
    }

    //Time dialogue before combat of SalsaDancer enemy character when engaging in combat with player
    @Override
    public void beginningDialogue() throws InterruptedException {
        System.out.println(".....");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Antonio: * dances *");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("* some women in the crowd faint *");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soul-stepper: Woah, you remind me of a young me.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Antonio: Yes my friend, Salsa is Sexy. Salsa is Love. Salsa is Love.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soul-stepper: I can appreciate that. Maybe you can show me a move or two and I can show you mine? ");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Antonio: Oh! This sounds intriguing. Dance we shall.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("SoulStepper: Let's do it.");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println();
        System.out.println("ALERT!!");
        System.out.println();
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        System.out.println();
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.printf("%s challenges you to a dance off", this.getName());
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("Ready? Let's dance!");
        System.out.println();
        System.out.println();
    }

    @Override
    public ArrayList<String> beginningDialogueGUI() throws InterruptedException {
        return null;
    }

    @Override
    public void enemyTaunt() throws InterruptedException{
        List<String> taunts = new ArrayList<>();
        taunts.add("You suck at that move boy..., check this out");
        taunts.add("I will show you what great move is");
        taunts.add("What was that punk?... haha.... you suck");
        taunts.add("come on loser... take this");

        Random rand = new Random();
        Integer nextTaunt = rand.nextInt(4);
        System.out.println(nextTaunt);
        System.out.println(taunts.get(nextTaunt));

    }

    //Time dialogue after combat of BreakDancer enemy character when engaging in combat with player
    @Override
    public void endingDialogue() throws InterruptedException {
        System.out.println(".....");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("* women in the crowd swoon over Soul-stepper and Antonio *");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Antonio: My friend, you dance with such passion. I can feel the fire in your heart!");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Yes it was electric. We should definitely dance again some time");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Antonio: Please, consider me a friend for life.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soul-stepper: Same to you Antonio.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.printf("You defeated %s with your soul and can now move on.", this.getName());
        System.out.println();
    }

    @Override
    public ArrayList<String> endingDialogueGUI() throws InterruptedException {
        return null;
    }

    //Random selection for Dance moves for combat of the CrunkDancer character
    @Override
    public void dance(Character soulStepper, Character enemy) throws InterruptedException {
        List<String> danceMoves = new ArrayList<>(5);
        danceMoves.add("Dile que no");
        danceMoves.add("Enchufla");
        danceMoves.add("Cubanito");
        danceMoves.add("70 en la salsa");
        danceMoves.add("Croqueta complicada");

        int number = randomInt(0, 4);


        if (number == 0) {
            enemyTaunt();
            System.out.println();
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(0));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soul-steppers current health is %s", soulStepper.getHealth());
            System.out.println();
            System.out.println();
        } else if (number == 1) {
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(1));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soul-steppers current health is %s", soulStepper.getHealth());
            System.out.println();
            System.out.println();
        } else if (number == 2) {
            enemyTaunt();
            System.out.println();
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(2));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soul-steppers current health is %s", soulStepper.getHealth());
            System.out.println();
            System.out.println();
        } else if (number == 3) {
            enemyTaunt();
            System.out.println();
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(3));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soul-steppers current health is %s", soulStepper.getHealth());
            System.out.println();
            System.out.println();
        } else {
            System.out.printf("The %s tried hit you with a move but missed!", getName());
            System.out.println();
            System.out.println();
        }
    }

    public int getHealth() {
        return Math.max(this.health, 0);
    }

    public String getName() {
        return name;
    }
}