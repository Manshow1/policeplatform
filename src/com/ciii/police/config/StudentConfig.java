/**
 * 
 */
package com.ciii.police.config;

/**
 * @author litong
 *
 */
public final class StudentConfig {
	private static boolean HasStudentLogin = false;

	/**
	 * @return the hasStudentLogin
	 */
	public static boolean isHasStudentLogin() {
		return HasStudentLogin;
	}

	/**
	 * @param hasStudentLogin the hasStudentLogin to set
	 */
	public static void setHasStudentLogin(boolean hasStudentLogin) {
		HasStudentLogin = hasStudentLogin;
	}
}
