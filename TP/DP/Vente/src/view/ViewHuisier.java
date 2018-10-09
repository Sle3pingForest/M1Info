package view;

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

import controller.ControllerHuisier;

public class ViewHuisier extends JPanel implements Observer {

    private JFrame frame = new JFrame("Bidder");
    private JButton startButton = new JButton("Start");
    private JButton stropButton = new JButton("Stop");
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

//        articleName.setText("  Article: " + auction.getArticleName());
        articleName.setText("  Article: " + this.vente.getArticle().getName());
        contentPane.add(articleName);

        articlePrice.setText("  Price: " + this.vente.getArticle().getPriceInit());
        contentPane.add(articlePrice);

        lastBid.setText("  Last bid: " + this.vente.getArticle().getLastPrice() );
        contentPane.add(lastBid);

        startButton.addActionListener(new ControllerHuisier(vente));
        contentPane.add(startButton);

        stropButton.addActionListener(new ControllerHuisier(vente));
        contentPane.add(stropButton);

        contentPane.setLayout(new GridLayout(6, 1));

        frame.pack();
        frame.setVisible(true);
    }

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
