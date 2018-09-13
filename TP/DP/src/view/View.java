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

import model.Calculator;

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
        buildFrame();
        this.cal.addObserver(this);
    }

    public void buildFrame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();

        // initialize panels 
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        // initialize button 0-9 
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(" " + i + " ");
            numberButtons[i].addActionListener(new View.LocalListener(i));
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
        addButton.addActionListener(new View.LocalListener(PLUS));

        // layout = FlowLayout.LEFT 
        panels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[2].add(numberButtons[4]);
        panels[2].add(numberButtons[5]);
        panels[2].add(numberButtons[6]);
        panels[2].add(subtractButton);
        subtractButton.addActionListener(new View.LocalListener(MINUS));

        // layout = FlowLayout.LEFT 
        panels[3].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[3].add(numberButtons[1]);
        panels[3].add(numberButtons[2]);
        panels[3].add(numberButtons[3]);
        panels[3].add(equateButton);
        equateButton.addActionListener(new View.LocalListener(EQUAL));

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
        private StringBuilder sb;
        private Calculator cal;
        
        public LocalListener() {
            this.sb = new StringBuilder();
        }

        public LocalListener(int digit, Calculator cal) {
            this.digit = digit;
            this.cal = cal;
            this.sb = new StringBuilder("");
        }
        

        public void actionPerformed(ActionEvent e) {
        	this.sb.append(digit+"");
        	if(this.digit != MINUS || this.digit != PLUS) {
            	this.cal.setOpG(Integer.valueOf(this.sb.toString()));
        	}
            System.out.println("TYPED : "+ digit + ": " +this.sb.toString());
        }
        
        public String getNumber() {
        	return this.sb.toString();
        }
    }

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}