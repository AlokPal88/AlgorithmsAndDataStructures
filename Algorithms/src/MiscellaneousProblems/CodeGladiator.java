package MiscellaneousProblems;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class CodeGladiator {
    static class Node{
        int sum;
        List<String> elements = new ArrayList<>();
        Node(int sum){
            this.sum = sum;
        }
        Node(){}
    }
    public static void main(String args[] ) throws Exception {

    	Scanner in = new Scanner(System.in);
        //int inputs = Integer.parseInt(in.nextLine()) * 2;
        List<String> res = new ArrayList<>();
        /*for(int i = 0; i < inputs; i++)
        {
            String text = in.nextLine();
            if(text.length() > 1){
                res.add(findMaxSumNonAdj(text.split(" ")));
            }
        }*/
        //String text = "4 5 4 3 ";
        String text = "-1 7 8 -5 4";
        res.add(findMaxSumNonAdj(text.split(" ")));
        System.out.println(res);

   }
   
   private static String findMaxSumNonAdj(String[] arr){
       return findMaxSumNonAdj(arr, arr.length);
   }

   private static String findMaxSumNonAdj(String[] arr, int length){
       Node[] nodes = new Node[length];
       for(int i = 0; i < length; i++){
           if (i == 0){
               Node n0 = new Node(Integer.parseInt(arr[0]));
               n0.elements.add(arr[0]);
               nodes[0] = n0;
           } else if(i == 1){
               int sum = Math.max(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
               Node n1 = new Node(sum);
               n1.elements.add(Integer.toString(sum));
               nodes[1] = n1;
           }
           else{
               Node ni = new Node();
               getMax(ni,nodes[i-2], Integer.parseInt(arr[i]), nodes[i-1]);
               nodes[i] = ni;
           }
       }
       return nodes[length-1].elements.stream().map(String::valueOf).collect(Collectors.joining());
   }

   private static void getMax(Node n, Node i_2, int x, Node i_1){
       if(i_2.sum + x > i_1.sum){
           n.sum = i_2.sum + x;
           n.elements.addAll(i_2.elements);
           n.elements.add(Integer.toString(x));
       }/*else if (i_2.sum + x == i_1.sum){
    	   n.sum = i_2.sum + x;
           //n.elements.addAll(i_2.elements);
           n.elements.add(Integer.toString(x));
       }*/
       else{
           n.sum = i_1.sum;
           n.elements.addAll(i_1.elements);
       }
   }


}
