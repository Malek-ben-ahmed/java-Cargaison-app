import java.util.ArrayList;

public class Cargaison_routière extends Cargaison {
	float c;


    public Cargaison_routière(float distance, ArrayList<Marchandisse> m) {
		super(distance,m);
		
	}


	public float Calculer_coûtCargaison() {
		if(super.Calculer_VolumesMarchandisses()<380000) {
			c+=4*super.distance*p;
			return c;
		}
		else {
			 c+=6*super.distance*p ;
			 return c;
		}
	};
	public String toString() {
		return "cargaison routière"+super.toString();
	};
}
