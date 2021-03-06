/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author cirstea
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import controler.HistoriqueListener;
import model.Calculator;
import model.Operation;
import operant.Operant;
import operateur.Operateur;
import operateur.OperateurMoins;
import operateur.OperateurPlus;

public class View extends JPanel implements Observer {

	public static final int PLUS = -100;
    public static final int MINUS = -200;
    public static final int EQUAL = -400;
    // ...
    private JPanel[] panels = new JPanel[6];
    private JTextField textField = new JTextField();
    private JButton[] numberButtons = new JButton[10];
    private JButton subtractButton = new JButton("-");
    private JButton addButton = new JButton("+");
    private JButton equateButton = new JButton(" = ");
    private JButton histButton = new JButton(" H ");
    private Calculator cal;

    
    public View(Calculator cal) {

    	super();
    	view(cal);
    }
    
    private void view(Calculator cal) {
        // ...
    	this.cal = cal;
        buildFrame(this.cal);
        this.cal.addObserver(this);
    }

    public void buildFrame(Calculator cal) {

        JPanel contentPane = new JPanel();

        // initialize panels 
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        // initialize button 0-9 
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(" " + i + " ");
            numberButtons[i].addActionListener(new View.LocalListener(i, cal));
        }

        // default layout = BorderLayout.CENTER 
        textField.setColumns(20);
        textField.setText("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panels[0].add(textField);

        // layout = FlowLayout.LEFT 
        panels[1].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[1].add(numberButtons[7]);
        panels[1].add(numberButtons[8]);
        panels[1].add(numberButtons[9]);
        panels[1].add(addButton);
        addButton.addActionListener(new View.LocalListener(PLUS, cal));

        // layout = FlowLayout.LEFT 
        panels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[2].add(numberButtons[4]);
        panels[2].add(numberButtons[5]);
        panels[2].add(numberButtons[6]);
        panels[2].add(subtractButton);
        subtractButton.addActionListener(new View.LocalListener(MINUS, cal));

        // layout = FlowLayout.LEFT 
        panels[3].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[3].add(numberButtons[1]);
        panels[3].add(numberButtons[2]);
        panels[3].add(numberButtons[3]);
        panels[3].add(equateButton);
        equateButton.addActionListener(new View.LocalListener(EQUAL, cal));

        // layout = FlowLayout.LEFT 
        panels[4].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[4].add(numberButtons[0]);
        panels[4].add(histButton);
        histButton.addActionListener(new HistoriqueListener(cal));

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        for (JPanel jPanel : panels) {
            contentPane.add(jPanel);
        }
        
        this.add(contentPane);
    }

    
    /* SECTION CONTROLEUR*/
    class LocalListener implements ActionListener {

        private int digit;
        private Calculator cal;
        private Operateur operateur;
        private Operation operation;



        public LocalListener(int digit, Calculator cal) {
            this.digit = digit;
            this.cal = cal;
            this.operation = this.cal.getOperation();
        }
        

        public void actionPerformed(ActionEvent e) {
  
        	if(this.digit == PLUS || this.digit == MINUS) {
        		if(Calculator.INTER) {
            		this.cal.calculerInter();
        		}
        		switch (this.digit){
        			case PLUS:
            			this.operateur = new OperateurPlus();
            			break;
        			case MINUS:
            			this.operateur = new OperateurMoins();
            			break;
            			default:
        		}
        		Calculator.DROITE = true;
        		this.operation.setOp(operateur);
        		Calculator.INTER = true;
        	}
        	else {
        		if(this.digit == EQUAL) {
        			this.cal.calculer();
        			this.operation = new Operation();
        			this.cal.setOperation(operation);
        			this.operation.setDroite(new Operant(0));
        			Calculator.END = false;
        			this.cal.setResultat(0);
        		}
        		else if(!Calculator.DROITE) {
        			int number = this.cal.getOperation().getGauche().getValeur() *10 + digit;
        			this.operation.setGauche(new Operant(number));
        			this.operation.setDroite(new Operant(0));
        			this.cal.setOperation(operation);
        		}
        		else {
        			int number =  this.cal.getOperation().getDroite().getValeur() *10 + digit;
        			this.operation.setDroite(new Operant(number));
        			this.cal.setOperation(operation);
        			
        		}
        	}
        	
        }
        
    }
    /* FIN SECTION CONTROLEUR*/

	public void update(Observable o, Object arg) {
		if(Calculator.END) {
			this.textField.setText(this.cal.getResultat()+"");
		}
		else {
			if(!Calculator.DROITE) {
				this.textField.setText(this.cal.getOperation().getGauche().getValeur()+"");
			}
			else{
				if(!Calculator.INTER) {
					this.textField.setText(this.cal.getResultat()+"");
				}
				else{
					this.textField.setText(this.cal.getOperation().getDroite().getValeur()+"");
				}
				
			}
		}
	
	}
}
