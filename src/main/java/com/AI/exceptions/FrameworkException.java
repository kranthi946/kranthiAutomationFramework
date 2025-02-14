package com.AI.exceptions;




///
///
///
///
/// FRAMEWORKEXCEPTION -> RUNTIMEEXCEPTION -> EXCEPTION -> TROWABLE -> IMPLEMENTS SERIALISABLE
///This ensures that the custom exception behaves like any other exception, meaning it can:
///
/// Carry a message (getMessage())
/// Hold a stack trace (getStackTrace())
/// Contain a cause (getCause())
///
///
///
/// public class ExceptionExample {
///     public static void main(String[] args) {
///         try {
///             // Directly performing the operation that causes the exception
///             int result = 10 / 0; // This will throw an ArithmeticException
///         } catch (ArithmeticException e) {
///             // Handle exception and print messages
///             System.out.println("Caught Exception: " + e.getMessage()); // getMessage() returns the exception message
///             e.printStackTrace(); // getStackTrace() prints the stack trace
///
///             // Demonstrate the cause of the exception
///             if (e.getCause() != null) {
///                 System.out.println("Cause: " + e.getCause());
///             } else {
///                 System.out.println("No cause available for this exception.");
///             }
///         } finally {
///             // This block will execute regardless of exception being thrown
///             System.out.println("Finally block executed.");
///         }
///     }
/// }
///
///

@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException {

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * 
	 * @param message Details about the exception or custom message
	 */
	public FrameworkException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause   Pass the enriched stacktrace or customised stacktrace
	 */
	public FrameworkException(String message, Throwable cause) {
		super(message, cause);
	}

}
