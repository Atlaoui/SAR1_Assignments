package TME2.TD;


import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import TME1.banque.Client;
import TME1.banque.Compte;

public class tools {
	public static String toString(Object o) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder S= new StringBuilder();
		Field[] fld = o.getClass().getDeclaredFields();
		S.append(o.getClass().getCanonicalName()+'\n');
		for(Field f : fld) {
			
			f.setAccessible(true);
			S.append(f.getType() +"="+ f.get(o));
		}
		return S.toString();
	}
	public static Set<Class<?>> getTypes(Object o){
		Set<Class<?>> set = new HashSet<>();
		set  = getTypes(o.getClass(),set);
		return set;
	}

	private static Set<Class<?>> getTypes(Class<?> c, Set<Class< ?>> set) {
		set.add(c);
		if(!c.equals(Object.class)) {
			for(Class<?> itf : c.getInterfaces()) {
				set.addAll(getTypes(itf,set));
			}
			if(!c.isInterface()) {
				set.addAll(getTypes(c.getSuperclass()));
			}
		}
		return set;
	}
	public static void main(String[] args) {
		Client c = new Client("Teste",new Compte("19"));
		try {
			//tools.toString(c);
			System.out.println(getTypes(c));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
