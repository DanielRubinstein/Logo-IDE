package commands;

import java.util.List;

import backend.TurtleInfo;
import resources.languages.Resources;

public class PenUp implements Command {

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Left", 1, arguments.size()));
		}
		turtle.setPenDown(false);
		return 0;
	}
}