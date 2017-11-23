package mrk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import mrk.ValidateList.IntPair;

public class ValidateList
{    int FirstRoll;
	 int LastRoll;
	 
	 ////Scheme table variables 
	 //// filled by setparameters
	 
	 private ArrayList<String>  Div = new ArrayList<String>();
	 private ArrayList<Integer> Left = new ArrayList<Integer>();
	 private ArrayList<Integer> Right = new ArrayList<Integer>();
	 private ArrayList<String>  Subjects = new ArrayList<String>();
	 
	 HashMap<Character, IntPair> cs = new HashMap<Character, IntPair>();
	 
	 
	 
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
	
	  
	//Set<String> UniqueDivs; 
	//  UniqueDivs = new HashSet<>(Div);
	//System.out.println(UniqueDivs); 
	  
	//  for(char c='A';c<='Z';c++)
		  
	/*  
	  
	  
	  for(i=0;i<Div.size();i++)
		  {System.out.println(Div.get(i));
		  System.out.println(Left.get(i));
		  System.out.println(Right.get(i));
		  System.out.println(Subjects.get(i));
		  }
		  
		*/
	  
	  for(char c='A';c<='Z';c++)
	  {for(i=0;i<Div.size();i++)
	       {
		     if(Div.get(i).indexOf(c)>=0) 
		    { ///c ontains in Div, hence equal strings
		    	IntPair temp=cs.get(c) ;
		    	if(temp!=null) 
		    	{
	    	      IntPair ep=new IntPair();//= new IntPair();
		          ep.Set(temp.getx(),Right.get(i));
		          cs.put(c,ep);
		    	}
		    	else 
		    	{ IntPair ep=new IntPair();//= new IntPair();
		    	  ep.Set(Left.get(i),Right.get(i));
		    	  cs.put(c,ep);
		    	}
		      
		    }
	       }
	  }
	    
	    // Get a set of the entries
	      Set set = cs.entrySet();
	      
	      // Get an iterator
	      Iterator i1 = set.iterator();
	      
	      // Display elements
	      while(i1.hasNext()) {
	         Map.Entry me = (Map.Entry)i1.next();
	         System.out.print(me.getKey() + ": ");
	         IntPair pp=(IntPair) me.getValue();
	         System.out.println(pp.x);
	         System.out.println(pp.y);
	      }
	      
	      IntPair testpair=new IntPair();//= new IntPair();
	      testpair=(IntPair) cs.get('A');
	      System.out.println(testpair.x);
	      System.out.println(testpair.y);
	
	 }
	 
	
	
	 
	 public String ValidateArray(ArrayList<String> Arr)
	    {  String Error="";
		  // Roll and Marks separated by ":"
		  // Return Error message such as First and Last Roll Do not Match
		 
		 
		 return Error;
		}
	////////////////////
	 
	 class IntPair 
	 {
		  
		   int x;
		   int y;
		  //IntPair(int x, int y) {this.x=x;this.y=y;}
		  void Set(int x,int y) {this.x=x;this.y=y;}
		  int getx(){ return x;}
		  int gety(){ return y;}
		  
		  
	}
	 
	 
}


