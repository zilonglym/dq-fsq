package com.zilong.fsq;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CharSequence cs = "你好App";  
        String s = cs.toString();  
        foo(s); // prints "string" 
    }
 
      
    public static void foo(CharSequence cs) {   
      System.out.println(cs);  
    } 
    
}
