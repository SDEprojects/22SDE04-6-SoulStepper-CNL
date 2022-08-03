<<<<<<< HEAD:client/src/com/group5/gameSetup/Instruction.java
package com.group5.gameSetup;
=======

>>>>>>> origin/main:client/src/Instruction.java

import java.util.concurrent.TimeUnit;

public class Instruction {

    public void showInstruction() throws InterruptedException {

        System.out.println("WELCOME TO SOUL STEPPER");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("In this story, you are Levon Soulstepper. " +
                "Who recently lost his " +
                "title as the Supreme Stepper to notorious LoVibe");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("After losing everything, " +
                "Levon spends his days at home watching reruns of " +
                "little house of the prairie.");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("You're mission is simple..");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("Find LoVibe.");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("Whoop his ass with your moves.");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("And become the Supreme Stepper once again!");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("Let me give you a few helpful commands to get your started..");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("\033[1;35m");
        System.out.println("Commands: \n To move = go [direction] \n To get items = get [item] \n To use items = use [item] " +
                "\n To look = look [direction] \n Exit Game = quit \n To save = save game \n To load = load game ");
        System.out.println("\033[0m");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println();
        System.out.println("Ready? let's go!");
        TimeUnit.MILLISECONDS.sleep(1500);
    }
}