
package com.mycompany.fractionalknapsake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Item
{
    int number;
    int weight;
    int benefit;
    double value;
    Item(int number,int weight,int benifit)
    {
        this.number = number;
        this.weight = weight;
        this.benefit = benifit;
        this.value=benifit/weight;
    }
    @Override
    public String toString()
    {
        return "Item"+this.number;
    }
}

public class FractionalKnapSake {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter number of item:");
       int n = sc.nextInt();
       ArrayList<Item> arr = new ArrayList<>();
       System.out.print("Enter the amount (Item And Weight):");
       for(int i=0;i<n;i++)
       {
           arr.add(new Item(i+1,sc.nextInt(),sc.nextInt()));
       }
     Collections.sort(arr,Comparator.comparingDouble(((Item i1)->i1.value)).reversed());
     System.out.println("Enter knapsake size:");
     int m = sc.nextInt();
     int x = m;
     int totalBenefit = 0;
     System.out.println("item\\tWeight\\tBenefit\\tAmount ");
       while(x>0)
       {
           Item item = arr.remove(0);
           if(item.weight<=x)
           {
               totalBenefit+=item.benefit;
               System.out.println(item.number+"\t"+item.weight+" \t"+item.benefit+"\t"+item.weight);
                x -= item.weight;
           }
           else
           {
               totalBenefit+=item.value*x;
               System.out.println(item.number+"\t"+item.weight+" \t"+item.benefit+"\t"+item.weight);
                x -= item.value*x;
           }
       }
       System.out.print("Total benefit is "+totalBenefit);
    }
}
