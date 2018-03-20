import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IntGraph extends JFrame {

	public final static int XDIM = 350;
	public final static int YDIM = (int) XDIM * 2 - 150;

	public ChatClient chatclient;
	public ChatLancementServeur chatlancementserveur;
	public ServerInt serverint;

	JFrame f;

	JPanel p = new JPanel();
	JPanel pT = new JPanel();
	JPanel pB = new JPanel();

	JLabel lbNc = new JLabel("Nom de compte", SwingConstants.CENTER);
	JTextField textNc = new JTextField("Votre nom");
	JLabel lbMdp = new JLabel("Mot de passe", SwingConstants.CENTER);
	JPasswordField textMdp = new JPasswordField("mdp");
	JButton btCn = new JButton("Se connecter");
	JButton btCc = new JButton("Créer un compte");

	ShowImage imgLogo = new ShowImage("logo1.png");

	JLabel temps = new JLabel();
	JLabel cryptochat = new JLabel("Cryptochat");

	PageCreationCompte pcc = new PageCreationCompte();
	PageChat pc = new PageChat();

	public IntGraph() {
		this.PageDeConnexion();
	}

	private void PageDeConnexion() {

		f = new JFrame("Cryptochat");
		f.setSize(XDIM, YDIM);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
		f.setLocationRelativeTo(null);

		lbNc.setForeground(Color.orange);
		lbMdp.setForeground(Color.orange);
		textNc.setForeground(Color.gray);
		textNc.getFont().deriveFont(Font.ITALIC);
		textMdp.setForeground(Color.gray);

		super.setTitle("Cryptochat");
		super.setLayout(new FlowLayout());

		super.getContentPane().add(imgLogo);

		p.add(imgLogo);
		p.add(lbNc);
		p.add(textNc);
		p.add(lbMdp);
		p.add(textMdp);

		p.setLayout(new GridLayout(7, 1, 5, 10));
		p.setBackground(Color.gray);

		pT.add(temps);
		pT.add(cryptochat);
		pT.setBackground(Color.gray);

		pB.add(btCn);
		pB.add(btCc);
		pB.setLayout(new GridLayout(1, 2));

		p.add(pB);
		p.add(pT);

		f.add(p);

		this.heure();
		System.out.println(textMdp.getPassword());

		// -------------------------------Hints----------------------------------

		textNc.addMouseListener(new MouseListener() {
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

		textMdp.addMouseListener(new MouseListener() {
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

		// -----------------------Buttons------------------------------

		btCc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				pcc.setVisible(true);
				f.dispose();
			}
		});

		btCn.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authentification(textNc.getText(), textMdp.getPassword());
			}

		}));

		btCn.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// connexion();
			}

		}));
	}

	// -----------------------Date------------------------------

	private void heure() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		temps.setText(dateFormat.format(cal.getTime()));
	}

	// --------------------------------------------------------------

	public void connexion() {
		chatclient = new ChatClient();
		try {
			serverint = (ServerInt) Naming.lookup("client");
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println(serverint + "s'est connectÃ©");
	}

	// -----------------------Connexion------------------------------

	public void Authentification(String lbNc, char[] lbMdp) {
		if (lbNc.equals("corentin") || lbMdp.equals("vachon")) {
			System.out.println("vous allez vous connecter");
			pc.setVisible(true);
			f.dispose();
		}
	}

	public void rendreVisible(boolean b) {
		if (b = true) {
			this.setVisible(true);

		}
	}

	// --------------Intégrer les images------------------

	public class ShowImage extends JPanel {
		BufferedImage image;

		public ShowImage(String chemin) {
			try {

				File input = new File(chemin);
				image = ImageIO.read(input);

			} catch (IOException ie) {
				System.out.println("Error:" + ie.getMessage());
			}
		}

		public void paint(Graphics g) {
			g.drawImage(image, 155, 10, null);
		}
	}

	// ---------------Main--------------------

	public static void main(String[] args) {
		new IntGraph();
	}

}
