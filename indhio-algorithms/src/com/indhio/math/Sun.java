package com.indhio.math;

import java.util.Enumeration;
import java.util.Vector;

public class Sun {

	public double[] calculateMeanAndSD(Vector vector) {
		double sum = 0.0;
		double mean = 0.0;
		double sigma = 0.0; // standard deviation;
		int numberObservations = 0;

		Enumeration enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			Double dd = (Double) enumeration.nextElement();
			sum += dd.doubleValue();
		}

		mean = sum / vector.size();

		// calculate standard deviation
		sum = 0.0;
		enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			Double dd = (Double) enumeration.nextElement();
			//sum += square(dd.doubleValue() - mean);
		}

		sum = sum / (vector.size() - 1); // divide by n-1
		sigma = Math.sqrt(sum);

		double[] returnArray = { mean, sigma };

		return returnArray;
	}

}
