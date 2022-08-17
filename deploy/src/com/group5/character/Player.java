package com.group5.character;

import com.group5.character.Character;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Player extends Character {

    // players inventory upon initialization.

    public ArrayList<String> inventory = new ArrayList<>();
    int curXP = 0;
    int level = 1;

    int preLevel = 1;
    int curLevel = preLevel + 1;
    int[] requiredXP = { 0, 6, 17, 36, 65, 105, 158, 224, 305, 402 };

    public Player(String name, int health) {
        super(name, health);
    }

    public Map<Integer, Integer> loadXpPerLevel() throws IOException {
        Map<Integer, Integer> xpPerLevel = new LinkedHashMap<>();
        AtomicInteger level = new AtomicInteger(1);
        try
                (Stream<String> lines = Files.lines(Paths.get("xpPerLevel.txt"))){
            lines.forEach(line-> xpPerLevel.put(level.incrementAndGet(), Integer.valueOf(line)));

        }
        return xpPerLevel;
    }

    public void checkCurrentXP() throws IOException {
        Integer xpRequired = null;
        do {
            xpRequired = loadXpPerLevel().get(curLevel);
            if (null != xpRequired){
                if(curXP >= xpRequired){
                    performLevelUP();
                }
            }
        }while (xpRequired == null || curXP < xpRequired);
    }

    public void performLevelUP(){
        System.out.println(" #############################");
        System.out.println(" # You have reached level " + (++curLevel) + "! # ");
        System.out.println(" #############################");
    }

    public int xpAmount(){
        Random r = new Random();
        int randomNumber = r.ints(1, 1, 11).findFirst().getAsInt();

        return randomNumber;
    }

    public void awardXp(int xpAmount) throws IOException {
        curXP += xpAmount;
        while (level < requiredXP.length && requiredXP[level] < curXP) {
            ++level;
            System.out.println(" #############################");
            System.out.println(" # You have reached level " + level + "! # ");
            System.out.println(" #############################");
        }
        checkCurrentXP();
    }

    @Override
    public void beginningDialogue()  {

    }

    @Override
    public ArrayList<String> beginningDialogueGUI() throws InterruptedException {
        return null;
    }

    @Override
    public void enemyTaunt() throws InterruptedException{

    }

    @Override
    public void endingDialogue() {

    }

    @Override
    public ArrayList<String> endingDialogueGUI() throws InterruptedException {
        return null;
    }

    // adds item to the players inventory

    public void addItem(String item){
        inventory.add(item);
    }

    // removes item from the players inventory

    public void removeItem(String item){
        inventory.remove(item);
    }

    // shows the players inventory

    public void showInventory() {
        System.out.println("Your inventory: " + inventory.toString());
    }

    // allows player to use the health kit item once in inventory

    public void useHealthKit() {
        this.health = this.getHealth() + randomInt(60, 70);
    }

    // outputs a string with the players current health

    public void currentHealth() {
        System.out.println("Soulsteppers current health is " + this.getHealth());
    }

    // players dance method which takes the current enemy and the current player object

    @Override
    public void dance(Character enemy, Character soulStepper) throws InterruptedException, IOException {
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
                        }
                        else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
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
                        }
                        else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
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
                        }
                        else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
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
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
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

    // player dance method created to be used specifically against the boss

    public void bossDance(Character enemy, Character soulStepper) throws InterruptedException, IOException {
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
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    case "2":
                        System.out.println("Soulstepper broke out the Bus Stop!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by the bus, and their current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    case "3":
                        System.out.println("Soulstepper took it back to the 70's with the Michael Jackson Robot!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by little Michael's spirit, and their current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    case "4":
                        System.out.println("Soulstepper was feeling a little weird and did the Funky Chicken!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got pecked by the chicken, and their current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
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

    public void danceGUI(Character enemy, Character soulStepper) throws InterruptedException, IOException {
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
                        System.out.println("Soul-stepper hit em with the Hustle!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s felt the soul, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    case "2":
                        System.out.println("Soul-stepper broke out the Bus Stop!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by the bus, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    case "3":
                        System.out.println("Soul-stepper took it back to the 70's with the Michael Jackson Robot!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by little Michael's spirit, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    case "4":
                        System.out.println("Soul-stepper was feeling a little weird and did the Funky Chicken!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got pecked by the chicken, and their current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    default:
                        System.out.println("Please enter a number 1-4");
                        System.out.println();
                }
            } else {
                System.out.println("Soul-Stepper was defeated!");
                System.out.println();
                System.out.println("GAME OVER");
                System.exit(0);
            }
        }
    }

    public void bossDancGUI(Character enemy, Character soulStepper) throws InterruptedException, IOException {
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
                        System.out.println("Soul-stepper hit em with the Hustle!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s felt the soul, and there current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    case "2":
                        System.out.println("Soul-stepper broke out the Bus Stop!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by the bus, and their current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    case "3":
                        System.out.println("Soul-stepper took it back to the 70's with the Michael Jackson Robot!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got hit by little Michael's spirit, and their current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
                            enemy.endingDialogue();
                        }
                        break;

                    case "4":
                        System.out.println("Soul-stepper was feeling a little weird and did the Funky Chicken!");
                        System.out.println();
                        enemy.decreaseHealth();
                        System.out.printf("%s got pecked by the chicken, and their current health is %s !", enemy.getName(), enemy.getHealth());
                        System.out.println();
                        System.out.println();
                        if (enemy.getHealth() > 0) {
                            enemy.dance(soulStepper, enemy);
                        } else {
                            System.out.println("You received " + xpAmount() + " XP!");
                            awardXp(xpAmount());
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