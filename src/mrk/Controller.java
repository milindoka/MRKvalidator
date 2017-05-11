package mrk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;

public class Controller {

    private Model model;
    private View view;
    private ActionListener onbtnStart,onbtnContinue,onbtnSetExam,onbtnSetRollSubjects;
    private int TotalFiles=0;
    
    
///////////////Temp Functions For Debugging    
    public void show(String msg) ///for debugging
	{JOptionPane.showMessageDialog(null, msg);}
    
    public void show(int msg)
	{JOptionPane.showMessageDialog(null, msg);}

//////////////////////////////////////////////////
    
    
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
         //String JarFilePath=model.getJarPath();
	   
	     //System.out.println(JarFilePath);
         //System.out.println(TotalFiles);

        
    }
    
    
    final Timer timer = new Timer(500, new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        	 
        	 OnButtonValidate();
        }
    });


    
    public void LinkViewControls() /// this is called once in constructor of Main
    {        
        onbtnStart = new ActionListener()
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {   model.setX(0);  ////Start from index 0
                  TotalFiles=model.GetAllFiles();
                  view.SetProgressBarUpperBound(TotalFiles-1);  
                  view.ShowContinueButton(false);
                  
                  timer.start();
                  view.getValidateButton().setVisible(false);
                  
              }
        };                
        view.getValidateButton().addActionListener(onbtnStart);  
        
        
        onbtnContinue = new ActionListener()
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
                  OnButtonContinue();
              }
        }; 
        
        view.getContinueButton().addActionListener(onbtnContinue);   
        
        onbtnSetExam = new ActionListener()
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
                  OnButtonSetExam();
              }
        }; 
        
        view.getSetExamButton().addActionListener(onbtnSetExam);
        
        
        
        onbtnSetRollSubjects = new ActionListener()
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
                  OnButtonSetRollSubjects();
              }
        }; 
        
        view.getSetRollSubjectButton().addActionListener(onbtnSetRollSubjects);
        
        
        
    } ////end of LinkView Controls
    
    
    private void OnButtonSetRollSubjects()
    { RollSubDialog rsd=new RollSubDialog();
      String temp=rsd.SetRollSubjects();
      
      show(temp);
    }
    
    
    
    private void OnButtonSetExam()
    {view.SelectExam();
    	
    }
    
    
    private void OnButtonContinue()
    {String div,exa,sub;
     div=view.getDivision();
     exa=view.getExam();
     sub=view.getSubject();
     model.setThreeValues(div, exa, sub);	
     if(model.InOneTwoThreeFormat()) 
      {  try {
		model.SaveList();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//save corrected list
    	 
    	 model.incX();
    	 view.ShowContinueButton(false);
    	
         timer.start();
     
    }
    
    } 
    private void OnButtonValidate()
    {   int currentfileindex=model.getX();
        if(currentfileindex<TotalFiles) Validate(currentfileindex);
        else{ model.setX(0);  ////back to start
              TotalFiles=model.GetAllFiles();
               view.SetProgressBarUpperBound(TotalFiles-1);
               view.getValidateButton().setVisible(true);
               timer.stop();
             }
    }
    
    private void Validate(int currentfileindex)
    {String Status;
     model.LoadMarkListFileToStrArray(currentfileindex);
     model.ExtractAllHeaderFields(); ///Div, Exam, Sub, Examiner
     if(model.InOneTwoThreeFormat()) { Status="Status : Ok"; model.incX();}
     else { Status="Status : Rectify and Continue"; view.ShowContinueButton(true); timer.stop();}     
     view.UpdateFromModel(model.getFnem(currentfileindex),model.getDiv(),model.getExam(),model.getSub(),Status);
     view.setProgressBarPercent(currentfileindex);
     	
    }
}