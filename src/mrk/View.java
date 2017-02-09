package mrk;


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View {
      
    private JFrame frame;
    private JLabel FileNameLabel;
    private JButton btnValidate;
    private JProgressBar jb;
    private JTextField DivField;
    private JTextField ExamField;
    private JTextField SubField;
    private JButton btnContinue;
    private JLabel BlankLabel1;
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
        
        BlankLabel1 = new JLabel(" ");
        frame.getContentPane().add(BlankLabel1);
        
        DivField = new JTextField();
        frame.getContentPane().add(DivField);
        DivField.setColumns(10);
        DivField.addKeyListener(new KeyAdapter()
        { public void keyTyped(KeyEvent e) {
	            char keyChar = e.getKeyChar();
	            if (Character.isLowerCase(keyChar)) {
	              e.setKeyChar(Character.toUpperCase(keyChar));
	            }
	          }
        });
        
        
        
        ExamField = new JTextField();
        frame.getContentPane().add(ExamField);
        ExamField.setColumns(10);
        ExamField.addKeyListener(new KeyAdapter()
        { public void keyTyped(KeyEvent e) {
	            char keyChar = e.getKeyChar();
	            if (Character.isLowerCase(keyChar)) {
	              e.setKeyChar(Character.toUpperCase(keyChar));
	            }
	          }
        });
        
        
        
        SubField = new JTextField();
        frame.getContentPane().add(SubField);
        SubField.setColumns(10);
        SubField.addKeyListener(new KeyAdapter()
        { public void keyTyped(KeyEvent e) {
	            char keyChar = e.getKeyChar();
	            if (Character.isLowerCase(keyChar)) {
	              e.setKeyChar(Character.toUpperCase(keyChar));
	            }
	          }
        });
        
        
        btnContinue = new JButton("Continue");
        frame.getContentPane().add(btnContinue);
        btnContinue.setVisible(false);
        
        
        FileNameLabel = new JLabel(" ");
        frame.getContentPane().add(FileNameLabel);
        
        Status = new JLabel("Status");
        frame.getContentPane().add(Status);
        
        btnValidate = new JButton("Validate");        
        frame.getContentPane().add(btnValidate);   
        
        
        
    }

    public String getDivision() {return DivField.getText();}
    public String getExam() {return ExamField.getText();}
    public String getSubject() {return SubField.getText();}
    
    
    public JButton getValidateButton(){
        return btnValidate;
    }
    
    public JButton getContinueButton(){
        return btnContinue;
    }
    
    
    public void setProgressBarPercent(int percent)
    {
      
        jb.setValue(percent);
    }
    public void UpdateFromModel(String fnem,String Division,String Examination,String Subject,String stetus)
    {
    	FileNameLabel.setText(fnem);
    	DivField.setText(Division);
    	ExamField.setText(Examination);
    	SubField.setText(Subject);
    	Status.setText(stetus);
    }
    
    public void SetProgressBarUpperBound(int bound)
    {
    	jb.setMaximum(bound);
    }

	public void ShowContinueButton(boolean bval) 
	{btnContinue.setVisible(bval);
		// TODO Auto-generated method stub
		
	}
    
}