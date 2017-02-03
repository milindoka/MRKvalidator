package mrk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controller {

    private Model model;
    private View view;
    private ActionListener actionListener;
    
    
    
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
	     int TotalFiles=model.GetAllFiles(JarFilePath);
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
    {
        model.incX();                
        view.setText(model.getX());
    }    
}