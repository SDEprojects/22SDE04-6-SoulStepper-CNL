

import org.w3c.dom.html.HTMLImageElement;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Player extends Character {

    ArrayList<String> inventory = new ArrayList<>();

    public Player(String name, int health) {
        super(name, health);
    }

    @Override
    public void beginningDialogue() throws InterruptedException {

    }

    @Override
    public void endingDialogue() {

    }


    public void addItem(String item){
        inventory.add(item);
    }

    public void removeItem(String item){
        inventory.remove(item);
    }

    public void showInventory() {
        System.out.println("Your inventory: " + inventory.toString());
    }

    @Override
    public void dance(Character enemy, Character soulStepper) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        enemy.beginningDialogue();

        while (enemy.getHealth() > 0) {

            if (soulStepper.getHealth() > 0) {

                System.out.println("" +
                        "Pick a number to select a dance move:\n" +
                        "            1. The Hustle\n" +
                        "            2. Bus Stop\n" +
                        "            3. Michael Jackson Robot\n" +
                        "            4. Funky Chicken");
                System.out.println();


                String userChoice = scanner.nextLine();

                switch (userChoice) {
                    case "1":
                        System.out.println("Soulstepper hit em with the Hustle!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s felt the soul, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            enemy.endingDialogue();
                        }
                        break;

                    case "2":
                        System.out.println("Soulstepper broke out the Bus Stop!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by the bus, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            enemy.endingDialogue();
                        }
                        break;

                    case "3":
                        System.out.println("Soulstepper took it back to the 70's with the Michael Jackson Robot!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by little Michael's spirit, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            enemy.endingDialogue();
                        }
                        break;

                    case "4":
                        System.out.println("Soulstepper was feeling a little weird and did the Funky Chicken!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got pecked by the chicken, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            enemy.endingDialogue();
                        }
                        break;

                    default:
                        System.out.println("Please enter a number 1-4");
                        System.out.println();
                }
            } else {
                System.out.println("Soul Stepper was defeated!");
                System.out.println();
                System.out.println("GAME OVER");
                System.exit(0);
            }
        }
    }

    public void bossDance(Character enemy, Character soulStepper) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        enemy.beginningDialogue();

        while (enemy.getHealth() > 0) {

            if (soulStepper.getHealth() > 0) {

                System.out.println("" +
                        "Pick a number to select a dance move:\n" +
                        "            1. The Hustle\n" +
                        "            2. Bus Stop\n" +
                        "            3. Michael Jackson Robot\n" +
                        "            4. Funky Chicken");
                System.out.println();


                String userChoice = scanner.nextLine();

                switch (userChoice) {
                    case "1":
                        System.out.println("Soulstepper hit em with the Hustle!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s felt the soul, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            enemy.endingDialogue();
                        }
                        break;

                    case "2":
                        System.out.println("Soulstepper broke out the Bus Stop!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by the bus, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            enemy.endingDialogue();
                        }
                        break;

                    case "3":
                        System.out.println("Soulstepper took it back to the 70's with the Michael Jackson Robot!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by little Michael's spirit, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            enemy.endingDialogue();
                        }
                        break;

                    case "4":
                        System.out.println("Soulstepper was feeling a little weird and did the Funky Chicken!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got pecked by the chicken, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            enemy.endingDialogue();
                        }
                        break;

                    default:
                        System.out.println("Please enter a number 1-4");
                        System.out.println();
                        System.out.println();
                }
            } else {
                System.out.println(".....");
                System.out.println();
                TimeUnit.MILLISECONDS.sleep(1500);
                System.out.println("LoVibe: What happened Soul Stepper? Was this the best you got?");
                System.out.println();
                TimeUnit.MILLISECONDS.sleep(1500);
                System.out.println("LoVibe: Go back to your hole and rot, you soul less nobody.");
                System.out.println();
                TimeUnit.MILLISECONDS.sleep(1500);
                System.out.println("Soul Stepper was defeated!");
                System.out.println();
                System.out.println("GAME OVER");
                System.exit(0);
            }
        }
    }

    public int getHealth() {
        return Math.max(this.health, 0);
    }

    public String getName() {
        return this.name;
    }

    public void setHealth(int health) {
        this.health = health;
    }




}