import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Simulation extends JPanel {
	//Attributs 
	private static Map m;
	private int x;
	private int prev_x;
	private int y;
	private int prev_y;
	
	public Simulation(){
		x = 0;
		y = 40;
		m = new Map();
	    setBackground(Color.white);
	    setOpaque(true);
	}
	
	/**
	   * Deplace l'objet a la position indiquee
	   * @param x Nouvelle coordonnee x
	   * @param y Nouvelle coordonnee y
	   */
	  public void moveRobot(int x, int y)
	  {
	    this.x = x;
	    this.y = y;
	  }
	  
	
	  /**
	   * Fonction appelee automatiquement quand le JPanel est (re)dessine a l'ecran
	   */
	public void paint(Graphics g){
		 super.paint(g); // Dessine le contenu d'un panel
	      int i,j;
	      //on dessine les taches noirs
	      for(i = 0; i < m.taches.size(); i++){
	    	 // g.drawOval((int)(m.taches.get(i).p.x -m.taches.get(i).diametre/2), (int)(m.taches.get(i).p.y - m.taches.get(i).diametre/2) , m.taches.get(i).diametre,m.taches.get(i).diametre);
	    	  g.setColor(Color.black);
	    	 g.fillOval((int)m.taches.get(i).p.x -m.taches.get(i).diametre/2, (int)m.taches.get(i).p.y - m.taches.get(i).diametre/2 , m.taches.get(i).diametre,m.taches.get(i).diametre);
	    	  //g.fillOval((int)m.taches.get(i).p.x , (int)m.taches.get(i).p.y, m.taches.get(i).diametre,m.taches.get(i).diametre);
    	    
	      }
	     //on dessine les obstacles rouges
	      for(j = 0; j <m.obstacles.size();j++){
	    	  g.setColor(Color.red);
	    	  g.fillOval((int)m.obstacles.get(j).p.x - m.obstacles.get(j).diametre/2, (int)m.obstacles.get(j).p.y - m.obstacles.get(j).diametre/2, m.obstacles.get(j).diametre,m.obstacles.get(j).diametre);
	    	//  g.fillOval((int)m.obstacles.get(j).p.x, (int)m.obstacles.get(j).p.y, m.obstacles.get(j).diametre,m.obstacles.get(j).diametre); 
	      }
	      
	      // on recupere la zone de dessin
	      Graphics2D g2 = (Graphics2D) g;
	      // on efface une zone un peu plus grande que le cercle
	      g2.setColor(Color.white);
	      g2.fillOval(prev_x, prev_y, 35, 35);
	      // on dessin un disque rouge
	      g2.setColor(Color.blue);
	      g2.drawOval(x, y, m.r.diametre, m.r.diametre);
	      g2.drawLine(x+17,y+17,(int) (x+17+17*Math.cos(m.r.po.getTheta())),(int)(y+17-17*Math.sin(m.r.po.getTheta())));
	      // on rend la main
	      g2.dispose();
	      // on retient x,y pour pouvoir effacer au prochain appel
	      prev_x = x;
	      prev_y = y;
	}

	public static void main (String [] args) 
	  {
		JFrame ma_fenetre = new JFrame("My map"); // Nouvelle fenetre
		Simulation s = new Simulation(); // Nouvel objet Move
		ma_fenetre.setPreferredSize(new Dimension(400, 400)); // Taille de la fenetre
		ma_fenetre.setContentPane(s); // Le contenu est l'objet Move
	    ma_fenetre.pack();
	    ma_fenetre.setVisible(true);
	    
	  //  s.moveRobot(0, 0); // On deplace le robot a la coordonnee (0,0)
	   
	    while (true)
	   {
	    double tho = 0.5; //pas de temps discret
	    //System.out.println(m.r.po);
		
	    m.r.simulerPasDeTemps(m);
		
		m.r.po.move(m.r.rg.v*tho, m.r.rd.v*tho, m.r.diametre);
		s.moveRobot((int) m.r.po.getX()-m.r.diametre/2 ,(int) m.r.po.getY()-m.r.diametre/2);
		m.nettoyer();
		
		// attend 0.01 sec
		try  { Thread.sleep(10); }
		catch (Exception e) {}
		// Redessine la fenetre (appelle automatiquement entre autres m.paint())
		s.repaint();
	      }
	  
	  }
}
