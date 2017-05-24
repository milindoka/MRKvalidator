package mrk;

import java.awt.Font;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class RollSubDialog 
{
	private String RollSubString;

	
	
	public String GetRollSubString() {return RollSubString;}
	
	public  void show(String msg)
	{JOptionPane.showMessageDialog(null, msg);}
	public  void show(int msg)
	{JOptionPane.showMessageDialog(null, msg);}

	public void show(long msg)
	{JOptionPane.showMessageDialog(null, msg);}

	public  String GetData(int row_index, int col_index)
	{ return (String) table.getModel().getValueAt(row_index, col_index); }
	
	Font TNR16=new Font("Times New Roman", Font.PLAIN, 14);


	
	 Object rows[][] = { 
	            { "A", "1-42","ENG-ECO-ORC-BKE-MAT-ITE" }, 
	            { "A", "44-62","ENG-ECO-ORC-BKE-SEP-HIN" }, 
	            { "A", "63-101","ENG-ECO-ORC-BKE-MAT-MAR" }
	            
	           };
	      Object cols[] = { "DIV", "ROLL","SUBJETS" };

	      DefaultTableModel model = new DefaultTableModel(rows, cols);
	    JTable table = new JTable(model);
	      // setFont(new Font("Serif", Font.BOLD, 20));  
	  
	    
	    RollSubDialog() ////CONSTRUCTOR
	    {
	    	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    	
	    	for(int i=0;i<30;i++)
	        dtm.addRow(new Object[]{"", "",""});	
	
	  // 	 table.setDefaultEditor(Object.class, new MyEditor());
		 table.setFont(TNR16);
		  
		 table.setRowHeight(20);
		 table.getColumnModel().getColumn(0).setMaxWidth(25);
		 table.getColumnModel().getColumn(1).setMaxWidth(90);
		 table.getColumnModel().getColumn(2).setMinWidth(120);
	
	    
	    
	    
	    };
	 
   
	public void SavePreferences()
	{Preferences prefs = Preferences.userNodeForPackage(mrk.RollSubDialog.class);

	// Preference key name
	final String PREF_NAME = "ExamPref";
	// Set the value of the preference
	prefs.put(PREF_NAME, RollSubString);
		
	}


	public  void LoadPreferences()
	{Preferences prefs = Preferences.userNodeForPackage(mrk.RollSubDialog.class);

	// Preference key name
	final String PREF_NAME = "ExamPref";
	RollSubString= prefs.get(PREF_NAME,RollSubString); // "a string"
	
	}

	
	public String GetRollSubjectString(){ return RollSubString; }
	
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
        	if (table.isEditing())
			    table.getCellEditor().stopCellEditing();
        	 
        	   ///Above statement takes care of refreshing last focused cell 
        	  
        	 
        	   SaveRollSubjects();   ///as string
        	//   show(RollSubString);
        	   return RollSubString;
              }
        else     
        return "Cancel";
       
    }


	public void SaveRollSubjects()
	{ 
	  int i,j;
	  RollSubString="";
	  int totalrows=table.getRowCount();
	  String div=GetData(0,0);
	  if(div.length()!=1) { RollSubString="Error"; return; }
	  RollSubString+=GetData(0,0)+"="+GetData(0,1)+"="+GetData(0,2);
	  for( i=1;i<totalrows;i++)
	  {   div=GetData(i,0);
	      if(div.length()!=1) continue;
		  RollSubString+="#";
		  RollSubString+=div+"="+GetData(i,1)+"="+GetData(i,2);
	  }
	
	
	}
/*	

////Inner Class For Forced Uppercase	
	class MyEditor extends DefaultCellEditor {
		  public MyEditor() 
		  {
		    super(new JTextField());
		  }

		  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
		      int row, int column) {
		    JTextField editor = (JTextField) super.getTableCellEditorComponent(table, value, isSelected,
		        row, column);

		    if (value != null)
		      editor.setText(value.toString().toUpperCase());
		  
		    return editor;
		  }
		}
	
/////end of inner class	
	
	*/
	
}



