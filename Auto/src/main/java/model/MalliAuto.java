package model;

public class MalliAuto {
	private String rekno, merkki, malli;
	private int vuosi;
	
	//Konstruktorit
	public MalliAuto() {
		super();
		
	}


	//Parametrillinen konstruktori
	public MalliAuto(String rekno, String merkki, String malli, int vuosi) {
		super();
		this.rekno = rekno;
		this.merkki = merkki;
		this.malli = malli;
		this.vuosi = vuosi;
	}
	
	//Getterit ja setterit
	public String getRekno() {
		return rekno;
	}

	public void setRekno(String rekno) {
		this.rekno = rekno;
	}

	public String getMerkki() {
		return merkki;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	public int getVuosi() {
		return vuosi;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}
	
	//toString
	@Override
	public String toString() {
		return "MalliAuto [rekno=" + rekno + ", merkki=" + merkki + ", malli=" + malli + ", vuosi=" + vuosi + "]";
	}
	
	
}
