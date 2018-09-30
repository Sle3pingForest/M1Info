import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.View;
import view.ViewHistorique;
import model.Calculator;


public class Calculatrice extends JFrame  {
	
	public Calculatrice(){
		super("Calculator");
		this.setPreferredSize(new Dimension(900, 600)) ;
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Calculator cal = new Calculator();
		View v = new View(cal);
		ViewHistorique vh = new ViewHistorique(cal);
		
		JPanel principal = new JPanel();
		principal.add(v,BorderLayout.EAST);
		principal.add(vh,BorderLayout.WEST);

		this.add(principal);
        this.pack();
        this.setVisible(true);
		
	}
	public static void main(String[] args) {
			new Calculatrice();
	}
}
