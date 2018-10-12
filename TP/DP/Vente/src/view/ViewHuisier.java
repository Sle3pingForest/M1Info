package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Vente;

import controller.ControllerHuisier;

public class ViewHuisier extends JPanel implements Observer {

    private JFrame frame = new JFrame("Huisier");
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");
    private JLabel articleName = new JLabel("Article: ");
    private JLabel articlePrice = new JLabel("Price: ");
    private JLabel articleDepot = new JLabel("Depot: ");
    private JLabel lastBid = new JLabel("Last bid: ");
    private Vente vente;

    public ViewHuisier(Vente vente) {
    	this.vente = vente;
        buildFrame(vente);
        this.vente.addObserver(this);
    }

    public void buildFrame( Vente vente) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setPreferredSize(new Dimension(300, 200));

        articleName.setText("  Article: " + this.vente.getProduit().getName() + ": " + this.vente.getProduit().quantite() + " piece(s)");
        contentPane.add(articleName);

        articlePrice.setText("  Price: " + this.vente.getProduit().getPriceInit());
        contentPane.add(articlePrice);

        articleDepot.setText("  Depot: " + this.vente.getProduit().getLieu().getNom());
        contentPane.add(articleDepot);

        lastBid.setText("  Last bid: " + this.vente.getProduit().getPriceInit() );
        contentPane.add(lastBid);

        startButton.addActionListener(new ControllerHuisier(vente));
        contentPane.add(startButton);

        stopButton.addActionListener(new ControllerHuisier(vente));
        contentPane.add(stopButton);

        contentPane.setLayout(new GridLayout(6, 1));

		this.startButton.setEnabled(true);
		this.stopButton.setEnabled(false);
        frame.pack();
        frame.setVisible(true);
    }


	public void update(Observable o, Object arg) {

		if(!this.vente.getProduit().isEstVendu()){
			this.startButton.setEnabled(true);
			this.stopButton.setEnabled(false);
		}
		else{
			this.startButton.setEnabled(false);
			this.stopButton.setEnabled(true);
			
		}

		this.lastBid.setText("  Last bid: "  + this.vente.getProduit().getLastPrice());

	}

}
