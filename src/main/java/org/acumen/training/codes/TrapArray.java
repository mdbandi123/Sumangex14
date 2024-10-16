package org.acumen.training.codes;

import java.util.Scanner;

import org.acumen.training.codes.exceptions.BadIndexException;
import org.acumen.training.codes.exceptions.ElementCharException;
import org.acumen.training.codes.exceptions.ElementDecimalException;
import org.acumen.training.codes.exceptions.InvalidSizeException;
import org.acumen.training.codes.exceptions.LetterSizeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrapArray {
	int[] arr;
	private static final Logger LOGGER = LogManager.getLogger("LOGGER2");
	
	public void arrayTransact() {
		try (Scanner sc = new Scanner(System.in);){
			int arrSize = promptArraySize(sc);
			arr = promptArrayValues(sc,arrSize);
			promptValSearch(sc);
			System.out.println("Good Bye");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private int promptArraySize(Scanner sc) {
		int arrSize = 0;

			while (true) {
				LOGGER.info("TrapArray starts.");
				try {
					System.out.print("Enter the Array Size: ");
					arrSize = getArraySize(sc);
					return arrSize;
				} catch (LetterSizeException e) {
					LOGGER.error(e.getMessage());
					e.printStackTrace();
				} catch (InvalidSizeException e) {
					LOGGER.error(e.getMessage());
					e.printStackTrace();
				} catch (NegativeArraySizeException e) {
					LOGGER.error(e.getMessage());
					e.printStackTrace();
				} catch (ArithmeticException e) {
					LOGGER.error(e.getMessage());
					e.printStackTrace();
				} catch (Exception e) {
					LOGGER.error(e.getMessage());
					e.printStackTrace();
				}
			}		
	}
	
	private int getArraySize(Scanner sc) throws LetterSizeException, 
												InvalidSizeException, 
												Exception {
		String input = "";
		try {
			input = sc.next();
			sc.nextLine();
			int parsedInt = Integer.parseInt(input);
			
			if (parsedInt < 0) {
				throw new LetterSizeException();
			}
			
			return parsedInt;
		} catch (NumberFormatException e) {
			try {
				double parsedDouble = Double.parseDouble(input);
				
				if (parsedDouble < 0) {
					throw new LetterSizeException();
				}
				
				throw new InvalidSizeException();
			} catch (NumberFormatException e2) {
				throw new InvalidSizeException();
			}		
		}
	}
	
	private int[] promptArrayValues(Scanner sc, int size) {
		int[] intArr = new int[size];
		int i = 0;
		
		while (i < size) {
			try {
				System.out.print("Enter the value: ");
				intArr[i] = getArrayValues(sc);
				i++;
			} catch (ElementCharException e) {
				LOGGER.error(e.getMessage());
				e.printStackTrace();
			} catch (ElementDecimalException e) {
				LOGGER.error(e.getMessage());
				e.printStackTrace();
			} catch (ArithmeticException e) {
				LOGGER.error(e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				e.printStackTrace();
			}
		}
		LOGGER.info("Array of {} integers created",size);
		return intArr;
	}
	
	private int getArrayValues(Scanner sc) throws ElementCharException, 
												  ElementDecimalException, 
												  Exception {
		String input = "";
		
		try {
			input = sc.next();
			sc.nextLine();
			int parsedInt = Integer.parseInt(input);
			return parsedInt;
		} catch (NumberFormatException e) {
			try {
				double parsedDouble = Double.parseDouble(input);
				throw new ElementDecimalException();
			} catch (NumberFormatException e2) {
				throw new ElementCharException(input);
			}		
		}
	}
	
	private void promptValSearch(Scanner sc) {
		String[] elemArr = new String[2];
		do{
			try {
				System.out.print("Enter the index that you want to view: ");
				elemArr = getArrayElement(sc);
				if (elemArr[1].equalsIgnoreCase("e")) {
					return;
				}
				System.out.println("The value in index "
						+ "%s is %s".formatted(elemArr[0], elemArr[1]));
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				e.printStackTrace();
			}
		} while (true);
	}
	
	private String[] getArrayElement(Scanner sc) throws BadIndexException, 
														Exception{
		String i = "";
		String[] elemArr = new String[2];
		
		try {
			i = sc.next();
			if(i.equalsIgnoreCase("e")) {
				elemArr[1] = i;
				return elemArr;
			}
			int idx = Integer.parseInt(i);
			
			if (idx >= arr.length) {
				throw new BadIndexException();
			}
			
			int tempInt = arr[idx];
			elemArr[0] = i;
			elemArr[1] = Integer.toString(tempInt);
			
			return elemArr;
		} catch (NumberFormatException e) {
			throw new BadIndexException();
		}
	}
}
