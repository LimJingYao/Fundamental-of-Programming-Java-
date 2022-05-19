package monopoly;

import java.util.logging.Level;
import java.util.logging.Logger;

abstract class calculation extends information {

    public void monster_round(int which_monster, int which_player) {
        if (B[which_monster][3] != 0) {
            if (B[which_monster][5] == 10 && B[which_monster][3] < 30 && used[which_monster] == false) {
                B[which_monster][0] += 30;
                button_label2.setText("" + monster_name(B[which_monster][5]) + " active shield of sand");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                used[which_monster] = true;
            }
            damage_BY_monster(which_monster, which_player);
            if (damage > 100 && currentWeapon[which_player] == 12 && cold[which_player] > 2) {
                damage = 0;
                cold[which_player] = 0;
            } else if (currentWeapon[which_player] == 13 && cold[which_player] > 3) {
                damage = 0;
            } else {
                cold[which_player]++;
            }
            if (damage != 0) {
                if (B[which_monster][5] == 12) {    //poison
                    probility();
                    if (probility < 3) {
                        button_label2.setText("" + monster_name(B[which_monster][5]) + "use Chakra Scalpel (poison)");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                        ppoison[which_player] = true;
                    }
                }
                if (B[which_monster][5] == 11) {
                    button_label2.setText("" + monster_name(B[which_monster][5]) + "active Sakura Healing increase " + (damage * 20 / 100) + " HP");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    B[which_monster][3] = B[which_monster][3] + (damage * 20 / 100);
                }
                if (B[which_monster][5] == 13) {
                    System.out.print("extra armor damage " + (A[which_player][1] * 20 / 100));
                    button_label2.setText("" + monster_name(B[which_monster][5]) + "active sealing palms(extra armor damage)");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    damage = damage + (A[which_player][1] * 20 / 100);
                }
            }
            if (B[which_monster][5] == 9) {     //attack double
                probility();
                if (probility < 3) {
                    button_label2.setText("" + monster_name(B[which_monster][5]) + "active Double Demons(double damage) ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                    damage = damage * 2;
                }
            }
            if (currentWeapon[which_player] == 18) {
                collect[which_player] = collect[which_player] + damage;
            }
            if (ppoison[which_player] == true) {
                button_label2.setText(player_name[which_player] + " poisoned, reduce hp" + (A[which_player][3] * 10 / 100));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                A[which_player][3] = A[which_player][3] - A[which_player][3] * 10 / 100;
            }
            A[which_player][3] = A[which_player][3] - damage;       // update player hp after attack by monster
            button_label2.setText(monster_name(B[which_monster][5]) + " attack " + player_name[which_player] + " reduce " + damage + " HP");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            if (A[which_player][3] <= 0) {
                System.out.print(player_name[which_player] + " die");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            } else {
                statistic_player(which_player);
            }  // display player information
        }
    }

    @Override
    public void after_fight(int number_monster, int which_player) {
        if (A[which_player][3] > 0) {
            int weapon_max = 8, weapon_min = 0, goldmax = 25, expmax = 55;
            int ii = 0;
            if (currentWeapon[which_player] == 6 || B[0][5] == 4 || B[1][5] == 4 || B[2][5] == 4) {    //get more powerful weapon
                weapon_max = 11;
                weapon_min = 0;
            }
            if (currentWeapon[which_player] == 7 || B[0][5] == 5 || B[1][5] == 5 || B[2][5] == 5) {
                weapon_max = 16;
                weapon_min = 6;
            }
            if (B[0][5] == 14 || B[1][5] == 14 || B[2][5] == 14) { // very stronger monster
                ii = 18;                     // very powerful weapon
                Ssword = true;
            }
            ii = r.nextInt(weapon_max - weapon_min + 1) + weapon_min;

//calculate gold
            int gold = r.nextInt(goldmax * number_monster);
            if (currentWeapon[which_player] == 10 || B[0][5] == 8 || B[1][5] == 8 || B[2][5] == 8) {
                gold += 50;
            }
            if (currentWeapon[which_player] == 11 || B[0][5] == 9 || B[1][5] == 9 || B[2][5] == 9) {
                gold += 150;
            }
///calculate exp 
            int iii = r.nextInt(expmax * number_monster);
            if (currentWeapon[which_player] == 8 || B[0][5] == 6 || B[1][5] == 6 || B[2][5] == 6) {
                iii += 150;
            }
            if (currentWeapon[which_player] == 9 || B[0][5] == 7 || B[1][5] == 7 || B[2][5] == 7) {
                iii += 300;
            }
//check whether weapon beg full or not
            int weapon_counter = 0;
            for (int i = 0; i < 20; i++) {
                if (D[which_player][i] == 0) {
                    D[which_player][i] = ii;
                    break;
                } else {
                    weapon_counter++;
                }
            }
            str = "";
            if (weapon_counter == 20) {
                str = str + ("<br/>" + player_name[which_player] + " weapon beg full");
            } else {
                str = str + ("<br/>" + player_name[which_player] + " earn " + weapon_name(ii));
            }  //print what weapon get
            str = str + ("<br/> " + player_name[which_player] + " earn " + gold + " gold");
            A[which_player][6] = A[which_player][6] + gold;
            gold = 0;
            //print what weapon get
            str = str + ("<br/>" + player_name[which_player] + " earn " + iii + " exp ");
            button_label2.setText("<html>" + str + "</html>");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            A[which_player][0] = A[which_player][0] - temp[which_player][0];
            A[which_player][1] = A[which_player][1] - temp[which_player][1];
            A[which_player][2] = A[which_player][2] - temp[which_player][2];
            temp[which_player][0] = 0;
            temp[which_player][1] = 0;
            temp[which_player][2] = 0;
            collect[which_player] = 0;
            levelup(which_player);
            ppoison[which_player] = false;
        } else {
            button_label2.setText(player_name[which_player] + " die");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
        B[0][5] = 0;
        B[1][5] = 0;
        B[2][5] = 0;
        for (int i = 0; i < 4; i++) {
            ppoison[i] = false;
            pfreeze[i] = false;
        }
    }

    @Override
    public void after_fightPvP(int survival, int dead) {
        int weapon_counter = 0;
        int item_counter = 0;
//gte weapon
        str = ("<br/>weapon that " + player_name[survival] + " get");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (D[survival][j] == 0) {
                    D[survival][j] = D[dead][i];
                    str = str + ("<br/>" + weapon_name(D[dead][i]));
                    break;
                } else {
                    weapon_counter++;
                }
            }
            if (weapon_counter == 20) {
                str = str + ("<br/>Your weapon inventory is full");
            }
        }
        button_label2.setText("<html> " + str + " </html>");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
// get item  
        str = ("<br/>item that " + player_name[survival] + " get");
        System.out.print("\nYou get ");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (C[survival][j] == 0) {
                    C[survival][j] = C[dead][i];
                    str = str + ("<br/>" + item_name(D[dead][i]));
                    break;
                } else {
                    item_counter++;
                }
            }
            if (item_counter == 20) {
                str = str + ("<br/>Your item inventory is full");
            }
        }
        button_label2.setText("<html> " + str + " </html>");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        str = ("<br/>Gold that" + player_name[survival] + " earn " + A[dead][6]);
        A[survival][6] = A[survival][6] + A[dead][6];
        A[survival][5] = A[survival][5] + 1000;
        A[survival][0] = A[survival][0] - temp[survival][0];
        A[survival][1] = A[survival][1] - temp[survival][1];
        A[survival][2] = A[survival][2] - temp[survival][2];
        temp[survival][0] = 0;
        temp[survival][1] = 0;
        temp[survival][2] = 0;
        collect[survival] = 0;
        levelup(survival);
        for (int i = 0; i < 4; i++) {
            ppoison[i] = false;
            pfreeze[i] = false;
        }

    }

    @Override
    public void player_attack(int number_monster, int which_player) {
        try {
            button_label2.setText("<html>Choose the monster you want to attack</html>");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            option_button2.removeAllItems();
            for (int i = 0; i < 4; i++) {
                if (i < number_monster) {
                    number_button[i] = monster_name(B[i][5]);
                } else {
                    number_button[i] = null;
                }
            }
            for (int i = 0; i < 4; i++) {
                option_button2.addItem(number_button[i]);
            }
            buttonpressed = false;
            check();
            delay();
            buttonpressed = false;
            int which_monster = number_action;
            damage_BY_player(which_monster, which_player);   // monster is target of player
            if (currentWeapon[which_player] == 14) {
                probility();
                if (probility < 3) {
                    button_label2.setText("Due to weapon" + weapon_name(currentWeapon[which_player]) + ", " + player_name[which_player] + " attack twice");
                    Thread.sleep(1000);
                    damage = damage * 2;
                }
            }
            if (damage != 0) {
                if (currentWeapon[which_player] == 15) {
                    A[which_player][3] = A[which_player][3] + (damage * 20 / 100);
                    button_label2.setText("Due to weapon" + weapon_name(currentWeapon[which_player]) + ", " + player_name[which_player] + "add " + (damage * 20 / 100) + "HP");
                    Thread.sleep(1000);
                }
                if (currentWeapon[which_player] == 16) {
                    probility();
                    if (probility < 3) {
                        button_label2.setText("Due to weapon" + weapon_name(currentWeapon[which_player]) + ", " + monster_name(B[which_monster][5]) + " poisoned");
                        Thread.sleep(1000);
                        mpoison[which_monster] = true;
                    }
                }
                if (currentWeapon[which_player] == 17) {
                    damage = damage + (B[which_monster][4] * 20 / 100);
                    button_label2.setText("Due to weapon " + weapon_name(currentWeapon[which_player]) + "monster get extra damage(20% of MAX HP) " + (B[which_monster][3] * 20 / 100));
                    Thread.sleep(1000);
                }
                if (currentWeapon[which_player] == 18) {
                    damage = damage + collect[which_player] * 40 / 100;
                    System.out.print("Due to weapon, extra damage = hp max " + (collect[which_player] * 40 / 100));
                    button_label2.setText("Due to weapon " + weapon_name(currentWeapon[which_player]) + " reflect damage to opponent " + (collect[which_player] * 40 / 100));
                    Thread.sleep(1000);
                }
            }

            if (mpoison[which_monster] == true) {
                button_label2.setText(monster_name(B[which_monster][5]) + " is poisoned, so reduce " + B[which_monster][3] * 10 / 100 + " hp");
                Thread.sleep(1000);
                B[which_monster][3] = B[which_monster][3] - B[which_monster][3] * 10 / 100;
            }
            B[which_monster][3] = B[which_monster][3] - damage;
            button_label2.setText(monster_name(B[which_monster][5]) + " reduce " + damage + "hp");
            Thread.sleep(1000);
            if (B[which_monster][3] <= 0) {
                B[which_monster][3] = 0;
                button_label2.setText(monster_name(B[which_monster][5]) + " is dead");
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void player_attackPvP(int attack, int defence) {
        try {
            damageBetPlayer(attack, defence);   // defence is target of attack
            if (currentWeapon[attack] == 14) {
                probility();
                if (probility < 3) {
                    button_label2.setText("Due to weapon " + weapon_name(currentWeapon[attack]) + "," + player_name[attack] + " attack twice");
                    Thread.sleep(1000);
                    damage = damage * 2;
                }
            }
            if (damage != 0) {
                if (currentWeapon[attack] == 15) {
                    A[attack][3] = A[attack][3] + (damage * 20 / 100);
                    button_label2.setText("Due to weapon " + weapon_name(currentWeapon[attack]) + ", " + player_name[attack] + "add " + (damage * 20 / 100) + " HP");
                    Thread.sleep(1000);
                }
                if (currentWeapon[attack] == 17) {
                    damage = damage + (A[defence][7] * 20 / 100);
                    button_label2.setText("Due to weapon " + weapon_name(currentWeapon[attack]) + ", " + player_name[defence] + " receive extra " + (A[defence][7] * 20 / 100) + "damage");
                    Thread.sleep(1000);
                }
                if (currentWeapon[attack] == 18) {
                    damage = damage + collect[attack] * 40 / 100;
                    button_label2.setText("Due to weapon " + weapon_name(currentWeapon[attack]) + "," + player_name[attack] + "reflect" + (collect[attack] * 40 / 100) + " damage to " + player_name[defence]);
                    Thread.sleep(1000);
                }
                if (currentWeapon[attack] == 16) {
                    probility();
                    if (probility < 3) {
                        button_label2.setText("Due to weapon " + weapon_name(currentWeapon[attack]) + ", " + player_name[defence] + " poisoned ");
                        Thread.sleep(1000);
                        mpoison[defence] = true;
                    }
                }
            }
            if (damage > 100 && currentWeapon[defence] == 12 && cold[defence] > 2) {
                button_label2.setText("Due to weapon " + weapon_name(currentWeapon[defence]) + "and damage over 100" + player_name[defence] + " immune this turn");
                Thread.sleep(1000);
                damage = 0;
                cold[defence] = 0;
            } else if (currentWeapon[defence] == 13 && cold[defence] > 3) {
                button_label2.setText("Due to weapon " + weapon_name(currentWeapon[defence]) + ", " + player_name[defence] + " immune this turn");
                Thread.sleep(1000);
                damage = 0;
            } else {
                cold[defence]++;
            }
            if (currentWeapon[defence] == 18) {
                collect[defence] = collect[defence] + damage;
            }
            if (ppoison[defence] == true) {
                button_label2.setText(player_name[defence] + "is poisoned, so reduce" + (A[defence][3] * 10 / 100) + " HP");
                Thread.sleep(1000);
                A[defence][3] = A[defence][3] - A[defence][3] * 10 / 100;
            }
            A[defence][3] = A[defence][3] - damage;
            button_label2.setText(player_name[defence] + " reduce " + damage + "hp");
            Thread.sleep(1000);
            if (A[defence][3] <= 0) {
                A[defence][3] = 0;
                button_label2.setText(player_name[defence] + " is dead");
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void player_chooseItem(int number_monster, int which_player) {
        try {
            button_label2.setText("choose item");

            Thread.sleep(1000);
            item_button[0] = "back";
            for (int i = 1; i < 21; i++) {
                item_button[i] = item_name(C[which_player][i - 1]);
            }
            option_button3.removeAllItems();
            for (int i = 0; i < 21; i++) {
                option_button3.addItem(item_button[i]);
            }
            buttonpressed = false;
            check();
            delay();
            int input2 = item_action - 1;
            if (input2 != -1) {
                button_label2.setText(player_name[which_player] + " used " + item_name(C[which_player][input2]));
                Thread.sleep(1000);
                if (C[which_player][input2] == 13) {
                    flee = true;
                    C[which_player][input2] = 0;
                    for (int i = 0; i < 19; i++) {
                        if (C[which_player][i] == 0) {
                            C[which_player][i] = C[which_player][i + 1];
                            C[which_player][i + 1] = 0;
                        }
                    }
                } else {
                    if (C[which_player][input2] >= 10) {  //add hp
                        add_itemValue(which_player, C[which_player][input2]);
                        A[which_player][3] = A[which_player][3] + add_item[which_player][3];
                        C[which_player][input2] = 0;
                        if (A[which_player][3] > A[which_player][7]) {
                            A[which_player][3] = A[which_player][7];
                        }
                        for (int i = 0; i < 19; i++) {
                            if (C[which_player][i] == 0) {
                                C[which_player][i] = C[which_player][i + 1];
                                C[which_player][i + 1] = 0;
                            }
                        }
                        player_chooseItem(number_monster, which_player);
                        statistic_player(which_player);
                    } else {
                        add_itemValue(which_player, C[which_player][input2]);
                        for (int i = 0; i < 5; i++) {
                            A[which_player][i] = A[which_player][i] + add_item[which_player][i];
                        }
                        C[which_player][input2] = 0;
                        for (int i = 0; i < 19; i++) {
                            if (C[which_player][i] == 0) {
                                C[which_player][i] = C[which_player][i + 1];
                                C[which_player][i + 1] = 0;
                            }
                        }
                        statistic_player(which_player);
                        check();
                    }
                    condition = "PVM";
                    player_round(number_monster, which_player);

                }
            }
        } catch (InterruptedException ex) {
        }
        condition = "PVM";
        player_round(number_monster, which_player);
    }

    @Override
    public void player_chooseItemPvP(int first, int second) {
        button_label2.setText("choose item");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        item_button[0] = "back";
        for (int i = 1; i < 21; i++) {
            item_button[i] = item_name(C[first][i - 1]);
        }
        option_button3.removeAllItems();
        for (int i = 0; i < 21; i++) {
            option_button3.addItem(item_button[i]);
        }
        buttonpressed = false;
        check();
        delay();
        int input2 = item_action - 1;
        if (input2 != -1) {
            button_label2.setText(player_name[first] + " use " + item_name(C[first][input2]));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            if (C[first][input2] == 13) {
                Pflee[first] = true;
                C[first][input2] = 0;
                for (int i = 0; i < 19; i++) {
                    if (C[first][i] == 0) {
                        C[first][i] = C[first][i + 1];
                        C[first][i + 1] = 0;
                    }
                }
            } else {
                if (C[first][input2] >= 10) {  //add hp
                    add_itemValue(first, C[first][input2]);
                    A[first][3] = A[first][3] + add_item[first][3];
                    C[first][input2] = 0;
                    for (int i = 0; i < 19; i++) {
                        if (C[first][i] == 0) {
                            C[first][i] = C[first][i + 1];
                            C[first][i + 1] = 0;
                        }
                    }
                    if (A[second][3] > A[second][7]) {
                        A[second][3] = A[second][7];
                    }
                    statistic_player(first);
                    player_chooseItemPvP(first, second);
                } else {
                    add_itemValue(first, C[first][input2]);
                    for (int i = 0; i < 5; i++) {
                        A[first][i] = A[first][i] + add_item[first][i];
                    }
                    C[first][input2] = 0;
                    for (int i = 0; i < 19; i++) {
                        if (C[first][i] == 0) {
                            C[first][i] = C[first][i + 1];
                            C[first][i + 1] = 0;
                        }
                    }
                    statistic_player(first);
                }
                condition = "PVP";
                player_roundPvP(first, second);
            }
        }
        condition = "PVP";
        player_roundPvP(first, second);
    }

    @Override
    public void damage_BY_player(int which_monster, int which_player) {
        int miss = r.nextInt(80);
        if (miss < B[which_monster][2]) {
            damage = 0;
        } else {
            damage = A[which_player][0] * 2 / B[which_monster][1];
            tempo = damage;
            hdamage = damage + 5;
            ldamage = tempo - 5;
            damage = r.nextInt(hdamage - ldamage + 1) + ldamage;
            if (damage < 0) {
                damage = 0;
            }
        }
    }

    @Override
    public void damage_BY_monster(int which_monster, int which_player) {
        int miss = r.nextInt(80);
        if (miss < A[which_player][2]) {
            damage = 0;
        } else {
            damage = (B[which_monster][0] * 2) / (A[which_player][1]);
            tempo = damage;
            hdamage = damage + 5;
            ldamage = tempo - 5;
            damage = r.nextInt(hdamage - ldamage + 1) + ldamage;
            if (damage < 0) {
                damage = 0;
            }
        }
    }

    @Override
    public void damageBetPlayer(int attack, int defence) {
        int miss = r.nextInt(11);
        if (miss < A[defence][2]) {
            damage = 0;
        } else {
            damage = A[attack][0] * 2 / A[defence][1];
            tempo = damage;
            hdamage = damage + 5;
            ldamage = tempo - 5;
            damage = r.nextInt(hdamage - ldamage + 1) + ldamage;
            if (damage < 0) {
                damage = 0;
            }
        }
    }

    public void shop(int which_player) {
        counter = 0;
        button_label2.setText("<html>Welcome to the shop<br/>Gold " + player_name[which_player] + " have" + A[which_player][6] + "</html>");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        for (int i = 0; i < 5; i++) {
            shop[i] = r.nextInt(13) + 1;
        }
        shop_weapon = r.nextInt(6) + 1;
        shop_option(which_player);
    }

    public void shop_option(int which_player) {
        int weapon_counter = 0;
        int item_counter = 0;
//display item beg
        str = ("<br/>" + player_name[which_player] + " item beg :");
        for (int i = 0; i < 20; i++) {
            if (C[which_player][i] == 0) {
                break;
            }
            str = str + ("<br/>" + item_name(C[which_player][i]));
            if (i == 10) {
                button_label2.setText("<html>" + str + "</html>");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
                str = ("<br/>" + player_name[which_player] + " item beg :");
            }
            item_counter++;
        }
        button_label2.setText("<html>" + str + "</html>");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        str = ("<br/>" + player_name[which_player] + " weapon beg :");
        for (int i = 0; i < 20; i++) {
            if (D[which_player][i] == 0) {
                break;
            }
            str = str + ("<br/>" + weapon_name(D[which_player][i]));
            weapon_counter++;

        }
        button_label2.setText("<html>" + str + "</html>");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        button_label2.setText("Choose Item or Weapon or Upgarde or Quit");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
//        input3 = sc.nextInt();    
        number_button[0] = "Item";
        number_button[1] = "Weapon";
        number_button[2] = "Upgrade";
        number_button[3] = "Quit";
        option_button2.removeAllItems();
        for (int i = 0; i < 4; i++) {
            option_button2.addItem(number_button[i]);
        }
        buttonpressed = false;
        check();
        delay();
        int input3 = number_action;
        if (input3 == 0 && item_counter != 20) {
            condition = "shop_item";
            buy(which_player);
        } else if (input3 == 1 && weapon_counter != 20) {
            condition = "shop_weapon";
            buy_weapon(which_player);
        } else if (input3 == 2) {
            condition = "shop_weapon";
            upgrade(which_player);
        } else if (input3 == 3); else {
            button_label2.setText("Your weapon and item bag is full");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void buy(int which_player) {   // buy item
        condition = "shop_item";
        str = ("<br/>Item has");
        button_label2.setText("<html>Item has </html>");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        item_button[0] = "Back";
        for (int i = 1; i < 6; i++) {
            if (shop[i - 1] == 0) {
                item_button[i] = "sold out";
                str = str + ("<br/>sold out");
            } else {
                item_button[i] = item_name(shop[i - 1]);
                str = str + ("<br/>" + item_name(shop[i - 1]) + " price: " + price_item(shop[i - 1]));
            }

        }
        button_label2.setText("<html>" + str + "</html>");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        option_button3.removeAllItems();
        for (int i = 0; i < 6; i++) {
            option_button3.addItem(item_button[i]);
        }
        buttonpressed = false;
        check();
        delay();

//       	System.out.print("   0. back");
        int input4 = item_action - 1;
        if (input4 != -1) {
            if (A[which_player][6] >= price_item(shop[input4])) {
                for (int i = 0; i < 20; i++) {
                    if (C[which_player][i] == 0) {
                        C[which_player][i] = shop[input4];
                        break;
                    }
                }
                A[which_player][6] = A[which_player][6] - (price_item(shop[input4]));
                shop[input4] = 0;
            } else {
                button_label2.setText("Gold not enough");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
        button_label2.setText("Gold " + player_name[which_player] + " have: " + A[which_player][6]);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        condition = "shop";
        shop_option(which_player);
    }

    public void buy_weapon(int which_player) {   // buy weapon
        condition = "shop_weapon";
        str = ("<br/>Weapons have:" + weapon_name(shop_weapon));
        str = str + ("<br/>Price:" + price_weapon(shop_weapon));
        str = str + ("<br/>Back or Buy");
        button_label2.setText("<html>" + str + "</html>");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        number_button[0] = "Back";
        number_button[1] = "Buy";
        option_button1.removeAllItems();
        for (int i = 0; i < 2; i++) {
            option_button1.addItem(number_button[i]);
        }
        check();
        buttonpressed = false;
        check();
        delay();
        int input5 = number_action;
        if (input5 == 1) {
            if (A[which_player][6] >= price_weapon(shop_weapon)) {
                A[which_player][6] = A[which_player][6] - price_weapon(shop_weapon);
                for (int i = 0; i < 20; i++) {
                    if (D[which_player][i] == 0) {
                        D[which_player][i] = shop_weapon;
                        shop_weapon = 0;
                    }
                }
            } else {
                button_label2.setText("Gold not enough");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
        button_label2.setText("gold that " + player_name[which_player] + " left : " + A[which_player][6]);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        condition = "shop";
        shop_option(which_player);
    }

    public void upgrade(int which_player) {
        button_label2.setText("what weapon " + player_name[which_player] + " ,You want to upgrade");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        weapon_button[0] = "Back";
        int counter = 1;
        for (int i = 1; i < 21; i++) {
            if (D[which_player][i - 1] == 0) {
                break;
            }
            weapon_button[i] = weapon_name(D[which_player][i - 1]);
            counter++;
        }
        option_button1.removeAllItems();
        for (int i = 0; i < counter; i++) {
            option_button1.addItem(weapon_button[i]);
        }
        check();
        buttonpressed = false;
        check();
        delay();
        int input6 = weapon_action - 1;
        if (input6 != -1) {
            if (A[which_player][6] >= (D[which_player][input6] * 20)) {
                currentWeapon[which_player] = D[which_player][input6];
                weapon(which_player);
                A[which_player][6] = A[which_player][6] - (D[which_player][input6] * 20);
                for (int i = 0; i < 5; i++) {
                    A[which_player][i] = A[which_player][i] + (add_weapon[which_player][i] * 50 / 100);
                }
                currentWeapon[which_player] = 0;
                button_label2.setText("upgrade success");
                check();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            } else {
                button_label2.setText("Not enough gold");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
        condition = "Shop";
        shop_option(which_player);
    }

    public void chest(int which_player) {
        try {
            cheast_random = r.nextInt(8);
            switch (cheast_random) {
                case 0:
                    button_label2.setText(player_name[which_player] + " get exp 50");
                    Thread.sleep(1000);
                    A[which_player][5] += 50;
                    break;
                case 1:
                    button_label2.setText(player_name[which_player] + " get exp 100");
                    Thread.sleep(1000);
                    A[which_player][5] += 100;
                    break;
                case 2:
                    button_label2.setText(player_name[which_player] + " get exp 150");
                    Thread.sleep(1000);
                    A[which_player][5] += 150;
                    break;
                case 3:
                    button_label2.setText(player_name[which_player] + " get gold 50");
                    Thread.sleep(1000);
                    A[which_player][5] += 50;
                    break;
                case 4:
                    button_label2.setText(player_name[which_player] + " get gold 100");
                    Thread.sleep(1000);
                    A[which_player][5] += 100;
                    break;
                case 5:
                    button_label2.setText(player_name[which_player] + " get gold 150");
                    Thread.sleep(1000);
                    A[which_player][5] += 150;
                    break;
                case 6:
                    cheast_random = r.nextInt(13) + 1;
                    int counter = 0;
                    button_label2.setText(player_name[which_player] + " get an item: " + item_name(cheast_random));
                    Thread.sleep(1000);
                    for (int i = 0; i < 20; i++) {
                        if (C[which_player][i] == 0) {
                            C[which_player][i] = cheast_random;
                            break;
                        } else {
                            counter++;
                        }
                    }
                    if (counter == 20) {
                        button_label2.setText("sorry " + player_name[which_player] + " your bag is full");
                        Thread.sleep(1000);
                    }
                    break;
                case 7:
                    cheast_random = r.nextInt(19) + 1;
                    counter = 0;
                    button_label2.setText(player_name[which_player] + "You get weapon" + weapon_name(cheast_random));
                    Thread.sleep(1000);
                    for (int i = 0; i < 20; i++) {
                        if (D[which_player][i] == 0) {
                            if (cheast_random == 19) {
                                Sdefence = true;
                            }
                            D[which_player][i] = cheast_random;
                            break;
                        } else {
                            counter++;
                        }
                    }
                    if (counter == 20) {
                        button_label2.setText("sorry " + player_name[which_player] + " your bag is full");
                        Thread.sleep(1000);
                    }
                    break;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(calculation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void probility() {
        probility = r.nextInt(10);
    }

    public void levelup(int which_player) {
        sum = 0;
        for (int i = 1; i <= A[which_player][4]; i++) {
            sum = sum + i;
        }
        if (A[which_player][5] >= sum * 200) {
            A[which_player][5] = A[which_player][5] - sum * 200;
            A[which_player][0] = A[which_player][0] + sum * 10;
            A[which_player][1] = A[which_player][1] + sum * 10;
            A[which_player][2] = A[which_player][2] + sum * 2;
            A[which_player][3] = A[which_player][3] + sum * 20;
            A[which_player][4] = A[which_player][4] + 1;
            A[which_player][7] = A[which_player][7] + sum * 20;
            button_label2.setText("Congratulations," + player_name[which_player] + " you leveled up");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            check();
        }
    }

    public void inventory(int player) {
        button_label2.setText(player_name[player] + " choose healing item want to use:");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        item_button[0] = "quit";
        for (int i = 1; i < 21; i++) {
            item_button[i] = item_name(C[player][i - 1]);
        }
        option_button3.removeAllItems();
        for (int i = 0; i < 21; i++) {
            option_button3.addItem(item_button[i]);
        }
        condition = "empty_item";
        buttonpressed = false;
        check();
        delay();
        int input2 = item_action - 1;
        if (input2 != -1) {
            if (C[player][input2] >= 10 && C[player][input2] <= 12) {  //add hp
                button_label2.setText(player_name[player] + ",You used " + item_name(C[player][input2]));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
                add_itemValue(player, C[player][input2]);
                A[player][3] = A[player][3] + add_item[player][3];
                C[player][input2] = 0;
                for (int i = 0; i < 19; i++) {
                    if (C[player][i] == 0) {
                        C[player][i] = C[player][i + 1];
                        C[player][i + 1] = 0;
                    }
                }
                if (A[player][3] > A[player][7]) {
                    A[player][3] = A[player][7];
                }
            } else {
                try {
                    button_label2.setText(player_name[player] + ",You can only use healing item ");
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
            inventory(player);
        }
    }

    public int winner() {
        winner = 4;
        for (int i = 0; i < 4; i++) {

            if (A[i][3] <= 0) {
                winner--;
            }
        }
        return winner;
    }
}

