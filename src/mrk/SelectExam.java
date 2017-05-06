package mrk;


import java.util.ArrayList;
import java.util.prefs.Preferences;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SelectExam 
{
   SelectExam() {};

	String ExamName;
   
	public void SavePreferences()
	{Preferences prefs = Preferences.userNodeForPackage(mrk.SelectExam.class);

	// Preference key name
	final String PREF_NAME = "ExamPref";
	// Set the value of the preference
	prefs.put(PREF_NAME, ExamName);
		
	}


	public  void LoadPreferences()
	{Preferences prefs = Preferences.userNodeForPackage(mrk.SelectExam.class);

	// Preference key name
	final String PREF_NAME = "ExamPref";
	ExamName= prefs.get(PREF_NAME,ExamName); // "a string"
	
	}

	
	public String GetExam(){ return ExamName; }
	
	public String SelectExam()
    {   LoadPreferences();
    	//show(PrinterName);
    	ButtonGroup group = new ButtonGroup();
        ArrayList<String> ExamNames = new ArrayList<String>(); 
    	
            ExamNames.add("U1");
            ExamNames.add("T1");
            ExamNames.add("U2");
            ExamNames.add("U2");
               
    	    	
    	JRadioButton buttons[] = new JRadioButton[ExamNames.size()];
    	
    	for (int i = 0; i < buttons.length; ++i)
    	{
    		buttons[i] = new JRadioButton(ExamNames.get(i));
    	 //   btn.addActionListener(this);
    	    group.add(buttons[i]);
    	    //buttons[i] = btn;
    	}
    	
        int res = JOptionPane.showConfirmDialog(null, buttons, "Select Current Exam", 
                JOptionPane.OK_CANCEL_OPTION);

        if (res == JOptionPane.OK_OPTION)
              { for(int i=0;i<ExamNames.size();i++) 
            	  if(buttons[i].isSelected()) { ExamName=ExamNames.get(i);
            	                                SavePreferences();}
              }

        return ExamName;
    }


}
