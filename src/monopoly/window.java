/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class window extends Board implements ActionListener {

    public void enable() {
        option_button1 = new JComboBox(weapon_button);
        option_button1.addActionListener(this);
        option_button1.setBounds(700, 210, 150, 40);

        option_button2 = new JComboBox(number_button);
        option_button2.addActionListener(this);
        option_button2.setBounds(860, 210, 150, 40);

        option_button3 = new JComboBox(item_button);
        option_button3.addActionListener(this);
        option_button3.setBounds(1020, 210, 150, 40);

        button1 = new JButton();
        button1.setBounds(130, 420, 100, 100);
        button1.addActionListener(this);
        button1.setText("Attack");
        button1.setFocusable(false);
        button1.setIcon(icon1);
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setVerticalTextPosition(JButton.BOTTOM);
        button1.setFont(new Font("Comic SANS", Font.BOLD, 25));
        button1.setForeground(Color.red);
        button1.setBorder(BorderFactory.createEtchedBorder());

        button2 = new JButton();
        button2.setBounds(250, 420, 100, 100);
        button2.addActionListener(this);
        button2.setText("Bag");
        button2.setFocusable(false);
        button2.setIcon(icon2);
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setVerticalTextPosition(JButton.BOTTOM);
        button2.setFont(new Font("Comic SANS", Font.BOLD, 25));
        button2.setForeground(Color.red);
        button2.setBorder(BorderFactory.createEtchedBorder());

        button3 = new JButton();
        button3.setBounds(370, 420, 100, 100);
        button3.addActionListener(this);
        button3.setText("Run");
        button3.setFocusable(false);
        button3.setIcon(icon3);
        button3.setHorizontalTextPosition(JButton.CENTER);
        button3.setVerticalTextPosition(JButton.BOTTOM);
        button3.setFont(new Font("Comic SANS", Font.BOLD, 25));
        button3.setForeground(Color.red);
        button3.setBorder(BorderFactory.createEtchedBorder());

        button4 = new JButton();                      //dice
        button4.setBounds(260, 300, 100, 100);
        button4.addActionListener(this);
        button4.setFocusable(false);
        button4.setIcon(icon4);
        button4.setBorder(BorderFactory.createEtchedBorder());

        button_label3 = new JButton();
        button_label3.setBounds(1200, 205, 50, 50);
        button_label3.addActionListener(this);
        button_label3.setFocusable(false);
        button_label3.setIcon(image2);
        button_label3.setBorder(BorderFactory.createEtchedBorder());

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            action = 1;
            button1.setEnabled(false);
            buttonpressed = true;
        }
        if (e.getSource() == button2) {
            action = 2;
            button2.setEnabled(false);
            buttonpressed = true;
        }
        if (e.getSource() == button3) {
            action = 3;
            button3.setEnabled(false);
            buttonpressed = true;
        }
        if (e.getSource() == button4) {
            dice();
            button4.setEnabled(false);
            buttonpressed = true;
        }
        if (e.getSource() == option_button1) {  // weapon
            weapon_action = option_button1.getSelectedIndex();
            option_button1.setEnabled(false);
            buttonpressed = true;

        }
        if (e.getSource() == option_button2) {  // number 
            number_action = option_button2.getSelectedIndex();
            option_button2.setEnabled(false);
            buttonpressed = true;

        }
        if (e.getSource() == option_button3) { // item
            item_action = option_button3.getSelectedIndex();
            option_button3.setEnabled(false);
            buttonpressed = true;
        }

        if (e.getSource() == button_label3) { // item
            dice = 100;
            option_button3.setEnabled(false);
            buttonpressed = true;
        }
    }

    public void delay() {
        try {
            if (!buttonpressed) {
                Thread.sleep(2000);
                delay();
            } else;
//                 buttonpressed=false;
        } catch (InterruptedException x) {
        }
    }

    public void window() {
        
        ImageIcon konoha = new ImageIcon("konoha_logo.jpg");
        frame.setLayout(null);
        frame.setTitle("Monopoly");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(konoha.getImage());
        frame.setResizable(true);
        frame.setSize(1350, 730);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void button() {

        button_label1.setIcon(image1);
        button_label1.setBackground(Color.red);
        button_label1.setBorder(border);
        button_label1.setVerticalAlignment(JLabel.CENTER);
        button_label1.setHorizontalAlignment(JLabel.CENTER);
        button_label1.setBounds(0, 0, 700, 700); // set position 
        // text box

        button_label2.setBorder(borderred);
        button_label2.setVerticalAlignment(JLabel.CENTER);
        button_label2.setHorizontalAlignment(JLabel.CENTER);
        button_label2.setBounds(701, 0, 580, 200); // set position 

        ImageIcon image1 = new ImageIcon("naruto.jpeg");
        label1 = new JLabel();
        label1.setBackground(Color.red);
        label1.setBorder(border);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setOpaque(true);

        ImageIcon image2 = new ImageIcon("sasuke.jpg");
        label2 = new JLabel();
        label2.setBackground(Color.blue);
        label2.setBorder(border);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setOpaque(true);

        ImageIcon image3 = new ImageIcon("pain.jpg");
        label3 = new JLabel();
        label3.setBackground(Color.green);
        label3.setBorder(border);
        label3.setVerticalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.yellow);
        ImageIcon image4 = new ImageIcon("madara.jpg");
        label4 = new JLabel();
        label4.setBackground(Color.yellow);
        label4.setBorder(border);
        label4.setVerticalAlignment(JLabel.CENTER);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label4.setOpaque(true);

        //panel at side       
        JPanel whitepanel1 = new JPanel();
        JPanel whitepanel2 = new JPanel();
        JPanel whitepanel3 = new JPanel();
        whitepanel1.setBackground(Color.white);
        whitepanel2.setBackground(Color.white);
        whitepanel3.setBackground(Color.white);
        whitepanel1.setBounds(700, 270, 150, 170);
        whitepanel2.setBounds(860, 270, 150, 170);
        whitepanel3.setBounds(1020, 270, 150, 170);
        // add small image to panel

        text1.setVerticalAlignment(JLabel.CENTER);
        text2.setVerticalAlignment(JLabel.CENTER);
        text3.setVerticalAlignment(JLabel.CENTER);
        text1.setHorizontalAlignment(JLabel.CENTER);
        text2.setHorizontalAlignment(JLabel.CENTER);
        text3.setHorizontalAlignment(JLabel.CENTER);

        whitepanel1.add(text1);
        whitepanel2.add(text2);
        whitepanel3.add(text3);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
//        frame.add(redpanel);
//        frame.add(bluepanel);
//        frame.add(greenpanel);
//        frame.add(yellowpanel);
        frame.add(option_button2);
        frame.add(button4);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(option_button1);
        frame.add(option_button3);

        frame.add(whitepanel1);
        frame.add(whitepanel2);
        frame.add(whitepanel3);

        frame.add(button_label1);
        frame.add(button_label2);
        frame.add(button_label3);
//        frame.removeAll
//        frame.revalidate();
//        frame.repaint();
    }

    public void check() {
        for (int i = 0; i < 4; i++) {
            player_text[i] = "";
            statistic_player(i);
        }
        statistic_monster(3);
        if (condition.equals("shop_weapon") || condition.equals("PVP_weapon") || condition.equals("PVM_weapon")) {
            enable = true;
        }
        option_button1.setEnabled(enable);
        enable = false;
        if (condition.equals("start") || condition.equals("PVM_number") || condition.equals("shop") || condition.equals("empty")) {
            enable = true;
        }
        option_button2.setEnabled(enable);
        enable = false;
        if (condition.equals("shop_item") || condition.equals("PVP_item") || condition.equals("PVM_item") || condition.equals("empty_item")) {
            enable = true;
        }
        option_button3.setEnabled(enable);
        enable = false;
        if (condition.equals("PVP") || condition.equals("PVM")) {
            enable = true;
        }
        button1.setEnabled(enable);
        enable = false;
        if (condition.equals("PVP") || condition.equals("PVM")) {
            enable = true;
        }
        button2.setEnabled(enable);
        enable = false;
        if (condition.equals("PVM")) {
            enable = true;
        }
        button3.setEnabled(enable);
        enable = false;
        if (condition.equals("DICE") || condition.equals("determineTurn")) {
            button4.setEnabled(true);
            button_label3.setEnabled(true);
        } else {
            button4.setEnabled(false);
            button_label3.setEnabled(false);
        }
        enable = false;

        if (!condition.equals("start")) {
            for (int i = 0; i < number_player; i++) {
                if (A[i][3] <= 0) {
                    continue;
                }
                if (player_name[i].equals("Naruto")) {
                    label1.setBounds((590 + (x[i] * -65)), (595 + (y[i] * -69)), 22, 22);
                } else if (player_name[i].equals("Sasuke")) {
                    label2.setBounds((610 + (x[i] * -65)), (595 + (y[i] * -69)), 22, 22);
                } else if (player_name[i].equals("Pain")) {
                    label3.setBounds((590 + (x[i] * -65)), (620 + (y[i] * -69)), 22, 22);
                } else if (player_name[i].equals("Madara")) {
                    label4.setBounds((610 + (x[i] * -65)), (620 + (y[i] * -69)), 22, 22);
                }
            }
        }
        for (int i = 0; i < number_player; i++) {
            statistic_player(i);
            if (player_name[i].equals("Naruto")) {
                redtext1.setBounds(0, 0, 50, 50);
                redtext1.setText("<html>" + player_text[i] + "</html>");
                player_text[i] = "";
            }

            if (player_name[i].equals("Sasuke")) {

                bluetext1.setBounds(0, 0, 50, 50);
                bluetext1.setText("<html>" + player_text[i] + "</html>");
                player_text[i] = "";
            }

            if (player_name[i].equals("Pain")) {

                greentext1.setBounds(0, 0, 50, 50);
                greentext1.setText("<html>" + player_text[i] + "</html>");
                player_text[i] = "";
            }

            if (player_name[i].equals("Madara")) {

                yellowtext1.setBounds(0, 0, 50, 50);
                yellowtext1.setText("<html>" + player_text[i] + "</html>");
                player_text[i] = "";
            }
        }
        text1.setBounds(500, 290, 1000, 700);
        text2.setBounds(500, -180, 700, 700);
        text3.setBounds(500, 0, 700, 700);
        text1.setText("<html>" + monster_text[0] + "</html>");
        text2.setText("<html>" + monster_text[1] + "</html>");
        text3.setText("<html>" + monster_text[2] + "</html>");
        if (!condition.equals("start")) {
            for (int i = 0; i < 4; i++) {
                if (A[i][3] <= 0) {
                    if (player_name[i].equals("Naruto")) {
                        frame.remove(label1);
                    }
                    if (player_name[i].equals("Sasuke")) {
                        frame.remove(label2);
                    }
                    if (player_name[i].equals("Pain")) {
                        frame.remove(label3);
                    }
                    if (player_name[i].equals("Madara")) {
                        frame.remove(label4);
                    }
                }
            }
        }
    }
    Clip clip;

    public void playMusic(String musicLocation) {

        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        clip.close();
    }

    public void getMadara() throws IOException {
        Desktop.getDesktop().open(new File("madara end games.mp4"));
    }

    public void getNaruto() throws IOException {
        Desktop.getDesktop().open(new File("naruto end games.mp4"));
    }

    public void getSasuke() throws IOException {
        Desktop.getDesktop().open(new File("sasuke end games.mp4"));
    }

    public void getPain() throws IOException {
        Desktop.getDesktop().open(new File("pain end games.mp4"));
    }
}