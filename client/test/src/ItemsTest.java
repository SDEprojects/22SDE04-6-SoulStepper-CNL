//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ItemsTest {
//
//    @Test
//    void useItem() {
//        Location test = new Location("test");
//        com.group5.character.Player player = new com.group5.character.Player("Andy", 20);
//        com.group5.items.Items items = new com.group5.items.Items();
//        test.addItem("health kit");
//        System.out.println("Before using health kit, health = " + player.getHealth());
//        items.useItem("health kit", player);
//        boolean increase = player.getHealth() >= 20;
//        Assert.assertEquals(increase, true);
//        System.out.println(player.getHealth());
//
//
//    }
//}