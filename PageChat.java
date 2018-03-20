import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class PageChat extends JFrame {

	JFrame m;

	JPanel pChat = new JPanel();
	JPanel pSend = new JPanel();
	JPanel pList = new JPanel();

	JTextField txtMsg = new JTextField("Parlez ici");
	JButton btnSend = new JButton("Envoyer");

	JButton btnFermer = new JButton("Fermer");

	JTextArea chatBox = new JTextArea();

	JLabel txt = new JLabel("Connexion avec ");
	JComboBox boxList = new JComboBox();

	IntGraph a;

	/*
	 * public PageChat(){
	 *
	 * this.setSize(IntGraph.XDIM,IntGraph.YDIM); this.setTitle("chat");
	 * this.setVisible(false); this.setResizable(false);
	 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * this.setLocationRelativeTo(null);
	 *
	 * chatBox.setEditable(false); chatBox.setLineWrap(true);
	 *
	 * //pChat.setLayout(new GridLayout(3, 1));
	 *
	 * pChat.setBackground(Color.gray); pSend.setBackground(Color.gray);
	 *
	 * pSend.add(btnSend); pSend.add(btnFermer);
	 *
	 *
	 * pChat.add(pSend); pChat.add(txtMsg); pChat.add(chatBox);
	 *
	 *
	 * this.add(pChat);
	 *
	 *
	 * }
	 */
	public PageChat() {
		this.setSize(IntGraph.XDIM, IntGraph.YDIM);
		this.setTitle("Chat");
		this.setVisible(false);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		pSend.setBackground(Color.gray);
		pList.setBackground(Color.gray);
		txtMsg.setForeground(Color.gray);

		chatBox.setEditable(false);
		chatBox.setLineWrap(true);

		pChat.setLayout(new BorderLayout());

		txtMsg.setPreferredSize(new Dimension(200, 40));
		btnSend.setPreferredSize(new Dimension(80, 40));

		btnFermer.setPreferredSize(new Dimension(100, 20));
		boxList.setPreferredSize(new Dimension(120, 20));
		boxList.addItem("Nathan JODAR");
		boxList.addItem("Clement LAMBERT");

		pSend.add(txtMsg);
		pSend.add(btnSend);

		pList.add(txt);
		pList.add(boxList);
		pList.add(btnFermer);

		pChat.add(pList, BorderLayout.NORTH);
		pChat.add(chatBox, BorderLayout.CENTER);
		pChat.add(pSend, BorderLayout.SOUTH);

		this.setContentPane(pChat);


		// -------------------------------Hints----------------------------------

		txtMsg.addMouseListener(new MouseListener() {
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

		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageChat.this.setVisible(false);
				PageChat.this.dispose();
				IntGraph a = new IntGraph();
			}
		});

	}
}
