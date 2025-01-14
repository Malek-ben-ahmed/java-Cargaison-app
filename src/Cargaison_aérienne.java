import java.util.ArrayList;
import java.util.List;

public class Cargaison_aérienne extends Cargaison {
	float c;


    public Cargaison_aérienne(float distance, ArrayList<Marchandisse> m) {
		super(distance,m);
		
	}

	public float Calculer_coûtCargaison(){
		if(super.Calculer_VolumesMarchandisses()<80000) {
			c+=10*super.distance*p ;
			return c;
		}
		else {
			 c+=12*super.distance*p ;
			 return c;
		}
	};
	public String toString() {
		return "cargaison aérienne"+super.toString();
}}
