package Exam_Mars_2019.exo3;

public class DataBloc {
	public static final int size=2048;
	private byte[] tab;
	public DataBloc() {
		tab= new byte[size];
	}
	public int size() {
		return tab.length;
	}
	public byte[] read(){
		return tab;
	}
	public void write(byte[] b){
		int i=0;
		while(i< b.length && i < tab.length) {
			tab[i]=b[i];
			i++;
		}
		while(i< tab.length) {
			tab[i]=0;
			i++;
		}
	}
}