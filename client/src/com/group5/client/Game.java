package com.group5.client;

import com.group5.character.Player;
import com.group5.gameSetup.GameSetup;
import com.group5.gameSetup.Instruction;
import com.group5.items.Items;

//import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.FileWriter;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.Font;
import java.util.concurrent.TimeUnit;

//import javax.swing.*;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, userChoicePanel, playerPanel;
    JLabel titleNameLabel,hpLabel, hpLabelNumber, playerLocationLabel, playerCurrentLocation;
    Font titleFont = new Font("Times New Roman",Font.PLAIN, 70);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    JButton startButton, choice1, choice2, choice3, choice4, choice5;
    JTextArea mainTextArea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    Player soulStepper;
    String position;


    public Game() {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("SOUL STEPPER");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.BLACK);

        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    public void createGameScreen() throws InterruptedException {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Welcome to Soul Stepper");
        mainTextArea.setBounds(110,100,600,250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        userChoicePanel = new JPanel();
        userChoicePanel.setBounds(250, 350, 300, 150);
        userChoicePanel.setBackground(Color.BLACK);
        userChoicePanel.setLayout(new GridLayout(5,1));
        con.add(userChoicePanel);

        choice1 = new JButton("Go");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(normalFont);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choice1.setFocusPainted(false);
        userChoicePanel.add(choice1);
        choice1.setVisible(false);

        choice2 = new JButton("Get");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(normalFont);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choice2.setFocusPainted(false);
        userChoicePanel.add(choice2);
        choice2.setVisible(false);

        choice3 = new JButton("Use");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(normalFont);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choice3.setFocusPainted(false);
        userChoicePanel.add(choice3);
        choice3.setVisible(false);

        choice4 = new JButton("Look");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(normalFont);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choice4.setFocusPainted(false);
        userChoicePanel.add(choice4);
        choice4.setVisible(false);

        choice5 = new JButton("Quit");
        choice5.setBackground(Color.BLACK);
        choice5.setForeground(Color.WHITE);
        choice5.setFont(normalFont);
        choice5.addActionListener(choiceHandler);
        choice5.setActionCommand("c5");
        choice5.setFocusPainted(false);
        userChoicePanel.add(choice5);
        choice5.setVisible(false);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.WHITE);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.WHITE);
        playerPanel.add(hpLabelNumber);

        playerLocationLabel = new JLabel("Location:");
        playerLocationLabel.setFont(normalFont);
        playerLocationLabel.setForeground(Color.WHITE);
        playerPanel.add(playerLocationLabel);

        playerCurrentLocation = new JLabel();
        playerCurrentLocation.setFont(normalFont);
        playerCurrentLocation.setForeground(Color.WHITE);
        playerPanel.add(playerCurrentLocation);

        playerSetup();
    }

    public void playerSetup() throws InterruptedException {
        String location = "Main Street";
        int playerHP = soulStepper.getHealth();
        playerCurrentLocation.setText(location);
        hpLabelNumber.setText("" + playerHP);

        // showGUIInstructions();
    }

    public void showGUIInstructions() throws InterruptedException {
        mainTextArea.setText("");
        mainTextArea.setText("WELCOME TO SOUL STEPPER");
        //TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainTextArea.setText("In this story, you are Levon Soulstepper. " +
                "Who recently lost his " +
                "title as the Supreme Stepper to notorious LoVibe");
        //TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainTextArea.setText("After losing everything, " +
                "Levon spends his days at home watching reruns of " +
                "little house of the prairie.");
        //TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainTextArea.setText("You're mission is simple..");
        // TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainTextArea.setText("Find LoVibe.");
        //TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainTextArea.setText("Whoop his ass with your moves.");
        //TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainTextArea.setText("And become the Supreme Stepper once again!");
        /// TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainTextArea.setText("Let me give you a few helpful commands to get your started..");
        // TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainTextArea.setText("\033[1;35m");
        //TimeUnit.MILLISECONDS.sleep(700);
        mainTextArea.setText("");
        mainTextArea.setText("Commands: \n To move = go [direction] \n To get items = get [item] \n To use items = use [item] " +
                "\n To look = look [direction] \n Exit Game = quit \n To save = save game \n To load = load game ");
        System.out.println("\033[0m");
        mainTextArea.setText("\033[1;35m");
        //TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainTextArea.setText("Ready? let's go!");
        // TimeUnit.MILLISECONDS.sleep(1500);
        mainTextArea.setText("");
        mainStreet();
    }

    public void mainStreet() {
        position = "Main Street";
        mainTextArea.setText("You are now at Main Street \n\nWhat do you do?");
        choice1.setText("Go");
        choice2.setText("Get");
        choice3.setText("Use");
        choice4.setText("Look");
        choice5.setText("Quit");
    }

    public void baseCircle() {
        position = "cross road";
        mainTextArea.setText("You are at a cross road\n If you go south, you will go back to town");
        choice1.setText("Go");
        choice2.setText("Look");
        choice3.setText("attackGuard");
        choice4.setText("Quit");
    }

    public void trebleParkWay() {
        position = "cross road";
        mainTextArea.setText("You are at a cross road\n If you go south, you will go back to town");
        choice1.setText("Go");
        choice2.setText("Look");
        choice3.setText("attackGuard");
        choice4.setText("Quit");
    }

    public void thePalace() {
        position = "cross road";
        mainTextArea.setText("You are at a cross road\n If you go south, you will go back to town");
        choice1.setText("Go");
        choice2.setText("Look");
        choice3.setText("attackGuard");
        choice4.setText("Quit");
    }

    public void riffRunway() {
        position = "cross road";
        mainTextArea.setText("You are at a cross road\n If you go south, you will go back to town");
        choice1.setText("Go");
        choice2.setText("Look");
        choice3.setText("attackGuard");
        choice4.setText("Quit");
    }

    public void wheatLand() {
        position = "cross road";
        mainTextArea.setText("You are at a cross road\n If you go south, you will go back to town");
        choice1.setText("Go");
        choice2.setText("Look");
        choice3.setText("attackGuard");
        choice4.setText("Quit");
    }

    public void seminarStreet() {
        position = "cross road";
        mainTextArea.setText("You are at a cross road\n If you go south, you will go back to town");
        choice1.setText("Go");
        choice2.setText("Look");
        choice3.setText("attackGuard");
        choice4.setText("Quit");
    }

    public void bossFightLocation() {
        position = "cross road";
        mainTextArea.setText("You are at a cross road\n If you go south, you will go back to town");
        choice1.setText("Go");
        choice2.setText("Look");
        choice3.setText("attackGuard");
        choice4.setText("Quit");
    }

    public void attackGuard() {
        position = "attackGuard";
        mainTextArea.setText("Guard: Dont be stupid");
        int playerHP = soulStepper.getHealth();

        soulStepper.decreaseHealth();
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Funky Chicken");
        choice2.setText("Look");
        choice3.setText("Use");
        choice4.setText("Quit");
    }

    public void goSelectedButtonSelected() {
        //position = "Go";
        mainTextArea.setText("Which direction would you like to go?");
        choice1.setText("North");
        choice2.setText("South");
        choice3.setText("East");
        choice4.setText("West");
    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                createGameScreen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();
            System.out.println(yourChoice);
            if(yourChoice.equals("c1")) {
                goSelectedButtonSelected();
            }
            else if(yourChoice.equals("c3")) {
                attackGuard();
            }
//
//            switch(position) {
//                case "townGate":
//                    switch(yourChoice) {
//                        case "c1":
//                            goSelectedButtonSelected();
//                            break;
//                        case "c2":
//                            break;
//                        case "c3":
            //                  aatckGuard();
//                            break;
//                        case "c4":
//                            break;
//                        default:
//                            break;
//                    }
//                case "attackGuard":
//                    switch(yourChoice) {
//                        case "c1":
//                            goSelectedButtonSelected();
//                            break;
//                        case "c2":
//                            break;
//                        case "c3":
//                            break;
//                        case "c4":
//                            break;
//                        default:
//                            break;
//                    }
//                case "crossRoad":
//                    switch(yourChoice) {
//                        case "c1":
//                            goSelectedButtonSelected();
//                            break;
//                        case "c2":
//                            break;
//                        case "c3":
            //                townGate();
//                            break;
//                        case "c4":
//                            break;
//                        default:
//                            break;
//                    }
//                case "townGate4":
//                    switch(yourChoice) {
//                        case "c1":
//                            goSelectedButtonSelected();
//                            break;
//                        case "c2":
//                            break;
//                        case "c3":
//                            break;
//                        case "c4":
//                            break;
//                        default:
//                            break;
//                    }
//                case "townGate4":
//                    switch(yourChoice) {
//                        case "c1":
//                            goSelectedButtonSelected();
//                            break;
//                        case "c2":
//                            break;
//                        case "c3":
//                            break;
//                        case "c4":
//                            break;
//                        default:
//                            break;
//                    }
//                case "townGate4":
//                    switch(yourChoice) {
//                        case "c1":
//                            goSelectedButtonSelected();
//                            break;
//                        case "c2":
//                            break;
//                        case "c3":
//                            break;
//                        case "c4":
//                            break;
//                        default:
//                            break;
//                    }
//                case "playerAttack":
//                    switch(yourChoice) {
//                        case "c1":
//                            goSelectedButtonSelected();
//                            break;
//                        case "c2":
//                            break;
//                        case "c3":
//                            break;
//                        case "c4":
//                            break;
//                        default:
//                            break;
//                    }
//
//
//            }

        }
    }

    public void playGUI() throws InterruptedException {
        showGUIInstructions();
    }

    // Array lists that allow the use to use different synonyms while playing the game.

    ArrayList<String> look = new ArrayList<>(Arrays.asList("look", "glance", "peep", "peek", "see", "view"));
    ArrayList<String> go = new ArrayList<>(Arrays.asList("go", "move", "proceed", "advance", "progress", "pass", "walk"));
    ArrayList<String> quit = new ArrayList<>(Arrays.asList("quit", "exit"));
    ArrayList<String> get = new ArrayList<>(Arrays.asList("get", "acquire", "obtain", "receive", "gain", "grab", "pick up", "take", "pull", "draw"));
    ArrayList<String> use = new ArrayList<>(Arrays.asList("use", "utilize", "operate"));
    ArrayList<String> view = new ArrayList<>(Arrays.asList("check", "current"));

    public void play() throws InterruptedException, IOException {

        Instruction instruction = new Instruction();
        instruction.showInstruction();
        GameSetup gameSetup = new GameSetup();
        soulStepper = new Player("SoulStepper", 100);
        Scanner scanner = new Scanner(System.in);
        Items item = new Items();
        while (true) {
            System.out.println("You are now at " + gameSetup.currentLocation.getName());

            System.out.println("\033[1;35m");
            System.out.println("Where would you like to go? ");
            System.out.println("\033[0m");
            System.out.println();
            soulStepper.showInventory();
            System.out.println();
            System.out.print("> ");

            if (gameSetup.currentLocation.items.size() > 0) {
                gameSetup.currentLocation.getItems();
            }
            String choice = scanner.nextLine().toLowerCase();
            String[] arrayChoice = choice.split(" ", 2);
            if (look.contains(arrayChoice[0])) {
                gameSetup.look(gameSetup.currentLocation, arrayChoice[1]);
            } else if (go.contains(arrayChoice[0])) {
                gameSetup.go(gameSetup.currentLocation, arrayChoice[1]);
                if (gameSetup.currentLocation.enemies.size() > 0) {
                    if (gameSetup.currentLocation.enemies.contains(gameSetup.boss)) {
                        soulStepper.bossDance(gameSetup.currentLocation.enemies.get(0), soulStepper);
                        gameSetup.currentLocation.enemies.remove(0);
                    }
                    soulStepper.dance(gameSetup.currentLocation.enemies.get(0), soulStepper);
                    gameSetup.currentLocation.enemies.remove(0);
                }
            } else if (quit.contains(arrayChoice[0])) {
                System.out.println("Thanks for playing Soul Stepper");
                System.exit(0);
            } else if (get.contains(arrayChoice[0])) {
                if (gameSetup.currentLocation.items.contains(arrayChoice[1])) {
                    gameSetup.removeItem(arrayChoice[1]);
                    soulStepper.addItem(arrayChoice[1]);
                } else {
                    System.out.println("You can't do that");
                }
            } else if (use.contains(arrayChoice[0])) {
                if (soulStepper.inventory.contains(arrayChoice[1])) {
                    soulStepper.removeItem(arrayChoice[1]);
                    item.useItem(arrayChoice[1], soulStepper);
                }
            } else if (view.contains(arrayChoice[0])) {
                switch (arrayChoice[1]) {
                    case "health":
                        soulStepper.currentHealth();
                        System.out.println();
                    case "map":
                }
            } else if (arrayChoice[0].equals("save")){
                String path = "saveGame.json";

                Map<String, Object> map = new HashMap<>();
                map.put("currentLocation",gameSetup.currentLocation.getName());
                map.put("currentHealth", soulStepper.getHealth());
                map.put("currentInventory", soulStepper.inventory);

                try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(map);
                    out.write(jsonString);
                    System.out.println("Game Saved!");
                } catch (Exception e) {
                    System.out.println("There was an error saving your game!");
                    e.printStackTrace();
                }
            } else if (arrayChoice[0].equals("load")){

                try (Reader in = Files.newBufferedReader(Paths.get("saveGame.json"))) {
                    Gson gson = new Gson();
                    Map<String,Object> map = gson.fromJson(in, Map.class);

                    String currentLocation = map.get("currentLocation") != null ? (String) map.get("currentLocation") : "Base Circle";
                    Integer health = map.get("currentHeath") != null ? (Integer) map.get("currentLocation") : 100;
                    ArrayList inv = (ArrayList) map.get("currentInventory");
                    gameSetup.currentLocation = gameSetup.ref.get(currentLocation);
                    soulStepper.setHealth(health);
                    for(Object invItem : inv)
                        soulStepper.addItem((String) invItem);
                    System.out.println("Game Loaded!");
                } catch (Exception e) {
                    System.out.println("There was an error saving your game!");
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Invalid Command");
            }
        }
    }
}