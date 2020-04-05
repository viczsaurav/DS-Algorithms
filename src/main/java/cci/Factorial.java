package cci;

public class Factorial {
	public static void main(String args[]) {
		int i, fact = 1;
		int number = 4;//It is the number to calculate factorial
		fact = factorialRecurse(number);
		System.out.println("Factorial of " + number + " is: " + fact);
	}

	private static int factorialBottomUp(int number) {
		int i, fact = 1;
		for (i = 1; i <= number; i++) {
			fact = fact * i;
		}
		System.out.println("Factorial of " + number + " is: " + fact);
		return fact;
	}

	static int factorialRecurse(int n) {
		if (n == 0)
			return 1;
		else
			return (n * factorialRecurse(n - 1));
	}
}
