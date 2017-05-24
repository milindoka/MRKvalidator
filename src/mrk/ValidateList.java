package mrk;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ValidateList
{    int FirstRoll;
	 int LastRoll;
	 private ArrayList<String>  Div = new ArrayList<String>();
	 private ArrayList<Integer> Left = new ArrayList<Integer>();
	 private ArrayList<Integer> Right = new ArrayList<Integer>();
	 private ArrayList<String>  Subjects = new ArrayList<String>();
	 
	
	 
	 
	 
	 
	 void SetParameters(String pref)
	 {	 String temp1[],temp2[],temp3[];
	     Div.removeAll(Div);
	     Left.removeAll(Left);
	     Right.removeAll(Right);
	     Subjects.removeAll(Subjects);
	  
	  int i;
	  if(!pref.contains("#")) return; //if empty or no #
	  temp1=pref.split("#");
	  for(i=0;i<temp1.length;i++)
	  { temp2=temp1[i].split("=");
	    if(temp2.length!=3) { return; }
	    Div.add(temp2[0]);
	    temp3=temp2[1].split("-");
	    Left.add(Integer.parseInt(temp3[0].replaceAll("[^0-9.]","")));
	    Right.add(Integer.parseInt(temp3[1].replaceAll("[^0-9.]","")));
	    Subjects.add(temp2[2]);
	   } 
	
	  for(i=0;i<Div.size();i++)
		  {System.out.println(Div.get(i));
		  System.out.println(Left.get(i));
		  System.out.println(Right.get(i));
		  System.out.println(Subjects.get(i));
		  
		  
		  }
		
	 }
	 
	
	 
	 
	 public String ValidateArray(ArrayList<String> Arr)
	    {  String Error="";
		  // Roll and Marks separated by ":"
		  // Return Error message such as First and Last Roll Do not Match
		 
		 
		 return Error;
		}
		
	 
	 
}


