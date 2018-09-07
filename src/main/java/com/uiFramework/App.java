package com.uiFramework;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        float calculation = (999 - 999*50/100);
        System.out.println("calculation "+calculation);
		int priceAfterDicount = (int)(calculation);
		System.out.println("priceAfterDicount "+priceAfterDicount);
    }
}
