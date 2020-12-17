package interfaces_projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import reservation_billets.Admin;
import reservation_billets.Ville;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class statistique_par_client extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel homePanel =new JPanel(new BorderLayout());
	JPanel insideHomePanel = new JPanel(new GridLayout(1,2));
	JPanel piePanel = new JPanel(new GridLayout(2,1) );
	JPanel tabPanel = new JPanel();
    private Vector<Double> pourcentages = Admin.statistiquesParClient();

	public statistique_par_client() {

        setContentPane(homePanel);
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        // add the chart to a panel...
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        piePanel.add(chartPanel);
        
        PieDataset dataset1 = createDataset1();
        JFreeChart chart1 = createChart1(dataset1);
        // add the chart to a panel...
        ChartPanel chartPanel1 = new ChartPanel(chart1);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        piePanel.add(chartPanel1);
 
     // Create the table
 		DefaultTableModel model = new DefaultTableModel(Admin.statistiquesParClientData(), Admin.statistiquesParClientColumnName());
        tabPanel.setLayout(null);
        JTable table = new JTable(model);
        JPanel panelo = new JPanel();
        panelo.setBorder(new LineBorder(new Color(255, 255, 255), 0));
        panelo.setLayout(new GridLayout(1, 1));
 		panelo.setBounds(0, 77,442, 302);
 		tabPanel.setBackground(Color.white);
 		tabPanel.add(panelo);
        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(706,141));
        scrollPane.setBorder(new LineBorder(new Color(255, 255, 255), 0));
        panelo.setBackground(Color.white);
        panelo.add(scrollPane);       
        
        insideHomePanel.add(piePanel);
        insideHomePanel.add(tabPanel);
        
        JLabel lblNombreReservation = new JLabel("Nombre Reservation / Chiffre D'affaire");
        lblNombreReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNombreReservation.setBounds(83, 23, 286, 43);
        tabPanel.add(lblNombreReservation);
        homePanel.add(BorderLayout.CENTER,insideHomePanel);
        
        JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/icons8_left_30px_1.png")));
		label.setBounds(0, 0, 37, 32);
		homePanel.add(BorderLayout.NORTH,label);
		homePanel.setBackground(Color.white);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new espace_Statistique();
				dispose();
			}
		});      
        setSize(900, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        

    }
    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Homme", pourcentages.elementAt(0));
        dataset.setValue("Femme", pourcentages.elementAt(1));
        return dataset;
    }
    private JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
            "Sexe",  // chart title
            dataset,             // dataset
            true,                // include legend
            false,
            false
        );        
        PiePlot plot = (PiePlot) chart.getPlot();      
        plot.setSectionPaint("Homme", SystemColor.inactiveCaption);
        plot.setSectionPaint("Femme", Color.WHITE);        
        plot.setBackgroundPaint(Color.white);       
        plot.setOutlinePaint(Color.white);              
        plot.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);    
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
        plot.setLabelBackgroundPaint(Color.white);
        chart.setBorderVisible(true);       

        return chart;
    }
    private PieDataset createDataset1() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Senior", pourcentages.elementAt(2));
        dataset.setValue("Junior", pourcentages.elementAt(3));
        return dataset;
    }
    private JFreeChart createChart1(PieDataset dataset) {
         JFreeChart chart = ChartFactory.createPieChart(
            "Categorie",  // chart title
            dataset,             // dataset
            true,                // include legend
            false,
            false
        );
        
         PiePlot plot = (PiePlot) chart.getPlot();
         plot.setSectionPaint("Senior", SystemColor.inactiveCaption);
         plot.setSectionPaint("Junior", Color.WHITE);
         plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
         plot.setLabelBackgroundPaint(Color.white);
         plot.setBackgroundPaint(Color.white);       
         plot.setOutlinePaint(Color.white);               
         chart.setBorderVisible(true);  
          
          
        return chart;
    }
    
    public static void main(final String[] args) {

    	new statistique_par_client();


    }
}