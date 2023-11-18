package com.code.kata.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;


import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

 
public class StringCalculatorTest {

	private  Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Test
    public void testAddEmptyString() {
	     int result = new StringCalculator().add("");
	     assertEquals(0, result);
    }
	
	@Test
    public void testAdd_SingleNumber_ReturnsOnw() {
        int result = new StringCalculator().add("1");
        assertEquals(1, result);
    }
	
	@Test
    public void testAdd_SingleNumber_ReturnsNumber() {
        int result = new StringCalculator().add("5");
        assertEquals(5, result);
    }
	
	@Test
    public void testAdd_TwoNumbers_ReturnsSum() {
        int result = new StringCalculator().add("2,3");
        assertEquals(5, result);
    }
	
	@Test
	public void Add_MultipleNumbers_ReturnsSum()
	{
	    int result = new StringCalculator().add("2,3,5");
	    assertEquals(10, result);
	} 
	
	@Test
	public void testAdd_UnknownNumberOfNumbers_ReturnsSum() {
	   
	    int result = new StringCalculator().add("2,3,5,7");
	    assertEquals(17, result);
	}
	 
	@Test
	public void testAddUnknownNumberOfNumbers() {
	    
	    int result = new StringCalculator().add("2,3,4,5");
	    assertEquals(14, result);
	}
	
	
	 @Test
     public void testAdd_DifferentDelimiter_ReturnsSum() {
        
        int result = new StringCalculator().add("1\n2,3");
        assertEquals(6, result);
     }
	 
	 @Test
    public void testAdd_CustomDelimiter_ReturnsSum() {
         
        int result = new StringCalculator().add("//;\n1;2");
        assertEquals(3, result);
    }
	
	 //7. Delimiters can be any length, using this syntax: "//[|||]\n1|||2|||3" returns 6.
	 @Test 
      public void testAdd_Delimiter_any_length_ReturnsSum() {
        
		int result = new StringCalculator().add("//[|||]\\n1|||2|||3");
        assertEquals(6, result);
     }
	 
	 //Allow multiple delimiters, using this syntax: "//[|][%]\n1|2%3" returns 6
	 @Test 
     public void testAdd_multipleDelimiter_any_length_ReturnsSum() {
       
		int result = new StringCalculator().add("//[|][%]\\n1|2%3");
       assertEquals(6, result);
    }
	 
	 @Test
     public void testAdd_MultipleDelimitersAnyLength_ReturnsSum() {
      
        int result = new StringCalculator().add("//[||][%%]\n1||2%%3");
        assertEquals(6, result);
     } 
	 
	 @Test
	 public void testAdd_NumbersGreaterThan1000_IgnoresNumbers() {
	    
	     int result = new StringCalculator().add("1001,2");
	     assertEquals(2, result);
	 }
	 
	 
	 @Test
     public void testAdd_NegativeNumbers_ThrowsException() {
         
		 assertThrows(IllegalArgumentException.class, new Executable() {
				public void execute() throws Throwable {
					new StringCalculator().add("-2,1");
				}
			});
     }
	 
	 @Test
     public void testAdd_NegativeNumbers_IllegalArgumentException() {
		  assertThrows(IllegalArgumentException.class, new Executable() {
			public void execute() throws Throwable {
				new StringCalculator().add("2,-4,3,-5");
			}
		});
     }
}
