
public class Carta {
	
	private final String face;
	private final String naipe;
	
	public Carta(String face, String naipe) {
		super();
		this.face = face;
		this.naipe = naipe;
	}
	
	public String toString(){
		return face +" de "+ naipe;
	}

	public String getFace() {
		return face;
	}

	public String getNaipe() {
		return naipe;
	}
}
