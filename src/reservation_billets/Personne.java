package reservation_billets;

public class Personne {
	protected String nomPersonne;
	protected String  prenomPersonne;
	protected String tel;
	public Personne(String nomPersonne, String prenomPersonne, String tel) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.tel = tel;
	}
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	

}
