/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author 2145594
 */
public class Anagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        a.toLowerCase();
        b.toLowerCase();
        scan.close();
        //boolean ret = solveFeo(a, b);
        boolean ret2 = solveBien(a,b);
        //System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        System.out.println( (ret2) ? "Anagrams" : "Not Anagrams" );
    }

    static boolean solveFeo (String a, String b){
        if (a.length()!= b.length()) return false;
        char[] first = a.toCharArray();
        char[] sec = b.toCharArray();
        Arrays.sort(first);
        Arrays.sort(sec);
        return Arrays.equals(first,sec);
        
    }
    
    static boolean solveBien (String a, String b){
        if (a.length()!= b.length()) return false;
        Hashtable<Character ,Integer> dicc = new Hashtable();
        for (int i=0; i<a.length();i++){
            if (!dicc.containsKey(a.charAt(i))){
                dicc.put(a.charAt(i),1);
            }
            else{
                dicc.put(a.charAt(i), dicc.get(a.charAt(i))+1 );
            }
        }
        for (int i=0; i<b.length();i++){
            if (dicc.containsKey(b.charAt(i))){
                if (dicc.get(b.charAt(i)) > 1){
                    dicc.put(b.charAt(i),dicc.get(b.charAt(i)) -1);
                }
                else{
                    dicc.remove(b.charAt(i));
                }
            }
            else{
                return false;
            }
        }
        
        if (dicc.isEmpty()) return true;
        else return false;

    }
}
