//import org.junit.Assert;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CharacterTest {
//
//    @Test
//    void decreaseHealth() {
//        com.group5.character.Character soulStteper = new com.group5.character.Player("George", 100);
//        soulStteper.decreaseHealth();
//        int health = soulStteper.getHealth();
//        boolean health1 = health < 100;
//        Assert.assertEquals(health1, true);
//        Assert.assertNotEquals(health1, false);
//    }
//
//    @Test
//    void randomInt() {
//        com.group5.character.Character soulStteper = new com.group5.character.Player("George", 100);
//        int n = soulStteper.randomInt(15, 30);
//        boolean number = n >= 15 & n <= 30;
//        Assert.assertEquals(number, true);
//        Assert.assertNotEquals(number, false);
//
//    }
//}