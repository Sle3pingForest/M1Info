package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Calculator;

public class HistoriqueListener implements ActionListener {

    private Calculator cal;
	
	public  HistoriqueListener(Calculator cal) {
        this.cal = cal;
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.cal.afficheHistorique();
		
	}

}
