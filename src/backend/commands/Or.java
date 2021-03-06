/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.command_abstraction.MathCommandTwoParams;
import constants.Constants;

/**
 * @author harirajan
 *
 */
public class Or extends MathCommandTwoParams {


	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		if (params.get(0) == 1.0 || params.get(1) == 1.0) {
			return Constants.TRUE;
		} else {
			return Constants.FALSE;
		}
	}
	


}
