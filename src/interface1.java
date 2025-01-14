import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class interface1 extends JFrame {
	protected JTextField tf1;
	protected JComboBox cmb1;
	protected JButton b2 ;
	protected JTextField tf5;
	protected String[]m;
	protected int num;
	protected float volume;
	protected float poids;
	protected float D;
	public JTextArea textarea1;
	ArrayList <Cargaison> cargaison=new ArrayList <>();
	ArrayList <Marchandisse>  listmarchandisse1=new ArrayList<> ();
	ArrayList <Marchandisse>  listmarchandisse2=new ArrayList<> ();
	public  DefaultListModel<String> model ;
	public JList liste;
	public DefaultTableModel model2;
     public interface1(){
    	 setTitle("Cargaisons");
    	 setSize(850,500);
    	 setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 setVisible(true);
    	 JPanel panel=new JPanel(new GridLayout(3,1));
    	 JPanel p1=new JPanel(new GridLayout(4,2,8,10));
    	 JLabel l1=new JLabel("Distance");
    	 p1.add(l1);
    	 tf1=new JTextField(20);
    	 p1.add(tf1);
    	 JLabel l2=new JLabel("Type");
    	 p1.add(l2);
    	 cmb1=new JComboBox();
    	 p1.add(cmb1);
    	 cmb1.addItem(" ");
    	 cmb1.addItem("Cargaison Aérienne");
    	 cmb1.addItem("Cargaison routière");
    	 JButton b2=new JButton("Ajouter Cargaison");
    	 p1.add(b2);
    	 JLabel l9=new JLabel();
    	 p1.add(l9);
    	 panel.add(p1);
    	 JPanel p=new JPanel(new GridLayout(1,1,5,10));
    	 model = new DefaultListModel<>();
    	 JList<String> list = new JList<>(model);
         JScrollPane js1=new JScrollPane(list);
         p.add(js1);
    	 panel.add(p);
    	 JPanel container=new JPanel();
    	 JLabel l8=new JLabel("coût de la cargaison ");
         container.add(l8);
         tf5=new JTextField (10);
         container.add(tf5);
         panel.add(container);
         add(panel,BorderLayout.WEST);
    	 panel.setBorder(BorderFactory.createEmptyBorder(85,40,50,30));
    	 JPanel panel2=new JPanel(new GridLayout(2,1));
    	 JPanel p3 =new JPanel(new GridLayout(4,3,20,40));
    	 JLabel l3=new JLabel("NUM");
    	 p3.add(l3);
    	 JLabel l4=new JLabel("POIDS");
    	 p3.add(l4);
    	 JLabel l5=new JLabel("VOLUME");
    	 p3.add(l5);
    	 JTextField tf2=new JTextField (5);
    	 p3.add(tf2);
    	 JTextField tf3=new JTextField (5);
    	 p3.add(tf3);
    	 JTextField tf4=new JTextField (5);
    	 p3.add(tf4);
         JButton b3=new JButton("Ajouter Marchandisse");
         p3.add(b3);
         JLabel l6=new JLabel("");
         p3.add(l6);
         JLabel l7=new JLabel("");
         p3.add(l7);
         panel2.add(p3);
         JPanel container2=new JPanel(new GridLayout(1,1));
    	 String[][] data = {
    	        };
         String[] columnNames = {"Num", "Poids", "Volume"};
    	 model2 = new DefaultTableModel(data, columnNames);
    	 JTable table = new JTable(model2);
    	 JScrollPane js = new JScrollPane(table);
    	 container2.add(js);
         panel2.add(container2);
         add(panel2,BorderLayout.EAST);
         panel2.setBorder(BorderFactory.createEmptyBorder(0,100,50,53));
         
     
    	b2.addActionListener(new ActionListener() {
    		 public void actionPerformed(ActionEvent e) {
    			 try {
    				    float D = Float.parseFloat(tf1.getText());
    				    System.out.println(D);
    				    String TC=(cmb1.getSelectedItem().toString());
    	    			System.out.println(TC);
    	    			Cargaison nouvelleCargaison;
    	    			 if ("Cargaison Aérienne".equals(TC)) {
    	    	                nouvelleCargaison = new Cargaison_aérienne(D, listmarchandisse1);
    	    	            } else {
    	    	                nouvelleCargaison = new Cargaison_routière(D, listmarchandisse2);
    	    	            }

    	    	            boolean exists = false;
    	    	            for (Cargaison c : cargaison) {
    	    	                if (c.equals(nouvelleCargaison)) {
    	    	                    exists = true;
    	    	                    break;
    	    	                }
    	    	            }
    	    	            if (!exists) {
    	    	                cargaison.add(nouvelleCargaison);
    	    	                model.addElement(nouvelleCargaison.toString());
    	    	            } else {
    	    	                System.out.println("Cette cargaison est déjà ajoutée.");
    	    	            }}
    			 catch (NumberFormatException e1) {
    				 System.out.println("Erreur: entrée invalide pour un float");}
    			
    			
    		 
    			 }});
    	
    	b3.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        try {
    	            // Vérifiez si un ou plusieurs champs sont vides
    	            if (tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty()) {
    	                throw new IllegalArgumentException("Tous les champs (num, poids, volume) doivent être remplis.");
    	            }

    	            int num = Integer.parseInt(tf2.getText());
    	            float poids = Float.parseFloat(tf3.getText());
    	            float volume = Float.parseFloat(tf4.getText());
    	            int indiceelement = list.getSelectedIndex();
    	            cargaison.get(indiceelement).Ajouter_Marchandisse(new Marchandisse(num, poids, volume));
    	            String num1 = String.valueOf(num);
    	            String poids1 = String.valueOf(poids);
    	            String volume1 = String.valueOf(volume);
    	            model2.addRow(new Object[]{num1, poids1, volume1});
    	            cargaison.get(indiceelement).Calculer_PoidsMarchandisses();
    	            cargaison.get(indiceelement).Calculer_VolumesMarchandisses();
    	            String coût = String.valueOf(cargaison.get(indiceelement).Calculer_coûtCargaison());
    	            System.out.println(coût);
    	            tf5.setText(coût);

    	        } catch (NumberFormatException e1) {
    	            JOptionPane.showMessageDialog(null, "Erreur : Veuillez saisir des valeurs numériques valides.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
    	        } catch (IllegalArgumentException e2) {
    	            JOptionPane.showMessageDialog(null, e2.getMessage(), "Champs manquants", JOptionPane.WARNING_MESSAGE);
    	        }
    	    }
    	});

			
    	 }
    	 } 
    	 
    	 
    	 
    	 
    
     

