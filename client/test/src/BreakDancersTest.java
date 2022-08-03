import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreakDancersTest {



    @Test
    void dance() throws InterruptedException {
        com.group5.character.Character soulStepper = new com.group5.character.Player("Daniel", 100);
        com.group5.character.Character enemy = new com.group5.character.BreakDancers("enemyTest", 100);

        enemy.dance(soulStepper, enemy);
    }
}