import java.util.ArrayList;

abstract public class Cargaison {
    protected float distance;
    protected ArrayList <Marchandisse>  Ma ;
    float v;
	float p;

	public Cargaison(float distance, ArrayList<Marchandisse> m) {
		this.distance = distance;
		Ma = m;
	}
	public void Ajouter_Marchandisse(Marchandisse mar) {
		Ma.add(mar);
	};
	public void Afficher_ToutesMarchandisses() {
		System.out.println("toutes les marchandisses de cette cargaison aérienne sont:");
		for(int i=0;i<Ma.size();i++) {
			System.out.println(Ma.get(i).toString());}
		}
	public void Afficher_Marchandisses(int numero) {
		for(int i=0;i<Ma.size();i++) {
			if(Ma.get(i).num==numero) {
				System.out.println(Ma.get(i).toString());
			}
			break;
		}
	};
    public float Calculer_VolumesMarchandisses() {
		
		for(int i=0;i<Ma.size();i++) {
			v+=(Ma.get(i).volume);
		}
		return v;
	};
	public float Calculer_PoidsMarchandisses() {
		for(int i=0;i<Ma.size();i++) {
			p+=Ma.get(i).poids;
		}
		return p;
	};
    abstract public float Calculer_coûtCargaison() ;
	@Override
	public String toString() {
		return "[distance=" + distance+"]" ;
	}
     
}
