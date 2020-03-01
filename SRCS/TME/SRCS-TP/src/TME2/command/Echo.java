package TME2.command;


import java.io.IOException;
import java.io.OutputStreamWriter;

import TME2.intpreter.Interpreteur;

public class Echo implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringBuilder args;
	private Interpreteur inter;
	public Echo(Interpreteur inter) {
		this.inter=inter;
		args = new StringBuilder();
	}
	public Echo(String args) {
		this.args = new StringBuilder();
		this.args.append(args);
	}

	@Override
	public void execute()throws IllegalArgumentException {

		args = inter.getArgs();
		String line[]=args.toString().split(" ");
		for(int i =0 ,len=line.length;i<len;i++) {
			try {
				inter.getBufferWriter().write(line[i]);
				inter.getBufferWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}	

}
