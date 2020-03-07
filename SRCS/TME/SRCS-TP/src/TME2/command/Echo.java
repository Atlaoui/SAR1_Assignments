package TME2.command;


import java.util.List;

public class Echo implements Command {
	private static final long serialVersionUID = 1L;
	private List<String> args;
	public Echo(List<String> args) {
		this.args=args;
	}

	@Override
	public void execute(){
		args.stream().forEach(s -> System.out.println(s+" "));;
	}
}
