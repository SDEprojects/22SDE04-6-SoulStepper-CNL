import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Boss extends Character {


    public Boss(String name, int health) {
        super(name, health);
    }

    @Override
    public void decreaseHealth() {
        this.health = health - randomInt(10, 25);
    }

    @Override
    public void beginningDialogue() throws InterruptedException {
        System.out.println(".....");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: So you decided to show your face here again huh?");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: You know why I'm here... I came back to take what is mine!");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: Go ahead and try Soul Stepper but your soul wasn't anywhere near mines last time.");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("LoVibe: Perhaps you can to try to prove me wrong?");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("Soulstepper: Well, let's not waste any time. Let me show you the real reason why they call me Soul Stepper..");
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
        System.out.println("Soulstepper: HA! You thought wrong bitch, now give me my damn title back");
        System.out.println();
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("Soulstepper: Soul has been restored.");
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

    @Override
    public void dance(Character soulStepper, Character enemy) {
        List<String> danceMoves = new ArrayList<>(5);
        danceMoves.add("Dictator");
        danceMoves.add("Show-off");
        danceMoves.add("Cabbage Patch");
        danceMoves.add("Almighty Push");
        danceMoves.add("Washing Machine");

        int number = randomInt(0, 4);


        if (number == 0) {
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(0));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soulsteppers current health is %s", soulStepper.getHealth());
            System.out.println();
            System.out.println();
        } else if (number == 1) {
            System.out.printf("The %s hit you with a %s", getName(), danceMoves.get(1));
            soulStepper.decreaseHealth();
            System.out.println();
            System.out.printf("Soulsteppers current health is %s", soulStepper.getHealth());
            System.out.println();
            System.out.println();
        } else if (number == 2) {
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