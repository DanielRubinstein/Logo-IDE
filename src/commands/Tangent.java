/**
 * 
 */
package commands;

import java.util.List;

import resources.languages.Resources;

/**
 * @author harirajan
 *
 */
public class Tangent extends LogicCommand {
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Forward", 1, input.size()));
		}
		
		return Math.toDegrees(Math.tan(Math.toRadians(input.get(0))));
	}
}