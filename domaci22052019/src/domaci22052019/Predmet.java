package domaci22052019;


public class Predmet {
	private int sifraPredmeta;
	private String nazivPredmeta;
	
	public Predmet(int sifraPredmeta, String nazivPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
	}

	public int getSifraPredmeta() {
		return sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	
	@Override
	public String toString() {
		return "sifra predmeta: " + sifraPredmeta + ", naziv predmeta: " + nazivPredmeta;
	}
}
