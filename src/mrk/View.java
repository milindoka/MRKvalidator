package mrk;


import javax.swing.*;

import java.awt.BorderLayout;

public class View {
      
    private JFrame frame;
    private JLabel label;
    private JButton buttonValidate;
    private JProgressBar jb;

    
    public View(String text){
        frame = new JFrame("View");                                    
        frame.getContentPane().setLayout(new BorderLayout());                                          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(250,150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        jb=new JProgressBar(0,100);    
        jb.setBounds(40,40,160,30);         
        jb.setValue(0);    
        jb.setStringPainted(true);    
        
        frame.getContentPane().add(jb,BorderLayout.NORTH);    

        
        
        label = new JLabel(text);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        
        buttonValidate = new JButton("Validate");        
        frame.getContentPane().add(buttonValidate, BorderLayout.SOUTH);   
        
        
        
    }
        
    public JButton getButton(){
        return buttonValidate;
    }
    
    public void setText(int percent){
        //label.setText(text);
        jb.setValue(percent);
    }
    
    
}