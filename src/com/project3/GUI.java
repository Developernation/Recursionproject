package com.project3;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;



/*
**********************************************************************************************************
Author: Greg Lane
Date: 09/26/16
Project: project 3 - Recursion
**********************************************************************************************************
 */




public class GUI extends JFrame {

        // Build all objects for the GUI
    private JOptionPane the_Frame = new JOptionPane();
    private JLabel enterNum = new JLabel("Enter Your Number Here");
    private JLabel results = new JLabel("Result: ");
    private JLabel Efficieny = new JLabel("Efficiency: ");
    private JRadioButton rButIterative = new JRadioButton("Iterative");
    private JRadioButton rButRecursive = new JRadioButton("Recursive");
    private JTextField eOutput = new JTextField("");
    private JTextField rOutput = new JTextField("");
    private JTextField input = new JTextField("");
    private JButton compute = new JButton("Compute");
    private ButtonGroup radioGroup = new ButtonGroup();
    private JLabel label = new JLabel("");
        // End of GUI objects



    // Build vars to write file to csv


    private static FileWriter Write;
    private File csvLog = new File("log.csv");

    // end of file vars

    private int eVal; // Value for to enter

    // display
    public void display(){
        setVisible(true);
    }


    // setup the_frame
    private void setThe_Frame(int width, int height){
        setLocationRelativeTo(null);
        setSize(width, height);
    }


    public GUI(){
        super("Iterative & Recursion");

    }



















































    public static void main(String[] args) {
	// write your code here
    }
}