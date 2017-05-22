/**
 * 
 */
package com.ciii.police.database.operator;

/**
 * @author litong
 *
 */
public class SQLInjection {
	/**
	 * 
	 */
	protected boolean sqlInjection(String str) {
		String inj_str = "'|and|exec|insert|select|delete|update|" + "count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
		String[] inj_stra = inj_str.split("\\|");
		for (int i = 0; i < inj_stra.length; i++) {
			if (str.indexOf(inj_stra[i]) >= 0) {
				return true;
			}
		}
		return false;	
	}
}
