/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

abstract class information extends battle1 {

    public void dice() {
        dice = r.nextInt(6) + 1;
    }

    public void add_weaponValue(int which_player) {
        int number = 0;
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                continue;
            }
            A[which_player][i] = A[which_player][i] - add_weapon[which_player][i];
        }
        A[which_player][7] = A[which_player][7] - add_weapon[which_player][4];
        if (A[which_player][3] > A[which_player][7]) {
            A[which_player][3] = A[which_player][7];
        }
        button_label2.setText("<html>Player " + player_name[which_player] + " choose weapon </html>");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        weapon_button[0] = "Quit";
        for (int i = 1; i < 21; i++) {
            weapon_button[i] = weapon_name(D[which_player][i - 1]);
            if (D[which_player][i - 1] == 0) {
                weapon_button[i] = null;
            } else {
                number++;
            }
        }
        option_button1.removeAllItems();
        for (int i = 0; i < 21; i++) {
            option_button1.addItem(weapon_button[i]);
        }
        if (number != 0) {
            buttonpressed = false;
            check();
            delay();

            int input1 = weapon_action - 1;
            if (input1 != -1) {
                currentWeapon[which_player] = D[which_player][input1];
                weapon(which_player);
                for (int i = 0; i < 5; i++) {
                    A[which_player][i] = A[which_player][i] + add_weapon[which_player][i];
                }
            }
        } else {
            button_label2.setText("<html>No weapon available</html>");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void player_round(int number_monster, int which_player) {
        button_label2.setText("Choose Attack or Bag or Run");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        condition = "PVM";
        buttonpressed = false;
        check();
        delay();

        switch (action) {
            case 1:
                condition = "PVM_number";
                player_attack(number_monster, which_player);   //display attack target
                statistic_monster(number_monster);
                check();
                break;
            case 2:
                condition = "PVM_item";
                player_chooseItem(number_monster, which_player);
                break;
            case 3:
                int escape = r.nextInt(5 + 1);
                if (escape > 1) {
                    flee = true;
                } else {
                    flee = false;
                }
                break;
            default:
                break;
        }
    }

    public void player_roundPvP(int attack, int defence) {
        button_label2.setText(player_name[attack] + " turn");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        buttonpressed = false;
        check();
        delay();
        if (action == 1) {
            player_attackPvP(attack, defence);   //display attack target
            statistic_player(defence);
            statistic_player(attack);
            check();
        } else if (action == 2) {
            condition = "PVP_item";
            player_chooseItemPvP(attack, defence);
        }
    }

    public void create_monster(int number_monster) {
        if (Ssword = true) {
            min = 1;
            max = 12;
        } else {
            min = 1;
            max = 13;
        }
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            B[i][5] = 0;
            monster(i);
        }
        for (int i = 0; i < number_monster; i++) {
            int counter = 0;
            B[i][5] = r.nextInt(max - min + 1) + min;
            temp[i] = B[i][5];
            for (int j = 0; j < 3; j++) {
                if (B[i][5] == temp[j] && i != j) {
                    counter++;
                }
            }
            if (counter != 0) {
                i--;
            }
            monster(i);
        }
    }
}
