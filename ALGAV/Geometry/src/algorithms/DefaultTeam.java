package algorithms;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Data.DataGatherer;
import supportGUI.Circle;
import supportGUI.Line;
import supportGUI.RandomPointsGenerator;



public class DefaultTeam {
	static DataGatherer d = new DataGatherer("/home/adrien/Documents/Master/ALGAV/Projet/Varoumas_benchmark/samples/");

	// calculDiametre: ArrayList<Point> --> Line
	//   renvoie une pair de points de la liste, de distance maximum.
	public Line calculDiametre(ArrayList<Point> points) {
		
		
		Line l ;


		if (points.size()<3) {
			return null;
		}

		Point p=points.get(0);
		Point q=points.get(1);

		/*******************
		 * PARTIE A ECRIRE *
		 *******************/
		return new Line(p,q);
	}

	// calculDiametreOptimise: ArrayList<Point> --> Line
	//   renvoie une pair de points de la liste, de distance maximum.
	public Line calculDiametreOptimise(ArrayList<Point> points) {
		//supportGUI.RandomPointsGenerator.distanceToCenter(5, 8);
	
		if (points.size()<3) {
			return null;
		}

		Point p=points.get(1);
		Point q=points.get(2);

		/*******************
		 * PARTIE A ECRIRE *
		 *******************/
		return new Line(p,q);
	}
	private ArrayList<Point> exercice5(ArrayList<Point> points){
        if (points.size()<4) return points;

        ArrayList<Point> result = tri_par_pixel(points);
        for (int i=1;i<result.size()+2;i++) {
            Point p = result.get((i-1)%result.size());
            Point q = result.get(i%result.size());
            Point r = result.get((i+1)%(result.size()));
            if (crossProduct(p,q,p,r)>0) {
                result.remove(i%result.size());
                if (i==2) i=1;
                if (i>2) i-=2;
            }
        }
        return result;
    }
	   private double crossProduct(Point p, Point q, Point s, Point t){
	        return ((q.x-p.x)*(t.y-s.y)-(q.y-p.y)*(t.x-s.x));
	    }
	private ArrayList<Point> tri_par_pixel(ArrayList<Point> points){
        if (points.size()<4) return points;
        int maxX=points.get(0).x;
        for (Point p: points) if (p.x>maxX) maxX=p.x;
        Point[] maxY = new Point[maxX+1];
        Point[] minY = new Point[maxX+1];
        for (Point p: points) {
            if (maxY[p.x]==null||p.y>maxY[p.x].y) maxY[p.x]=p;
            if (minY[p.x]==null||p.y<minY[p.x].y) minY[p.x]=p;
        }
        ArrayList<Point> result = new ArrayList<Point>();
        for (int i=0;i<maxX+1;i++) if (maxY[i]!=null) result.add(maxY[i]);
        for (int i=maxX;i>=0;i--) if (minY[i]!=null && !result.get(result.size()-1).equals(minY[i])) result.add(minY[i]);

        if (result.get(result.size()-1).equals(result.get(0))) result.remove(result.size()-1);

        return result;
    }

	// calculCercleMin: ArrayList<Point> --> Circle
	//   renvoie un cercle couvrant tout point de la liste, de rayon minimum.
	public Circle calculCercleMin(ArrayList<Point> points) {
		//points.clear();  
		//RandomPointsGenerator.generate(400000);
		//System.out.println(points.size());
		
		//points = d.getNext();
		//si il y a un seul point ont peux pas tracer le cercle donc erreur
		supportGUI.RandomPointsGenerator.generate(400000);
		if (points.size()<1) return null;
		if(true)
			return Algo(points);
		/**
		 * CX CY C_RAYON corresponde au cercle C
		 * CP_rayon le rayon de C'
		 * alpha et beta de la formule pour le barycentre
		 * SC_droite c la droite tracer de S ver C (la distance)
		 * S un point random
		 */
		double CX,CY,C_rayon,CP_rayon,alpha,beta,SC_droite;
		Point S;
		
		
		//Clone de l'array list passer ont arrgument
		ArrayList<Point> rest = new  ArrayList<>();
		for(Point p : points) rest.add((Point) p.clone());
		//1-Prendre un point dummy quelconque appartenant a l’ensemble de points de départ
		Point dummy=rest.get(0);
		Point P=dummy;
		//2-Parcourir l’ensemble de points pour trouver un point P de distance maximum au point dummy
		for (Point p: rest) if (dummy.distance(p)>dummy.distance(P)) P=p;
		//3-Re-parcourir l’ensemble de points pour trouver un point Q de distance maximum au point P
		Point Q=P;
		for (Point p: rest) if (P.distance(p)>P.distance(Q)) Q=p;
		//4-Considérer le point c le centre du segment PQ pas besoin de crée l'objet
		CX=(P.x+Q.x)/2;
		CY=(P.y+Q.x)/2;
		//5-Considérer le cercle centré en C, de rayon ∣CP∣ : il passe par P et Q
		C_rayon=P.distance(Q)/2;
		//6-ont enléve les points contenu dans le cercle considéré
		rest.remove(Q);
		rest.remove(P);
		//7-Re-parcourir l’ensemble de points et enlever tout point contenu dans le cercle considéré
		//8-S’il reste des points dans l’ensemble de points, considérer un tel point, appelé S
		while (!rest.isEmpty()){
			S=rest.remove(0);
			//9-Tracer la droite passant par S et C.
			//Celle-ci coupe le périmètre du cercle courant en deux points : soit T le point le plus éloigné de S
			SC_droite=Math.sqrt((S.x-CX)*(S.x-CX)+(S.y-CY)*(S.y-CY));
			//si le nouveau point est dans le cercle on l'igore
			if(SC_droite<=C_rayon)
				continue;
				//9-Considérer le point C′, le centre du segment ST
				CP_rayon=0.5*(C_rayon+SC_droite);

				//10-Considérer le cercle centré en C′ , de rayon ∣C′S∣ : il passe par S et T  via les coordonnées barycentriques
				alpha=CP_rayon/(double)(SC_droite);
				beta=(SC_droite-CP_rayon)/(double)(SC_droite);
			
				CX=alpha*CX+beta*S.x;
				CY=alpha*CY+beta*S.y;
				C_rayon=CP_rayon;
			

		}
		return new Circle(new Point((int)CX,(int)CY),(int)C_rayon);
	}

	// enveloppeConvexe: ArrayList<Point> --> ArrayList<Point>
	//   renvoie l'enveloppe convexe de la liste.
	public ArrayList<Point> enveloppeConvexe(ArrayList<Point> points){
		//points.clear(); 
		//oints = d.getNext();
		supportGUI.RandomPointsGenerator.generate(400000);
		if (points.size()<4) return points;
		ArrayList<Point> enveloppe = exercice5(points);

		return enveloppe;
	}
	 private ArrayList<Point> exercice3(ArrayList<Point> points){
	        if (points.size()<4) return points;

	        Point ouest = points.get(0);
	        Point sud = points.get(0);
	        Point est = points.get(0);
	        Point nord = points.get(0);
	        for (Point p: points){
	            if (p.x<ouest.x) ouest=p;
	            if (p.y>sud.y) sud=p;
	            if (p.x>est.x) est=p;
	            if (p.y<nord.y) nord=p;
	        }
	        ArrayList<Point> result = (ArrayList<Point>)points.clone();
	        for (int i=0;i<result.size();i++) {
	            if (triangleContientPoint(ouest,sud,est,result.get(i)) ||
	                    triangleContientPoint(ouest,est,nord,result.get(i))) {
	                result.remove(i);
	                i--;
	            }
	        }
	        return result;
	    }


	public ArrayList<Point> jarvis(ArrayList<Point> points){
		ArrayList<Point> result = new ArrayList<Point>();
		Point top = points.get(0);
		for(Point p : points) {
			if (p.y < top.y) top = p;
		}
		result.add(top);
		Point cur = top;
		do {
			Point min = null;
			for(Point next : points) {
				if (next.equals(cur)) continue;
				if(min == null) { 
					min = next;
					continue;
				}
				if(crossProduct(cur, min, next) <= 0) continue;
				min = next;
			}
			cur = min;
			result.add(cur);
		} while(!cur.equals(top));
		return result;
	}


	//coefficient directeur entre les deux vecteurs qui sont représenter par des pts ....
	private double dotProduct(Point p,Point other) {
		return p.x * other.x + p.y * other.y;
	}


	private boolean isEqual(int i, int j, int k, int l) {	
		return i==j || i == k || i == l || j == k || j== l || k == l;
	}
	private boolean triangleContientPoint(Point a, Point b, Point c, Point x) {
		double l1 = ((b.y-c.y)*(x.x-c.x)+(c.x-b.x)*(x.y-c.y))/(double)((b.y-c.y)*(a.x-c.x)+(c.x-b.x)*(a.y-c.y));
		double l2 = ((c.y-a.y)*(x.x-c.x)+(a.x-c.x)*(x.y-c.y))/(double)((b.y-c.y)*(a.x-c.x)+(c.x-b.x)*(a.y-c.y));
		double l3 = 1-l1-l2;
		return (0<l1 && l1<1 && 0<l2 && l2<1 && 0<l3 && l3<1);
	}

	public ArrayList<Point> toussaint(ArrayList<Point> polygon){
		double min = Double.MAX_VALUE;
		Point [] rectangle = new Point[4];
		int u = 1, r = 1, l = 1, n = polygon.size() - 1;
		for(int i=0; i < n; ++i) {
			while(Math.abs(crossProduct(polygon.get(i + 1), polygon.get(i), polygon.get(u))) <=
					Math.abs(crossProduct(polygon.get(i+1), polygon.get(i), polygon.get(u + 1)))){
				u = (u + 1) % n;
			}

			while(dotProduct(polygon.get(i + 1), polygon.get(i), polygon.get(r)) <=
					dotProduct(polygon.get(i + 1), polygon.get(i), polygon.get(r + 1))) {
				r = (r + 1) % n;
			}

			if(i == 0) l = r;

			while(dotProduct(polygon.get(i + 1), polygon.get(i), polygon.get(l)) >=
					dotProduct(polygon.get(i + 1), polygon.get(i), polygon.get(l + 1))) {
				l = (l + 1) % n;
			}

			double d_ = Math.sqrt((double)calculDistance(polygon.get(i), polygon.get(i + 1))),
					r_ = dotProduct(polygon.get(i + 1), polygon.get(i), polygon.get(r)) / d_,
					l_ = dotProduct(polygon.get(i + 1), polygon.get(i), polygon.get(l)) / d_,
					dd = Math.abs(crossProduct(polygon.get(i + 1), polygon.get(i), polygon.get(u))) / d_,
					ll = r_ - l_, s = ll * dd;
			if (s < min) {
				min = s;
				// top = pi + (p(i+1) - pi) * (r_/d_)
				Point top = dotPlusdot(polygon.get(i), dotProductConstant(dotMoinsdot(polygon.get(i + 1), polygon.get(i)), (r_/d_)));
				rectangle[0] = top;
				// right = top + ( (pr - top) * (dd / dis(pr, top)) )
				Point right = dotPlusdot(top, dotProductConstant(dotMoinsdot(polygon.get(r), top), (dd/Math.sqrt(calculDistance(polygon.get(r), top)))));
				rectangle[1] = right;
				//left = right + ( (pi - top) * (ll / r_) )
				Point left = dotPlusdot(right, dotProductConstant(dotMoinsdot(polygon.get(i), top), (ll/r_)));
				rectangle[2] = left;
				Point down = dotPlusdot(left, dotMoinsdot(top, right));
				rectangle[3] = down;
			}
		}
		return new ArrayList<Point>(Arrays.asList(rectangle));
	}
	private int dotProduct(Point pre, Point cur, Point next) {
		int x1 = cur.x - pre.x, y1 = cur.y - pre.y,
				x2 = cur.x - next.x, y2 = cur.y - next.y;
		return x1*x2 + y1*y2;
	}

	public int calculDistance(Point p1, Point p2) {
		return (p1.x-p2.x) * (p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y);
	}


	private Point dotPlusdot(Point a, Point b) {
		return new Point(a.x + b.x, a.y + b.y);
	}

	private Point dotProductConstant(Point p, double c) {
		return new Point((int)(p.x * c),(int)(p.y * c));
	}

	private Point dotMoinsdot(Point a, Point b) {
		return new Point(a.x - b.x, a.y - b.y);
	}

	private int crossProduct(Point pre, Point cur, Point next) {
		int ax = cur.x - pre.x, ay = cur.y - pre.y, 
				bx = cur.x - next.x, by = cur.y - next.y;
		int res = (ax * by) - (ay * bx);
		return res;
	}
	private Random random = new Random();
	public  Circle Algo(ArrayList<Point> points) {
		//si il y a un seul point ont peux pas tracer le cercle donc erreur
		 if (points.size()<1) return null;
		 
		 	//Clone de l'array list passer ont arrgument 
	        ArrayList<Point> rest = new  ArrayList<>();   
	        for(Point p : points) rest.add((Point) p.clone());
	        
	        //1-Prendre un point dummy quelconque appartenant a l’ensemble de points de départ
	        Point dummy=rest.get(random.nextInt(points.size()));
	        Point p=dummy;
	        //2-Parcourir l’ensemble de points pour trouver un point P de distance maximum au point dummy
	        for (Point s: rest) if (dummy.distance(s)>dummy.distance(p)) p=s;
	        //3-Re-parcourir l’ensemble de points pour trouver un point Q de distance maximum au point P
	        Point q=p;
	        for (Point s: rest) if (p.distance(s)>p.distance(q)) q=s;
	        
	        //4-Considérerc le point c le centre du segment PQ
	        double cX=.5*(p.x+q.x);
	        double cY=.5*(p.y+q.y);
	        //5-Considérer le cercle centré en C, de rayon ∣CP∣ : il passe par P et Q
	        double cRadius=.5*p.distance(q);
	        
	      //6-Re-parcourir l’ensemble de points et enlever tout point contenu dans le cercle considéré
	        rest.remove(p);
	        rest.remove(q);
	        
	        while (!rest.isEmpty()){
	        	//6-Re-parcourir l’ensemble de points et enlever tout point contenu dans le cercle considéré
	        	//7-S’il reste des points dans l’ensemble de points, considérer un tel point, appelé S
	            Point s=rest.remove(0);
	         
	            //8-Tracer la droite passant par S et C.
	            //Celle-ci coupe le périmètre du cercle courant en deux points : soit T le point le plus éloigné de S
	            double distanceFromCToS=Math.sqrt((s.x-cX)*(s.x-cX)+(s.y-cY)*(s.y-cY));
	            if (distanceFromCToS>cRadius) {
	            
	            //9-Considérer le point C′, le centre du segment ST
	            double cPrimeRadius=.5*(cRadius+distanceFromCToS);
	            
	            //10-Considérer le cercle centré en C′ , de rayon ∣C′S∣ : il passe par S et T  via les coordonnées barycentriques 
	            double alpha=cPrimeRadius/(double)(distanceFromCToS);
	            double beta=(distanceFromCToS-cPrimeRadius)/(double)(distanceFromCToS);
	            double cPrimeX=alpha*cX+beta*s.x;
	            double cPrimeY=alpha*cY+beta*s.y;
	            cRadius=cPrimeRadius;
	            cX=cPrimeX;
	            cY=cPrimeY;
	            }
	        }
	        return new Circle(new Point((int)cX,(int)cY),(int)cRadius);
	}
	
	private boolean isInCircle(int x_point ,int y_point,double x_centre ,double y_centre,double rayon) {
		return Math.sqrt((x_point-x_centre)*(x_point-x_centre) +(y_centre-y_point))<rayon;
	}
	public static Circle computeRitter(ArrayList<Point> points) {

		// On prend un point dummy quelconque dans le nuage de points.
		Random random = new Random();
		Point dummy = points.get(random.nextInt(points.size()));
		double distance = Integer.MIN_VALUE;
		// p est le point le plus éloigné de dummy dans le nuage de points.
		Point p = null;
		for (Point temp : points) {
			double d = dummy.distance(temp);
			if (d >= distance) {
				distance = d;
				p = temp;
			}
		}
		// q est le point le plus éloigné de p dans le nuage de points.
		Point q = null;
		for (Point temp : points) {
			double d = p.distance(temp);
			if (d >= distance) {
				distance = d;
				q = temp;
			}
		}

		Point c, c2 = null;
		double cp = 0;

		// Coordonnées du centre du segment [PQ]
		int a = (p.x + q.x) / 2;
		int b = (p.y + q.y) / 2;
		// c est le centre du segment [PQ]
		c = new Point(a, b);
		// Rayon du cercle de centre c, passant par P et Q (distance CP)
		cp = Point.distance(a, b, p.x, p.y);
		// On parcourt la liste de points, et on enlève tout point compris dans
		// ce cercle
		ArrayList<Point> l = new ArrayList<Point>();
		for (Point temp : points) {
			if (Point.distance(a, b, temp.x, temp.y) > cp) {
				l.add(temp);
			}
		}
		// S'il ne reste plus de points dans la liste
		if (l.isEmpty()) {
			// On renvoie le cercle centré en C, et de rayon CP
			return new Circle(c, (int) cp);
		}
		// S'il en reste, soit s un de ces points
		Point s = null;
		// Tant que la liste n'est pas vide
		while (!l.isEmpty()) {
			ArrayList<Point> l1 = new ArrayList<Point>();
			// S est un point quelconque dans la liste des points.
			s = l.get(random.nextInt(l.size()));
			// On l'enlève de la liste.
			l.remove(s);
			// 8.

			double alpha, beta;
			// Distance du centre du cercle à S
			double sc = Point.distance(s.x, s.y, a, b);
			// T est sur le cercle,
			double st = sc + cp;
			double sc2 = st / 2;
			double cc2 = sc - sc2;
			alpha = sc2 / sc;
			beta = cc2 / sc;

			// 9.
			int a2 = (int) (alpha * a + beta * s.x);
			int b2 = (int) (alpha * b + beta * s.y);
			c2 = new Point(a2, b2);
			for (Point temp : l) {
				if (Point.Double.distance(a2, b2, temp.x, temp.y) > sc2) {
					l1.add(temp);
				}
			}
			if (l1.isEmpty()) {
				return new Circle(c2, (int) sc2);
			} else {
				l = (ArrayList<Point>) l1.clone();
				a = a2;
				b = b2;
				cp = sc2;
			}
			// 10.

		}
		return new Circle(c2, (int) cp);
	}
	public Circle CercleMinRitter ( ArrayList < Point > points ) {
		// Initialisation des variables
		int pos_alea = ( int ) ( Math . random () *( points . size () ));
		Point dummy = points . get ( pos_alea );
		Point P = null ;
		Point Q = null ;
		Point C = null ;
		Point S = null ;
		Point Cbis = null ; // C '
		Circle circle ;
		double distance = 0;
		int control = 0;
		// borne du nombre de tours pour le while
		int max_nb_tours = 200;
		// recherche le point le plus eloigne de dummy --> P
		for ( int i = 0 ; i < points . size () ; i ++) {
		if ( dist ( dummy , points . get (i)) > distance ) {
		P = points . get (i);
		distance = dist ( dummy , points . get (i));
		}
		}
		// recherche le point le plus eloigne de P --> Q
		distance = 0;
		for ( int i = 0 ; i < points . size () ; i ++) {
		if ( dist (P , points . get (i)) > distance ) {
		Q = points . get (i);
		distance = dist ( dummy , points . get (i));
		}
		}
		// Le point C , centre de P et Q
		C = new Point (( P.x + Q.x) / 2, (P.y + Q.y) / 2) ;
		circle = new Circle (C , ( int ) dist (C , P));
		while ( control < max_nb_tours ) {
		control ++;
		C = circle . getCenter () ;
		// On enleve tout les points qui
		// sont dans le cercle
		ArrayList < Point > tmp = new ArrayList < Point >() ;
		for ( Point p : points ) {
			if ( dist (C , p) > circle . getRadius () ) {
				tmp . add (p);
				}
		}
		points = tmp ;
		if ( points . size () > 0) {
		S = points . get (( int ) ( Math . random () * points . size () ));
		} else {
		break ;
		}
		// S 'il reste des points , CS coupe
		// le perimetre du cercle en T et S
		double cs = dist (C , S);
		double cbs = ( circle . getRadius () + cs ) / 2; // nouveau rayon
		double ccb = cs - cbs ; // distance entre C et C '
		// Calcul des coordonnees de C '
		double x = ( ccb / cs ) * S.x + ( cbs / cs ) * C.x;
		double y = ( ccb / cs ) * S.y + ( cbs / cs ) * C.y;
		Cbis = new Point (( int ) x , ( int ) y);
		circle = new Circle ( Cbis , ( int ) cbs );
		}
		return circle ;
	}

	private double dist(Point c, Point s) {
		// TODO Auto-generated method stub
		return c.distance(s);
	}
	   private ArrayList<Point> exercice6(ArrayList<Point> points){
	        if (points.size()<4) return points;

	        Point ouest = points.get(0);
	        Point sud = points.get(0);
	        Point est = points.get(0);
	        Point nord = points.get(0);
	        for (Point p: points){
	            if (p.x<ouest.x) ouest=p;
	            if (p.y>sud.y) sud=p;
	            if (p.x>est.x) est=p;
	            if (p.y<nord.y) nord=p;
	        }
	        ArrayList<Point> result = new ArrayList<Point>();
	        result.add(ouest);
	        result.add(sud);
	        result.add(est);
	        result.add(nord);

	        ArrayList<Point> rest = (ArrayList<Point>)points.clone();
	        for (int i=0;i<rest.size();i++) {
	            if (triangleContientPoint(ouest,sud,est,rest.get(i)) ||
	                    triangleContientPoint(ouest,est,nord,rest.get(i))) {
	                rest.remove(i);
	                i--;
	                    }
	        }

	        for (int i=0;i<result.size();i++) {
	            Point a = result.get(i);
	            Point b = result.get((i+1)%result.size());
	            Point ref = result.get((i+2)%result.size());

	            double signeRef = crossProduct(a,b,a,ref);
	            double maxValue = 0;
	            Point maxPoint = a;

	            for (Point p: points) {
	                double piki = crossProduct(a,b,a,p);
	                if (signeRef*piki<0 && Math.abs(piki)>maxValue) {
	                    maxValue = Math.abs(piki);
	                    maxPoint = p;
	                }
	            }
	            if (maxValue!=0){
	                for (int j=0;j<rest.size();j++) {
	                    if (triangleContientPoint(a,b,maxPoint,rest.get(j))){
	                        rest.remove(j);
	                        j--;
	                    }
	                }
	                result.add(i+1,maxPoint);
	                i--;
	            }
	        }
	        return result;
	    }
	
}
