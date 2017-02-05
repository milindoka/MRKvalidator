package mrk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller {

    private Model model;
    private View view;
    private ActionListener actionListener;
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
         view.SetUpperBound(TotalFiles-1);
	     System.out.println(JarFilePath);
         System.out.println(TotalFiles);
         
    }
    
    public void LinkViewControls()
    {        
        actionListener = new ActionListener()
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
                  OnButtonValidate();
              }
        };                
        view.getButton().addActionListener(actionListener);   
    }
    
    
    private void OnButtonValidate()
    {   int currentfileindex=model.getX();
        if(currentfileindex<TotalFiles) Validate(currentfileindex);
        else model.setX(0);  ////back to start
    }
    
    private void Validate(int currentfileindex)
    {
     model.LoadMarkListFileToStrArray(currentfileindex);
     model.ExtractAllHeaderFields(); ///Div, Exam, Sub, Examiner
     model.CheckOneTwoThreeFormat();
     view.UpdateFromModel(model.getFnem(currentfileindex),model.getDiv(),model.getExam(),model.getSub());
     view.setProgressBarPercent(currentfileindex);
     model.incX();
     	
    }
}