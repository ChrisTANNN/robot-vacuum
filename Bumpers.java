

public class Bumpers extends Capteur{
	
	//Constructeur
	public Bumpers(double p){
		super(p);
	}
	
	//Methodes
	//la methode renvoie true si le cpateur est en collision avec un obstacle ou mur, false sinon
	public boolean collision(Map m){
		int i,num = 0;
		double alpha;
		Position positionCapteur = new Position();
		
		//on calcule les coordonnees du capteur
		//le rayon du robot est 17 cm
		alpha = normalize_angle(p+m.r.po.getTheta());
		positionCapteur.x = m.r.po.getX() + (m.r.diametre/2)*Math.cos(alpha);
		positionCapteur.y = m.r.po.getY() - (m.r.diametre/2)*Math.sin(alpha);
		
		for(i = 0; i < m.obstacles.size(); i++){
			if(positionCapteur.x <= 0 || positionCapteur.y <= 0 || positionCapteur.x >= 350 ||positionCapteur.y >= 350)num+=1;
			if(Math.sqrt((m.obstacles.get(i).p.x - positionCapteur.x)*(m.obstacles.get(i).p.x - positionCapteur.x)+(m.obstacles.get(i).p.y - positionCapteur.y)*(m.obstacles.get(i).p.y - positionCapteur.y))
					<= (m.obstacles.get(i).diametre/2))num+=1;
			
		}
		
		
	
		if(num == 0)return false;
		else{
			return true;
		}
	
	} 
	public double normalize_angle(double a){
		    while (a > Math.PI)
		      a -= 2 * Math.PI;
		    while (a < -Math.PI)
		      a += 2 * Math.PI;
		    return a;
		  } 

}
