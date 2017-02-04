package mrk;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class Model {
    private int TotalMarklists;
    private int x;
    private String JarFilepath;
    private ArrayList<String> pathArray = new ArrayList<String>(); //array containing full paths
    private  ArrayList<String> nameArray = new ArrayList<String>(); //array containing file names only
   
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

    
    public String getFileName(int index)
    {   String temp=(String) nameArray.get(index);
    	return temp;
    }
    
    
}