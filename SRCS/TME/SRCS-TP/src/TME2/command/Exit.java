package TME2.command;

import java.util.List;

public class Exit implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int value;
	public Exit(List<String> args) {
		if(args.size()>1)
			throw new IllegalArgumentException("To much args");
		if(args.size()==1)
			value=Integer.parseInt(args.get(0));
		else
			value=0;

	}
	@Override
	public void execute() throws IllegalArgumentException{
		System.out.println("End");
		System.exit(this.value);
	}
}
