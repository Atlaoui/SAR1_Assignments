package TME2.command;

public class Exit implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String args;
	public Exit() {

	}
	public Exit(String args) {
		this.args=args;
	}
	@Override
	public void execute() throws IllegalArgumentException{
		if(args==null)
			System.exit(1);
		else
			System.exit(Integer.parseInt(args));
	}

}
