/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

abstract class battle1 extends player {

    public void battlePvP(int first, int second) {
        for (int i = 0; i < 3; i++) {             //clean previous item effect
            A[first][i] = A[first][i] - temp[first][i];
            temp[first][i] = 0;
        }
        condition = "PVP_weapon";
        add_weaponValue(first);           // equip weapon
        condition = "PVP";
        for (int i = 0; i < 3; i++) {          //clean previous item effect
            A[second][i] = A[second][i] - temp[second][i];
            temp[second][i] = 0;
        }
        condition = "PVP_weapon";
        add_weaponValue(second);                      // equip weapon
        condition = "PVP";
        for (int round = 0; A[first][3] > 0 && A[second][3] > 0; round++) {
            if (round == 0) {
                player_roundPvP(first, second);
                if (Pflee[first] == true || Pflee[second] == true) {
                    break;
                }
            } else {
                player_roundPvP(second, first);
            }

            if (round == 1) {
                round = -1;
            }
        }
        if (Pflee[first] == true) {
            button_label2.setText(player_name[first] + " flee");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            Pflee[first] = false;
        } else if (Pflee[second] == true) {
            button_label2.setText(player_name[second] + " flee");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            Pflee[second] = false;
        } else {
            if (A[first][3] <= 0) {
                after_fightPvP(second, first);
                button_label2.setText("<html>" + player_name[second] + " wins the battle</html>");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            } else {
                after_fightPvP(first, second);
                button_label2.setText("<html>" + player_name[first] + " wins the battle</html>");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            ppoison[i] = false;
            pfreeze[i] = false;
        }
    }

    public void battlePvM(int number_monster, int which_player) {
        for (int i = 0; i < 3; i++) {
            A[which_player][i] = A[which_player][i] - temp[which_player][i];
            temp[which_player][i] = 0;
        }
        condition = "PVM_weapon";
        add_weaponValue(which_player);
        condition = "PVM";
        create_monster(number_monster);
        check();
        for (int round = 0; (A[which_player][3] > 0) && (B[0][3] > 0 || B[1][3] > 0 || B[2][3] > 0); round++) {
            if (round == 0) {
                player_round(number_monster, which_player);
                if (flee == true) {
                    break;
                }
            } else {
                monster_round((round - 1), which_player);
                check();
            }
            if (round == number_monster) {
                round = -1;
            }
        }
        if (flee == true) {
            button_label2.setText(player_name[which_player] + " escaped from battle");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            B[0][5] = 0;
            B[1][5] = 0;
            B[2][5] = 0;
            for (int i = 0; i < 4; i++) {
                ppoison[i] = false;
                pfreeze[i] = false;
            }
            for (int i = 0; i < 3; i++) {
                mpoison[i] = false;
                mfreeze[i] = false;
            }
            flee = false;
        } else {
            after_fight(number_monster, which_player);
        }
    }
}
