package TME2.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import TME2.intpreter.Interpreteur;
//https://rafalcieslak.wordpress.com/2013/04/02/dynamic-linker-tricks-using-ld_preload-to-cheat-inject-features-and-investigate-programs/
//https://blog.jessfraz.com/post/ld_preload/

public class test {
	public static void main(String[] args) {
		Interpreteur i = new Interpreteur();
		String path = "/home/adrien/Documents/Master/Master_1-S2/SRCS/TME/Teste/bin/";
		URL [] ur = new URL[1]; 
		System.out.println(1);
		
			//ur[0] = new File(path).toURI().toURL();
			//URLClassLoader  classLoader = new URLClassLoader(ur);
		//	System.out.println(classLoader.loadClass("Add"));
			i.run();
		
	}




	public void invokeClassMethod(String classBinName, String methodName){

		try {

			// Create a new JavaClassLoader 
			ClassLoader classLoader = this.getClass().getClassLoader();

			// Load the target class using its binary name
			Class loadedMyClass = classLoader.loadClass(classBinName);

			System.out.println("Loaded class name: " + loadedMyClass.getName());

			// Create a new instance from the loaded class
			Constructor constructor = loadedMyClass.getConstructor();
			Object myClassObject = constructor.newInstance();

			// Getting the target method from the loaded class and invoke it using its name
			Method method = loadedMyClass.getMethod(methodName);
			System.out.println("Invoked method name: " + method.getName());
			method.invoke(myClassObject);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
