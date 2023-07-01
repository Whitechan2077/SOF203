/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demo2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author buidu
 */
public class Demo2 extends JFrame {
    JButton btnRed = new JButton("Red");    
    public Demo2(){ 
        setTitle("lmao");
        setSize(1078,300);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel pn = new JPanel();
        pn.setVisible(true);
        pn.add(btnRed);
        btnRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.red);
            }
        });
    }
   public static void main(String[] args) {
       new Demo2().setVisible(true);
    } 
}
