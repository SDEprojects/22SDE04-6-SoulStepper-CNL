package com.group5.gameSetup;

import com.group5.character.*;
import com.group5.character.Character;
import com.group5.location.Location;

import java.util.HashMap;
import java.util.Map;

public class GameSetup {

    //initializing on a field all the location and enemy's characters for some location

    Location mainStreet = new Location("Main Street");
    Location trebleParkWay = new Location("Treble Parkway");
    Location baseCircle = new Location("Base Circle");
    Location riffRunWay = new Location("Riff Runway");
    Location seminary = new Location("Seminary Street");
    Location wheatLand = new Location("Wheat Land");
    Location thePalace = new Location("The Palace");
    Location bossPlace = new Location("Boss House");
    Character breakDancer = new BreakDancers("Break Dancer Tyler", 100);
    Character crunkDancer = new CrunkDancer("Crunk Dancer Nathan", 100);
    Character salsaDancer = new SalsaDancer("Salsa Dancer Antonio", 100);
    Character swingDancer = new SwingDancer("Swing Dancer Jimmy", 100);
    public Character boss = new Boss("LoVibe the Boss", 100);
    public Location currentLocation;
    public Map <String, Location> ref = new HashMap<>();


//object-oriented: adding location, description, item and enemy
    public GameSetup() {
        currentLocation = mainStreet;
        ref.put(mainStreet.getName(), mainStreet);
        mainStreet.addNextLocation("north", baseCircle);
        mainStreet.setDescription("You see main street, where you just came from.");

        ref.put(baseCircle.getName(), baseCircle);
        baseCircle.addNextLocation("south", mainStreet);
        baseCircle.addNextLocation("west", riffRunWay);
        baseCircle.addNextLocation("east", trebleParkWay);
        baseCircle.setDescription("You see lights and you hear various types of in music the distance");

        ref.put(trebleParkWay.getName(), trebleParkWay);
        trebleParkWay.addNextLocation("west", baseCircle);
        trebleParkWay.addNextLocation("north", thePalace);
        trebleParkWay.addItem("health kit");
        trebleParkWay.addEnemy(breakDancer);
        trebleParkWay.setDescription("You hear 90's hiphop in the distance and see dancers doing some difficult looking dance moves, you become curious");

        ref.put(riffRunWay.getName(), riffRunWay);
        riffRunWay.addNextLocation("east", baseCircle);
        riffRunWay.addNextLocation("north", seminary);
        riffRunWay.addItem("health kit");
        riffRunWay.addEnemy(swingDancer);
        riffRunWay.setDescription("You see lights and see people swing dancing, you feel excited.");

        ref.put(seminary.getName(), seminary);
        seminary.addNextLocation("south", riffRunWay);
        seminary.addNextLocation("north", bossPlace);
        seminary.addNextLocation("east", wheatLand);
        seminary.setDescription("You hear hiphop music and you see a large crowd surrounding some Crunk Dancers");
        seminary.addEnemy(crunkDancer);

        ref.put(wheatLand.getName(), wheatLand);
        wheatLand.addNextLocation("west", seminary);
        wheatLand.addNextLocation("south", baseCircle);
        wheatLand.addNextLocation("north", bossPlace);
        wheatLand.addNextLocation("east", thePalace);
        wheatLand.setDescription("Looks quiet and not many people are around");
        wheatLand.addItem("mj jacket");

        ref.put(thePalace.getName(), thePalace);
        thePalace.addNextLocation("west", wheatLand);
        thePalace.addNextLocation("south", trebleParkWay);
        thePalace.addNextLocation("north", bossPlace);
        thePalace.addItem("health kit");
        thePalace.setDescription("You see lights and hear Salsa music playing, people seem to be having fun in this direction");
        thePalace.addEnemy(salsaDancer);

        ref.put(boss.getName(), bossPlace);
        bossPlace.addEnemy(boss);
        bossPlace.setDescription("There's a path this way and it's extremely dark but you hear bass thumping in the distance, you feel anxious.");


    }
//Look method would be able to let player kook on the direction they wish to go
    public void look(Location currentLocation, String direction) {
        if (currentLocation.nextLocation.keySet().contains(direction)) {
            System.out.println(currentLocation.nextLocation.get(direction).description);
            System.out.println();
        } else {
            System.out.println("There's nothing of interest there.");
            System.out.println();
        }
    }

    //go method would move the player across the rooms
    public void go(Location currentLocation, String direction) {
        if (currentLocation.nextLocation.keySet().contains(direction)) {
            this.currentLocation = currentLocation.nextLocation.get(direction);
            System.out.println();
        } else {
            System.out.println("You can't go that way.");
            System.out.println();
        }
    }
//It would remove an item from array since with another method the Item would be placed on Inventory
    public void removeItem(String item) {
        this.currentLocation.items.remove(item);
    }
}