package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 * Klasa koja sluzi za reprezentativni nacin prikaza tabele profesora i
 * sortiranje profesora.
 * 
 * @author Vaxi i Pufke
 *
 */
public class ProfesoriJTable extends JTable {

	private static final long serialVersionUID = -3442801886235942895L;

	private TableRowSorter<ATMProfesori> sortiranje;

	public ProfesoriJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false); // kako bi iskljucili mogucnost pomeranja kolona levo-desno
		this.setModel(new ATMProfesori());
		ATMProfesori model = new ATMProfesori();
		this.setModel(model);

		sortiranje = new TableRowSorter<ATMProfesori>(model);

		for (int i = 3; i <= 10; i++) {
			sortiranje.setSortable(i, false);
		}
		this.setRowSorter(sortiranje);
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		/*
		 * Metoda koja omogucava da selektovani red ima drugaciju boju od ostalih
		 * redova.
		 */
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
