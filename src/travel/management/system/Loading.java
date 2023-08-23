package travel.management.system;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    Connection conn;
    int s;
    JProgressBar progressbar;
    JPanel contentPane;
    String username;
    
    public void run() {
        try{
            for(int i = 1; i <= 101; i++){
                int max = progressbar.getMaximum();
                int value = progressbar.getValue();
                
                if(value < max) {        //101<100
                    progressbar.setValue(progressbar.getValue() + 1);
                } else {
                   
                    setVisible(false);
                  new Dashboard(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    Loading(String username){
        this.username = username;
        t = new Thread(this);
        
    setBounds(500,200,650,400);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel text = new JLabel("Travel and Tourism Application");
    text.setBounds(50, 20   , 600, 40);
    text.setForeground(Color.BLUE);
    text.setFont(new Font("Raleway", Font.BOLD,35));
    add(text);
    
    progressbar = new JProgressBar();
    progressbar.setBounds(150, 100, 300, 35);
    progressbar.setStringPainted(true);
    add(progressbar);
    
     JLabel loading = new JLabel("Please wait...");
    loading.setBounds(230, 130   , 150, 30);
    loading.setForeground(Color.RED);
    loading.setFont(new Font("Raleway", Font.BOLD,16));
    add(loading);
    
     JLabel lblusername = new JLabel("Welcome " +username);
    lblusername.setBounds(20, 310   , 400, 40);
    lblusername.setForeground(Color.RED);
    lblusername.setFont(new Font("Raleway", Font.BOLD,16));
    add(lblusername);
    
    t.start();
    setVisible(true);
    }
    
    public static void main(String[] args){
        new Loading("").setVisible(true); 
    }
}
