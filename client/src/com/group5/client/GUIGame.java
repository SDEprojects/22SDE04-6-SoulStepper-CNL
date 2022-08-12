package com.group5.client;

import com.group5.character.Player;
import com.group5.gameSetup.GUIGameSetup;
import com.group5.items.Items;

//import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.Font;

//import javax.swing.*;

public class GUIGame {

    // Array lists that allow the use to use different synonyms while playing the game.
    ArrayList<String> look = new ArrayList<>(Arrays.asList("look", "glance", "peep", "peek", "see", "view"));
    ArrayList<String> go = new ArrayList<>(Arrays.asList("go", "move", "proceed", "advance", "progress", "pass", "walk"));
    ArrayList<String> quit = new ArrayList<>(Arrays.asList("quit", "exit"));
    ArrayList<String> get = new ArrayList<>(Arrays.asList("get", "acquire", "obtain", "receive", "gain", "grab", "pick up", "take", "pull", "draw"));
    ArrayList<String> use = new ArrayList<>(Arrays.asList("use", "utilize", "operate"));
    ArrayList<String> view = new ArrayList<>(Arrays.asList("check", "current"));

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, userChoicePanel, playerPanel;
    JLabel titleNameLabel,hpLabel, hpLabelNumber, playerLocationLabel, playerCurrentLocation;
    Font titleFont = new Font("Times New Roman",Font.PLAIN, 70);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    JButton startButton, choice1, choice2, choice3, choice4, choice5;
    JButton button1, button2, button3, button4;
    JTextArea mainTextArea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    secondChoiceHandler secondChoiceHandler = new secondChoiceHandler();
    Player soulStepper = new Player("SoulStepper", 100);
    GUIGameSetup guiGameSetup = new GUIGameSetup();
    Items item = new Items();
    String position;
    String buttonSelected;


    public GUIGame() {
        window = new JFrame();
        window.setSize(1000,800);
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
        position = "game intro";

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100, 800, 350);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("WELCOME TO SOUL STEPPER");
        mainTextArea.setBounds(110,100,600,330);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        userChoicePanel = new JPanel();
        userChoicePanel.setBounds(250, 450, 500, 250);
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
        playerPanel.setBounds(100,15,800,50);
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
        showGUIInstructions();
    }

    public void playerSetup() throws InterruptedException {
        String previousLocation = "Main Street";
        int playerHP = soulStepper.getHealth();
        playerCurrentLocation.setText(guiGameSetup.currentLocation.getName());
        hpLabelNumber.setText("" + playerHP);
        displayCurrentLocationInfo();
    }

    private void displayCurrentLocationInfo() {
        switch(guiGameSetup.currentLocation.getName().toLowerCase()) {
            case "main street":
                displayMainStreet();
                break;
            case "base circle":
                baseCircle();
                break;
            case "treble parkway":
                trebleParkWay();
                break;
            case "riff runway":
                riffRunway();
                break;
            case "the palace":
                thePalace();
                break;
            case "wheat land":
                wheatLand();
                break;
            case "seminary street":
                seminaryStreet();
                break;
            case "boss house":
                bossHouse();
                break;
        }
    }

    public void setUpDirectionButtons() {
        choice1.removeActionListener(choiceHandler);
        choice1.setText("North");
        choice1.addActionListener(secondChoiceHandler);

        choice2.removeActionListener(choiceHandler);
        choice2.setText("South");
        choice2.addActionListener(secondChoiceHandler);

        choice3.removeActionListener(choiceHandler);
        choice3.setText("East");
        choice3.addActionListener(secondChoiceHandler);

        choice4.removeActionListener(choiceHandler);
        choice4.setText("West");
        choice4.addActionListener(secondChoiceHandler);

        choice5.removeActionListener(choiceHandler);
        choice5.addActionListener(secondChoiceHandler);
    }

    public void showGUIInstructions() throws InterruptedException {
        int delay = 4000;
        int delay2 = 8000;
        int delay3 = 12000;
        int delay4 = 16000;
        int delay5 = 20000;
        int delay6 = 24000;
        int delay7 = 28000;
        int delay8 = 32000;
        int delay9 = 36000;
        int delay10 = 40000;
        int delay11 = 45000;

        Timer timer = new Timer(delay, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("In this story, you are Levon Soulstepper. " +
                    "Who recently lost his " +
                    "title as the Supreme Stepper to notorious LoVibe");
        });
        timer.setRepeats(false);
        timer.start();
        Timer timer2 = new Timer(delay2, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("After losing everything, " +
                    "Levon spends his days at home watching reruns of " +
                    "little house of the prairie.");
        });
        timer2.setRepeats(false);
        timer2.start();
        Timer timer3 = new Timer(delay3, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("You're mission is simple..");
        });
        timer3.setRepeats(false);
        timer3.start();
        Timer timer4 = new Timer(delay4, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("Find LoVibe.");
        });
        timer4.setRepeats(false);
        timer4.start();
        Timer timer5 = new Timer(delay5, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("Whoop his ass with your moves.");
        });
        timer5.setRepeats(false);
        timer5.start();
        Timer timer6 = new Timer(delay6, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("And become the Supreme Stepper once again!");
        });
        timer6.setRepeats(false);
        timer6.start();
        Timer timer7 = new Timer(delay7, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("Whoop his ass with your moves.");
        });
        timer7.setRepeats(false);
        timer7.start();
        Timer timer8 = new Timer(delay8, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("Let me give you a few helpful commands to get your started..");
        });
        timer8.setRepeats(false);
        timer8.start();
        Timer timer9 = new Timer(delay9, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("Commands: \n To move = go [direction] \n To get items = get [item] \n To use items = use [item] " +
                    "\n To look = look [direction] \n Exit Game = quit \n To save = save game \n To load = load game ");
        });
        timer9.setRepeats(false);
        timer9.start();
        Timer timer10 = new Timer(delay10, e -> {
            mainTextArea.setText("");
            mainTextArea.setText("Ready? let's go!");
        });
        timer10.setRepeats(false);
        timer10.start();
        Timer timer11 = new Timer(delay11, e -> {
            try {
                playerSetup();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        timer11.setRepeats(false);
        timer11.start();
    }

    //---LOCATIONS-----//
    public void displayMainStreet() {
        position = "Main Street";
        mainTextArea.setText("You are on Main Street");
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(true);
        choice5.setVisible(true);

        choice1.setText("Go");
        choice2.setText("Get");
        choice3.setText("Use");
        choice4.setText("Look");
        choice5.setText("Quit");
    }

    public void baseCircle() {
        mainTextArea.setText("You on Base Circle");
        choice1.setText("Go");
        choice2.setText("Get");
        choice3.setText("Use");
        choice4.setText("Look");
        choice5.setText("Quit");
    }

    public void trebleParkWay() {
        mainTextArea.setText("You are on Treble Parkway");
        choice1.setText("Go");
        choice2.setText("Get");
        choice3.setText("Use");
        choice4.setText("Look");
        choice5.setText("Quit");
    }

    public void thePalace() {
        position = "cross road";
        mainTextArea.setText("You are in the Palace");
        choice1.setText("Go");
        choice2.setText("Get");
        choice3.setText("Use");
        choice4.setText("Look");
        choice5.setText("Quit");
    }

    public void riffRunway() {
        position = "cross road";
        mainTextArea.setText("You are on Riff Runway");
        choice1.setText("Go");
        choice2.setText("Get");
        choice3.setText("Use");
        choice4.setText("Look");
        choice5.setText("Quit");
    }

    public void wheatLand() {
        position = "cross road";
        mainTextArea.setText("You are on Wheat Land");
        choice1.setText("Go");
        choice2.setText("Get");
        choice3.setText("Use");
        choice4.setText("Look");
        choice5.setText("Quit");
    }

    public void seminaryStreet() {
        position = "cross road";
        mainTextArea.setText("");
        mainTextArea.setText("You are on Seminary Street");
        choice1.setText("Go");
        choice2.setText("Get");
        choice3.setText("Use");
        choice4.setText("Look");
        choice5.setText("Quit");
    }

    public void bossHouse() {
        mainTextArea.setText("Soul Stepper....You dare show your face...haha..");
        choice1.setText("Go");
        choice2.setText("Get");
        choice3.setText("Use");
        choice4.setText("Look");
        choice5.setText("Quit");
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

            switch(guiGameSetup.currentLocation.getName().toLowerCase()) {
                case "main street":
                case "base circle":
                case "treble parkway":
                case "seminary street":
                case "wheat land":
                case "riff runway":
                case "the palace":
                    switch(yourChoice) {
                        case "c1":
                            setUpDirectionButtons();
                            buttonSelected = "Go";
                            break;
                        case "c2":
                            getButtonSelected();
                            buttonSelected = "Get";
                            break;
                        case "c3":
                            useButtonSelected();
                            buttonSelected = "Use";
                            break;
                        case "c4":
                            setUpDirectionButtons();
                            buttonSelected = "Look";
                            break;
                        default:
                            break;
                    }
                    break;
                case "boss house":
                    switch(yourChoice) {
                        case "c1":
                            setUpDirectionButtons();
                            buttonSelected = "Go";
                            break;
                        case "c2":
                            getButtonSelected();
                            buttonSelected = "Get";
                            break;
                        case "c3":
                            useButtonSelected();
                            buttonSelected = "Use";
                            break;
                        case "c4":
                            setUpDirectionButtons();
                            buttonSelected = "Look";
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
    }

    public class secondChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();
            System.out.println(yourChoice);

            switch(buttonSelected) {
                case "Go":
                    switch(yourChoice) {
                        case "c1":
                            System.out.println(choice1.getText());
                            guiGameSetup.go(guiGameSetup.currentLocation, choice1.getText().toLowerCase());
                            executeGoResults();
                            NorthButtonSelected();
                            break;
                        case "c2":
                            guiGameSetup.go(guiGameSetup.currentLocation, choice2.getText().toLowerCase());
                            executeGoResults();
                            SouthButtonSelected();
                            break;
                        case "c3":
                            guiGameSetup.go(guiGameSetup.currentLocation, choice3.getText().toLowerCase());
                            executeGoResults();
                            EastButtonSelected();
                            break;
                        case "c4":
                            guiGameSetup.go(guiGameSetup.currentLocation, choice4.getText().toLowerCase());
                            executeGoResults();
                            WestButtonSelected();
                            break;
                        case "c5":
                            QuitButtonSelected();
                            //Quit Game
                            break;
                        default:
                            break;
                    }
                    break;
                case "Get":
                    switch(yourChoice) {
                        case "c1":
                            // goButtonSelected();
                            break;
                        case "c2":
                            //getButtonSelected();
                            break;
                        case "c3":
                            // useButtonSelected();
                            break;
                        case "c4":
                            // lookButtonSelected();
                            break;
                        case "c5":
                            // guitButtonSelected();
                            break;
                        default:
                            break;
                    }
                    break;
                case "Use":
                    switch(yourChoice) {
                        case "c1":
                            //goButtonSelected();
                            break;
                        case "c2":
                            // getButtonSelected();
                            break;
                        case "c3":
                            //useButtonSelected();
                            break;
                        case "c4":
                            // lookButtonSelected();
                            break;
                        case "c5":
                            // guitButtonSelected();
                            //Quit Game
                            break;
                        default:
                            break;
                    }
                    break;
                case "Look":
                    switch(yourChoice) {
                        case "c1":
                            guiGameSetup.look(guiGameSetup.currentLocation, choice1.getText().toLowerCase());
                            executeLookResults();
                            NorthButtonSelected();
                            break;
                        case "c2":
                            guiGameSetup.look(guiGameSetup.currentLocation, choice3.getText().toLowerCase());
                            executeLookResults();
                            SouthButtonSelected();
                            break;
                        case "c3":
                            guiGameSetup.look(guiGameSetup.currentLocation, choice3.getText().toLowerCase());
                            executeLookResults();
                            EastButtonSelected();
                            break;
                        case "c4":
                            guiGameSetup.look(guiGameSetup.currentLocation, choice4.getText().toLowerCase());
                            executeLookResults();
                            WestButtonSelected();
                            break;
                        case "c5":
                            QuitButtonSelected();
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
    }

    private void getButtonSelected() {
        buttonSelected = "Get";
    }

    private void useButtonSelected() {
        buttonSelected = "Use";
    }

    private void executeGoResults() {
        System.out.println("execute Results firing...");
        System.out.println(guiGameSetup.previousLocation.getName());
        System.out.println(guiGameSetup.currentLocation.getName());
        if(guiGameSetup.previousLocation.getName().equals(guiGameSetup.currentLocation.getName())) {
            mainTextArea.setText("");
            mainTextArea.setText("you can't go that way. Select Different Direction");
        } else {
            playerCurrentLocation.setText(guiGameSetup.currentLocation.getName());
            guiGameSetup.previousLocation = guiGameSetup.currentLocation;
            displayCurrentLocationInfo();
            setUpMainCommandButtons();
        }
    }

    private void executeLookResults() {
        System.out.println("execute Results firing...");
        if(guiGameSetup.validLookedAtDirection ==  false) {
            mainTextArea.setText("");
            mainTextArea.setText("There's nothing of interest there.");
        } else {
            mainTextArea.setText("");
            mainTextArea.setText(guiGameSetup.lookedAtLocation);
            //displayCurrentLocationInfo();
            setUpMainCommandButtons();
        }
    }

    private void setUpMainCommandButtons() {
        choice1.removeActionListener(secondChoiceHandler);
        choice1.setText("Go");
        choice1.addActionListener(choiceHandler);

        choice2.removeActionListener(secondChoiceHandler);
        choice2.setText("Get");
        choice2.addActionListener(choiceHandler);

        choice3.removeActionListener(secondChoiceHandler);
        choice3.setText("Use");
        choice3.addActionListener(choiceHandler);

        choice4.removeActionListener(secondChoiceHandler);
        choice4.setText("Look");
        choice4.addActionListener(choiceHandler);

        choice5.removeActionListener(secondChoiceHandler);
        choice5.addActionListener(choiceHandler);
    }

    private void NorthButtonSelected() {
    }

    private void SouthButtonSelected() {
    }

    private void EastButtonSelected() {
    }

    private void WestButtonSelected() {
    }

    private void QuitButtonSelected() {
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

    public void playGUI() throws InterruptedException {
    }
}