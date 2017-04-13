import java.util.Scanner;

public class Robot extends Thread{
	//Attributs
	Posture po;
	Bumpers c1;
	Bumpers c2;
	Bumpers c3;
	Bumpers c4;
	Bumpers c5;
	CapteurSalete cs;
	Roue rg;
	Roue rd;
	int diametre;
	
	//Constructeur par defaut
	public Robot(){
		c1 = new Bumpers(0);
		c2 = new Bumpers(-0.78539816339);//-pi/4
		c3 = new Bumpers(0.78539816339);//pi/4
		c4 = new Bumpers(-1.57079632679);
		c5 = new Bumpers(1.57079632679);
		po =  new Posture(17, 57, 0); // Nouvelle posture a l'origine
		cs = new CapteurSalete();
		rg = new Roue(1);
		rd = new Roue(1);
		diametre = 34;
	}
	
	//methodes
	public void aleatoire(){
		rg.v = 1;
		rd.v = 1;
	}
	
	public void simulerPasDeTemps(Map m){
		c1.p = this.c1.p + po.getTheta();
		c2.p = this.c2.p + po.getTheta();
		c3.p = this.c3.p + po.getTheta();
		aleatoire();
		if((c1.collision(m) || c2.collision(m) || c3.collision(m)) == true){
			rg.v = 1;
			rd.v = -1;
		}
	}

}
