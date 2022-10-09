import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class DirAllDeleter {

	 
	public static void main(String[] args) throws IOException {
		
		System.out.println("START");
		
	    Set<File> all = new HashSet<File>();
	    getAllFileAndFolder(new File("c://tmp"), all);
	    
	    for(File file : all) {
	    	if(file.exists()) {
	    	deleteDir(file);
	    	System.out.println(file);
	    	}
	    }
		 
	    System.out.println("FINISH");
		  
	}

	private static void deleteDir(File dir) throws IOException {
		
		if (!dir.isDirectory()) {
			throw new IOException("Not a directory " + dir);
		}

		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];

			if (file.isDirectory()) {
				deleteDir(file);
			} else {
				boolean deleted = file.delete();
				if (!deleted) {
					throw new IOException("Unable to delete file" + file);
				}
			}
		}

		dir.delete();
		
	}

	private static void getAllFileAndFolder(File folder, Set<File> all) {

	    if (folder.isFile()) {
		      return;
		    }
		    all.add(folder);
		    
		    for (File file : folder.listFiles()) {
		    	 
			      //all.add(file);
			      if (file.isDirectory()) {
					all.add(file);	       
			        getAllFileAndFolder(file, all);
			      }
			    }
		
	}
	
	 
}
 



