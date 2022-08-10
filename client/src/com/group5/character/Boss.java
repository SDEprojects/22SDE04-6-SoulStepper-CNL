package com.group5.character;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//Boss is a character on the game
public class Boss extends Character {


    public Boss(String name, int health) {
        super(name, health);
    }

    //different int when decreasing health by an attack from other characters
    @Override
    public void decreaseHealth() {
        this.health = health - randomInt(10, 25);
    }

    //Time dialogue before combat of Boss character when engaging in combat with player
    @Override
    public void beginningDialogue() throws InterruptedException {
        System.out.println(".....");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: So you decided to show your face here again huh?");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soul-stepper: You know why I'm here... I came back to take what is mine!");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: Go ahead and try Soul Stepper but your soul wasn't anywhere near mines last time.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: Perhaps you can to try to prove me wrong?");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soul-stepper: Well, let's not waste any time. Let me show you the real reason why they call me Soul Stepper..");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println();
        System.out.println();
        System.out.println("ALERT!!");
        System.out.println();
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        System.out.println();
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        System.out.println();
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        System.out.println();
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("ALERT!!");
        System.out.println();
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.printf("The Supreme Stepper %s challenges you to a dance off", this.getName());
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("Ready? Let's dance!");
        System.out.println();
        System.out.println();
    }

    @Override
    public void enemyTaunt() throws InterruptedException{
            List<String> taunts = new ArrayList<>();
            taunts.add("You suck at that move dude.... Check this out.");
            taunts.add("I will show you what great move is");
            taunts.add("What was that punk?... haha.... you suck");
            taunts.add("come on loser... take this");

            Random rand = new Random();
            Integer nextTaunt = rand.nextInt(4);
        System.out.println(nextTaunt);
        System.out.println(taunts.get(nextTaunt));

    }


    //    //Time dialogue after combat of Boss character when engaging in combat with player
    @Override
    public void endingDialogue() throws InterruptedException {
        System.out.println(".....");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: NOOOOOOOOOOOOOOOOOO!");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("LoVibe: I thought..... I was..... Supreme?!?!");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Soul-stepper: HA! You thought wrong bitch, now give me my damn title back");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Soul-stepper: Soul has been restored.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.printf("You defeated %s with your soul and have regained your title as Supreme Stepper", this.getName());
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("CONGRATULATIONS");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("YOU WIN!");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("GAME OVER");
        System.exit(0);
    }
//Random selection for Dance moves for combat of the Boss character
    @Override
    public void dance(Character soulStepper, Character enemy) throws InterruptedException {
        List<String> danceMoves = new ArrayList<>(5);
        danceMoves.add("Dictator");
        danceMoves.add("Show-off");
        danceMoves.add("Cabbage Patch");
        danceMoves.add("Almighty Push");
        danceMoves.add("Washing Machine");

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
            enemyTaunt();
            System.out.println();
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