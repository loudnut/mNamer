package loudnut_namer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * This class add a specified string to target String[] at a specified position.<br/>
 * If you want to add a string at the beginning, set targetIndex to 0.<br/>
 * At the end, set to -1.<br/>
 * After n charactors, set to n.<br/>
 * 
 * 
 * @author 9722105 YJC
 */
public class Adder {
    
  
    String[] formerName;       
    /**
     * The modified String[].
     */
    public String[] newName;    
    String targetStr;
    int targetIndex;

    /**
     * Creates a new {@code Adder} instance.
     * 
     * @param a The String[] to be modified.
     * @param i The index of inserting. i.e.targetIndex.
     * @param Str The String you want to add.
     */
    public Adder( String[] a, int i, String Str ){
        
            formerName = a;
            targetIndex = i;
            targetStr = Str;
            newName = new String[a.length];

    }
    
    /**
     * Add a String to all elements in a String array at specified index.
     */
    public void add(){
        
        if( targetIndex == 0 ){            
            for( int i = 0; i < formerName.length; i++ )                
                newName[i] = targetStr + formerName[i] ;
        }
        
        else if ( targetIndex == -1 ){
            for( int i = 0; i < formerName.length; i++ )
                newName[i] = formerName[i] + targetStr ;
        }
        
        else {
            for( int i = 0; i < formerName.length; i++ ){

                int newLength = formerName[i].length() + targetStr.length() ;
                char[] newChar = new char[newLength];
                char[] formerChar = formerName[i].toCharArray();
                char[] targetChar = targetStr.toCharArray();
                
                
                for( int j = 0, m=0, n=0; j < newLength; ){


                    if( j < targetIndex || j >= targetIndex+targetStr.length() ){
                        newChar[j++] = formerChar[m++];
                    }
                    else {
                        newChar[j++] = targetChar[n++];
                    }
                }
                
                newName[i] = String.valueOf(newChar);
            }
        }
    }
           
}
