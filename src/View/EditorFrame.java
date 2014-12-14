package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import it.sauronsoftware.base64.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import logic.Disk; // importeren export class
import Model.Pattern;
public class EditorFrame extends JFrame implements ActionListener {
	private JTextField contextTF, problemTF, solutionTF, diagramTF, consequencesTF;
	private JLabel contextLAB, problemLAB, solutionLAB, diagramLAB, consequencesLAB, plaatjeslabel;///
	private String filepath, filepad;///
	private JButton uploadBTN;
	private JButton saveBTN, importBTN, exportBTN;
	private Image image;////
	private JPanel contextPANEL, problemPANEL,solutionPANEL, diagramPANEL, consequencePANEL;
	//Create a file chooser

	public EditorFrame() {
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
		
		uploadBTN = new JButton("Upload Diagram"); solutionPANEL.add(uploadBTN);
		uploadBTN.addActionListener(this);
		
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
		
		///////////////
		plaatjeslabel = new JLabel("");
		this.add(plaatjeslabel);
		Image image = null;
		//////////////
		
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
		
		if(event.getSource() == uploadBTN){
			  
			FileDialog fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
			fd.setDirectory("C:\\");
			fd.setFile("*.png");
			fd.setVisible(true);
			String filename = fd.getFile();
			String filterPath = fd.getDirectory();
			if (filename == null)
			  System.out.println("You cancelled the choice");
			else
				filepath = "" + filename;
			System.out.println("filterPath:" + filterPath);
			  System.out.println("You chose " + filename);

			////////////////
			 filepad = filterPath + filename;
			
			try {
				File sourceimage = new File(filepad);
				image = ImageIO.read(sourceimage);
			} catch (IOException e){
				e.printStackTrace();
			}
		
			plaatjeslabel.setIcon(new ImageIcon(image));
			this.add(plaatjeslabel);
			this.setVisible(true);
			this.repaint();
			/////////////////
			
			// v2 //
			
			
			BufferedImage img = ImageIO.read(new File(filepad));             
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(img, "jpg", baos);
			baos.flush();
			Base64 base = new Base64(false);
			String encodedImage = base.encodeToString(baos.toByteArray());
			baos.close();
			encodedImage = java.net.URLEncoder.encode(encodedImage, "ISO-8859-1");
		}
		
		
		if(event.getSource() == exportBTN){
			String problem = problemTF.getText();
			
			String solution = solutionTF.getText();
			String consequence = consequencesTF.getText();
			
			Pattern nieuwePattern  = new Pattern(problem,image,solution,consequence);
			ArrayList<Pattern> patterns = new ArrayList<Pattern>();
			patterns.add(nieuwePattern);
			Disk.savePattern(patterns);
			
		
		}
			
			// call naar export.java
		
	}
}
