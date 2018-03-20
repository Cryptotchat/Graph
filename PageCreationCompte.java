import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PageCreationCompte extends JFrame {

	JLabel lbTxt = new JLabel("Création d'un compte", SwingConstants.CENTER);
	JTextField ndc = new JTextField("Veuillez saisir un nom de compte");
	JTextField mdp = new JTextField("Veuillez saisir un mot de passe");
	JButton bouton = new JButton("Créer mon compte !");
	JPanel pCr = new JPanel();

	public PageCreationCompte() {

		this.setSize(IntGraph.XDIM, IntGraph.YDIM);
		this.setTitle("Création");
		this.setVisible(false);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		lbTxt.setForeground(Color.orange);
		ndc.setForeground(Color.gray);
		mdp.setForeground(Color.gray);

		super.add(pCr);

		this.setSize(IntGraph.XDIM, IntGraph.YDIM);
		this.setTitle("chat");
		this.setVisible(false);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		pCr.setLayout(new GridLayout(4, 1, 0, 75));

		pCr.setBackground(Color.gray);

		pCr.add(lbTxt);
		pCr.add(ndc);
		pCr.add(mdp);
		pCr.add(bouton);

		this.add(pCr);

		// -------------------------------Hints----------------------------------

		ndc.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JTextField texteField = ((JTextField) e.getSource());
				texteField.setText("");
				texteField.getFont().deriveFont(Font.PLAIN);
				texteField.setForeground(Color.black);
				texteField.removeMouseListener(this);
			}
		});

		mdp.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JTextField texteField = ((JTextField) e.getSource());
				texteField.setText("");
				texteField.getFont().deriveFont(Font.PLAIN);
				texteField.setForeground(Color.black);
				texteField.removeMouseListener(this);
			}
		});

		// -------------------------------Buttons----------------------------------

		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				IntGraph a = new IntGraph();
			}
		});

	}

}
