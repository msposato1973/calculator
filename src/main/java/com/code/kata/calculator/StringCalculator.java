package com.code.kata.calculator;


public class StringCalculator {
	
	private static final String DEFAULT_DELIMITER = ",";
    private static final String LINE = "n";
    private static final String CUSTOM_SUFFIX = "//";
    private static final String REGEX_SLIP = "\\W";
    private static final String NEWLINE = "[,\n]";


	public int add(String numbers) {

		if (isInputEmpty(numbers))
			return 0;
		 
		
		if (numbers.startsWith(CUSTOM_SUFFIX)) {
			String[] tokens = numbers.replace(LINE, "").split(REGEX_SLIP);
            return summ(tokens);
        }
		

		// Split numbers using commas and new lines
		String[] numberArray = numbers.split(NEWLINE);
		return  summ(numberArray);
	}

	

	private int summ(String[] numbers) {
		int sum = 0;

		// Step 5: Handling negative numbers
		StringBuilder negativeNumbers = new StringBuilder();

		for (String number : numbers) {

			if (!number.trim().isEmpty()) {
				int parsedNum = Integer.parseInt(number);
				
				if (isNegative(parsedNum)) negativeNumbers.append(parsedNum).append(DEFAULT_DELIMITER);
				if (isValidRange(parsedNum)) sum += parsedNum;
			}
		}

		// Step 5: Throw exception if there are negative numbers
		if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }

		return sum;
	}

	private boolean isInputEmpty(String numbers) {
		return (numbers.isEmpty() || numbers.equals(""));
	}

	private boolean isNegative(Integer valueAsInteger) {
		return valueAsInteger < 0;
	}

	private boolean isValidRange(Integer valueAsInteger) {
		return valueAsInteger <= 1000;
	}
}
