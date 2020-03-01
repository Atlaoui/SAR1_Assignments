package TME2.TD;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
//@Retention(Runtime)
//@Target(METHOD)
public @interface ExecuteOnBuilding {
	int value() default 1;
/*	
	public <T> T deploy(Class<T> c) {
		for(Methode v : c.getMethods()) {
			ExecuteOnBuilding annot = m.getAnnotation(ExecutingOnBuilding.class);
			if(annot!=null) {
				for(int i=0;i<annot.value();i++) {
					m.invoke(c);
				}
			}
		}
		return e;
	}*/
}


