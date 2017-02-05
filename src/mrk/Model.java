package mrk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Model {
    private int TotalMarklists;
    private int x;
    private String JarFilepath;
    private ArrayList<String> pathArray = new ArrayList<String>(); //array containing full paths
    private ArrayList<String> nameArray = new ArrayList<String>(); //array containing file names only
    private ArrayList<String> strArray = new ArrayList<String>(); //array containing file names only
    
    private Set<String> DivSet = new HashSet<>();
    private Set<String> ExamSet = new HashSet<>();
    private Set<String> SubjectSet = new HashSet<>();
    private  String Order[]={"ENG","MAR","TAM","HIN","ITE","MAT","PHY","CHE","BIO","SEP","ECO","BKE","OCM","CS1","CS2","EL1","EL2","EVS","PTE"};
    
    private String Division,Examination, Subject, Examiner;
    
    public Model()
    {
        x = 0;
        ///Initialize Division Set
        for(char alphabet = 'A'; alphabet <= 'L';alphabet++) DivSet.add(String.valueOf(alphabet));   
        
       ///Initialize Exam Set 
        ExamSet.add("U1");ExamSet.add("T1"); ExamSet.add("U2"); ExamSet.add("T2");
        
       ///Initialize Subject Set
        for(int i=0;i<Order.length;i++) SubjectSet.add(Order[i]);
        
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
    public String getJarPath()
    {
    	File f = new File(System.getProperty("java.class.path"));
     	File dir = f.getAbsoluteFile().getParentFile();
        JarFilepath=dir.toString();
     	return  JarFilepath;
    }
    
    public int GetAllFiles(String path)
    { 
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
  	  File folder = new File(path);
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
    
    public String getDiv()  { 	return Division;   }
    public String getExam()  { 	return Examination;   }
    public String getSub()  { 	return Subject;   }
    
    
    public void LoadMarkListFileToStrArray(int currentindex)
    {       strArray.removeAll(strArray);
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

    	
    }
    
    public void CheckOneTwoThreeFormat()
    {
    	
    }
    
    
}