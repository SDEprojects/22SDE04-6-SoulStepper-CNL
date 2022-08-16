package com.group5.character;

import com.group5.character.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CrunkDancer extends Character {


    public CrunkDancer(String name, int health) {
        super(name, health);
    }

    //Time dialogue before combat of CrunkDancer enemy character when engaging in combat with player
    public ArrayList<String> beginningDialogueGUI() throws InterruptedException {
        ArrayList<String> dialogue = new ArrayList<>();
        dialogue.add(".....");
        dialogue.add("Nathan: *performs dance move 'show-off'*");
        dialogue.add("*The crowd roars*");
        dialogue.add("Soulstepper: Hey kid, you seem to be the main attraction here.");
        dialogue.add("Nathan: Seems like it right, worked my butt of to get to this point.");
        dialogue.add("Soulstepper: I respect that, hard work pays off.");
        dialogue.add("Nathan: You seem like you got some soul in you, \nI still got some time before I have to head out. \nYou wanna face off?");
        dialogue.add("SoulStepper: Sure, I can spare some time, plus it seems like this crowd wants to see more.");
        dialogue.add("Nathan: That's what I'm talking about, let's get it.");
        dialogue.add("ALERT!!");
        dialogue.add("ALERT!!");
        dialogue.add("ALERT!!");
        dialogue.add(this.getName() + " challenges you to a dance off");
        dialogue.add("Ready? Let's dance!");

        return dialogue;
    }

    public ArrayList<String> endingDialogueGUI() throws InterruptedException {
        ArrayList<String> dialogue = new ArrayList<>();
        dialogue.add(".....");
        dialogue.add("* crowd erupts in applause *");
        dialogue.add("Nathan: Woah dude, you taught me something tonight. You really don't mess around");
        dialogue.add("Soulstepper: Haha so I've been told");
        dialogue.add("Nathan: Only other person to defeat me in a face-off of like this is that snake LoVibe.\n The guy made me look like a fool out here.");
        dialogue.add("Soulstepper: .....");
        dialogue.add("Nathan: I've been working hard ever since to challenge him again and earn my respect back. But it seems I still have a long way to go.");
        dialogue.add("Soulstepper: Keep, working kid. You'll get there, and when you do I'll be there to see it. For now, I have somewhere I have to be. Peace kid.");
        dialogue.add("Nathan: Peace.");
        dialogue.add("You defeated "+ this.getName() + " with your soul and can now move on.");
        dialogue.add("ALERT!!");
        dialogue.add("ALERT!!");
        dialogue.add(this.getName() + " challenges you to a dance off");
        dialogue.add("Ready? Let's dance!");

        return dialogue;
    }

    @Override
    public void beginningDialogue() throws InterruptedException {
        System.out.println(".....");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Nathan: *performs dance move 'show-off'*");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("*The crowd roars*");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.printf("Soulstepper: Hey kid, you seem to be the main attraction here.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Nathan: Seems like it right, worked my butt of to get to this point.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: I respect that, hard work pays off.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Nathan: You seem like you got some soul in you, I still got some time before I have to head out. You wanna face off?");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("SoulStepper: Sure, I can spare some time, plus it seems like this crowd wants to see more.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println();
        System.out.println("Nathan: That's what I'm talking about, let's get it.");
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
    public void enemyTaunt() throws InterruptedException{
        List<String> taunts = new ArrayList<>();
        taunts.add("You suck at that move");
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
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("* crowd erupts in applause *");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Nathan: Woah dude, you taught me something tonight. You really don't mess around");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Haha so I've been told");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Nathan: Only other person to defeat me in a face-off of like this is that snake LoVibe. The guy made me look like a fool out here.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: .....");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Nathan: I've been working hard ever since to challenge him again and earn my respect back. But it seems I still have a long way to go.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Keep, working kid. You'll get there, and when you do I'll be there to see it. For now, I have somewhere I have to be. Peace kid.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Nathan: Peace.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.printf("You defeated %s with your soul and can now move on.", this.getName());
        System.out.println();
    }

//Random selection for Dance moves for combat of the CrunkDancer character
    @Override
    public void dance(Character soulStepper, Character enemy) throws InterruptedException {
        List<String> danceMoves = new ArrayList<>(5);
        danceMoves.add("Kill-off");
        danceMoves.add("Chest Pop");
        danceMoves.add("Jab");
        danceMoves.add("Buck");
        danceMoves.add("Get-off");

        int number = randomInt(0, 4);


        if (number == 0) {
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