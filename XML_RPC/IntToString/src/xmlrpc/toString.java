package xmlrpc;

import java.util.Scanner;

public class toString {
    static String[] dig = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] tee = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] ten = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] big = {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Sextillion", "Septillion", "Octillion", "Nonillion"};
  
   public  String toString(int x) {
       if (x == 0) {     // special cases  
           return "Zero";
       }else if(x<0){
           return "Negative" + toString(-1*x);
       }
         
       int count=0;
       String str="";
       while(x>0){
           if(x%1000!=0){
               //这句是最重要的一句，1000的发音就在这里处理。
               //前面+一个函数处理100一下的数字
               //利用字符串数组bigs轻松处理每个1000的发音
               //而且巧妙地在第一个位置加上逗号","。
               //str = numUnder100(x % 1000) + big[count] + "," + str;
               if(str!=""){ // 1234 ==> One Thousand,Two Hundred Thirty Four
               str = numUnder100(x % 1000) + big[count] + "," + str;
           }else{
           str = numUnder100(x % 1000) + big[count];
              }
             }
             
           x/=1000;
           count++;
       }      
       return str.trim(); //remove the last " "(space)
   } 
     
   // 将三位数转换为string
   public  String numUnder100(int num) {
       String str="";
        //100以下的数字需要四种情况处理，十分麻烦。
       if (num >= 100){
           str += dig[num/100-1] + " Hundred ";
           num %= 100;
       }
         
       if (num >= 11 && num <= 19){
           return str + tee[num - 11] + " ";
       }
         
       if (num == 10 || num >= 20){
           str += ten[num/10 - 1] + " ";
           num %= 10;
    }
         
       if (num >= 1 && num <= 9){
           str += dig[num - 1] + " ";
   }
         
       return str;
   }
   
}
