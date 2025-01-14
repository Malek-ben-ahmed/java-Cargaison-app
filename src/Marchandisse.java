
public class Marchandisse {
    protected int num;
    protected float poids;
    protected float volume;
	public Marchandisse(int num, float poids, float volume) {
		super();
		this.num = num;
		this.poids = poids;
		this.volume = volume;
	}
	@Override
	public String toString() {
		return "cargaison routière"+super.toString();
	
}}
