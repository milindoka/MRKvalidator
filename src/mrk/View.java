package mrk;


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class View {
      
    private JFrame frame;
    private JLabel label;
    private JButton buttonValidate;
    private JProgressBar jb;
    private JTextField DivField;
    private JTextField ExamField;
    private JTextField SubField;
    private JButton btnNewButton;
    private JLabel lblNewLabel;
    private JLabel Status;

    
    public View(String text){
        frame = new JFrame("MRKvalidator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(300,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        
        jb=new JProgressBar(0,100);    
        jb.setBounds(40,40,160,30);         
        jb.setValue(0);    
        jb.setStringPainted(true);    
        
        frame.getContentPane().add(jb);    
        
        lblNewLabel = new JLabel("New label");
        frame.getContentPane().add(lblNewLabel);
        
        DivField = new JTextField();
        frame.getContentPane().add(DivField);
        DivField.setColumns(10);
        
        ExamField = new JTextField();
        frame.getContentPane().add(ExamField);
        ExamField.setColumns(10);
        
        SubField = new JTextField();
        frame.getContentPane().add(SubField);
        SubField.setColumns(10);

        
        
        label = new JLabel(text);
        frame.getContentPane().add(label);
        
        Status = new JLabel("Status");
        frame.getContentPane().add(Status);
        
        buttonValidate = new JButton("Validate");        
        frame.getContentPane().add(buttonValidate);   
        
        btnNewButton = new JButton("New button");
        frame.getContentPane().add(btnNewButton);
        
        
        
    }
        
    public JButton getButton(){
        return buttonValidate;
    }
    
    
    public void setProgressBarPercent(int percent)
    {
      
        jb.setValue(percent);
    }
    public void UpdateFromModel(String fnem,String Division,String Examination,String Subject)
    {
    	label.setText(fnem);
    	DivField.setText(Division);
    	ExamField.setText(Examination);
    	SubField.setText(Subject);
    	
    }
    
    public void SetUpperBound(int bound)
    {
    	jb.setMaximum(bound);
    }
    
}