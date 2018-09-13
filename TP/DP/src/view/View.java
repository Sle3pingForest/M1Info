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

import model.Addition;
import model.Calculator;
import model.Sub;

public class View implements Observer{

    public static final int PLUS = -100;
    public static final int MINUS = -200;
    public static final int EQUAL = -400;
    // ...
    private JFrame frame = new JFrame("Calculator");
    private JPanel[] panels = new JPanel[6];
    private JTextField textField = new JTextField();
    private JButton[] numberButtons = new JButton[10];
    private JButton subtractButton = new JButton("-");
    private JButton addButton = new JButton("+");
    private JButton equateButton = new JButton(" = ");
    private Calculator cal;

    public void view(Calculator cal) {
        // ...
    	this.cal = cal;
        buildFrame(this.cal);
        this.cal.addObserver(this);
    }

    public void buildFrame(Calculator cal) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();

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

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        for (JPanel jPanel : panels) {
            contentPane.add(jPanel);
        }
        frame.pack();
        frame.setVisible(true);
    }

    class LocalListener implements ActionListener {

        private int digit;
        private Calculator cal;
        private Addition add;
        private Sub sub;
        


        public LocalListener(int digit, Calculator cal) {
            this.digit = digit;
            this.cal = cal;
        }
        

        public void actionPerformed(ActionEvent e) {

            if(this.digit == MINUS || this.digit == PLUS){
            	Calculator.DROITE = true;
            	if(this.digit == PLUS){
            		this.add = new Addition();
                	cal.setOperation(this.add);
            	}
            	else{
            		this.sub = new Sub();
                	cal.setOperation(this.sub);
            	}
            }
            else{
                if(this.digit == EQUAL){
                	Calculator.RESULTAT = true;
                	Calculator.DROITE = false;
                	this.cal.setResultat();
                	Calculator.RESULTAT = false;
                	
                }
                else{
                	if(!Calculator.DROITE){
                		int number = this.cal.getOpG()*10 + digit;
                		if(!Calculator.RESULTAT){
                			number = this.cal.getOpG()*10 + digit;
                		}
                		this.cal.setOpG(number);
                	}
                	if(Calculator.DROITE){
	        			int number = this.cal.getOpD()*10 + digit;
	        			this.cal.setOpD(number);
	        		}
                }
        	}

        	System.out.println("Gauche : " + this.cal.getOpG());

        	System.out.println("Droite: " + this.cal.getOpD());
            System.out.println("TYPED : "+ digit);
        }
        
    }

	public void update(Observable o, Object arg) {
		if(Calculator.RESULTAT){
			this.textField.setText(this.cal.getResultat()+"");		
		}
		else{
			if(!Calculator.DROITE){
				this.textField.setText(this.cal.getOpG()+"");
			}
			if(Calculator.DROITE){
				this.textField.setText(this.cal.getOpD()+"");
			}
		}
		
	}

}
