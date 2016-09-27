package com.project3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;



/*
**********************************************************************************************************
Author: Greg Lane
Date: 09/26/16
Project: project 3 - Program that calculates recursively or iteratively then logs to a csv file
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


    private static FileWriter Writer;
    private File csvLog = new File("project3.csv");

    // end of file vars
    private ArrayList<String> log = new ArrayList<>();

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



    // Get, set and clear methods

    public int getValue(){
        try{
            return Integer.parseInt(input.getText());


        }
        catch (NumberFormatException x){
            clearValue();
            return 11;

        }
    }

    public void  clearValue(){
        input.setText("");
    }

    public void setValue(){
        this.eVal = getValue();
    }



    // Action listener and Window adapter

    class ComputeButton implements ActionListener{
        @Override

        public void actionPerformed(ActionEvent e){
            setValue();
            if (eVal > 10 || eVal < 0){
                JOptionPane.showMessageDialog(the_Frame, "Number entered is invalid, please try again :)");
            } else if (rButIterative.isSelected()){
                rOutput.setText(String.valueOf(Sequence.iterative(eVal)));
                eOutput.setText(String.valueOf(Sequence.efficincy()));
                log.add("Iterative" + ", " + Sequence.efficincy() + ", " + eVal);
                // CODE SEQUENCE CLASS BEFORE CONTINUING;
            } else if (rButRecursive.isSelected()){
                rOutput.setText(String.valueOf(Sequence.recursion(eVal)));
                eOutput.setText(String.valueOf((Sequence.efficincy())));
                log.add("Recursive" + ", " + Sequence.efficincy() + ", " + eVal);
            }
            clearValue();
        }
    }

    class CloseApplication extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){

            try{
                if(log.isEmpty() == false){
                    Writer = new FileWriter(csvLog);
                    for (String l : log) {
                        Writer.write(l + System.getProperty("line.separator"));
                    }

                    Writer.close();
                }
            }
            catch(IOException x){
                System.out.println("Caught IOException: " + x.getMessage() + "When trying to write to csv");
                System.exit(0);

            }
            System.exit(0);
        }
    }


    public GUI(){ // Builds the actual GUI and adds everything
        super("Iterative & Recursion");
        setThe_Frame(350,250);
        setResizable(false);
        JPanel mPan = new JPanel();
        add(mPan);
        mPan.setLayout(new GridLayout(5,2,0,10));
        radioGroup.add(rButIterative);
        radioGroup.add(rButRecursive);
        rButIterative.setSelected(true);
        mPan.add(rButIterative);
        mPan.add(rButRecursive);
        mPan.add(enterNum);
        mPan.add(input);
        mPan.add(label);
        mPan.add(compute);
        mPan.add(results);
        mPan.add(rOutput);
        mPan.add(Efficieny);
        mPan.add(eOutput);
        CloseApplication closeWin = new CloseApplication();
        compute.addActionListener(new ComputeButton());
        addWindowListener(closeWin);


    }



    // Main

    public static void main(String[] args) {
	// write your code here
        GUI theApp = new GUI();
        theApp.display();
    }
}
