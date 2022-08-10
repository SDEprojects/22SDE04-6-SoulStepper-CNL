package com.group5.character;

import junit.framework.TestCase;
import org.junit.Assert;

public class BossTest extends TestCase {

    public void testEnemyTaunt() throws InterruptedException {
        Boss boss = new Boss("chris", 100);
        boss.enemyTaunt();
    }
}