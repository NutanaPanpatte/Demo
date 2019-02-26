import java.util.Scanner;
import java.util.*;
class Jobsequence
{ 
  
   
   int job;
   int deadline; 
   int profit;
  
   public Jobsequence(int job, int deadline , int profit){
     this.job = job;
     this.deadline = deadline;
     this.profit = profit;
   }
  
   //main method
   public static void main(String[] args){
     
     int counter = 0; 
     Scanner sc = new Scanner(System.in);
     Jobsequence[] a = new Jobsequence[5];
     
     System.out.println("Enter job, deadline,and profit int the given array in respective manner");
    
     for(int i = 0; i<5 ; i++){
             int job = sc.nextInt();
             int deadline = sc.nextInt();
             int profit = sc.nextInt();
               
             a[i] = new Jobsequence(job,deadline,profit);
             System.out.println();
    }

   //predifined funtion for sorting of array objects
    Arrays.sort(a,0,5,new Comparator<Jobsequence>(){
                      public int compare(Jobsequence J1, Jobsequence J2)
                      {
                            Integer i1 = (Integer)J1.profit;
                            Integer i2 = (Integer)J2.profit;
                            return -i1.compareTo(i2);
                      }});  

   
   int[] result = new int[5];
   boolean[] slot = new boolean[5];

   for(int i = 0 ; i<5 ; i++){
        slot[i] = false;
   }
   
   for(int i = 0 ;i<5 ;i++){
       for(int j = Math.min(a[i].deadline,5)-1 ; j>=0 ;j--){
         if(slot[j] == false){
           counter++;
           result[j] = i+1;
           slot[j] = true;
           break;
         }
      }
   }

  System.out.println();
  System.out.println("FINAL JOB SEQUENCE:: ");
  System.out.println();
  for(int i = 0 ;i<counter; i++)
  {
    System.out.println(result[i]);
  }
  
     
  


 
  }
}
