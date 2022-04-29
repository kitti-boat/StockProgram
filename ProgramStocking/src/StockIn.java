import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockIn {

	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField count;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockIn window = new StockIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ArrayList ListOfstock() {
		ArrayList<Stock> list = new ArrayList<>();
		Stock s1 = new Stock("001","charge_cable",0);
		Stock s2 = new Stock("002","protect_film",0);
		Stock s3 = new Stock("003","case",0);
		Stock s4 = new Stock("004","earphone",0);
		Stock s5 = new Stock("005","airpod",0);
		Stock s6 = new Stock("006","cleaning_paper",0);
		Stock s7 = new Stock("007","adapter",0);
		Stock s8 = new Stock("008","joystick",0);
		Stock s9 = new Stock("009","loudspeaker",0);
		Stock s10 = new Stock("010","microphone",0);
		list.add(s1);list.add(s2);list.add(s3);list.add(s4);list.add(s5);list.add(s6);list.add(s7);list.add(s8);list.add(s9);list.add(s10);
		return list;
	}
		
	public void pullRowToTable() {
		 String filePath = "Stockprogram.TXT";
	        File file = new File(filePath);
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(file));

	            Object[] tableLines = br.lines().toArray();
	            for(int i = 0; i <= tableLines.length; i++)
	            {
	                String line = tableLines[i].toString().trim();
	                String[] dataRow = line.split(" ");
	                model.addRow(dataRow);
	                
	            }
	            
	        } catch (Exception ex) {
	        }

	}

	/**
	 * Create the application.
	 */
	public StockIn() {
		initialize();
		pullRowToTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 800);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1266, 169);
		panel.setBackground(new Color(153, 51, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Kittiboat\\Desktop\\proj.pic\\rePicturelo1.png"));
		lblNewLabel.setBounds(27, 0, 136, 150);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Stock Program");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 60));
		lblNewLabel_1.setBounds(173, 38, 617, 112);
		panel.add(lblNewLabel_1);
		
		JLabel lblObjectOrientedDesign = new JLabel("Object Oriented Design and Programming Project\r\n\r\n");
		lblObjectOrientedDesign.setForeground(Color.WHITE);
		lblObjectOrientedDesign.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		lblObjectOrientedDesign.setBounds(745, 10, 482, 27);
		panel.add(lblObjectOrientedDesign);
		
		JLabel lblObjectOrientedDesign_1 = new JLabel("6431503003");
		lblObjectOrientedDesign_1.setForeground(Color.WHITE);
		lblObjectOrientedDesign_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
		lblObjectOrientedDesign_1.setBounds(1122, 38, 482, 27);
		panel.add(lblObjectOrientedDesign_1);
		
		JLabel lblObjectOrientedDesign_1_1 = new JLabel("6431503038\r\n");
		lblObjectOrientedDesign_1_1.setForeground(Color.WHITE);
		lblObjectOrientedDesign_1_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
		lblObjectOrientedDesign_1_1.setBounds(1122, 60, 482, 27);
		panel.add(lblObjectOrientedDesign_1_1);
		
		JLabel lblObjectOrientedDesign_1_2 = new JLabel("6431503054\r\n");
		lblObjectOrientedDesign_1_2.setForeground(Color.WHITE);
		lblObjectOrientedDesign_1_2.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
		lblObjectOrientedDesign_1_2.setBounds(1122, 83, 482, 27);
		panel.add(lblObjectOrientedDesign_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 248, 1044, 505);
		scrollPane.getViewport().setBackground(Color.WHITE);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				id.setText(model.getValueAt(i, 0).toString());
				name.setText(model.getValueAt(i, 1).toString());
				count.setText(model.getValueAt(i, 2).toString());
			}
		});
		table.setBackground(Color.white);
		table.setFont(new Font("Microsoft JhengHei", Font.BOLD,15));
		table.setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 18));
		model = new DefaultTableModel();
		Object[] column = {"ID","Name","Quantity"};
		Object[] row = new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

		scrollPane.setViewportView(table);
		
		
		id = new JTextField();
		id.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		id.setBounds(108, 198, 180, 28);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		JLabel idd = new JLabel("ID : ");
		idd.setBounds(68, 198, 40, 28);
		idd.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		frame.getContentPane().add(idd);
		
		JLabel namee = new JLabel("NAME : ");
		namee.setBounds(341, 198, 81, 28);
		namee.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		frame.getContentPane().add(namee);
		
		name = new JTextField();
		name.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		name.setBounds(421, 198, 180, 28);
		name.setColumns(10);
		frame.getContentPane().add(name);
		
		JLabel countt = new JLabel("QUANTITY : ");
		countt.setBounds(648, 198, 123, 28);
		countt.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		frame.getContentPane().add(countt);
		
		count = new JTextField();
		count.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		count.setBounds(771, 198, 96, 28);
		count.setColumns(10);
		frame.getContentPane().add(count);
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				if (id.getText().equals("") || name.getText().equals("") || count.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please type someting");
				}
				else {
				
				row[0]=id.getText();
				row[1]=name.getText();
				row[2]=count.getText();
				model.addRow(row);
				String idtext = id.getText() ;
				String nametext = name.getText() ;
				String conttext = count.getText() ;
				FileWriter stream = new FileWriter("C:\\Users\\Kittiboat\\eclipse-workspace\\ProgramStocking");
				BufferedWriter out = new BufferedWriter(stream);
				out.write(idtext);
				out.write(nametext);
				out.write(conttext);
				id.setText("");
				name.setText("");
				count.setText("");
				
				out.close();
				}
				
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Saved");
				}
				try {
					File file= new File("Stockprogram.TXT");
					if(!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					for(int i = 0;i < table.getRowCount();i++) {
						for(int j = 0;j < table.getColumnCount();j++) {
								bw.write(table.getModel().getValueAt(i, j)+" ");
						}
						bw.write("\n");
					}
					bw.close();
					fw.close();
				}catch (Exception ex5) {
					ex5.printStackTrace();
			};
			}
		});
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(153, 51, 255));
		add.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		add.setBounds(1078, 266, 178, 54);
		frame.getContentPane().add(add);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 255));
		panel_1.setBounds(0, 169, 1266, 594);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnDelete = new JButton("UPDATE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.setValueAt(id.getText(),i,0);
					model.setValueAt(name.getText(),i,1);
					model.setValueAt(count.getText(),i,2);
					JOptionPane.showMessageDialog(null, "Updated Successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}
				try {
					File file= new File("Stockprogram.TXT");
					if(!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					for(int a = 0;a < table.getRowCount();a++) {
						for(int j = 0;j < table.getColumnCount();j++) {
								bw.write(table.getModel().getValueAt(a, j)+" ");
						}
						bw.write("\n");
					}
					bw.close();
					fw.close();
				}catch (Exception ex5) {
					ex5.printStackTrace();
			};
			}
		});
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(153, 51, 255));
		btnDelete.setBounds(1078, 203, 178, 54);
		panel_1.add(btnDelete);
		btnDelete.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		
		JButton btnUpdate = new JButton("DELETE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Deleted Successfully");
				}else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}
				try {
					File file= new File("Stockprogram.TXT");
					if(!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					for(int A = 0;A < table.getRowCount();A++) {
						for(int j = 0;j < table.getColumnCount();j++) {
								bw.write(table.getModel().getValueAt(A, j)+" ");
						}
						bw.write("\n");
					}
					bw.close();
					fw.close();
				}catch (Exception ex5) {
					ex5.printStackTrace();
			};
			}
			
		});
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(153, 51, 255));
		btnUpdate.setBounds(1078, 308, 178, 54);
		panel_1.add(btnUpdate);
		btnUpdate.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));
		
		JButton btnNewButton = new JButton("Restore");
		btnNewButton.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 51, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int a = table.getRowCount()-1; a >= 0; a--) {
				  model.removeRow(a);
				}
				ArrayList<Stock> list = ListOfstock();
				Object rowData[]= new Object[3];
				for(int i=0;i<list.size();i++) {
					
					rowData[0] = list.get(i).getID();
					rowData[1] = list.get(i).getName();
					rowData[2] = list.get(i).getQuantity();
					model.addRow(rowData);
				}
				try {
					File file= new File("Stockprogram.TXT");
					if(!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					for(int i = 0;i < table.getRowCount();i++) {
						for(int j = 0;j < table.getColumnCount();j++) {
								bw.write(table.getModel().getValueAt(i, j)+" ");
						}
						bw.write("\n");
					}
					bw.close();
					fw.close();
				}catch (Exception ex5) {
					ex5.printStackTrace();
			};
			}
		});
		btnNewButton.setBounds(948, 38, 106, 28);
		panel_1.add(btnNewButton);
	}
}
