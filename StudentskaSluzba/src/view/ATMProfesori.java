package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesor;

/**
 * Klasa AbstractTableModelProfesori je klasa koja nam sluzi za prikaz tabele
 * profesora.
 * 
 * @author Vaxi
 *
 */
public class ATMProfesori extends AbstractTableModel {

	private static final long serialVersionUID = -4422057131202788042L;

	@Override
	public int getRowCount() {
		return BazaProfesor.getInstance().getProfesori().size();
	}

	@Override
	public int getColumnCount() {
		// TODO proveriti da li je uredu + 1, ocekujem da bude, zbog dodatne kolone za
		// listu predmeta tog profesora
		return BazaProfesor.getInstance().getBrojKolona() + 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex <= BazaProfesor.getInstance().getBrojKolona()) {
			return BazaProfesor.getInstance().getVrednost(rowIndex, columnIndex);
		} else if (columnIndex == BazaProfesor.getInstance().getBrojKolona() + 1) {
			//TODO implementirati da vrati listu predmeta za tog profesora
		}
		return null;
	}

}
