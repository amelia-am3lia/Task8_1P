package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	
	// using same login method created and tested in task 7.1P
	public static final String USERNAME = "amelia";
	public static final String PASSWORD = "amelia_pass";
	public static final String DOB = "2000-12-24";
	public static final LocalDate ILLOGICAL_DATE = LocalDate.of(2026, 01, 01);
	public static final LocalDate DOB_MIN = LocalDate.of(1900, 01, 05);
	
	public static boolean login(String username, String password, String dob) {
		// check for nulls or empty inputs
		if(username == null || username.trim().isEmpty()) {
			throw new IllegalArgumentException("No username entered.");
		}
		if(password == null || password.trim().isEmpty()) {
			throw new IllegalArgumentException("No password entered.");
		}
		if(dob == null || dob.trim().isEmpty()) {
			throw new IllegalArgumentException("No date of birth entered.");
		}
		if(username.length() >= 20) {
			throw new IllegalArgumentException("Entered username exceeds limit");
		}
		if(password.length() >= 20) {
			throw new IllegalArgumentException("Entered password exceeds limit");
		}
		
		// validate date input - check age is logical, then confirm age is reasonable 
		try {LocalDate.parse(dob);}
		catch(DateTimeParseException e) {
			throw new IllegalArgumentException("Date of birth must be in format yyyy-mm-dd.");
		}
		
		LocalDate temp_date = LocalDate.parse(dob);
		if(temp_date.isAfter(ILLOGICAL_DATE)) {
			throw new IllegalArgumentException("The date of birth entered is illogical. Please try again.");
		}

		if(temp_date.isBefore(DOB_MIN)) {
			throw new IllegalArgumentException("With the entered DOB, you must be Dracula.");
		}

		if (USERNAME.equals(username) && PASSWORD.equals(password) && DOB.equals(dob)) {
			return true;
		}
		return false;
	}
}
