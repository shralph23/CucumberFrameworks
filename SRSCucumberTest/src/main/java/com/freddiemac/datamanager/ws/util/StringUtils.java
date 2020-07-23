package com.freddiemac.datamanager.ws.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import generic.Base64Utils;

public final class StringUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(StringUtils.class);

	private StringUtils() {
	}

	public static boolean containsIgnoreCase(String theString, String isThisStringInOtherString) {

		return theString.toLowerCase().contains(isThisStringInOtherString.toLowerCase());

	}

	public static String getSubString(final String theString, int startIndex) {

      String subString = "";

      if (theString.length() > startIndex) {
         subString = theString.substring(startIndex);
      } else {
         subString = theString;
      }

      return subString;
   }
	
	public static String getTruncatedString(final String theString, int maxLength) {

//		String truncatedString = "";

		return theString.length() > maxLength ? theString.substring(0, maxLength) : theString;
      /*if (theString.length() > maxLength) {
      	truncatedString = theString.substring(0, maxLength);
      } else {
      	truncatedString = theString;
      }
      
      return truncatedString;*/
	}

	public static String getMaskedString(final String theString) {
		String encodedString = "null";

		if (theString != null) {
			encodedString = Base64Utils.encode(theString);
		}

		return encodedString;
	}

	public static boolean isNum(final String theString) {
		boolean theBoolean = Boolean.TRUE;

		try {
			Double.parseDouble(theString);
		} catch (NumberFormatException nfe) {
			theBoolean = Boolean.FALSE;
		}

		return theBoolean;
	}

	// to suppress SONAR warnings about method, do not want to throw any exceptions
	// since
	// this code is used in catch to print out exception
	@SuppressWarnings("all")
	public static String stackTraceToString(final Exception theException) {
		final ByteArrayOutputStream theByteStream = new ByteArrayOutputStream();
		final PrintStream thePrintStream = new PrintStream(theByteStream, true);
		thePrintStream.flush();
		return theByteStream.toString();
	}

	public static boolean doesValueExist(String possibleValue) {
		boolean returnValue = Boolean.FALSE;

		if ((possibleValue != null) && (!possibleValue.trim().isEmpty())) {
			returnValue = Boolean.TRUE;
		}

		return returnValue;
	}

	public static boolean isValueEmpty(String possibleValue) {

		return !doesValueExist(possibleValue);

	}

	/**
	 * 
	 * Checks whether the String contains a not null value
	 * 
	 * @param possibleValue is a instance of String class.
	 * 
	 * @return returnValue is true in case of possibleValue is not null otherwise
	 *         false
	 * 
	 */
	public static boolean isNotNull(String possibleValue) {

		boolean returnValue = Boolean.FALSE;

		if (possibleValue != null) {
			returnValue = Boolean.TRUE;
		}

		return returnValue;

	}

	/**
	 * 
	 * Checks whether the String contains null value
	 * 
	 * @param possibleValue is a instance of String class.
	 * 
	 * @return returnValue is true in case of possibleValue is null otherwise false
	 * 
	 */
	public static boolean isNull(String possibleValue) {

		return !isNotNull(possibleValue);

	}

	// if inputValue has valid value, and outputValue is null or empty, return true
	// used to update keys, only if nothing currently exists
	public static boolean doesNewDataExist(String inputValue, String outputValue) {
		boolean newDataExists = Boolean.FALSE;

		if (StringUtils.doesValueExist(inputValue)) {

			if (outputValue == null) {
				newDataExists = Boolean.TRUE;
			} else if (StringUtils.isValueEmpty(outputValue)) {
				newDataExists = Boolean.TRUE;
			}
		}

		return newDataExists;
	}

	// if inputValue has valid value, and different than outputValue, return true
	// used to update fields, if something changed
	public static boolean doesDifferentDataExist(String inputValue, String outputValue, boolean caseSensitiveFlag) {
		boolean differentDataExists = Boolean.FALSE;

		if (StringUtils.doesValueExist(inputValue)) {

			// so we have some data in input, check to see if target output is null, or
			// different
			if (StringUtils.doesValueExist(outputValue)) {

				if (!internalDoValuesMatch(inputValue, outputValue, caseSensitiveFlag)) {
					differentDataExists = Boolean.TRUE;
				}
			} else {
				differentDataExists = Boolean.TRUE;
			}
		}

		return differentDataExists;
	}

	// if inputValue conflicts with outputValue, return true
	// conflict means the input has a non-empty value and the database has non-empty
	// value and they are different.
	// if input has value but database has empty -> no conflict
	// if input has empty value but database has a value -> no conflict
	// if input has a value and database has a value -> possible conflict -> if
	// different conflict
	public static boolean doesDataConflict(String inputValue, String outputValue, boolean caseSensitiveFlag) {
		boolean dataConflictExists = Boolean.FALSE;

		if ((StringUtils.doesValueExist(inputValue)) && (StringUtils.doesValueExist(outputValue))) {

			// so we have some data in input, check to see if conflict with target output
			if (!internalDoValuesMatch(inputValue, outputValue, caseSensitiveFlag)) {
				dataConflictExists = Boolean.TRUE;
			}

		}

		return dataConflictExists;
	}

	public static boolean doValuesMatch(String leftValue, String rightValue, boolean caseSensitiveFlag) {

		boolean isMatch = Boolean.FALSE;

		if ((StringUtils.doesValueExist(leftValue)) && (StringUtils.doesValueExist(rightValue))) {

			if (internalDoValuesMatch(leftValue, rightValue, caseSensitiveFlag)) {
				isMatch = Boolean.TRUE;
			}

		}

		return isMatch;
	}

	public static boolean doValuesMatchForChars(String leftValue, String rightValue, int countCharsToMatch,
			boolean caseSensitiveFlag) {

		boolean isMatch = Boolean.FALSE;

		if ((StringUtils.doesValueExist(leftValue)) && (StringUtils.doesValueExist(rightValue))) {

			String leftSubString = leftValue.trim().substring(0, Math.min(leftValue.length(), countCharsToMatch));
			String rightSubString = rightValue.trim().substring(0, Math.min(rightValue.length(), countCharsToMatch));

			if (internalDoValuesMatch(leftSubString, rightSubString, caseSensitiveFlag)) {
				isMatch = Boolean.TRUE;
			}

		}

		return isMatch;
	}

	// used for exact compare, so if null on one side needs to be null on other.
	public static boolean doValuesExactMatch(String leftValue, String rightValue, boolean caseSensitiveFlag) {

		boolean isExactMatch = Boolean.FALSE;

		if (StringUtils.doesValueExist(leftValue)) {

			if (StringUtils.doesValueExist(rightValue)) {

				// left has value - right has value
				if (internalDoValuesMatch(leftValue, rightValue, caseSensitiveFlag)) {
					isExactMatch = Boolean.TRUE;
				}
			}

			else {
				// left has value - right has no value
			}
		} else {
			if (StringUtils.doesValueExist(rightValue)) {

				// left has no value - right has value
			} else {

				// left has no value - right has no value
				isExactMatch = Boolean.TRUE;
			}
		}

		return isExactMatch;
	}

	// asumes values exist, includes the trim

	private static boolean internalDoValuesMatch(String leftValue, String rightValue, boolean caseSensitiveFlag) {

		boolean isMatch = Boolean.FALSE;

		if (caseSensitiveFlag) {
			if (leftValue.trim().equals(rightValue.trim())) {
				isMatch = Boolean.TRUE;
			}
		} else {
			if (leftValue.trim().equalsIgnoreCase(rightValue.trim())) {
				isMatch = Boolean.TRUE;
			}
		}

		return isMatch;
	}

	// String Find & Replace using Pattern Matching
	public static String doValuesFindReplace(String searchPattern, String searchText, String replaceText) {

		Pattern pattern = Pattern.compile(searchPattern);
		Matcher matcher = pattern.matcher(searchText);
		return matcher.replaceAll(replaceText);

	}
	
  // Validate value against Match pattern
   public static String validateValuesAgainstPattern(String searchPattern, String searchText) {

      Pattern pattern = Pattern.compile(searchPattern);
      Matcher matcher = pattern.matcher(searchText);
      if(matcher.find()){
         return null;
      }
      return searchText;
   }

	/**
	 * 
	 * Converts the value to uppercase and also removes the leading and trailing
	 * spaces in the value
	 * 
	 * @param value is a instance of String class
	 * 
	 * @return the result which is a instance of String class
	 * 
	 */
	public static String doTrimPlusUpperCase(String value) {

		if (StringUtils.isNotNull(value))
			return value.trim().toUpperCase();

		return null;

	}
	
	/**
	 * 
	 * Gets the secret location path and the authentication user to retrieve password
	 * 
	 * @param secretLocationPath is the secret location of the password
	 * @param authUser is the ID whose password needs to be retrieved
	 * 
	 * @return the password from the secret location
	 * 
	 */
	public static String retrievePwdFromSecretsLocation(String secretLocationPath, String authUser) {
		
		String password = null;
		try {
			password = new String(Files.readAllBytes(Paths.get(secretLocationPath + authUser)));
		} catch (IOException e) {
			LOGGER.error("ERROR while reading from SecretLocationPath  : " + e);
			password = secretLocationPath;
		}
		return password;
	}

}
