import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewEmp extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField kod;
	private JTextField nev;
	private JTextField szid;
	private JTextField lak;
	private JTextField fiz;
	private Checker c =new Checker();
	private DbMethods dbm=new DbMethods();

	

	/**
	 * Create the dialog.
	 */
	public NewEmp(int dbkez) {
		getContentPane().setBackground(new Color(72,209,204));
		setBounds(100, 100, 341, 340);
		getContentPane().setLayout(null);
		
		JLabel lblKd = new JLabel("K\u00F3d:");
		lblKd.setBounds(12, 13, 56, 16);
		getContentPane().add(lblKd);
		
		JLabel lblNv = new JLabel("N\u00E9v:");
		lblNv.setBounds(12, 58, 56, 16);
		getContentPane().add(lblNv);
		
		JLabel lblSzletsiId = new JLabel("Sz\u00FClet\u00E9si id\u0151:");
		lblSzletsiId.setBounds(12, 103, 87, 16);
		getContentPane().add(lblSzletsiId);
		
		JLabel lblLakcm = new JLabel("Lakc\u00EDm:");
		lblLakcm.setBounds(12, 148, 56, 16);
		getContentPane().add(lblLakcm);
		
		JLabel lblFizets = new JLabel("Fizet\u00E9s:");
		lblFizets.setBounds(12, 198, 56, 16);
		getContentPane().add(lblFizets);
		
		kod = new JTextField();
		kod.setBounds(111, 10, 116, 22);
		getContentPane().add(kod);
		kod.setColumns(10);
		
		nev = new JTextField();
		nev.setBounds(111, 55, 200, 22);
		getContentPane().add(nev);
		nev.setColumns(10);
		
		szid = new JTextField();
		szid.setBounds(111, 100, 200, 22);
		getContentPane().add(szid);
		szid.setColumns(10);
		
		lak = new JTextField();
		lak.setBounds(111, 145, 200, 22);
		getContentPane().add(lak);
		lak.setColumns(10);
		
		fiz = new JTextField();
		fiz.setBounds(111, 195, 200, 22);
		getContentPane().add(fiz);
		fiz.setColumns(10);
		
		JButton btnBeszr = new JButton("Besz\u00FAr");
		btnBeszr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c.goodInt(kod, "Kód"))
					if (c.filled(nev, "Név"))
						if (c.goodDate(szid, "Születési idõ"))
							if (c.filled(lak, "Lakcím"))
								if (c.goodInt(fiz, "Fizetés"))
									if (dbkez==0) {
									FileManager.Insert(RTF(kod), RTF(nev), RTF(szid), RTF(lak), RTF(fiz));
									} else {
										dbm.Connect();
										dbm.Insert(RTF(kod), RTF(nev), RTF(szid), RTF(lak), RTF(fiz));
										dbm.DisConnect();
									}
				dispose();
			}
		});
		btnBeszr.setBounds(111, 255, 97, 25);
		getContentPane().add(btnBeszr);

	}
	
	public String RTF(JTextField jtf) {
		return jtf.getText();
	}
}
