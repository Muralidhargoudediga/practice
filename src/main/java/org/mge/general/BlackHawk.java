package org.mge.general;

import java.util.Scanner;

class Main {

  public static String BRule(String str) {
    // code goes here 
    if(str == null || str.isEmpty()){
      return str;
    }
    char sign = '@';
    boolean isB = false;
    boolean isPrevSign = false;
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < str.length(); i++){
      char c = str.charAt(i);
      if(c == ' ') {
        continue;
      }
      
      if(c == '(') {
        isB = true;
      } else if(c == ')') {
        isB = false;
        sign = '@';
      } else if(i < str.length() && str.charAt(i+1) == '(' && isSign(c)) {
        sign = c;
      } else if(isB && sign != '@') {
        if(isSign(c)) {
          sb.append(getResultSign(sign, c));
          isPrevSign = true;
        } else {
          if(!isPrevSign) {
            sb.append(sign);
          }
          sb.append(c);
          isPrevSign = false;
        }
      } else if(isSign(c)) {
        sign = c;
      }  else {
        sb.append(c);
      }
    }
    
    str = sb.toString();
    
    return str;
  }
  
  public static char getResultSign(char c1, char c2){
    if(c1 == '-') {
      if(c2 == '+') {
        return '-';
      } else {
        return '+';
      }
    }
    
    return c2;
  }
  
  public static boolean isSign(char c){
    if(c == '+' || c == '-'){
      return true;
    } 
    
    return false;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(BRule(s.nextLine())); 
  }

}
