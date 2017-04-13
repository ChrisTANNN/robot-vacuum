
public class Tache {
	//Attributs
		int diametre;
		Position p;
		
		//Constructeurs
		public Tache(int d, Position pp){
			this.diametre = d;
			this.p = pp;
		}
		
		public Position calculPosition(Position pp){
			Position p = new Position();
			p.x = pp.x - 17;
			p.y = pp.y - 17;
			return p;
		}
}
