package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditorFrame extends JFrame implements ActionListener {
	private JTextField contextTF, problemTF, solutionTF, diagramTF, consequencesTF;
	private JLabel contextLAB, problemLAB, solutionLAB, diagramLAB, consequencesLAB;
	
	private JButton saveBTN, importBTN, exportBTN;
	
	private JPanel contextPANEL, problemPANEL,solutionPANEL, diagramPANEL, consequencePANEL;
	
	public EditorFrame(){
		setLayout(new FlowLayout());
		// save button
		saveBTN = new JButton("Save/Load"); add(saveBTN);
		saveBTN.addActionListener(this);
		// panels
		contextPANEL = new JPanel();
		add(contextPANEL);
		
		problemPANEL = new JPanel();
		add(problemPANEL);
		
		solutionPANEL = new JPanel();
		add(solutionPANEL);
		
		 diagramPANEL = new JPanel();
		add(solutionPANEL);
		
		consequencePANEL = new JPanel();
		add(consequencePANEL);
		
		
		contextLAB = new JLabel("Context"); contextPANEL.add(contextLAB);
		contextTF = new JTextField(20); contextPANEL.add(contextTF);
		
		
		problemLAB = new JLabel("Problem"); problemPANEL.add(problemLAB);
		problemTF = new JTextField(20); problemPANEL.add(problemTF);
		
		solutionLAB = new JLabel("Solution"); solutionPANEL.add(solutionLAB);
		solutionTF = new JTextField(20); solutionPANEL.add(solutionTF);
		
		diagramLAB = new JLabel("Diagram"); diagramPANEL.add(diagramLAB);
		diagramTF = new JTextField(20); diagramPANEL.add(diagramTF);
		
		consequencesLAB = new JLabel("Consequence"); consequencePANEL.add(consequencesLAB);
		consequencesTF = new JTextField(20);consequencePANEL.add(consequencesTF);
		
		importBTN = new JButton("Import Patterns"); add(importBTN);
		importBTN.addActionListener(this);
		
		exportBTN = new JButton("Export Patterns"); add(exportBTN);
		exportBTN.addActionListener(this);
		
		setSize(400, 500);
		setVisible(true);
		setTitle("Editor Pattern");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event){
		// save button
		if(event.getSource() == saveBTN){
		}
		
		//import button
		
		if(event.getSource() == importBTN){
			// call naar import.java
		}
		
		//export button
		
		if(event.getSource() == exportBTN){
			// call naar export.java
		}
	}
}
