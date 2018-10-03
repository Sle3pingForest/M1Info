package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Calculator;

public class ViewHistorique extends JPanel implements Observer {


    private JTextArea historiques = new JTextArea(5,300);

    private JPanel panels = new JPanel();
	private Calculator calcul;
    
    
    public ViewHistorique(Calculator cal) {
    	view(cal);
    }
    
	private void view (Calculator cal) {
		calcul = cal;
        panels.add(historiques);
        panels.setVisible(false);
        historiques.setVisible(false);
        this.add(historiques);
        this.calcul.addObserver(this);
	}
	
	
	public class HistoriqueListener implements ActionListener {

	    private Calculator cal;
		
		public  HistoriqueListener(Calculator cal) {
	        this.cal = cal;
	        
		}
		
		public void actionPerformed(ActionEvent e) {
			this.cal.afficheHistorique();
			
		}

	}

	public void update(Observable o, Object arg) {
		if(Calculator.HISTORIQUE) {
			historiques.setVisible(true);
		}
		else {
			historiques.setVisible(false);
		}
		
	}

}
