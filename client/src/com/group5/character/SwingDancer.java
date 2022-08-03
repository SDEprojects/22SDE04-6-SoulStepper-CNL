package com.group5.character;

import com.group5.character.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SwingDancer extends Character {


    public SwingDancer(String name, int health) {
        super(name, health);
    }

    //Time dialogue before combat of SwingDancer enemy character when engaging in combat with player
    @Override
    public void beginningDialogue() throws InterruptedException {
        System.out.println(".....");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Jimmy: Hey you!");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Soulstepper: huh?");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Jimmy: Yeah you, I like you shoes!");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Ha ha, thanks alot.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Jimmy: They call me Jimmy around here, what's your name?");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("SoulStepper: You can call me Soulstepper.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println();
        System.out.println("Jimmy: That's a cool name. I felt like I heard that somewhere before.... Anyways, do you swing?");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println();
        System.out.println("SoulStepper: No, but I do have a few moves..");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println();
        System.out.println("Jimmy: Ok then old timer, then show me? I need a good warmup before the Lindy competition later today.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println();
        System.out.println("SoulStepper: Haha, sure. I won't hold back though.");
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println();
        System.out.println("Jimmy: sheesh, you don't look like somebody that can make me break a sweat.");
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

    //Time dialogue after combat of SwingDancer enemy character when engaging in combat with player
    @Override
    public void endingDialogue() throws InterruptedException {
        System.out.println(".....");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Jimmy: *heavy panting* what the hell? I thought you said you had a few moves up you sleeve?");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("People shouting in distance: Oh my god, that's Levon SoulStepper, the original Supreme Stepper.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Jimmy: ....... you could've told me that in the beginning instead of making me think I was going against an old man.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Hahaha my apologies, I like to keep a low profile.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Jimmy: *limps away in pain* Now, I won't be able to do the competition! ");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("SoulStepper: Sorry kid.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.printf("You defeated %s with your soul and can now move on.", this.getName());
        System.out.println();
    }

//Random selection for Dance moves for combat of the SwingDancer character
    @Override
    public void dance(Character soulStepper, Character enemy) throws InterruptedException {
        List<String> danceMoves = new ArrayList<>(5);
        danceMoves.add("Collegiate Shag");
        danceMoves.add("Charleston");
        danceMoves.add("East Coast Swing");
        danceMoves.add("Balboa");
        danceMoves.add("Lindy Hop");

        int number = randomInt(0, 4);


        if (number == 0) {
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(0));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soulsteppers current health is %s", soulStepper.getHealth());
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.println();
            System.out.println();
        } else if (number == 1) {
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(1));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soulsteppers current health is %s", soulStepper.getHealth());
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.println();
            System.out.println();
        } else if (number == 2) {
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(2));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soulsteppers current health is %s", soulStepper.getHealth());
            System.out.println();
            System.out.println();
        } else if (number == 3) {
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(3));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soulsteppers current health is %s", soulStepper.getHealth());
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