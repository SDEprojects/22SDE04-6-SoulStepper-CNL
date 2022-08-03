import java.util.Locale;
import java.util.Scanner;


public class Game {
    public void play() throws InterruptedException {
        Instruction instruction = new Instruction();
        instruction.showInstruction();

        Controller controller = new Controller();
        Player soulStepper = new Player("SoulStepper", 100);
        Scanner scanner = new Scanner(System.in);
        Items item = new Items();
        while (true) {
            System.out.println("You are now at " + controller.currentLocation.getName());

            System.out.println("\033[1;35m");
            System.out.println("Where would you like to go? ");
            System.out.println("\033[0m");
            System.out.print("> ");

            System.out.println();
            soulStepper.showInventory();

            if (controller.currentLocation.items.size() > 0) {
                controller.currentLocation.getItems();
            }
            String choice = scanner.nextLine().toLowerCase();
            String[] arrayChoice = choice.split(" ", 2);
            switch (arrayChoice[0]) {
                case "look":
                    controller.look(controller.currentLocation, arrayChoice[1]);
                    break;

                case "go":
                    controller.go(controller.currentLocation, arrayChoice[1]);
                    if (controller.currentLocation.enemies.size() > 0) {
                        if (controller.currentLocation.enemies.contains(controller.boss)){
                            soulStepper.bossDance(controller.currentLocation.enemies.get(0), soulStepper);
                            controller.currentLocation.enemies.remove(0);
                        }
                        soulStepper.dance(controller.currentLocation.enemies.get(0), soulStepper);
                        controller.currentLocation.enemies.remove(0);
                    }
                    break;

                case "quit":

                case "exit":
                    System.out.println("Thanks for playing Soul Stepper");
                    return;

                case "get":
                    if (controller.currentLocation.items.contains(arrayChoice[1])) {
                        controller.removeItem(arrayChoice[1]);
                        soulStepper.addItem(arrayChoice[1]);
                    } else {
                        System.out.println("You can't do that");
                    }
                    break;
                case "use":
                    if (soulStepper.inventory.contains(arrayChoice[1])) {
                        soulStepper.removeItem(arrayChoice[1]);
                        item.useItem(arrayChoice[1], soulStepper);
                    }
                    break;

                default:
                    System.out.println("Invalid Command");
            }
        }


    }


}