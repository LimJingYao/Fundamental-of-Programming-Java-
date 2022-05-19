/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

abstract class store extends calculation {

    public void weapon(int which_player) {
        switch (currentWeapon[which_player]) {
            case 0:
                add_weapon[which_player][5] = 0;  ///empty
            //level D
            case 1:
                add_weapon[which_player][0] = 5;    //normal
                add_weapon[which_player][5] = 1;
                break;
            case 2:
                add_weapon[which_player][1] = 5;       //normal
                add_weapon[which_player][5] = 2;
                break;
            case 3:
                add_weapon[which_player][0] = 10;        ///shop
                add_weapon[which_player][5] = 3;
                break;
            case 4:
                add_weapon[which_player][1] = 10;   ///shop
                add_weapon[which_player][5] = 4;
                break;
            case 5:
                add_weapon[which_player][2] = 5;        ///shop
                add_weapon[which_player][5] = 5;
                break;
            case 6:
                add_weapon[which_player][3] = 20;       ///shop
                add_weapon[which_player][4] = 20;
                add_weapon[which_player][5] = 6;
                break;
            /// level C
            case 7:
                add_weapon[which_player][0] = 20;              //weapon
                add_weapon[which_player][1] = 10;
                add_weapon[which_player][5] = 7;
                break;
            case 8:
                add_weapon[which_player][0] = 10;        ///weapon
                add_weapon[which_player][2] = 10;
                add_weapon[which_player][5] = 8;
                break;
            case 9:
                add_weapon[which_player][0] = 10;     //exp
                add_weapon[which_player][3] = 50;
                add_weapon[which_player][4] = 50;
                add_weapon[which_player][5] = 9;
                break;
            case 10:
                add_weapon[which_player][1] = 5;     //exp
                add_weapon[which_player][2] = 10;
                add_weapon[which_player][5] = 10;
                break;
            case 11:
                add_weapon[which_player][1] = 15;        //gold
                add_weapon[which_player][3] = 10;
                add_weapon[which_player][4] = 10;
                add_weapon[which_player][5] = 11;
                break;
            case 12:
                add_weapon[which_player][2] = 10;       //gold
                add_weapon[which_player][3] = 25;
                add_weapon[which_player][4] = 25;
                add_weapon[which_player][5] = 12;
                break;
            //level B
            case 13:
                add_weapon[which_player][0] = 10;       //damge =0 if damage>100
                add_weapon[which_player][1] = 20;
                add_weapon[which_player][3] = 65;
                add_weapon[which_player][4] = 65;
                add_weapon[which_player][5] = 13;
                break;
            case 14:
                add_weapon[which_player][0] = 15;
                add_weapon[which_player][2] = 15;    //  damage = 0 , 3 cold
                add_weapon[which_player][3] = 65;
                add_weapon[which_player][4] = 65;
                add_weapon[which_player][5] = 14;
                break;
            case 15:
                add_weapon[which_player][0] = 20;   //attck double
                add_weapon[which_player][1] = 15;
                add_weapon[which_player][3] = 20;
                add_weapon[which_player][4] = 20;
                add_weapon[which_player][5] = 15;
                break;
            case 16:
                add_weapon[which_player][0] = 20;     // recover hp
                add_weapon[which_player][1] = 20;
                add_weapon[which_player][2] = 20;
                add_weapon[which_player][5] = 16;
                break;
            case 17:
                add_weapon[which_player][0] = 15;   // poision
                add_weapon[which_player][1] = 20;
                add_weapon[which_player][3] = 15;
                add_weapon[which_player][4] = 15;
                add_weapon[which_player][5] = 17;
                break;
            //level c
            case 18:
                add_weapon[which_player][0] = 30;
                add_weapon[which_player][1] = 20;      // damage = max hp
                add_weapon[which_player][2] = 20;
                add_weapon[which_player][3] = 70;
                add_weapon[which_player][4] = 70;
                add_weapon[which_player][5] = 18;
                break;
            case 19:
                add_weapon[which_player][0] = 20;
                add_weapon[which_player][1] = 30;
                add_weapon[which_player][2] = 25;     // damge = temp *40;
                add_weapon[which_player][3] = 100;
                add_weapon[which_player][4] = 100;
                add_weapon[which_player][5] = 19;
                break;
        }
    }

    public void monster(int which_monster) {
        switch (B[which_monster][5]) {
//level D
            case 0:              // empty
                B[which_monster][0] = 0 * time;
                B[which_monster][1] = 0 * time;
                B[which_monster][2] = 0 * time;
                B[which_monster][3] = 0 * time;
                B[which_monster][4] = 0 * time;
                B[which_monster][5] = 0;
                break;
            case 1:              //no effect
                B[which_monster][0] = 5 * time;
                B[which_monster][1] = 10 * time;
                B[which_monster][2] = 5 * time;
                B[which_monster][3] = 30 * time;
                B[which_monster][4] = 30 * time;
                B[which_monster][5] = 1;
                break;
            case 2:               // no effet
                B[which_monster][0] = 5 * time;
                B[which_monster][1] = 5 * time;
                B[which_monster][2] = 10 * time;
                B[which_monster][3] = 30 * time;
                B[which_monster][4] = 30 * time;
                B[which_monster][5] = 2;
                break;
// level C
            case 3:                     //weapon
                B[which_monster][0] = 15 * time;
                B[which_monster][1] = 10 * time;
                B[which_monster][2] = 10 * time;
                B[which_monster][3] = 45 * time;
                B[which_monster][4] = 45 * time;
                B[which_monster][5] = 3;
                break;
            case 4:
                B[which_monster][0] = 10 * time;       ///weapon
                B[which_monster][1] = 15 * time;
                B[which_monster][2] = 10 * time;
                B[which_monster][3] = 40 * time;
                B[which_monster][4] = 40 * time;
                B[which_monster][5] = 4;
                break;
            case 5:
                B[which_monster][0] = 10 * time;  /////exp
                B[which_monster][1] = 10 * time;
                B[which_monster][2] = 15 * time;
                B[which_monster][3] = 35 * time;
                B[which_monster][4] = 35 * time;
                B[which_monster][5] = 5;
                break;
            case 6:
                B[which_monster][0] = 20 * time;     ///////exp
                B[which_monster][1] = 20 * time;
                B[which_monster][2] = 10 * time;
                B[which_monster][3] = 25 * time;
                B[which_monster][4] = 25 * time;
                B[which_monster][5] = 6;
                break;
            case 7:                                  //gold
                B[which_monster][0] = 10 * time;
                B[which_monster][1] = 20 * time;
                B[which_monster][2] = 10 * time;
                B[which_monster][3] = 45 * time;
                B[which_monster][4] = 45 * time;
                B[which_monster][5] = 7;
                break;
            case 8:
                B[which_monster][0] = 15 * time;
                B[which_monster][1] = 15 * time;         //gold
                B[which_monster][2] = 10 * time;
                B[which_monster][3] = 50 * time;
                B[which_monster][4] = 50 * time;
                B[which_monster][5] = 8;
                break;
///LEVEL B
            case 9:
                B[which_monster][0] = 20 * time;          //atk up when hp< certain
                B[which_monster][1] = 15 * time;
                B[which_monster][2] = 15 * time;
                B[which_monster][3] = 55 * time;
                B[which_monster][4] = 55 * time;
                B[which_monster][5] = 9;
                break;
            case 10:
                B[which_monster][0] = 15 * time;        /////recover hp
                B[which_monster][1] = 20 * time;
                B[which_monster][2] = 15 * time;
                B[which_monster][3] = 60 * time;
                B[which_monster][4] = 60 * time;
                B[which_monster][5] = 10;
                used [which_monster]=false; //special skill
                break;
            case 11:
                B[which_monster][0] = 15 * time;
                B[which_monster][1] = 15 * time;            // double attAck
                B[which_monster][2] = 20 * time;
                B[which_monster][3] = 65 * time;
                B[which_monster][4] = 65 * time;
                B[which_monster][5] = 11;
                break;
            case 12:
                B[which_monster][0] = 15 * time;        //poision
                B[which_monster][1] = 15 * time;
                B[which_monster][2] = 15 * time;
                B[which_monster][3] = 100 * time;
                B[which_monster][4] = 100 * time;
                B[which_monster][5] = 12;
                break;
//LEVEL A
            case 13:
                B[which_monster][0] = 50 * time;            //extra armor damage
                B[which_monster][1] = 50 * time;
                B[which_monster][2] = 20 * time;
                B[which_monster][3] = 200 * time;
                B[which_monster][4] = 200 * time;
                B[which_monster][5] = 13;
                break;
        }
    }

    public void add_itemValue(int which_player, int which_item) {
        for (int i = 0; i < 4; i++) {
            add_item[which_player][i] = 0;
        }
        switch (which_item) {
            case 0:
                add_item[which_player][4] = 0;
//strength
            case 1:
                add_item[which_player][0] = 5;
                temp[which_player][0] += 5;
                add_item[which_player][4] = 1;
                break;
            case 2:
                add_item[which_player][0] = 10;
                temp[which_player][0] += 10;
                add_item[which_player][4] = 2;
                break;
            case 3:
                add_item[which_player][0] = 15;
                temp[which_player][0] += 15;
                add_item[which_player][4] = 3;
                break;
//defence
            case 4:
                add_item[which_player][1] = 5;
                temp[which_player][1] += 5;
                add_item[which_player][4] = 4;
                break;
            case 5:
                add_item[which_player][1] = 10;
                temp[which_player][1] += 10;
                add_item[which_player][4] = 5;
                break;
            case 6:
                add_item[which_player][1] = 15;
                temp[which_player][1] += 15;
                add_item[which_player][4] = 6;
                break;
//agility
            case 7:
                add_item[which_player][2] = 5;
                temp[which_player][2] += 5;
                add_item[which_player][4] = 7;
                break;
            case 8:
                add_item[which_player][2] = 10;
                temp[which_player][2] += 10;
                add_item[which_player][4] = 8;
                break;
            case 9:
                add_item[which_player][2] = 15;
                temp[which_player][2] += 15;
                add_item[which_player][4] = 9;
                break;
//hp
            case 10:
                add_item[which_player][3] = 15;
                add_item[which_player][4] = 10;
                break;
            case 11:
                add_item[which_player][3] = 25;
                add_item[which_player][4] = 11;
                break;
            case 12:
                add_item[which_player][3] = 35;
                add_item[which_player][4] = 12;
                break;
//flee
            case 13:
                add_item[which_player][4] = 13;
                break;
        }
    }

    public int price_weapon(int ID) {
        switch (ID) {
            case 0:
                return 0;
            case 1:
                return 50;
            case 2:
                return 50;
            case 3:
                return 100;
            case 4:
                return 100;
            case 5:
                return 100;
            case 6:
                return 100;
            case 20:
                return 50;
            case 21:
                return 100;
            case 22:
                return 150;
            case 23:
                return 50;
            case 24:
                return 100;
            case 25:
                return 150;
            case 26:
                return 50;
            case 27:
                return 100;
            case 28:
                return 150;
            case 29:
                return 50;
            case 30:
                return 100;
            case 31:
                return 150;
            case 32:
                return 300;
            default:
                return 0;
        }
    }

    public int price_item(int ID) {
        switch (ID) {
            case 0:
                return 0;
            case 1:
                return 50;
            case 2:
                return 100;
            case 3:
                return 150;
            case 4:
                return 50;
            case 5:
                return 100;
            case 6:
                return 150;
            case 7:
                return 50;
            case 8:
                return 100;
            case 9:
                return 150;
            case 10:
                return 50;
            case 11:
                return 100;
            case 12:
                return 150;
            case 13:
                return 300;
            default:
                return 0;
        }
    }

    public String weapon_name(int ID) {
        switch (ID) {
            case 0:
                return ("None");

            case 1:
                return ("Kunai");

            case 2:
                return ("Goggles");

            case 3:
                return ("Training suit");

            case 4:
                return ("Shuriken");

            case 5:
                return ("Genin Clothes");

            case 6:
                return ("HeadBand");

            case 7:
                return ("Ninjutsu Ring");

            case 8:
                return ("Fuma Shuriken");

            case 9:
                return ("Chunin Clothes");

            case 10:
                return ("Ninjutsu Mask");

            case 11:
                return ("Bracelet");

            case 12:
                return ("Necklace");

            case 13:
                return ("Multiple Kunai");

            case 14:
                return ("Jonin Clothes");

            case 15:
                return ("Akatsuki Cloak");

            case 16:
                return ("Totsuka Sword");

            case 17:
                return ("Yata Mirror");

            case 18:
                return ("Kurama Cloak");

            case 19:
                return ("truth seeking ball");
            default:
                return null;
        }
    }

    public String item_name(int ID) {
        switch (ID) {
            case 0:
                return ("None");
            case 1:
                return ("Energy Drink");

            case 2:
                return ("Painkiller");

            case 3:
                return ("Super Big Burger");

            case 4:
                return ("Ice Shield");

            case 5:
                return ("Thunder Cloud");

            case 6:
                return ("Fire Wall");

            case 7:
                return ("Boots");

            case 8:
                return ("Rollerskater");

            case 9:
                return ("Skateboard");

            case 10:
                return ("Health Potion");

            case 11:
                return ("Grand Potion");

            case 12:
                return ("Ultimate Potion");

            case 13:
                return ("Smoke Bomb");
            default:
                return null;
        }
    }

    public String monster_name(int ID) {
        switch (ID) {
            case 0:
                return ("None");

            case 1:
                return ("Shino");

            case 2:
                return ("Hinata");

            case 3:
                return ("Temari");

            case 4:
                return ("Kimimaro");

            case 5:
                return ("Shikamaru");

            case 6:
                return ("Orochimaru");

            case 7:
                return ("Jiraiya");

            case 8:
                return ("Tsunade");

            case 9:
                return ("Sakon");

            case 10:
                return ("Gaara");

            case 11:
                return ("Sakura");

            case 12:
                return ("Kabuto");

            case 13:
                return ("Kagura");
            default:
                return null;
        }
    }
    public void build_avatar(int number_player) {
        random_setup();
        //determineTurn();
        for (int i = 0; i < number_player; i++) {
            A[i][0] = 35;
            A[i][1] = 25;
            A[i][2] = 5;
            A[i][3] = 200;
            A[i][4] = 1;
            A[i][5] = 0;
            A[i][6] = 200;
            A[i][7] = A[i][3];
            statistic_player(i);
        }
        for (int i = 0; i < number_player; i++) {
            if (player_name[i].equals("Naruto")) {
                side_label1.setBounds(0, 0, 50, 50);
                redpanel.setBounds(700, 460, 150, 230);
                side_label1.setIcon(side_image1);
                redpanel.setBackground(Color.red);
                redpanel.add(side_label1);
                redpanel.add(redtext1);
                frame.add(redpanel);

            } else if (player_name[i].equals("Sasuke")) {
                side_label2.setBounds(0, 0, 50, 50);
                bluepanel.setBounds(850, 460, 150, 230);
                side_label2.setIcon(side_image2);

                bluepanel.setBackground(Color.blue);

                bluepanel.add(side_label2);

                bluepanel.add(bluetext1);
                frame.add(bluepanel);

            } else if (player_name[i].equals("Pain")) {
                side_label3.setBounds(0, 0, 50, 50);
                greenpanel.setBounds(1000, 460, 150, 230);
                side_label3.setIcon(side_image3);

                greenpanel.setBackground(Color.green);

                greenpanel.add(side_label3);

                greenpanel.add(greentext1);
                frame.add(greenpanel);

            } else if (player_name[i].equals("Madara")) {
                side_label4.setBounds(0, 0, 50, 50);
                yellowpanel.setBounds(1150, 460, 150, 230);
                side_label4.setIcon(side_image4);

                yellowpanel.setBackground(Color.yellow);

                yellowpanel.add(side_label4);

                yellowpanel.add(yellowtext1);
                frame.add(yellowpanel);

            }
        }
        condition = "end_start";
        check();
    }

    public void random_setup() {
        for (int j = 0; j < 4; j++) {
            int i = r.nextInt(4);
            player_name[i] = "Naruto";
            int temp1 = i;

            i = r.nextInt(4);
            while (i == temp1) {
                i = r.nextInt(4);
            }
            player_name[i] = "Sasuke";
            int temp2 = i;

            i = r.nextInt(4);
            while (i == temp1 || i == temp2) {
                i = r.nextInt(4);
            }
            player_name[i] = "Pain";
            int temp3 = i;

            i = r.nextInt(4);
            while (i == temp1 || i == temp2 || i == temp3) {
                i = r.nextInt(4);
            }
            player_name[i] = "Madara";
        }
    }

    public void determineTurn() {
        condition = "determineTurn";
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        int[] d = new int[4];
        int temp0 = 0, temp1 = 0, temp2 = 0;

        for (int i = 0; i < number_player; i++) {                           //randomize number
            button_label2.setText(player_name[i] + " Run the dice");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            buttonpressed = false;
            check();
            delay();

//            if(=='R'){
            d[i] = r.nextInt(6) + 1;

            if (i == 0) {
                temp0 = d[i];
            } else if (i == 1) {
                while (d[i] == temp0) {
                    d[i] = r.nextInt(6) + 1;
                }
                temp1 = d[i];
            } else if (i == 2) {
                while (d[i] == temp0 || d[i] == temp1) {
                    d[i] = r.nextInt(6) + 1;
                }
                temp2 = d[i];
            } else {
                while (d[i] == temp0 || d[i] == temp1 || d[i] == temp2) {
                    d[i] = r.nextInt(6) + 1;
                }
            }
            String a = player_name[i] + " gets " + d[i] + " ";
            button_label2.setText("<html>" + a + "</html>");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {

            }
        }

        for (int pass = 1; pass < d.length; pass++) {     //bubble sort dice value and player name						
            for (int i = 0; i < d.length - 1; i++) {
                if (d[i] < d[i + 1]) {
                    int hold = d[i];
                    String holdname = player_name[i];
                    d[i] = d[i + 1];
                    player_name[i] = player_name[i + 1];
                    d[i + 1] = hold;
                    player_name[i + 1] = holdname;
                    for (int j = 0; j < 8; j++) {
                        int temp = A[i][j];
                        A[i][j] = A[i + 1][j];
                        A[i + 1][j] = temp;
                    }
                }
            }
        }
    }

}
