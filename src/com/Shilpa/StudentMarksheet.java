/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Shilpa;
import java.util.Scanner;
/**
 *
 * @author Shilpa
 */
public class StudentMarksheet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Scanner input= new Scanner(System.in);
   
        String result="";
        System.out.print("Enter no. of student records: ");
        int records=input.nextInt();
        
        String[] student= new String[records];
        String[] passedStudent=new String[records];
        String[] subjects={"Science","English","Opt.math","C.math","Nepali"};
        float[][] marks= new float[student.length][subjects.length];
        float[] total=new float[student.length];
        float[] percentage=new float[student.length];
        int k=0;
                
        for (int i=0;i<student.length;i++)
        {
        System.out.print("Enter Student's name:");
        student[i]=input.next();
            for(int j=0;j<subjects.length;j++)
            {
                System.out.print("Enter marks for "+subjects[j]+": ");
                marks[i][j]=input.nextFloat();
                if(marks[i][j]<32)
                {
                    result="failed";
                }
                total[i]+=marks[i][j];
            }
            
        if(result.equals("failed"))
        {
            System.out.println(" You have Failed ");
        }else
        {
            System.out.println("You have passed");
            passedStudent[k]=student[i];
            percentage[k]= total[i]/5;
            System.out.println("Percentage:"+percentage[k]+ "%" );
            if(percentage[k]>=80)   
            {
                 System.out.println("Distinction!");
            }else if (percentage[k]>=60&&percentage[k]<80)
                 System.out.println("First Division!");
            else if (percentage[k]>=50&&percentage[k]<60)
                 System.out.println("Second Division!");
            
            else if(percentage[k]<50)
                 System.out.println("Third Division!");
            
      
           k++;
            
        }
        
        
          
        }
       
        System.out.println("1. SEE THE RANK");
        System.out.println("2. EXIT");
        int choice=input.nextInt();
        switch(choice)
                {
            case 1:
               
               rank(percentage,passedStudent,k);
            break;
            case 2:
                System.exit(0);
                break;
            
                }
    }
    
    private static void rank(float[] p,String[] n,int length)
    {
        float temp=0;
        String name;
        int count=1;
        for(int i=0;i<length;i++)
        {
            for(int j=1;j<length-i;j++)
            {
                if(p[j-1]<p[j])
                    temp= p[j-1];
                    p[j-1]= p[j] ;
                    p[j]=temp;
                    
                    name=n[j-1];
                    n[j-1]=n[j];
                    n[j]=name;
                    
            }
        }
        System.out.println("Rank");
        for(int i=0;i<length;i++)
        {
            System.out.println(count+". " +n[i]+" "+p[i]);
            count++;
        }
    }
    
}
    
    

