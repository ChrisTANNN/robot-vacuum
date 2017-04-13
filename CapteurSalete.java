import java.lang.*;
/**
 * represente le capteur qui permet de detecter des saletes 
 *  * @author qianqian
 *
 */
public class CapteurSalete {
	//Attributs
	double diametre;
	
	//Constructeur
	public CapteurSalete(){
		this.diametre = 5;
	}
	
	//Methodes
	/**
	 * Fonction verifiant si le capteur detecte une tache  
	 * @param m : Map
	 * @return true si il detecte une tache, false sinon
	 */
	public boolean capteSalete(Map m){
		int i, num = 0;
		for(i = 0;i < m.taches.size(); i++){
		if(Math.sqrt((m.taches.get(i).p.x - m.r.po.getX())*(m.taches.get(i).p.x - m.r.po.getX())+(m.taches.get(i).p.y - m.r.po.getY())*(m.taches.get(i).p.y - m.r.po.getY()))
				<= (diametre + m.taches.get(i).diametre)/2)num+=1;
		else{}
		}
		if(num == 0)return false;
		else{return true;}
	}
	
}
