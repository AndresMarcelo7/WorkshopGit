/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readproblem;

import java.util.Scanner;

/**
 *
 * @author 2145594
 */
public class ReadProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        String a = scan.nextLine();
        while (!a.isEmpty()){
            n+=1;
            System.out.println(n + " " + a);
            a = scan.nextLine();
        }
        scan.close();
        
    }
    
}
