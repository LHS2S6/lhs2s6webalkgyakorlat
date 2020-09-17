import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class Program extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private EmpTm etm;
	private DbMethods dbm = new DbMethods();
	private int dbkez=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program frame = new Program();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Program() {
		dbm.Reg();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxDbKezels = new JCheckBox("DB kezel\u00E9s");
		chckbxDbKezels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxDbKezels.isSelected()) dbkez=1;
				else dbkez=0;
			}
		});
		chckbxDbKezels.setBounds(158, 127, 113, 25);
		contentPane.add(chckbxDbKezels);
		
		JButton btnLista = new JButton("Lista");
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dbkez==0) etm = FileManager.CsvReader();
				else {
					dbm.Connect();
					etm=dbm.ReadAllData();
					dbm.DisConnect();
				}
				
				EmpList el = new EmpList(Program.this,etm);
				el.setVisible(true);
			}
		});
		btnLista.setBounds(12, 13, 97, 25);
		contentPane.add(btnLista);
		
		JButton btnUjAdat = new JButton("\u00DAj adatsor");
		btnUjAdat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewEmp ne = new NewEmp(dbkez);
				ne.setVisible(true);
			}
		});
		btnUjAdat.setBounds(12, 51, 97, 25);
		contentPane.add(btnUjAdat);
		
		JButton btnTrls = new JButton("T\u00F6rl\u00E9s");
		btnTrls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dbkez==0) etm = FileManager.CsvReader();
				else {
					dbm.Connect();
					etm=dbm.ReadAllData();
					dbm.DisConnect();
				}
				
				EmpDel ed = new EmpDel(Program.this,etm,dbkez);
				ed.setVisible(true);
			}
		});
		btnTrls.setBounds(12, 89, 97, 25);
		contentPane.add(btnTrls);
		
		JButton btnMdosts = new JButton("M\u00F3dos\u00EDt\u00E1s");
		btnMdosts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dbkez==0) etm = FileManager.CsvReader();
				else {
					dbm.Connect();
					etm=dbm.ReadAllData();
					dbm.DisConnect();
				}
				EmpMod em = new EmpMod(Program.this,etm,dbkez);
				em.setVisible(true);
			}
		});
		btnMdosts.setBounds(12, 127, 97, 25);
		contentPane.add(btnMdosts);
		
		JButton btnProba = new JButton("proba");
		btnProba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbm.Connect();
				dbm.DisConnect();
				}
		});
		btnProba.setBounds(158, 13, 97, 25);
		contentPane.add(btnProba);
		
		
		
		
		Object emptmn[] = {"Jel","Kód","Név","Szülidõ","Lakóhely","Fizetés"};
		etm = new EmpTm(emptmn,0);
	}
}
