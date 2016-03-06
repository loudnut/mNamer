package loudnut_namer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Rename all files under a directory by adding a string.<br/>
 * It needs there args;<br/>
 * args[0]:directory<br/>
 * args[1]:targetIndex<br/>
 * args[2]:String you want<br/>
 * 
 * Note: targetIndex usage<br/>
 *  0: beginning of the name<br/>
 * -1: end of the name<br/>
 *  n: after n characters<br/>
 * 
 * 
 * @author 9722105 YJC
 */

public class Add {

    public void addWantedString(String path, String wantedString){
        
        Viewer v = new Viewer(path);
        v.fileName = v.directory.list();
        Adder a = new Adder( v.fileName, 0, wantedString );
        a.add();
        Namer n = new Namer( v.directory, v.filePath, a.newName );
        n.name();        
    }
}
