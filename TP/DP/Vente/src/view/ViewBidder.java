package view;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Vente;

import controller.ControllerBidder;

/**
 *
 * @author cirstea
 */
public class ViewBidder extends JPanel implements Observer{

    private JFrame frame = new JFrame("Bidder");
    private JTextField textField = new JTextField();
    private JButton bidButton = new JButton("Bid");
    private JLabel articleName = new JLabel("Article: ");
    private JLabel articlePrice = new JLabel("Price: ");
    private JLabel articleDepot = new JLabel("Depot: ");
    private JLabel lastBid = new JLabel("Last bid: ");
    private Vente vente;

    public ViewBidder(Vente vente) {
    	this.vente = vente;
        buildFrame(vente);
        this.vente.addObserver(this);
    }

    public void buildFrame(Vente vente) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();

//        articleName.setText("  Article: " + auction.getArticleName());
        articleName.setText("  Article: " + this.vente.getArticle().getName());
        contentPane.add(articleName);

        articlePrice.setText("  Price: " + + this.vente.getArticle().getPriceInit());
        contentPane.add(articlePrice);

        lastBid.setText("  Last bid: "  + this.vente.getArticle().getPriceInit());
        contentPane.add(lastBid);

        textField.setColumns(5);
        textField.setText("");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        contentPane.add(textField);

        bidButton.addActionListener(new ControllerBidder( vente));
        contentPane.add(bidButton);

        contentPane.setLayout(new GridLayout(6, 1));

        frame.pack();
        frame.setVisible(true);
    }

	public void update(Observable o, Object arg) {
		
	}

}
