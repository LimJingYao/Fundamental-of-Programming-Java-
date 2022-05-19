/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.Random;
import java.util.Scanner;

abstract class Board extends store {
    //starting each player location
    //dice value insert to player location later

    public void tileRandom() {
        Random r = new Random();
        tiles[0] = 1;
        for (int i = 1; i < tiles.length; i++) {
            tiles[i] = r.nextInt(32 - 2 + 1) + 2;
            for (int j = 0; j < i; j++) {
                if (tiles[i] == tiles[j]) {
                    i--;
                }
            }
        }
        for (int i = 1; i < tiles.length; i++) {
            if (tiles[i] == 9) {
                int temp = tiles[8];
                tiles[8] = tiles[i];
                tiles[i] = temp;
            } else if (tiles[i] == 17) {
                int temp = tiles[16];
                tiles[16] = tiles[i];
                tiles[i] = temp;
            } else if (tiles[i] == 25) {
                int temp = tiles[24];
                tiles[24] = tiles[i];
                tiles[i] = temp;
            }
        }

       for (int i = 0; i < tiles.length; i++)             //check the number)
           System.out.print(tiles[i]+" ");
    }

    public void tile(int player) {
        button_label2.setText(player_name[player] + " run the dice");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        check();
        int PvP_opponent;
        condition = "DICE";
        buttonpressed = false;
        check();
        delay();

        if (dice == 100) {
            A[player][3] = 0;
        } else {
            playerLocation[player] = playerLocation[player] + dice;
            button_label2.setText(player_name[player] + " move " + dice);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            if (playerLocation[player] >=32) {
                A[player][5] = A[player][5] + 100;
                levelup(player);                    //function not working??
                playerLocation[player] -= 32;
            }
            if (playerLocation[player] <= 8) {
                x[player] = playerLocation[player];
                y[player] = 0;
            } else if (playerLocation[player] <= 16) {
                x[player] = 8;
                y[player] = playerLocation[player] - 8;
            } else if (playerLocation[player] <= 24) {
                x[player] = 24 - playerLocation[player];
                y[player] = 8;
            } else if (playerLocation[player] <= 31) {
                x[player] = 0;
                y[player] = 32 - playerLocation[player];
            }
            switch (tiles[playerLocation[player]]) {                                                               //add dice value each turn
                case 1:                                     // not req bc level up location handled by if statement above
                    button_label2.setText(player_name[player] + " arrive street（empty）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    condition = "empty";
                    check();
                    break;

                case 2:
                    check();
                    button_label2.setText(player_name[player] + " arrive land of waves（2）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(2, player);                                                    //duoM();
                    break;

                case 3:
                    check();
                    button_label2.setText(player_name[player] + " arrive Land of Earth（3）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(3, player);                                                   //triM();
                    break;

                case 4:
                    check();
                    button_label2.setText(player_name[player] + " arrive Land of Iron（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                   //sinM();
                    break;

                case 5:
                    check();
                    button_label2.setText(player_name[player] + " arrive street（empty）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "empty";
                    empty(player);                                                 // empty
                    break;

                case 6:
                    check();
                    button_label2.setText(player_name[player] + " arrive Land of Lightning（2）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(2, player);                                                    //duoM();
                    break;

                case 7:
                    check();
                    button_label2.setText(player_name[player] + " arrive Land of Water（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;

                case 8:
                    check();
                    button_label2.setText(player_name[player] + " arrive Land of Wind（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;

                case 9:
                    check();
                    button_label2.setText(player_name[player] + " arrive Yile Ramen（shop）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    condition = "shop";
                    shop(player);                                                           //shop
                    break;

                case 10:
                    check();
                    button_label2.setText(player_name[player] + " arrive Ryūchi Cave（2）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(2, player);                                                    //duoM();
                    break;

                case 11:
                    check();
                    button_label2.setText(player_name[player] + " arrive Tenchi bridge（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;

                case 12:
                    check();
                    button_label2.setText(player_name[player] + " arrive Forest of Death（2）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(2, player);                                                    //duoM();
                    break;

                case 13:
                    check();
                    button_label2.setText(player_name[player] + " arrive street（empty）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "empty";
                    empty(player);                                                                 //empty();
                    break;

                case 14:
                    check();
                    button_label2.setText(player_name[player] + " arrive training place（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;

                case 15:
                    check();
                    button_label2.setText(player_name[player] + " arrive Shikkotsu Forest （1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;

                case 16:
                    check();
                    button_label2.setText(player_name[player] + " arrive Final Valley（empty）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(3, player);                                                    //triM();
                    break;

                case 17:
                    check();
                    button_label2.setText(player_name[player] + " arrive hokage office（chest）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    condition = "";
                    chest(player);                                                         //chest();  
                    break;

                case 18:
                    check();
                    button_label2.setText(player_name[player] + " arrive Tonika Village（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;

                case 19:
                    check();
                    button_label2.setText(player_name[player] + " arrive Tsuchigumo Village（2）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(2, player);                                                    //duoM();
                    break;

                case 20:
                    check();
                    button_label2.setText(player_name[player] + " arrive Uzushiogakure（3）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(3, player);                                                    //triM();
                    break;

                case 21:
                    check();
                    button_label2.setText(player_name[player] + " arrive street（empty）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "empty";
                    empty(player);                                                                 //empty();
                    break;

                case 22:
                    check();
                    button_label2.setText(player_name[player] + " arrive Yugakure（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;

                case 23:
                    check();
                    button_label2.setText(player_name[player] + " arrive Otogakure（2）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(2, player);                                                    //duoM();
                    break;

                case 24:
                    check();
                    button_label2.setText(player_name[player] + " arrive Nadeshiko Village（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;

                case 25:
                    check();
                    button_label2.setText(player_name[player] + " arrive Yile Ramen（shop）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    condition = "shop";
                    shop(player);                                                           //shop
                    break;

                case 26:
                    check();
                    button_label2.setText(player_name[player] + " arrive Mount Myōboku （1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sin();
                    break;

                case 27:
                    check();
                    button_label2.setText(player_name[player] + " arrive Kusagakure（2）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(2, player);                                                    //duoM();
                    break;

                case 28:
                    check();
                    button_label2.setText(player_name[player] + " arrive Kumogakure（2）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(2, player);                                                    //duoM();
                    break;

                case 29:
                    check();
                    button_label2.setText(player_name[player] + " arrive street（empty）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "empty";
                    empty(player);                                                                 //empty();
                    break;

                case 30:
                    check();
                    button_label2.setText(player_name[player] + " arrive Jōmae Village（3）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(3, player);                                                    //triM();
                    break;

                case 31:
                    check();
                    button_label2.setText(player_name[player] + " arrive Hoshigakure（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;

                case 32:
                    check();
                    button_label2.setText(player_name[player] + " arrive land of rain（1）");
                     {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                    PvP_opponent = checkPvP(player, playerLocation[player]);
                    if (PvP_opponent >= 0) {
                        condition = "PVP";
                        battlePvP(PvP_opponent, player);
                        break;
                    }
                    condition = "PVM";
                    battlePvM(1, player);                                                    //sinM();
                    break;
            }
        }                                              //update player location after each round and tile

    }

    public void empty(int player) {
        Scanner sc = new Scanner(System.in);
        str = ("<br/>" + player_name[player] + " you at Empty tile");    //empty();
        str = str + ("<br/>0 - Use items");
        str = str + ("<br/>1 - Do nothing");
        button_label2.setText("<html>" + str + "</html>");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        number_button[0] = "Use items";
        number_button[1] = "Do nothing";
        option_button2.removeAllItems();
        for (int i = 0; i < 2; i++) {
            option_button2.addItem(number_button[i]);
        }
        condition = "empty";
        buttonpressed = false;
        check();
        delay();

        int empty = number_action;
        if (empty == 0) {
            inventory(player);
        }
    }

    public int checkPvP(int player, int currentPlayerLocation) {
        int OtherPlayersOnTile = 0;
        int opponent = -1;

        for (int i = 0; i < playerLocation.length; i++) {
            if ((currentPlayerLocation == playerLocation[i]) && (player != i)) {                //check if same tile as other player
                opponent = i;
                OtherPlayersOnTile++;                                                       //update no. of player & who
                continue;
            }
        }
        if (OtherPlayersOnTile > 1) {
            return -1;                                                                           //no PvP return negative number
        } else if (OtherPlayersOnTile == 1 && A[player][4] >= 5 && A[opponent][4] >= 5) {
            return opponent;                                                                     //PvP occurs return who's on the tile                                                                      
        }
        return -1;                                                                              //no conditions met
    }

}
