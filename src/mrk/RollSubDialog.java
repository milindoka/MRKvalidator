package mrk;

import java.util.prefs.Preferences;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class RollSubDialog 
{

	public  void show(String msg)
	{JOptionPane.showMessageDialog(null, msg);}
	public  void show(int msg)
	{JOptionPane.showMessageDialog(null, msg);}

	public void show(long msg)
	{JOptionPane.showMessageDialog(null, msg);}

	public  String GetData(int row_index, int col_index)
	{ return (String) table.getModel().getValueAt(row_index, col_index); }
	
	RollSubDialog() {};

	String RollSubList;
	
	 Object rows[][] = { 
	            { "A", "1-42","ENG-ECO-ORC-BKE-MAT-ITE" }, 
	            { "A", "44-62","ENG-ECO-ORC-BKE-SEP-HIN" }, 
	            { "A", "63-101","ENG-ECO-ORC-BKE-MAT-MAR" },
	            { "A", "102-120","ENG-ECO-ORC-BKE-MAT-HIN" },
	            
	            	            { "A", "44-62","ENG-ECO-ORC-BKE-SEP-HIN" }, 
	            { "A", "63-101","ENG-ECO-ORC-BKE-MAT-MAR" },
	            { "A", "102-120","ENG-ECO-ORC-BKE-MAT-HIN" }
	            
	           };
	      Object cols[] = { "DIV", "ROLL","SUBJETS" };

	    JTable table = new JTable(rows, cols);

	
	
   
	public void SavePreferences()
	{Preferences prefs = Preferences.userNodeForPackage(mrk.RollSubDialog.class);

	// Preference key name
	final String PREF_NAME = "ExamPref";
	// Set the value of the preference
	prefs.put(PREF_NAME, RollSubList);
		
	}


	public  void LoadPreferences()
	{Preferences prefs = Preferences.userNodeForPackage(mrk.RollSubDialog.class);

	// Preference key name
	final String PREF_NAME = "ExamPref";
	RollSubList= prefs.get(PREF_NAME,RollSubList); // "a string"
	
	}

	
	public String GetRollSubjectString(){ return RollSubList; }
	
	public String SetRollSubjects()
    {   //LoadPreferences();
    	//show(PrinterName);
    
		 
	    Object[] options = {"Save",
	    "Cancel"};
	       int n = JOptionPane.showOptionDialog(null,
			new JScrollPane(table),         ///JTable as Message 
	       "Enter Roll and Subject Scheme", ///Message Window Title
	      JOptionPane.YES_NO_OPTION,
	      JOptionPane.PLAIN_MESSAGE,    	///do not use default icon
	      null,     						///do not use a custom Icon
	      options,  						///the titles of buttons
	      options[0]); 						///default button title
		
		
		
		
        if (n == JOptionPane.OK_OPTION)
              {
        	  // show("Save");
        	   RollSubList=GetData(2,2);
              }
        else show("cancel");

        return RollSubList;
    }


}
