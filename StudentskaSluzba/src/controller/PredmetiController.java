package controller;

import java.util.ArrayList;
import java.util.List;

import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import model.Student;


/**
 * Klasa koja rukuje reakcijama na dogadjaje entiteta/modela: Predmet.
 * 
 * @author Vaxi
 *
 */
public class PredmetiController {

	private static PredmetiController instance = null;
	//List<Predmet> listaPredmetaZaSerijalizaciju = new ArrayList<Predmet>();
	List<Predmet> listaPredmetaZaSerijalizaciju = SerijalizacijaPredmeta.getInstance().deserijalizacijaObjekta();
	
	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}

	private PredmetiController() {

	}
	
	/**
	 * Metoda koja prosledjeni Predmet stavlja u BazuPredmeta.
	 * @param predmet
	 */
	public void dodavanjePredmeta(Predmet predmet) {
		BazaPredmeta.getInstance().dodajPredmet(predmet.getSifraPredmeta(), predmet.getNazivPredmeta(),
				predmet.getSemestar(), predmet.getGodinaStudija(), predmet.getPredmetniProfesor(), predmet.getListaStudenata());
		//Dodajemo predmeta u listu za serijalizaciju
		listaPredmetaZaSerijalizaciju.add(predmet);
	}
	
	/**
	 * Metoda koja za prosledjeni red, vrati iz baze taj Predmet.
	 * @param selectedRowIndex
	 * @return
	 */
	public Predmet getListaPredmeta(int selectedRowIndex) {
		return BazaPredmeta.getInstance().getPredmeti().get(selectedRowIndex);
	}
	
	
	  //Metoda koja vraca studenta za prosledjeni index reda public Predmet
	 public Predmet getPredmetByRowIndex(int rowIndex) { 
		 return BazaPredmeta.getInstance().getPredmeti().get(rowIndex); 
	}
	 
	
	//Metoda koja vraca studenta za prosledjenu sifru
	public Predmet getPredmetByID(String sifra) {
		List<Predmet> listaPredmeta = new ArrayList<Predmet>();
		listaPredmeta = BazaPredmeta.getInstance().getPredmeti();
		
		for(Predmet predmet : listaPredmeta) {
			if(predmet.getSifraPredmeta().equals(sifra)) {
				return predmet;
			}else
			{
				System.out.println("Nije isto");
			}
		}
		return null;
		
	}
	
	public Predmet getPredmetByNaziv(String naziv) {
		List<Predmet> listaPredmeta = new ArrayList<Predmet>();
		listaPredmeta = BazaPredmeta.getInstance().getPredmeti();
		for(Predmet predmet : listaPredmeta) {
			if(predmet.getNazivPredmeta().equals(naziv)) {
				return predmet;
			}
		}
		return null;
	}
	
	//Metoda koja dodaje studenta na predmet
	public void dodajStudentaNaPredmet(Student student, Predmet predmet) {
		BazaPredmeta.getInstance().dodajStudentaNaPredmet(student,predmet);
	}
	
	/* Metoda koja dodaje profesora na predmet */
	public void dodajProfesoraNaPredmet(Profesor profesor, Predmet predmet) {
		BazaPredmeta.getInstance().dodajProfesoraNaPredmet(profesor,predmet);
	}
	
	public void izbrisiStudentaProsledjenomPredmetu(Student student, Predmet predmet) {
		BazaPredmeta.getInstance().izbrisiStudentaProsledjenomPredmetu(student, predmet);
	}
	
	/* Metoda koja brise tog profesora iz liste profesora u predmetu*/
	public void izbrisiProfesoraSaPredmeta(Profesor profesor,Predmet predmet) {
		BazaPredmeta.getInstance().izbrisiProfesoraSaPredmeta(profesor,predmet);
	}

	//Metoda koja brise predmet za prosledjeni index reda
	public void izbrisiPredmet(int selectedRowIndex) {
		BazaPredmeta.getInstance().getPredmeti().remove(selectedRowIndex);
		listaPredmetaZaSerijalizaciju.remove(selectedRowIndex);
	}

	public List<Predmet> getListaPredmetaZaSerijalizaciju() {
		return listaPredmetaZaSerijalizaciju;
	}

	public void setListaPredmetaZaSerijalizaciju(List<Predmet> listaPredmetaZaSerijalizaciju) {
		this.listaPredmetaZaSerijalizaciju = listaPredmetaZaSerijalizaciju;
	}
	
	
}
