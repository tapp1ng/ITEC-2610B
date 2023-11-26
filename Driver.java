import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver extends JFrame implements ActionListener {

    //variables we use in the code
        static String characterNameShop;             
        static int money = 10;
        static String currentCharacterName;
        static int characterShopChoice;
        static Character playerCharacter = new Character();
        static Character characterInShop = new Character();
        static Mob currentMob = new Mob();
        static int logCounter = 0;

        static int counter = 1;
        public static void main (String arg []) throws IOException { 
        
            Random rand = new Random();

         
                //reading file and creating character array
                String lineNum;
                FileReader fr = new FileReader("characters.txt"); 
                BufferedReader br = new BufferedReader(fr); 
                int characterCounter = 0;
                Character[] charactersArray = new Character[10];
                for(int i = 0; i < charactersArray.length;i++) {
                    charactersArray[i] = new Character();
                }
                
                //creating the characters from file
                while ((lineNum = br.readLine()) != null) {
                    String[] token = lineNum.split(",");
                    charactersArray[characterCounter].setHP(Integer.parseInt(token[0]));
                    charactersArray[characterCounter].setName(token[1]);
                    charactersArray[characterCounter].setDmg(Integer.parseInt(token[2]));
                    charactersArray[characterCounter].setExp(Integer.parseInt(token[3]));
                    charactersArray[characterCounter].setLevel(Integer.parseInt(token[4]));
                    charactersArray[characterCounter].setLevelUpExp(Integer.parseInt(token[5]));
                    charactersArray[characterCounter].setPrice(Integer.parseInt(token[6]));
                    characterCounter++;
                    }

                br.close();

            //mob initalization
            Mob mobObject = new Mob(50,"BAD GUY",3,25, 3);

 


            JFrame frame = new JFrame("Game");
            
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            //panel creation for Shop
            JPanel shopPanel = new JPanel();  

            shopPanel.setLayout(new FlowLayout());  


            //button panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(1,2));
            JButton buy = new JButton("Buy character");
            JButton roll = new JButton("Roll shop");

            buttonPanel.add(buy);
            buttonPanel.add(roll);
            
            //starter character
            JLabel label = new JLabel("The Shop");  
            characterShopChoice = rand.nextInt(0,10);

            characterInShop = charactersArray[characterShopChoice];
            JLabel shopCharacterName = new JLabel("Character in Shop: "  +  characterInShop.getName());
            JLabel shopCharacterHP = new JLabel("HP: " + characterInShop.getHealth());
            JLabel shopCharacterDmg = new JLabel("DMG: " + characterInShop.getDmg());
            JLabel shopCharacterExp = new JLabel("EXP: " + characterInShop.getExp() + "/" + characterInShop.getLevelUpExp());
            JLabel shopCharacterPrice = new JLabel("Price: " + characterInShop.getPrice());

            JPanel shopCharacterStats = new JPanel();
            shopCharacterStats.setLayout(new GridLayout(5,1));
            shopCharacterStats.add(shopCharacterName);
            shopCharacterStats.add(shopCharacterHP);
            shopCharacterStats.add(shopCharacterDmg);
            shopCharacterStats.add(shopCharacterExp);
            shopCharacterStats.add(shopCharacterPrice);

            


            JLabel char1 = new JLabel("Current character: ?");
            JLabel char1HP = new JLabel();
            JLabel char1Name = new JLabel();
            JLabel char1Dmg = new JLabel();
            JLabel char1Exp = new JLabel();

            JPanel charStats = new JPanel();
            charStats.setLayout(new GridLayout(4,1));
            charStats.add(char1Name);
            charStats.add(char1HP);
            charStats.add(char1Dmg);
            charStats.add(char1Exp);


            JLabel currentCharacter = new JLabel("current character: ?");
            JLabel currentMoney = new JLabel("Current Amount of Money is: " + money);

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new GridLayout(4,1));
            textPanel.add(label);
            textPanel.add(shopCharacterStats);
            textPanel.add(currentCharacter);
            textPanel.add(currentMoney);


            //roll buttion action
            roll.addActionListener(                
                new ActionListener() {
                    public void actionPerformed (ActionEvent e) {
                        if(money >= 1) {
                            characterShopChoice = rand.nextInt(0,10);
                            
                            characterInShop = charactersArray[characterShopChoice];
                            shopCharacterName.setText("Character in Shop: "  +  characterInShop.getName());
                            shopCharacterHP.setText("HP: " + characterInShop.getHealth());
                            shopCharacterDmg.setText("DMG: " + characterInShop.getDmg());
                            shopCharacterExp.setText("EXP: " + characterInShop.getExp() + "/" + characterInShop.getLevelUpExp());
                            shopCharacterPrice.setText("Price: " + characterInShop.getPrice());
                            playerCharacter.setPrice(characterInShop.getPrice());                         
                            

                            money = money-1;
                            currentMoney.setText("Current Amount of Money is: " + String.valueOf(money));
                        }
                    }      
                }
            );

            //buy button
            buy.addActionListener(
                new ActionListener() {
                    public void actionPerformed (ActionEvent e) {
                        if(money > playerCharacter.getPrice()) {
                            playerCharacter = characterInShop;
                            currentCharacter.setText("Current Character: " + playerCharacter.getName());
                            money = money - playerCharacter.getPrice();
                            currentMoney.setText("Current Amount of Money is: " + String.valueOf(money));
                           char1.setText("");
                            char1HP.setText("HP: " + playerCharacter.getHealth());
                            char1Name.setText("Name: " + playerCharacter.getName());
                            char1Dmg.setText("DMG: " + playerCharacter.getDmg());
                            char1Exp.setText("EXP: " + playerCharacter.getExp() + "/" + playerCharacter.getLevelUpExp());
                        }
                        
                    }
                }
            ); 
            //adding the jframe components to the panel
            JPanel shopCharButtons = new JPanel();
            shopCharButtons.setLayout(new GridLayout(2,1));

            shopCharButtons.add(shopCharacterStats);
            shopCharButtons.add(buttonPanel);

            
            shopPanel.add(textPanel);
            shopPanel.add(shopCharButtons);  
            

         //combat system
         //attack mobs
        currentMob = mobObject;
        JLabel mobHP1 = new JLabel(" HP: " + currentMob.getHealth());   
        JLabel mobName = new JLabel ("Name: " + currentMob.getName());
        JLabel mobDMG = new JLabel("DMG: " + currentMob.getDmg());
        JButton attack = new JButton("Attack " + currentMob.getName());
        JLabel mobLog = new JLabel("#");
        JLabel playerLog = new JLabel("#");

        JPanel mobInfo = new JPanel();
        mobInfo.setLayout(new GridLayout(3,1));

        mobInfo.add(mobName);
        mobInfo.add(mobHP1);
        mobInfo.add(mobDMG);

         //combat log for player
         attack.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {   

                    if(playerCharacter.getDmg() >= currentMob.getHealth()) {
                        playerCharacter.setExp(currentMob.getExp());
                        money = money + currentMob.getGold();
                        currentMoney.setText("Current Amount of Money is: " + String.valueOf(money));
                        System.out.println("!");

                        currentMob = mobObject;

                        currentMob.setHP(100+counter);
                        currentMob.setDmg(mobObject.getDmg()+1);
                        currentMob.setGold(mobObject.getGold()+1);
                        currentMob.setExpDrop(mobObject.getExp()+1);
                        
                        counter++;

                        mobHP1.setText("HP: " + String.valueOf(currentMob.getHealth()));
                        mobDMG.setText("DMG: " + String.valueOf(currentMob.getDmg()));
                        
                        playerLog.setText("Log #" + logCounter + " " + playerCharacter.getName() +  " has attacked for " + playerCharacter.getDmg() + " dmg");
                        logCounter++;
                        
                    }
                    
                    //if the mob is going to die
                    //setting the values after the attack of the player
                   if (playerCharacter.getDmg() < currentMob.getHealth()) {
                    
                    mobHP1.setText("HP: " + String.valueOf(currentMob.removeHP(playerCharacter.getDmg())));
                    mobDMG.setText("DMG: " + String.valueOf(currentMob.getDmg()));


                            char1HP.setText("HP: " + playerCharacter.getHealth());
                            char1Name.setText("Name: " + playerCharacter.getName());
                            char1Dmg.setText("DMG: " + playerCharacter.getDmg());
                            char1Exp.setText("EXP: " + playerCharacter.getExp() + "/" + playerCharacter.getLevelUpExp());
                    playerLog.setText("Log #" + logCounter + " " + playerCharacter.getName() +  " has attacked for " + playerCharacter.getDmg() + " dmg");
                    logCounter++;
                   }
                    

                    
                    //if the mob lived it gets to attack
                    if (currentMob.isDead() == false) {
                        //setting the values of the player after the mob attacks
                        char1HP.setText("HP: " + playerCharacter.removeHP(currentMob.getDmg()));
                        char1Name.setText("Name: " + playerCharacter.getName());
                        char1Dmg.setText("DMG: " + playerCharacter.getDmg());
                        char1Exp.setText("EXP: " + playerCharacter.getExp() + "/" + playerCharacter.getLevelUpExp());
                        mobLog.setText("Log #" + logCounter + " " + currentMob.getName() + " has attacked " + "for " + currentMob.getDmg() + " dmg");
                        
                        //if the mob kills the player
                        if(playerCharacter.isDead() == true) {
                            frame.setVisible(false);
                        }
                    }
                    //condiontial for the player to level up
                    if(playerCharacter.getExp() >= playerCharacter.getLevelUpExp()) {
                        playerCharacter.levelUp();
                    }
                }
                
            }         
         );

         JPanel mobPanel = new JPanel();
        mobPanel.setLayout(new GridLayout(2,1));
        mobPanel.add(mobInfo);
        mobPanel.add(attack);
         
        JPanel logPanel = new JPanel();
        logPanel.setLayout(new GridLayout(2,1));
        logPanel.add(playerLog);
        logPanel.add(mobLog);

        JPanel gamePanel = new JPanel();
        gamePanel.add(charStats);
        
        gamePanel.add(mobPanel);
        gamePanel.add(logPanel);
        
        mainPanel.add(shopPanel);
        mainPanel.add(gamePanel);
        frame.add(mainPanel);  

        frame.setSize(700, 500);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
    


