package Exam_Mars_2019.exo3;

public class DataBlocStore {
	private DataBloc[] blocs;
	public DataBlocStore(int size) {
		blocs=new DataBloc[size];
	}
	public int size() {
		return blocs.length;
	}
	public byte[] read(int i) throws OutOfMemoryError {
		if(i >= size()) {
			throw new OutOfMemoryError();
		}
		return blocs[i].read();
	}
	public void write(int i, byte[] b) throws OutOfMemoryError {
		if(i >= size()) {
			throw new OutOfMemoryError();
		}
		blocs[i].write(b);
	}
}
