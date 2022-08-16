package com.group5.client;

import com.group5.character.Player;
import com.group5.gameSetup.GUIGameSetup;
import com.group5.items.Items;

//import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.Font;
import java.util.List;

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
    JTextArea mainTextArea, mainTextArea2;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    secondChoiceHandler secondChoiceHandler = new secondChoiceHandler();
    DanceBattleHandler danceBattleHandler = new DanceBattleHandler();
    com.group5.character.Character currentEnemy;
    Player soulStepper = new Player("SoulStepper", 100);
    GUIGameSetup guiGameSetup = new GUIGameSetup();
    Items item = new Items();
    String position;
    String buttonSelected;
    Boolean enemyExist = false;


    public GUIGame() {
        window = new JFrame();
        window.setSize(1200,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,800,200);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("SOUL STEPPER");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(400,500,200,100);
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

    public void createGameScreen() throws InterruptedException, IOException {
        position = "game intro";

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,200, 800, 350);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("WELCOME TO SOUL STEPPER");
        mainTextArea.setBounds(110,100,800,330);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        mainTextArea2 = new JTextArea("");
        mainTextArea2.setBounds(110,300,800,330);
        mainTextArea2.setBackground(Color.BLACK);
        mainTextArea2.setForeground(Color.WHITE);
        mainTextArea2.setFont(normalFont);
        mainTextArea2.setLineWrap(true);
        mainTextPanel.add(mainTextArea2);


        userChoicePanel = new JPanel();
        userChoicePanel.setBounds(250, 450, 500, 250);
        userChoicePanel.setBackground(Color.BLACK);
        userChoicePanel.setLayout(new GridLayout(5,1));
        con.add(userChoicePanel);

        choice1 = new JButton("Go");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(normalFont);
        choice1.addActionListener(new ChoiceHandler());
        choice1.removeActionListener(new ChoiceHandler());
        choice1.setActionCommand("c1");
        choice1.setFocusPainted(false);
        userChoicePanel.add(choice1);
        choice1.setVisible(false);

        choice2 = new JButton("Get");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(normalFont);
        choice2.addActionListener(new ChoiceHandler());
        choice2.setActionCommand("c2");
        choice2.setFocusPainted(false);
        userChoicePanel.add(choice2);
        choice2.setVisible(false);

        choice3 = new JButton("Use");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(normalFont);
        choice3.addActionListener(new ChoiceHandler());
        choice3.setActionCommand("c3");
        choice3.setFocusPainted(false);
        userChoicePanel.add(choice3);
        choice3.setVisible(false);

        choice4 = new JButton("Look");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(normalFont);
        choice4.addActionListener(new ChoiceHandler());
        choice4.setActionCommand("c4");
        choice4.setFocusPainted(false);
        userChoicePanel.add(choice4);
        choice4.setVisible(false);

        choice5 = new JButton("Quit");
        choice5.setBackground(Color.BLACK);
        choice5.setForeground(Color.WHITE);
        choice5.setFont(normalFont);
        choice5.addActionListener(new ChoiceHandler());
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

        //showGUIInstructions();
        playerSetup();
    }

    //-----GAME SETUP METHODS----------//
    public void playerSetup() throws InterruptedException, IOException {
        String previousLocation = "Main Street";
        int playerHP = soulStepper.getHealth();
        playerCurrentLocation.setText(guiGameSetup.currentLocation.getName());
        hpLabelNumber.setText("" + playerHP);
        displayCurrentLocationInfo();
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
            } catch (InterruptedException | IOException ex) {
                ex.printStackTrace();
            }
        });
        timer11.setRepeats(false);
        timer11.start();
    }

    //-------------------DISPLAY LOCATION INFO------------------//
    private void displayCurrentLocationInfo() throws IOException, InterruptedException {
        mainTextArea.setVisible(true);
        mainTextArea2.setText("");

        choice1.setEnabled(true);
        choice2.setEnabled(true);
        choice3.setEnabled(true);
        choice4.setEnabled(true);
        choice5.setEnabled(true);

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

    //-----------ENEMY FIGHT LOGIC---------------//
    private void checkIfEnemyExists() throws IOException, InterruptedException {
        if(guiGameSetup.currentLocation.enemies.size() > 0) {
            enemyExist = true;

                removeActionListeners();
                setupDanceBattleButtons();
                currentEnemy = guiGameSetup.currentLocation.enemies.get(0);
                displayDanceBattleIntro();
                guiGameSetup.currentLocation.enemies.remove(0);
//            removeActionListeners();
//            setupDanceBattleButtons();
//            currentEnemy = guiGameSetup.currentLocation.enemies.get(0);
//            displayDanceBattleIntro();
//            guiGameSetup.currentLocation.enemies.remove(0);
        } else {
            removeActionListeners();
            setUpMainCommandButtons();
        }
    }

    private void displayDanceBattleIntro() {
        choice1.setEnabled(false);
        choice2.setEnabled(false);
        choice3.setEnabled(false);
        choice4.setEnabled(false);

        int delay = 3000;
        mainTextArea.setText("YOU ENCOUNTERED " + currentEnemy.getName()+"!");
        mainTextArea2.setText("DANCE BATTLE INITIATED!");
        mainTextArea2.setVisible(true);
        Timer timer = new Timer(delay, e -> {
            try {
                danceGUI();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void displayEnemyEndingDialogue(ArrayList<String> enemyDialogue) {
    }

    private void danceGUI() throws IOException, InterruptedException {
        int delay = 300;
        int delay2 = 2000;


        Timer timer = new Timer(delay, e -> {
            choice1.setEnabled(true);
            choice2.setEnabled(true);
            choice3.setEnabled(true);
            choice4.setEnabled(true);
            choice5.setEnabled(true);
            if(currentEnemy.getHealth() > 0) {
                mainTextArea.setText("");
                if(soulStepper.getHealth() > 0) {
                    mainTextArea2.setVisible(true);
                    mainTextArea2.setText("" +
                            "Pick a number to select a dance move:\n" +
                            "            1. The Hustle\n" +
                            "            2. Bus Stop\n" +
                            "            3. Michael Jackson Robot\n" +
                            "            4. Funky Chicken");
                } else {

                    mainTextArea.setText("Soul-Stepper was defeated!");
                    mainTextArea2.setVisible(false);
                    Timer timer2 = new Timer(delay2, e2 -> {
                        quitButtonSelected();
                    });
                    timer2.setRepeats(false);
                    timer2.start();
                }
            } else {
                removeActionListeners();
                setUpMainCommandButtons();
                mainTextArea2.setText("");
                try {
                    displayCurrentLocationInfo();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void enemyDanceGUI() {

        Random random = new Random();
        int number = random.nextInt(4) + 2;
        int delay = 3000;
        int delay2 = 5400;

        List<String> danceMoves = new ArrayList<>(5);
        danceMoves.add("Kill-off");
        danceMoves.add("Chest Pop");
        danceMoves.add("Jab");
        danceMoves.add("Buck");
        danceMoves.add("Get-off");

        Timer timer = new Timer(delay, e -> {

            if (number == 0) {
                mainTextArea.setText("The " + currentEnemy.getName() + " hit you with a " + danceMoves.get(0));
                soulStepper.decreaseHealth();
                hpLabelNumber.setText("" +soulStepper.getHealth());
                mainTextArea2.setVisible(false);
            } else if (number == 1) {
                // enemyTaunt();
                System.out.println();
                mainTextArea.setText("The " + currentEnemy.getName() + " hit you with a " + danceMoves.get(1));
                soulStepper.decreaseHealth();
                hpLabelNumber.setText("" +soulStepper.getHealth());
                mainTextArea2.setVisible(false);
            } else if (number == 2) {
                //enemyTaunt();;
                mainTextArea.setText("The " + currentEnemy.getName() + " hit you with a " + danceMoves.get(2));
                soulStepper.decreaseHealth();
                hpLabelNumber.setText("" +soulStepper.getHealth());
                System.out.printf("Soul-steppers current health is %s", soulStepper.getHealth());
                mainTextArea2.setVisible(false);
            } else if (number == 3) {
                //enemyTaunt();
                mainTextArea.setText("The " + currentEnemy.getName() + " hit you with a " + danceMoves.get(3));
                soulStepper.decreaseHealth();
                hpLabelNumber.setText("" +soulStepper.getHealth());
                mainTextArea2.setVisible(false);
            } else {
                mainTextArea2.setText("The " + currentEnemy.getName() + " tried hit you with a move but missed!");
            }
        });
        timer.setRepeats(false);
        timer.start();
        Timer timer2 = new Timer(delay2, e -> {
            try {
                danceGUI();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        timer2.setRepeats(false);
        timer2.start();


    }

    //-------------------LOCATIONS------------------//
    public void displayMainStreet() throws IOException, InterruptedException {
        removeActionListeners();
        setUpMainCommandButtons();
        mainTextArea.setText("You are on Main Street");
        mainTextArea.setVisible(true);

        if (guiGameSetup.currentLocation.items.size() > 0) {
            mainTextArea2.setText(guiGameSetup.currentLocation.items.toString());
            mainTextArea2.setVisible(true);
        }
    }

    public void baseCircle() throws IOException, InterruptedException {
        removeActionListeners();
        setUpMainCommandButtons();
        mainTextArea.setText("You on Base Circle");

        if (guiGameSetup.currentLocation.items.size() > 0) {
            mainTextArea2.setText(guiGameSetup.currentLocation.items.toString());
            mainTextArea2.setVisible(true);
        }
    }

    public void trebleParkWay() throws IOException, InterruptedException {
        removeActionListeners();
        setUpMainCommandButtons();
        mainTextArea.setText("You are on Treble Parkway");

        if (guiGameSetup.currentLocation.items.size() > 0) {
            mainTextArea2.setText(guiGameSetup.currentLocation.items.toString());
            mainTextArea2.setVisible(true);
        }
    }

    public void thePalace() throws IOException, InterruptedException {
        removeActionListeners();
        setUpMainCommandButtons();
        mainTextArea.setText("You are in the Palace");

        if (guiGameSetup.currentLocation.items.size() > 0) {
            mainTextArea2.setText(guiGameSetup.currentLocation.items.toString());
            mainTextArea2.setVisible(true);
        }
    }

    public void riffRunway() throws IOException, InterruptedException {
        removeActionListeners();
        setUpMainCommandButtons();
        mainTextArea.setText("You are on Riff Runway");

        if (guiGameSetup.currentLocation.items.size() > 0) {
            mainTextArea2.setText(guiGameSetup.currentLocation.items.toString());
            mainTextArea2.setVisible(true);
        }
    }

    public void wheatLand() throws IOException, InterruptedException {
        removeActionListeners();
        setUpMainCommandButtons();
        mainTextArea.setText("You are on Wheat Land");

        if (guiGameSetup.currentLocation.items.size() > 0) {
            mainTextArea2.setText(guiGameSetup.currentLocation.items.toString());
            mainTextArea2.setVisible(true);
        }
    }

    public void seminaryStreet() throws IOException, InterruptedException {
        removeActionListeners();
        setUpMainCommandButtons();
        mainTextArea.setText("");
        mainTextArea.setText("You are on Seminary Street");

        if (guiGameSetup.currentLocation.items.size() > 0) {
            mainTextArea2.setText(guiGameSetup.currentLocation.items.toString());
            mainTextArea2.setVisible(true);
        }
    }

    public void bossHouse() throws IOException, InterruptedException {
        removeActionListeners();
        setUpMainCommandButtons();

        if (guiGameSetup.currentLocation.items.size() > 0) {
            mainTextArea2.setText(guiGameSetup.currentLocation.items.toString());
            mainTextArea2.setVisible(true);
        }
        quitButtonSelected();
    }

    //-----------HANDLER METHODS---------------//
    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                createGameScreen();
            } catch (InterruptedException | IOException e) {
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
                            goButtonSelected();
                            removeActionListeners();
                            setUpDirectionButtons();
                            break;
                        case "c2":
                            removeActionListeners();
                            getButtonSelected();
                            setupGetButtons();

                            break;
                        case "c3":
                            useButtonSelected();
                            removeActionListeners();
                            setUpUseButtons();
                            break;
                        case "c4":
                            removeActionListeners();
                            buttonSelected = "Look";
                            setUpDirectionButtons();
                            break;
                        case "c5":
                            quitButtonSelected();
                            break;
                        default:
                            break;
                    }
                    break;
                case "boss house":
                    switch(yourChoice) {
                        case "c1":
                            removeActionListeners();
                            setUpDirectionButtons();
                            break;
                        case "c2":
                            removeActionListeners();
                            setupGetButtons();
                            break;
                        case "c3":
                            removeActionListeners();
                            useButtonSelected();
                            break;
                        case "c4":
                            removeActionListeners();
                            setUpDirectionButtons();
                            break;
                        case "c5":
                            quitButtonSelected();
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
                            removeActionListeners();
                            try {
                                executeGoResults();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c2":
                            guiGameSetup.go(guiGameSetup.currentLocation, choice2.getText().toLowerCase());
                            removeActionListeners();
                            try {
                                executeGoResults();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c3":
                            guiGameSetup.go(guiGameSetup.currentLocation, choice3.getText().toLowerCase());
                            removeActionListeners();
                            try {
                                executeGoResults();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c4":
                            guiGameSetup.go(guiGameSetup.currentLocation, choice4.getText().toLowerCase());
                            removeActionListeners();
                            try {
                                executeGoResults();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c5":
                            removeActionListeners();
                            quitButtonSelected();
                            break;
                        default:
                            break;
                    }
                    break;
                case "Get":
                    switch(yourChoice) {
                        case "c1":
                            executeGetResults(choice1.getText());
                            break;
                        case "c2":
                            executeGetResults(choice2.getText());
                            getButtonSelected();
                            break;
                        case "c3":
                            executeGetResults(choice3.getText());
                            break;
                        case "c4":
                            executeGetResults(choice4.getText());
                            break;
                        case "c5":
                            quitButtonSelected();
                            break;
                        default:
                            break;
                    }
                    break;
                case "Use":
                    switch(yourChoice) {
                        case "c1":
                            try {
                                executeUseResult(choice1.getText());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c2":
                            try {
                                executeUseResult(choice1.getText());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "c3":

                            break;
                        case "c4":
                            // lookButtonSelected();
                            break;
                        case "c5":
                            quitButtonSelected();
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
                            break;
                        case "c2":
                            guiGameSetup.look(guiGameSetup.currentLocation, choice2.getText().toLowerCase());
                            executeLookResults();
                            break;
                        case "c3":
                            guiGameSetup.look(guiGameSetup.currentLocation, choice3.getText().toLowerCase());
                            executeLookResults();
                            break;
                        case "c4":
                            guiGameSetup.look(guiGameSetup.currentLocation, choice4.getText().toLowerCase());
                            executeLookResults();
                            break;
                        case "c5":
                            quitButtonSelected();
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
    }

    public class DanceBattleHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();
            System.out.println(yourChoice);

            switch(yourChoice) {
                case "c1":
                    try {
                        displayHustleResults();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "c2":
                    try {
                        displayBusStopResults();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "c3":
                    try {
                        displayRobotResults();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "c4":
                    try {
                        displayFunkyChickenResults();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "c5":
                    removeActionListeners();
                    quitButtonSelected();
                    break;
                default:
                    break;
            }
        }
    }

    //--------------DANCE MOVES------------//
    private void displayBusStopResults() throws IOException, InterruptedException {
        choice1.setEnabled(false);
        choice2.setEnabled(false);
        choice3.setEnabled(false);
        choice4.setEnabled(false);
        choice5.setEnabled(false);

        int delay = 2700;

        System.out.println(choice1.getText());
        mainTextArea.setText("Soul-stepper broke out the Bus Stop!");
        mainTextArea2.setVisible(false);
            Timer timer = new Timer(delay, e -> {
                currentEnemy.decreaseHealth();
                mainTextArea2.setText(currentEnemy.getName() + " got hit by the bus, and there current health is " + currentEnemy.getHealth() + "!");
                mainTextArea2.setVisible(true);
                if (currentEnemy.getHealth() > 0) {
                    Timer timer2 = new Timer(delay, e2 -> {
                        enemyDanceGUI();
                    });
                    timer2.setRepeats(false);
                    timer2.start();
                }else {
                    Timer timer2 = new Timer(delay, e2 -> {
                        System.out.println("Enemey defeated..");
                        displayEnemyDefeatedInfo();
                    });
                    timer2.setRepeats(false);
                    timer2.start();
                }
            });
            timer.setRepeats(false);
            timer.start();
    }

    private void displayHustleResults() throws IOException, InterruptedException {
        choice1.setEnabled(false);
        choice2.setEnabled(false);
        choice3.setEnabled(false);
        choice4.setEnabled(false);

        int delay = 2700;


        System.out.println(choice1.getText());
        mainTextArea.setText("Soul-stepper hit em with the Hustle!");
        mainTextArea2.setVisible(false);
        Timer timer = new Timer(delay, e -> {
            currentEnemy.decreaseHealth();
            mainTextArea2.setText(currentEnemy.getName() + " got hit by the bus, and there current health is " + currentEnemy.getHealth() + "!");
            mainTextArea2.setVisible(true);
            if (currentEnemy.getHealth() > 0) {
                Timer timer2 = new Timer(delay, e2 -> {
                    enemyDanceGUI();
                });
                timer2.setRepeats(false);
                timer2.start();
            }else {
                Timer timer2 = new Timer(delay, e2 -> {
                    System.out.println("Enemey defeated..");
                    displayEnemyDefeatedInfo();
                });
                timer2.setRepeats(false);
                timer2.start();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void displayRobotResults() throws IOException, InterruptedException {
        choice1.setEnabled(false);
        choice2.setEnabled(false);
        choice3.setEnabled(false);
        choice4.setEnabled(false);

        int delay = 2700;

        System.out.println(choice1.getText());
        mainTextArea.setText("Soul-stepper took it back to the 70's with the Michael Jackson Robot!");
        mainTextArea2.setVisible(false);
        Timer timer = new Timer(delay, e -> {
            currentEnemy.decreaseHealth();
            mainTextArea2.setText(currentEnemy.getName() + " got hit by the bus, and there current health is " + currentEnemy.getHealth() + "!");
            mainTextArea2.setVisible(true);
            if (currentEnemy.getHealth() > 0) {
                Timer timer2 = new Timer(delay, e2 -> {
                    enemyDanceGUI();
                });
                timer2.setRepeats(false);
                timer2.start();
            }else {
                Timer timer2 = new Timer(delay, e2 -> {
                    System.out.println("Enemey defeated..");
                    displayEnemyDefeatedInfo();
                });
                timer2.setRepeats(false);
                timer2.start();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void displayFunkyChickenResults() throws IOException, InterruptedException {
        choice1.setEnabled(false);
        choice2.setEnabled(false);
        choice3.setEnabled(false);
        choice4.setEnabled(false);

        int delay = 2700;

        System.out.println(choice1.getText());
        mainTextArea.setText("Soul-stepper was feeling a little weird and did the Funky Chicken!");
        mainTextArea2.setVisible(false);
        Timer timer = new Timer(delay, e -> {
            currentEnemy.decreaseHealth();
            mainTextArea2.setText(currentEnemy.getName() + " got hit by the bus, and there current health is " + currentEnemy.getHealth() + "!");
            mainTextArea2.setVisible(true);
            if (currentEnemy.getHealth() > 0) {
                Timer timer2 = new Timer(delay, e2 -> {
                    enemyDanceGUI();
                });
                timer2.setRepeats(false);
                timer2.start();
            }else {
                Timer timer2 = new Timer(delay, e2 -> {
                    System.out.println("Enemey defeated..");
                    displayEnemyDefeatedInfo();
                });
                timer2.setRepeats(false);
                timer2.start();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void displayEnemyDefeatedInfo() {
        int delay = 2300;
        int delay2 = 3960;

        mainTextArea.setText("You defeated " + currentEnemy.getName());
        mainTextArea2.setVisible(false);
        enemyExist = false;
        currentEnemy = null;

        Timer timer = new Timer(delay, e -> {
            mainTextArea.setText("You received " + soulStepper.xpAmount() + " XP!");
            mainTextArea2.setVisible(true);

        });
        timer.setRepeats(false);
        timer.start();
        Timer timer2 = new Timer(delay2, e2 -> {
            try {
                System.out.println("display firing from defeat info..");
                displayCurrentLocationInfo();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        timer2.setRepeats(false);
        timer2.start();
    }

    //-----------BUTTON SETUP METHODS---------------//
    private void setupGetButtons() {
        if (guiGameSetup.currentLocation.items.size() > 0) {
            ArrayList<JButton> buttons = new ArrayList<>(5);
            buttons.add(choice1);
            buttons.add(choice2);
            buttons.add(choice3);
            buttons.add(choice4);
            buttons.add(choice5);

            for (int i = 0; i < guiGameSetup.currentLocation.items.size(); i++) {
                buttons.get(i).setText(guiGameSetup.currentLocation.items.get(i));
                buttons.get(i).addActionListener(new secondChoiceHandler());
            }

            choice2.setVisible(false);
            choice3.setVisible(false);
            choice4.setVisible(false);
            choice5.setVisible(false);
        }
        else {
            mainTextArea.setText("No items in this room");
            mainTextArea.setVisible(true);
            mainTextArea2.setVisible(false);
            setUpMainCommandButtons();
        }
    }

    private void setUpMainCommandButtons() {
        buttonSelected = "";
        choice1.setText("Go");
        choice1.addActionListener(new ChoiceHandler());
        choice1.setVisible(true);
        choice1.setEnabled(true);

        choice2.setText("Get");
        choice2.addActionListener(new ChoiceHandler());
        choice2.setVisible(true);
        choice2.setEnabled(true);

        choice3.setText("Use");
        choice3.addActionListener(new ChoiceHandler());
        choice3.setVisible(true);
        choice3.setEnabled(true);

        choice4.setText("Look");
        choice4.addActionListener(new ChoiceHandler());
        choice4.setVisible(true);

        choice5.addActionListener(new ChoiceHandler());
        choice5.setVisible(true);
        choice5.setEnabled(true);
    }

    public void setUpDirectionButtons() {
        choice1.setText("North");
        choice1.addActionListener(secondChoiceHandler);

        choice2.setText("South");
        choice2.addActionListener(secondChoiceHandler);

        choice3.setText("East");
        choice3.addActionListener(new secondChoiceHandler());

        choice4.setText("West");
        choice4.addActionListener(secondChoiceHandler);

        choice5.addActionListener(secondChoiceHandler);
        mainTextArea2.setVisible(false);
    }

    private void setUpUseButtons() {
        if (soulStepper.inventory.size() > 0) {
            ArrayList<JButton> buttons = new ArrayList<>(5);
            buttons.add(choice1);
            buttons.add(choice2);
            buttons.add(choice3);
            buttons.add(choice4);
            buttons.add(choice5);
            for (int i = 0; i < soulStepper.inventory.size(); i++) {
                buttons.get(i).setText(soulStepper.inventory.get(i));
                buttons.get(i).addActionListener(new secondChoiceHandler());
            }
            choice2.setVisible(false);
            choice3.setVisible(false);
            choice4.setVisible(false);
            choice5.setVisible(false);
        }
        else {
            mainTextArea2.setText("No items in inventory to be used");
            mainTextArea2.setVisible(true);
            setUpMainCommandButtons();
        }


    }

    private void setupDanceBattleButtons() {
        choice1.setText("Hustle");
        choice1.addActionListener(danceBattleHandler);

        choice2.setText("Bus Stop");
        choice2.addActionListener(danceBattleHandler);

        choice3.setText("Michael Jackson Robot");
        choice3.addActionListener(danceBattleHandler);

        choice4.setText("Funky Chicken");
        choice4.addActionListener(danceBattleHandler);

        choice5.addActionListener(danceBattleHandler);
        mainTextArea2.setVisible(false);
    }


    //-----------REMOVE ACTION LISTENERS METHOD---------------//
    public void removeActionListeners() {

        ArrayList<JButton> buttons = new ArrayList<>(5);
        buttons.add(choice1);
        buttons.add(choice2);
        buttons.add(choice3);
        buttons.add(choice4);
        buttons.add(choice5);

        for(int i = 0; i < buttons.size();i++) {
            System.out.println("Current Button: " + buttons.get(i).getText());
            for(ActionListener al : buttons.get(i).getActionListeners()) {
                System.out.println("Before: " + al);
                buttons.get(i).removeActionListener(al);
            }
        }

        for(int i = 0; i < buttons.size();i++) {
            System.out.println("Current Button: " + buttons.get(i).getText());
            for(ActionListener al : buttons.get(i).getActionListeners()) {
                System.out.println("After: " + al);
            }
        }
    }

    //-----------EXECUTE RESULTS METHODS---------------//
    private void executeGoResults() throws IOException, InterruptedException {
        System.out.println("execute Results firing...");
        System.out.println(guiGameSetup.previousLocation.getName());
        System.out.println(guiGameSetup.currentLocation.getName());
        if(guiGameSetup.previousLocation.getName().equals(guiGameSetup.currentLocation.getName())) {
            mainTextArea.setText("");
            mainTextArea.setText("you can't go that way. Select Different Direction");
            setUpMainCommandButtons();
        } else {
            choice1.setEnabled(false);
            choice2.setEnabled(false);
            choice3.setEnabled(false);
            choice4.setEnabled(false);
            choice5.setEnabled(false);

            playerCurrentLocation.setText(guiGameSetup.currentLocation.getName());
            guiGameSetup.previousLocation = guiGameSetup.currentLocation;
            checkIfEnemyExists();
            if(enemyExist == false) {
                removeActionListeners();
                setUpMainCommandButtons();
                displayCurrentLocationInfo();
            }
        }
    }

    private void executeGetResults(String item) {
        if (guiGameSetup.currentLocation.items.contains(item)) {
            guiGameSetup.removeItem(item);
            soulStepper.addItem(item);
            mainTextArea2.setText("You picked up: " + item);
            mainTextArea2.setVisible(true);
            removeActionListeners();
            setUpMainCommandButtons();
        } else {
            mainTextArea2.setText("You can't do that");
            mainTextArea2.setVisible(true);
            removeActionListeners();
            setUpMainCommandButtons();
        }
    }

    private void executeLookResults() {
        int delay = 2200;
        int delay2 = 1400;

        choice1.setEnabled(false);
        choice2.setEnabled(false);
        choice3.setEnabled(false);
        choice4.setEnabled(false);

        System.out.println("execute Results firing...");
        if(guiGameSetup.validLookedAtDirection ==  false) {
            mainTextArea.setText("");
            mainTextArea.setText("There's nothing of interest there.");

            Timer timer = new Timer(delay2, e -> {
                try {
                    removeActionListeners();
                    setUpMainCommandButtons();
                    displayCurrentLocationInfo();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            mainTextArea.setText("");
            mainTextArea.setText(guiGameSetup.lookedAtLocation);
            guiGameSetup.validLookedAtDirection = false;

            Timer timer = new Timer(delay, e -> {
                try {
                    removeActionListeners();
                    setUpMainCommandButtons();
                    displayCurrentLocationInfo();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void executeUseResult(String playerItem) throws InterruptedException {
        int delay = 1700;

        System.out.println("execute Results firing ...");
        if (playerItem.equals("health kit")){
            soulStepper.useHealthKit();
            soulStepper.inventory.remove(playerItem);
            hpLabelNumber.setText("" + soulStepper.getHealth());
            mainTextArea2.setText("You used: " + playerItem);
            mainTextArea2.setVisible(true);
            removeActionListeners();
            setUpMainCommandButtons();
        }
        else if (playerItem.equals("mj jacket")) {
            soulStepper.setHealth(300);
            soulStepper.inventory.remove(playerItem);
            hpLabelNumber.setText("" + soulStepper.getHealth());
            mainTextArea2.setText("You have increased your power level over 10000");
            mainTextArea2.setVisible(true);
        }
        else {
            mainTextArea.setText("There is no item to be used");
            mainTextArea.setVisible(true);
            mainTextArea2.setVisible(false);
        }
        Timer timer = new Timer(delay, e -> {
            removeActionListeners();
            setUpMainCommandButtons();
        });
        timer.setRepeats(false);
        timer.start();
    }

    //-----------BUTTON SELECTED METHODS---------------//
    private void goButtonSelected() {
        buttonSelected = "Go";
    }

    private void getButtonSelected() {
        buttonSelected = "Get";
    }

    private void useButtonSelected() {
        buttonSelected = "Use";
    }

    private void quitButtonSelected() {
        int delay = 2000;
            mainTextArea.setText("Thanks for Playing Soul Stepper!");
            mainTextArea2.setVisible(false);

        Timer timer = new Timer(delay, e -> {
            System.exit(0);
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void playGUI() throws InterruptedException {
    }
}