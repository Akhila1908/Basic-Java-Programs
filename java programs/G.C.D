 
//  Euclids Theorem
//Time complexity:-  O(log(min(a,b))

import java.util.*;
public class Main{
    public static void main(String[] args){
       int a=105,b=224;
        System.out.println(gcd(a,b));
    }
        public static int gcd(int a,int b) {
        int rem=b%a;
        if(rem==0){
            return a;
        }
            return gcd(rem,a);
        }
    }
