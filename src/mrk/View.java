package mrk;


import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View {
      
    private JFrame frame;
    private JLabel FileNameLabel;
    private JButton btnStart;
    private JProgressBar jb;
    private JTextField DivField;
    private JTextField ExamField;
    private JTextField SubField;
    private JButton btnContinue;
    private JButton btnSetExam;
    private JButton btnSetRollSubjects;
    
  //  private JLabel BlankLabel1;
    private JLabel Status;
    private JPanel barpanel;
    private Font MyFont;
    private SelectExam se;
    private String ExamName;
    public View(String text)
    {
        frame = new JFrame("MRKvalidator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(500,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        
        jb=new JProgressBar(0,100);    
       Border border = BorderFactory.createTitledBorder("Progress...");
       
       barpanel=new JPanel(new BorderLayout());
       
       barpanel.setSize(200,100);
       jb.setBorder(border);
       
      // jb.setBounds(0,80,480,90);   
             jb.setValue(0);    
        jb.setStringPainted(true);    
       
        barpanel.add(jb,BorderLayout.NORTH);
     //   BlankLabel1 = new JLabel("1 ");
   //     barpanel.add(BlankLabel1,BorderLayout.SOUTH);
        
        frame.getContentPane().add(barpanel);    
        
       
       
        //frame.getContentPane().add(BlankLabel1);
        MyFont = new Font("Liberation Serif", Font.PLAIN,40);
        
        DivField = new JTextField();
        DivField.setFont(MyFont);
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
        ExamField.setFont(MyFont);
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
        SubField.setFont(MyFont);
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
        
        btnStart = new JButton("Start Validation");        
        frame.getContentPane().add(btnStart);
        
        
        btnSetExam = new JButton("Set Exam Name");
        frame.getContentPane().add(btnSetExam);
        //btnSetExam.setVisible(false);
        
        btnSetRollSubjects = new JButton("Set Roll and Subjects");
        frame.getContentPane().add(btnSetRollSubjects);
        
       //JDialog d= new FirstDialog(frame);
       se=new SelectExam(); 
       se.LoadPreferences();
       ExamName=se.GetExam();
      //  ExamName=se.SelectExam();
       frame.setTitle(ExamName);
        
    }   ///end of view constructor

    
    public void SelectExam()
    {ExamName=se.SelectExam();
     se.SavePreferences();
    frame.setTitle(ExamName);	
    }
    
    
    public String getDivision() {return DivField.getText();}
    public String getExam() {return ExamField.getText();}
    public String getSubject() {return SubField.getText();}
    
    
    public JButton getValidateButton(){
        return btnStart;
    }
    
    public JButton getContinueButton(){
        return btnContinue;
    }
    
    public JButton getSetExamButton()
    {
        return btnSetExam;
    }
    
    public JButton getSetRollSubjectButton()
    {
        return btnSetRollSubjects;
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
	 btnStart.setVisible(!bval);
		
	}
    
}