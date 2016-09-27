package com.project3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private File csvLog = new File("project3.csv");

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

    public int getValue(){
        try{
            return Integer.parseInt(enterNum.getText());


        }
        catch (NumberFormatException x){
            clearValue();
            return 11;

        }
    }

    public void  clearValue(){
        enterNum.setText("");
    }

    public void setValue(){
        this.eVal = getValue();
    }



    class ComputeButton implements ActionListener{
        @Override

        public void actionPerformed(ActionEvent e){
            setValue();
            if (eVal > 10 || eVal < 0){
                JOptionPane.showMessageDialog(the_Frame, "Number entered is invalid, please try again :)");
            } else if (rButIterative.isSelected()){
                rOutput.setText(String.valueOf(Sequence.iterative(eVal)));
                eOutput.setText(String.valueOf(Sequence.efficincy()));
                //add to csv
                // CODE SEQUENCE CLASS BEFORE CONTINUING;
            }
            clearValue();
        }
    }


    public GUI(){
        super("Iterative & Recursion");
        setThe_Frame(300,200);
        setResizable(false);
        JPanel mPan = new JPanel();
        add(mPan);
        mPan.setLayout(new GridLayout(4,1,0,9));
        radioGroup.add(rButIterative);
        radioGroup.add(rButRecursive);
        rButRecursive.setSelected(true);
        mPan.add(enterNum);
        mPan.add(input);
        mPan.add(label);
        mPan.add(compute);
        mPan.add(results);
        mPan.add(rOutput);
        mPan.add(Efficieny);
        mPan.add(eOutput);

        // ADD ACTIONLISTENERS


    }



















































    public static void main(String[] args) {
	// write your code here
    }
}
