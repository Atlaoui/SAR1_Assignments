package Data;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataGatherer {
	private String path;
	
	//trouver autre chose pour le stockage
	private ArrayList<ArrayList<Point>> allData = new ArrayList<>();
	
	private int NBSAMPLES = 1664;
	private int index = 1;
	
	
	
	public DataGatherer(String path) {
		this.path=path;
	}
	

	/**
	 * Parser toutes les instances de donner a traiter
	 */
	public ArrayList<ArrayList<Point>>  ParseAll() {	
		for (int i =1 ;i< NBSAMPLES  ;i++)
			allData.add(getPoints(path+"test-"+i+".points"));
		
		return allData;
	}
	/**
	 * Parser a la voler
	 */
	public ArrayList<Point> getNext(){
		return getPoints(path+"test-"+index+++".points");
	};

	/**
	 * Fonction qui permet la lecture du fichier de pts
	 * */
	private ArrayList<Point> getPoints(String filePath) {
		ArrayList<Point> pointsLu = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine())!=null) {
				String[] s = line.split("\\P{N}+");
				if(s.length==2)
				pointsLu.add(new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1])));

			}
			br.close();		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pointsLu;
	}
	
	
}
