/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

abstract class player extends Role {

    public void statistic_player(int which_player) {
        player_text[which_player] = "";
        player_text[which_player] = player_text[which_player] + ("<br/>Player " + player_name[which_player] + " Data");
        player_text[which_player] = player_text[which_player] + ("<br/>The strength is  " + A[which_player][0]);
        player_text[which_player] = player_text[which_player] + ("<br/>The defence is  " + A[which_player][1]);
        player_text[which_player] = player_text[which_player] + ("<br/>The agility is " + A[which_player][2]);
        player_text[which_player] = player_text[which_player] + ("<br/>The current HP is " + A[which_player][3]);
        player_text[which_player] = player_text[which_player] + ("<br/>The level is " + A[which_player][4]);
        player_text[which_player] = player_text[which_player] + ("<br/>The exp is  " + A[which_player][5]);
        player_text[which_player] = player_text[which_player] + ("<br/>The gold is " + A[which_player][6]);
        player_text[which_player] = player_text[which_player] + ("<br/>The maximum hp is " + A[which_player][7]);
    }

    public void statistic_monster(int number_monster) {
        for (int i = 0; i < number_monster; i++) {
            monster_text[i] = "";
            monster_text[i] = monster_text[i] + ("<br/> ");
            monster_text[i] = monster_text[i] + ("<br/>Monster " + monster_name(B[i][5]) + " Data");
            monster_text[i] = monster_text[i] + ("<br/>The strength is  " + B[i][0]);
            monster_text[i] = monster_text[i] + ("<br/>The defence is  " + B[i][1]);
            monster_text[i] = monster_text[i] + ("<br/>The agility is " + B[i][2]);
            monster_text[i] = monster_text[i] + ("<br/>The HP is " + B[i][3]);
            monster_text[i] = monster_text[i] + ("<br/> ");
            monster_text[i] = monster_text[i] + ("<br/> ");
            monster_text[i] = monster_text[i] + ("<br/> ");
        }

    }
}
