package mrk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Model {
    private int TotalMarklists;
   
    private int x;
    private String JarFilepath;
    private ArrayList<String> pathArray = new ArrayList<String>(); //array containing full paths
    private ArrayList<String> nameArray = new ArrayList<String>(); //array containing file names only
    private ArrayList<String> strArray = new ArrayList<String>(); //array containing marklist data
    private ArrayList<String> rollArray=new ArrayList<String>();   //array Containg roll
    private ArrayList<String> markArray=new ArrayList<String>();   //array Containg roll
    
    private String DIV[]={"A","B","C","D","E","F","G","H","I","J","K","L"};
    private  String EXAM[]={"U1","T1","U2","T2"};
    private  String SUBJECT[]={"ENG","MAR","TAM","HIN","ITE","MAT","PHY","CHE","BIO","SEP","ECO","BKE","OCM","CS1","CS2","EL1","EL2","EVS","PTE",
                        	   "ENGOPP","MAROPP","TAMOPP","HINOPP","ITEOPP","MATOPP","PHYOPP","CHEOPP","BIOOPP","SEPOPP","ECOOPP","BKEOPP","OCMOPP","CS1OPP","CS2OPP","EL1OPP","EL2OPP"};
    
    private boolean FormatOk;
    
    private String Division,Examination, Subject, Examiner,Date,MaxMarks;

    
//////////Helper Functions ////////////////////////////////  
	public static void show(String msg)
	{JOptionPane.showMessageDialog(null, msg);}
	public static void show(int msg)
	{JOptionPane.showMessageDialog(null, msg);}
	
	public static void show(long msg)
	{JOptionPane.showMessageDialog(null, msg);}
//////////Helper Functions ///////////////////////////////////
    
    
    
    
    public Model()
    {
        x = 0;
        
    }
    
    public Model(int x)  ///// Model Constructor
    {
        this.x = x;
    }
    
    public void incX(){
        x++;
    }
    
    public int getX(){
        return x;
    }
    
    
    public void setX(int x){
        this.x= x;
    }
    
    
    public String getDiv()  { 	return Division;   }
    public String getExam()  { 	return Examination;   }
    public String getSub()  { 	return Subject;   }
    
    public void setThreeValues(String div,String exa, String sub)
    {this.Division=div; this.Examination=exa;this.Subject=sub;
    
	
    }
    
    public void getJarPath()
    {
    	File f = new File(System.getProperty("java.class.path"));
     	File dir = f.getAbsoluteFile().getParentFile();
        JarFilepath=dir.toString();
     
    }
    
    public int GetAllFiles()
    { 
     getJarPath();
  	  FilenameFilter mrkFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".mrk")) {
					return true;
				} else {
					return false;
				}
			}
		};
  	  
  	  pathArray.removeAll(pathArray);
  	  nameArray.removeAll(nameArray);
  	  File folder = new File(JarFilepath);
  	  File[] listOfFiles = folder.listFiles(mrkFilter);
  	      for (int i = 0; i < listOfFiles.length; i++) {
  	        if (listOfFiles[i].isFile()) 
  	        {  
  	           pathArray.add(listOfFiles[i].getAbsolutePath());
  	           nameArray.add(listOfFiles[i].getName());
  	           
  	         } 
  	      }
  	  TotalMarklists=pathArray.size();
  	  return TotalMarklists;
    }

    
    public String getFnem(int index)
    {   String temp=(String) nameArray.get(index);
    	return temp;
    }
    
    
    
    public void LoadMarkListFileToStrArray(int currentindex)
    {       strArray.removeAll(strArray);
    		markArray.removeAll(markArray);
    		rollArray.removeAll(rollArray);
    
        	BufferedReader reader=null;
    		try {
    			reader = new BufferedReader(new FileReader(pathArray.get(currentindex)));
    		} catch (FileNotFoundException e1) 
    		{
    		
    			e1.printStackTrace();
    		}
     				
    		String line = null;
        	try { while ((line = reader.readLine()) != null) 
    			{
    			 
    			 strArray.add(line);
    			}
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	
         }
    	
    	
    
    public void ExtractAllHeaderFields()
    {	String temp[],stemp;
	    stemp=strArray.get(7);
	    temp=stemp.split(":");
	    int TotalSets=Integer.parseInt(temp[1].replaceAll("[^0-9.]",""));
    
	    stemp=strArray.get(13+3*TotalSets); temp=stemp.split(":");
    	Examiner=temp[1].trim();
    	
    	stemp=strArray.get(15+3*TotalSets); temp=stemp.split(":");
    	Division=temp[1].trim();
    	
    	stemp=strArray.get(17+3*TotalSets); temp=stemp.split(":");
    	Subject=temp[1].trim();
    	
    	
    	stemp=strArray.get(18+3*TotalSets); temp=stemp.split(":");
    	Examination=temp[1].trim();
    	
    	stemp=strArray.get(19+3*TotalSets); temp=stemp.split(":");
    	MaxMarks=temp[1].trim();
    	stemp=strArray.get(20+3*TotalSets); temp=stemp.split(":");
    	Date=temp[1].trim();

		for(int i=28+3*TotalSets;i<strArray.size();i++) 
		{
		stemp=strArray.get(i); temp=stemp.split(":");
    	rollArray.add(temp[0].trim());markArray.add(temp[1].trim());
		
		}

    	
    }
    
    public boolean InOneTwoThreeFormat()
    { FormatOk=false;
      for(int i=0;i<DIV.length;i++) 
      if(DIV[i].equals(Division)) FormatOk=true;
      
      if(!FormatOk) return false;
      
      FormatOk=false;
      for(int i=0;i<EXAM.length;i++) 
          if(EXAM[i].equals(Examination)) FormatOk=true;
      
      if(!FormatOk) return false;
        	
      FormatOk=false;
      for(int i=0;i<SUBJECT.length;i++) 
          if(SUBJECT[i].equals(Subject)) FormatOk=true;
      
     // if(!found) return false;
        	
      return FormatOk;
    }
    
    public void SaveList() throws IOException
    {   FileWriter f0=null;
    	try {f0 = new FileWriter(pathArray.get(x));	} catch (IOException e1) {e1.printStackTrace();	}
        String newLine = System.getProperty("line.separator");
        
        String temp[],stemp;
	    stemp=strArray.get(7);
	    temp=stemp.split(":");
	    int TotalSets=Integer.parseInt(temp[1].replaceAll("[^0-9.]",""));
        
        
        strArray.set(15+3*TotalSets,"Div         :"+Division); 
    	strArray.set(17+3*TotalSets,"Subject     :"+Subject);
    	strArray.set(18+3*TotalSets,"Examination :"+Examination);
    	
    	for(int i=0;i<strArray.size();i++) 
    		{f0.write(strArray.get(i));f0.write(newLine);}
    	
    	f0.close();
    	
    	
    	 File oldfile = new File(pathArray.get(x));
         File newfile = new File(JarFilepath+"/"+Division+"-"+Examination+"-"+Subject+"-[Rectified]-"+Examiner+".mrk");

         if(oldfile.renameTo(newfile)) {
            System.out.println("File name changed succesful");
         } else {
            System.out.println("Rename failed");
         } 
    	
    }
    
    
    public void ExamineEachRoll()
    {
    	for(int i=0;i<markArray.size();i++)
    	{
    		if(markArray.get(i).contains("AB")) show(rollArray.get(i)+":"+markArray.get(i));
    	}
    }
    
}