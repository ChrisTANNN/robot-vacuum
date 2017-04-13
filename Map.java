import java.util.ArrayList;

public class Map{
	
	//Attributs
	ArrayList<Obstacle> obstacles;
	ArrayList<Tache> taches;
	Robot r;
	
	
	//Constructeur par defaut
	public Map (){
		obstacles = new ArrayList <Obstacle>();
		taches = new ArrayList <Tache>();
		r = new Robot();
		//ajout 3 obstacles et 3 taches aux arraylists 
		Position p1 = new Position(300,200);
		Position p2 = new Position(25,100);
		Position p3 = new Position(300,80);
		Position p4 = new Position(200,120);
		Position p5 = new Position(120,50);
		Position p6 = new Position(170,250);
		
		Obstacle o1 = new Obstacle(50,p1);
		Obstacle o2 = new Obstacle(60,p2);
		Obstacle o3 = new Obstacle(45,p3);
		Tache t1 = new Tache(25,p4);
		Tache t2 = new Tache(15,p5);
		Tache t3 = new Tache(20,p6);
		
		obstacles.add(o1);
		obstacles.add(o2);
		obstacles.add(o3);
		taches.add(t1);
		taches.add(t2);
		taches.add(t3);
	}
	
	public void nettoyer(){
		int i;
		for(i = 0 ; i < taches.size(); i++){
			if(Math.pow((taches.get(i).p.x - r.po.getX()),2) + Math.pow((taches.get(i).p.y - r.po.getY()),2)
					<= Math.pow(((taches.get(i).diametre + r.cs.diametre)/2),2))
				taches.remove(i);
		}
	}
	
}
