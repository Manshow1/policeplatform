/**
 * 
 */
package com.ciii.police.model.response.student;

import java.util.ArrayList;

/**
 * @author litong
 *
 */
public class Schedule {
    private ArrayList<Times> times;

    /**
	 * 
	 */
	public ArrayList<Times> getTimes() {
        return times;
    }

	/**
	 * 
	 */
	public void setTimes(ArrayList<Times> times) {
        this.times = times;
    }
}
