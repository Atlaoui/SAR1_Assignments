package com.paracamplus.ilp3.ilp3Tme7.interpreter;

import java.util.List;
import java.util.concurrent.Semaphore;

import com.paracamplus.ilp1.interpreter.Interpreter;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.Invocable;

public class CoroutineInstance extends Thread {
	private List<Object> args;
	private Invocable func;
	private Semaphore sem_resume = new Semaphore(0);
	private Semaphore sem_yield = new Semaphore(0);
	private Interpreter vis;
	private boolean isEnded = false;

	public CoroutineInstance(Invocable f,List<Object> a , Interpreter v ) {
		vis = v;
		args = a;		
		func = f;
		this.start();
	}

	public void run() {
		try {
			
			sem_resume.acquire();
			func.apply(vis, args.toArray());
			System.out.println("Fini");
			isEnded =true;
			sem_yield.release();
			
		} catch (EvaluationException e) {
			e.printStackTrace();
		}	
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	public boolean resumeCoroutine() {
		System.out.println("Resume_Couroutine");
		if(isEnded) {
			System.out.println("Endend");
			sem_yield.release();
		}
		else {
			
			try {
				
				sem_resume.release();
				sem_yield.acquire();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isEnded;
			
	}

	public void yieldCoroutine() {		
		try {
			//ont lache l'appelant et ont reprond l'éxecution
			sem_yield.release();
			sem_resume.acquire();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
