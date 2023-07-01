/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demo;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author buidu
 */
public class Demo extends Frame{
    Button btnLmao;
    Label lblResult = new Label("Rélut");
    public Demo(){
        setTitle("Lala");
        setSize(300,100);
        setLocationRelativeTo(null);
        btnLmao = new Button("red");
        add(new Button("Lmao"));
        add(btnLmao);
        setLayout(new FlowLayout());
        add(lblResult);
        btnLmao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblResult.setText("red");
                setBackground(Color.yellow);
            }
        });
    }
}
