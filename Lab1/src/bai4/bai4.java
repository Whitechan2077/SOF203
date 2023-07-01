/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author buidu
 */
public class bai4 {
        public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLocation(200, 200);
        f.setSize(400, 200);
        JPanel p = new JPanel(new GridLayout(3, 3));
        f.add(p);
        JButton btns [] = new JButton[9];
        for (int i = 0; i < 9; i++) {
            btns[i] = new JButton("btn "+i+1);
            p.add(btns[i]);
        }
        f.setVisible(true);
    }
}
