package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.commons.codec.binary.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import logic.Disk; // importeren export class
import Model.Pattern;

public class EditorFrame extends JFrame implements ActionListener {
	private JTextField contextTF, problemTF, solutionTF, diagramTF, consequencesTF;
	private JLabel contextLAB, problemLAB, solutionLAB, diagramLAB, consequencesLAB, plaatjeslabel;
	private String filepath, filepad;///
	private JButton uploadBTN;
	private JButton saveBTN, loadBTN, importBTN, exportBTN;
	private Image image;////
	private JPanel contextPANEL, problemPANEL,solutionPANEL, diagramPANEL, consequencePANEL;
	private String stringImage;
	private JList lister;
	private ArrayList<Pattern> patterns;
	//Create a file chooser

	public EditorFrame(ArrayList<Pattern> patterns2) {
		this.patterns = patterns2;
		setLayout(new FlowLayout());
		// save button
		saveBTN = new JButton("Save"); add(saveBTN);
		saveBTN.addActionListener(this);
		loadBTN = new JButton("Load");add(loadBTN);
		loadBTN.addActionListener(this);
		JList lister = new JList(patterns.toArray());
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
			//sla de gewijzigde patterns op in het JSon bestand
			//Hier wordt de arraylijst naar een te exporteren JSon bestand omgezet.
			String problem = problemTF.getText();
			String solution = solutionTF.getText();
			String consequence = consequencesTF.getText();
			// Image omzetten voor JSON
						BufferedImage img;
						try {
							img = ImageIO.read(new File(filepad));
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							ImageIO.write(img, "jpg", baos);
							baos.flush();
							Base64 base = new Base64(false);
							String encodedImage = base.encodeToString(baos.toByteArray());
							baos.close();
							encodedImage = java.net.URLEncoder.encode(encodedImage, "ISO-8859-1");
							setStringImage(encodedImage);
						}
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			// nieuwe arraylist
			/* Nieuwe constructor toevoegen aan pattern met String op de plaats van image */
			Pattern nieuwePattern = new Pattern(problem,stringImage,solution,consequence);
			patterns.add(nieuwePattern);
			Disk.savePattern(patterns,null);
		}
		
		if(event.getSource() == loadBTN){
			//haal het geselecteerde patroon op uit de arraylijst en vul de velden in
			Pattern p = (Pattern) lister.getSelectedValue();
			contextLAB.setText(p.getConsequence());
			problemLAB.setText(p.getProblem());
			//plaatjeslabel.
		}
		
		if(event.getSource() == importBTN){
			/* decode code
			byte[] b = base.decodeBase64(encodedImage);
			BufferedImage img2 = ImageIO.read(new ByteArrayInputStream(b));*/
			// call naar import.java
		}
		
		if(event.getSource() == uploadBTN){
			//Koppel een plaatje aan het pattern
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

			             
			
		}
		
		
		if(event.getSource() == exportBTN){
			Disk.savePattern(patterns,"export");
		}
			
			// call naar export.java
		
	}
	
	public void  setStringImage(String s){
		 stringImage = s;
	}
}
