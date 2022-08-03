//import com.group5.gameSetup.GameSetup;
//import org.junit.Assert;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ControllerTest {
//
//    @Test
//    void look() {
//        GameSetup c = new GameSetup();
//        Location test = new Location("test");
//        Location test1 = new Location("test1");
//        Location test2 = new Location("test2");
//        test.addNextLocation("west", test1);
//        test.addNextLocation("east", test2);
//        test.setDescription("west is test1 room and east is test2 room");
//        test2.setDescription("east you have test room");
//        c.look(test, "east");
//    }
//
//    @Test
//    void go() {
//        Controller c = new Controller();
//        Location test = new Location("test");
//        Location test1 = new Location("test1");
//        Location test2 = new Location("test2");
//        c.currentLocation = test;
//        test.addNextLocation("west", test1);
//        test.addNextLocation("east", test2);
//        c.go(c.currentLocation, "east");
//        Assert.assertEquals(test2, c.currentLocation);
//    }
//
//    @Test
//    void removeItem() {
//        Controller c = new Controller();
//        Location test = new Location("test");
//        c.currentLocation = test;
//        test.addItem("water");
//        test.addItem("light");
//        for (String i : test.items){
//            System.out.println(i);
//        }
//        c.removeItem("water");
//        for (String i : test.items){
//            System.out.println(i);
//        }
//    }
//}