package mrk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller {

    private Model model;
    private View view;
    private ActionListener onbtnValidate,onbtnContinue;
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
         String JarFilePath=model.getJarPath();
	     TotalFiles=model.GetAllFiles(JarFilePath);
         view.SetProgressBarUpperBound(TotalFiles-1);
	     System.out.println(JarFilePath);
         System.out.println(TotalFiles);
         
    }
    
    public void LinkViewControls()
    {        
        onbtnValidate = new ActionListener()
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
                  OnButtonValidate();
              }
        };                
        view.getValidateButton().addActionListener(onbtnValidate);   
        
        onbtnContinue = new ActionListener()
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
                  OnButtonContinue();
              }
        };                
        view.getContinueButton().addActionListener(onbtnContinue);   
        
        
    }
    
    
    private void OnButtonContinue()
    {String div,exa,sub;
     div=view.getDivision();
     exa=view.getExam();
     sub=view.getSubject();
     model.setThreeValues(div, exa, sub);	
     if(model.InOneTwoThreeFormat()) {model.incX(); OnButtonValidate();}
     
    }
    
    
    private void OnButtonValidate()
    {   int currentfileindex=model.getX();
        if(currentfileindex<TotalFiles) Validate(currentfileindex);
        else model.setX(0);  ////back to start
    }
    
    private void Validate(int currentfileindex)
    {String Status;
     model.LoadMarkListFileToStrArray(currentfileindex);
     model.ExtractAllHeaderFields(); ///Div, Exam, Sub, Examiner
     if(model.InOneTwoThreeFormat()) { Status="Status : Ok"; model.incX();}
     else Status="Status : Rectify and Continue";
     
     view.UpdateFromModel(model.getFnem(currentfileindex),model.getDiv(),model.getExam(),model.getSub(),Status);
     view.setProgressBarPercent(currentfileindex);
     	
    }
}