package com.group5.location;

import com.group5.character.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    String name;
    public String description;
    public ArrayList<String> items = new ArrayList<>();
    public ArrayList<Character> enemies = new ArrayList<>();
    public HashMap<String, Location> nextLocation = new HashMap<String, Location>();


    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getItems() {
        System.out.println("You see a: " + items.toString());
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public void addItem(String item) {
        this.items.add(item);
    }

    public void addEnemy(Character character) {
        this.enemies.add(character);
    }

    public void addNextLocation(String direction, Location location) {
        this.nextLocation.put(direction, location);
    }
}