package loudnut_namer;

import java.io.File;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Given directory and files under it, rename all files by input string.
 * 
 * 
 * 
 * @author 9722105 YjC
 */
public class Namer {
    
    File directory;
    String[] fileName;
    File[] filePath;
    
    /**
     * Create a new Namer instance by the following parameters.
     * @param dir The input directory.
     * @param files Files under the directory.
     * @param Str New names of the files.
     */ 
    public Namer( File dir, File[] files, String[] Str ){
        
        filePath = files;
        directory = dir;
        fileName = Str;
    }
    
    /**
     * Rename all files.
     */
    public void name(){
        

        
        
        for( int i = 0; i < filePath.length; i++ ){
            if( filePath[i].isFile() && !filePath[i].isHidden() )
            filePath[i].renameTo(new File(directory, fileName[i]));
        }
//        System.out.println("Rename successfully.");
    }    
}
