import java.util.concurrent.TimeUnit;

public class Items {

    public void useItem(String item, Player player) throws InterruptedException {
        switch (item) {
            case "health kit":
                int number = player.getHealth() + player.randomInt(60, 70);
                player.setHealth(number);
                System.out.println("....");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println();
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Soul Steppers health is now at " + player.getHealth());
                break;
            case "mj jacket":
                player.setHealth(300);
                System.out.println("....");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println();
                System.out.println("MJ's soul now flows through you and you feel invincible ");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println();
                System.out.println("Soul Steppers health is now at " + player.getHealth());
                System.out.println();
                break;
        }
    }



}