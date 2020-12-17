package interfaces_projet;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import reservation_billets.Connexion;


public class statistique_par_mois_chiffreaffaire extends JFrame {

	private static final long serialVersionUID = -1314877738034042129L;
	java.sql.Connection conn = Connexion.getConnection();
	JPanel homePanel = new JPanel(new BorderLayout());
	JPanel insideHomePanel = new JPanel(new BorderLayout());

    public statistique_par_mois_chiffreaffaire() {
        final JFreeChart chart = createChart(createDataset());

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        insideHomePanel.add(BorderLayout.CENTER,chartPanel);
        homePanel.add(insideHomePanel);

        JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("/icons8_left_30px_1.png")));
		label.setBounds(0, 0, 37, 32);
		insideHomePanel.add(BorderLayout.NORTH,label);
		insideHomePanel.setBackground(Color.white);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new statistique_par_mois_menu();
				dispose();
			}
		});
        
        setContentPane(homePanel);
        
        setSize(900, 500);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    private CategoryDataset createDataset() {
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	try {
			PreparedStatement ps = conn.prepareStatement("select substring(date_reservation,4,2) as mois, count(id_reservation) as nbr_reservation, sum(prix_reservation) as Chiffre_affaire from reservation group by mois");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dataset.setValue(rs.getDouble(3), "X", rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
    	return dataset;
    }
    

    private JFreeChart createChart(CategoryDataset dataset) {

    	JFreeChart chart = ChartFactory.createBarChart("Chiffre D'affaire par Mois", "M o i s", "Chiffre D'affaire", dataset, PlotOrientation.VERTICAL, true, true, true);

    	CategoryPlot plot = chart.getCategoryPlot();   	
    	plot.setRangeGridlinePaint(Color.BLACK);  
    	plot.setBackgroundPaint(Color.WHITE);
    	plot.setOutlineVisible(false);
    	
    	BarRenderer renderer = (BarRenderer) plot.getRenderer();
    	
    	renderer.setGradientPaintTransformer(null);
    	
    	
    	GradientPaint gp1 = new GradientPaint(
    			7, 7, new Color(109, 166, 253),
    			2, 2, Color.white,
			true
		);
		renderer.setSeriesPaint(0, gp1);
    	renderer.setBarPainter(new StandardBarPainter());
        return chart;
        
    }

    public static void main(final String[] args) {

         new statistique_par_mois_chiffreaffaire();

    }

}
