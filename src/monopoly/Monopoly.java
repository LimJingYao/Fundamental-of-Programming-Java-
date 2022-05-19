package monopoly;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Monopoly {       
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        window obj= new window();
        obj.tileRandom();
        int player[] = new int[4];
        obj.window();
        String file = "monoploymusic (online-audio-converter.com).wav";
        obj.playMusic(file);
        obj.button_label2.setText("<html>determine number of player </html>");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        obj.condition = "start";
        obj.number_button[0] = "Two";
        obj.number_button[1] = "Three";
        obj.number_button[2] = "Four";
        obj.number_button[3] = null;
        obj.enable();
        obj.button();
        obj.check();
        obj.delay();
        obj.buttonpressed = false;
        obj.number_player = obj.number_action + 2;
        obj.build_avatar(obj.number_player);

        obj.determineTurn();

        for (int i = 0; obj.winner() != 1; i++) {
            if (obj.A[i][3] > 0) {
                obj.tile(i);
            }
            if (i == obj.number_player-1) {
                i = -1;
            }
        }
        obj.close();
        for (int i = 0; i < 4; i++) {
            if (obj.A[i][3] > 0) {
                if (obj.player_name[i].equals("Madara")) {
                    obj.getMadara();
                } else if (obj.player_name[i].equals("Naruto")) {
                    obj.getNaruto();
                } else if (obj.player_name[i].equals("Sasuke")) {
                    obj.getSasuke();
                } else if (obj.player_name[i].equals("Pain")) {
                    obj.getPain();
                }
                break;
            }
        }
    }
    }

