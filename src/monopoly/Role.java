package monopoly;

import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author xianp
 */
abstract class Role {

    Random r = new Random();
    Scanner sc = new Scanner(System.in);
// button class
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button_label3;
    JComboBox option_button1;
    JComboBox option_button2;
    JComboBox option_button3;
    ImageIcon icon1 = new ImageIcon("attack.jpg");
    ImageIcon icon2 = new ImageIcon("beg.jpg");
    ImageIcon icon3 = new ImageIcon("run.jpg");
    ImageIcon icon4 = new ImageIcon("dice.jpg");
// charcacter class 
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
// frame class
    JButton button;
    JFrame frame = new JFrame();
    JLabel button_label1 = new JLabel();
    JLabel button_label2 = new JLabel();
//    JLabel button_label3 = new JLabel();
    ImageIcon image1 = new ImageIcon("broad2.png");
    ImageIcon image2 = new ImageIcon("quit1.jpg");
    Border border = BorderFactory.createLineBorder(Color.yellow);
    Border borderred = BorderFactory.createLineBorder(Color.red);
    JLayeredPane layer = new JLayeredPane();
    JPanel yellowpanel = new JPanel();
    JPanel greenpanel = new JPanel();
    JPanel redpanel = new JPanel();
    JPanel bluepanel = new JPanel();
    JLabel yellowtext1 = new JLabel();
    JLabel greentext1 = new JLabel();
    JLabel bluetext1 = new JLabel();
    JLabel redtext1 = new JLabel();
    JLabel side_label1 = new JLabel();
    JLabel side_label2 = new JLabel();
    JLabel side_label3 = new JLabel();
    JLabel side_label4 = new JLabel();
    JLabel text1 = new JLabel();
    JLabel text2 = new JLabel();
    JLabel text3 = new JLabel();
    ImageIcon side_image1 = new ImageIcon("naruto.jpeg");
    ImageIcon side_image2 = new ImageIcon("sasuke.jpg");
    ImageIcon side_image3 = new ImageIcon("pain.jpg");
    ImageIcon side_image4 = new ImageIcon("madara.jpg");
//

    public abstract void statistic_player(int which_player);              //show player information

    public abstract void statistic_monster(int number_monster);          ///show monster information

    public abstract void battlePvP(int first, int second);                        // undergo battle between player and player

    public abstract void battlePvM(int number_monster, int which_player);          // undergo battle between player and monster

    public abstract void add_weaponValue(int which_player);                      //// set value to add_weapon[][]

    public abstract void player_round(int number_monster, int which_player);         //player turn in battle PvM

    public abstract void player_roundPvP(int attack, int defence);                      /// player turn in battle PvP

    public abstract void create_monster(int number_monster);                         //create monster or set value to B[][]

    public abstract void monster_round(int which_monster, int which_player);           // monster round in baattle PvM

    public abstract void after_fight(int number_monster, int which_player);          // after the battle end (player or monster die)

    public abstract void after_fightPvP(int survival, int dead);                 // after the battle end (one player die)

    public abstract void player_attack(int number_monster, int which_player);          // player attack monster

    public abstract void player_attackPvP(int attack, int defence);                /// player attack player

    public abstract void player_chooseItem(int number_monster, int which_player);        // player choose item in PvM

    public abstract void player_chooseItemPvP(int first, int second);            /// player chiise item in PvP

    public abstract void damage_BY_player(int which_monster, int which_player);         // calculate damage done by player  in PvM

    public abstract void damage_BY_monster(int which_monster, int which_player);        // calculate damage done by monster in PvM

    public abstract void damageBetPlayer(int attack, int defence);             // calculate damage done by attacker in PvP

    public abstract void shop(int which_player);                      // enter shop

    public abstract void shop_option(int which_player);          // action in shop

    public abstract void buy(int which_player);               // buy item

    public abstract void buy_weapon(int which_player);           // buy weapon

    public abstract void upgrade(int which_player);                 // uprage weapon

    public abstract void chest(int which_player);              //chest

    public abstract void weapon(int which_player);                // memory location to store weapon value

    public abstract void monster(int which_monster);            // memory location to store monster value

    public abstract void add_itemValue(int which_player, int which_item);            // set add_item after use item

    public abstract int price_weapon(int ID);                                     /// store price 

    public abstract int price_item(int ID);

    public abstract String weapon_name(int ID);                           // store name

    public abstract String item_name(int ID);

    public abstract String monster_name(int ID);

    public abstract void probility();                          // calculate probility

    public abstract void levelup(int which_player);             // calculate the levelup system
//    public abstract void start();

    public abstract void build_avatar(int number_player);

    public abstract void random_setup();

    public abstract void dice();

    public abstract void tile(int player);  // public void tile(int playerLocation, int player);

    public abstract void tileRandom();

    public abstract void empty(int player);  //public abstract static void empty(Role roleobj);

    public abstract int checkPvP(int player, int currentPlayerLocation);

    public abstract void inventory(int player);

    public abstract int winner();

    public abstract void enable();

    public abstract void button();

    public abstract void window();

    public abstract void delay();

    public abstract void check();

    public abstract void close();

    public abstract void playMusic(String musicLocation);

    public abstract void getMadara() throws IOException;

    public abstract void getNaruto() throws IOException;

    public abstract void getPain() throws IOException;

    public abstract void getSasuke() throws IOException;

    public abstract void determineTurn();

    protected String[] display = new String[20];
    protected String[] player_name = new String[4];
//    protected String[] player_name={"Naruto","Sasuke","Pain","Madara"};
    protected int[][] A = new int[4][8];  // 0=strength, 1 defence,2agility, 3 hp , 4level, 5 exp, 6gold, 7MAXhp;
    protected int[][] B = new int[3][6];                // 0 strength, 1defence 2agility, 3hp, 4Maxhp , 5 ID
    protected int[][] D = new int[4][20];                 // beg store weapon
    protected int[][] C = new int[4][20];               // beg store item
    protected int[][] add_weapon = new int[4][6];       // 0 strength, 1defence 2agility, 3hp, 4Maxhp,5 ID
    protected int[][] add_item = new int[4][5];          // 0 strength, 1defence 2agility, 3hp, 4 ID
    protected int[][] temp = new int[4][3];      //  0 strength, 1defence 2agility        /// used to clean the effect form previous fight
    protected int[] collect = new int[4];           // certain weapon need 
    protected int[] cold = new int[4];             // colddown
    protected int[] currentWeapon = new int[4];       // weapon that player equip
    protected int[] shop = new int[5];               // store shop item, only have 5 item sold per time
    protected boolean[] used = new boolean[3];            // for certain monster use
    protected boolean[] mfreeze = new boolean[3];          // whether monster freeze or not
    protected boolean[] mpoison = new boolean[3];         // whether monsterr poision or nor
    protected boolean[] pfreeze = new boolean[4];         /// whether player freeze or nor
    protected boolean[] ppoison = new boolean[4];       /// whether player poision or not
    protected boolean flee = false;                    // run from battle
    protected boolean Ssword = false;                    // for certain weapon use
    protected boolean Sdefence = false;               // fro certain weapon use
    protected int damage = 0;                         // store damage         
    protected int probility;
    protected int counter;                    // check whether beg full or not
    protected int shop_weapon;                // store shop weapon , only sold 1 weapon per time
    protected int cheast_random;              // chest 
    protected int which_item;
    protected int ID;                                 // ID for monstoe , item, and monster        ****** no change this ********
    protected int max;                        //range of level monster 
    protected int min;                        //range of level monster
    protected int ldamage;                    //for calculate damage
    protected int hdamage;                    //for calculate damage
    protected int tempo;                      //for calculate damage
    protected int sum;                        //for levelup calculation
    protected int time = 1;   ///increase this value when after certain turn pass
    protected String condition = "";
    protected int number_player;
    protected int playerLocation[] = {0, 0, 0, 0};
    protected int winner;
    protected String str = "";
    protected String[] player_text = {"", "", "", ""};
    protected String[] monster_text = {"", "", "", ""};
    protected boolean button_enable = false;
    protected int[] x = new int[4];
    protected int[] y = new int[4];
    protected boolean enable = false;
    protected boolean[] Pflee = new boolean[4];
    protected String[] weapon_button = new String[21];
    protected String[] number_button = new String[4];
    protected String[] item_button = new String[21];
    protected int action;
    protected int number_action;
    protected int weapon_action;
    protected int item_action;
    protected int dice;
    protected boolean buttonpressed = false;
    protected int tiles[] = new int[32];
}
