package TME2.command;

import TME2.intpreter.Interpreteur;

public class Undeploy implements Command {

	private static final long serialVersionUID = 1L;
	private Interpreteur inter;
	private String nom ;
	public Undeploy(Interpreteur inter) {
		this.inter=inter;
		System.out.println("WOUAAAAAAAAAAAAAAAH");
	}

	@Override
	public void execute() {
		nom=inter.getArgs().toString();
		inter.remove(nom);
	}

}
