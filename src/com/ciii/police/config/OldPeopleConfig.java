/**
 * 
 */
package com.ciii.police.config;

/**
 * @author litong
 *
 */
public final class OldPeopleConfig {
	private static boolean HasOldPeopleLogin = false;

	/**
	 * @return the hasOldPeopleLogin
	 */
	public static boolean isHasOldPeopleLogin() {
		return HasOldPeopleLogin;
	}

	/**
	 * @param hasOldPeopleLogin the hasOldPeopleLogin to set
	 */
	public static void setHasOldPeopleLogin(boolean hasOldPeopleLogin) {
		HasOldPeopleLogin = hasOldPeopleLogin;
	}
}
