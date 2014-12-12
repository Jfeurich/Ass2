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

import javax.imageio.ImageIO;
import javax.swing.*;

import logic.Disk; // importeren export class

public class EditorFrame extends JFrame implements ActionListener {
	private JTextField contextTF, problemTF, solutionTF, diagramTF, consequencesTF;
	private JLabel contextLAB, problemLAB, solutionLAB, diagramLAB, consequencesLAB;
	private String filepath;
	private JButton uploadBTN;
	private JButton saveBTN, importBTN, exportBTN;
	
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
			/*  
			  
			  BufferedImage img = null;
			  try{
			  img = ImageIO.read(new File(filterPath));
		         ByteArrayOutputStream baos = new ByteArrayOutputStream();
		         
				 ImageIO.write(img, "jpg", baos);
		         baos.flush();
		         byte[] bytes = baos.toByteArray();
		         baos.close();
		         System.out.println("Sending image to server. ");
		         
		         OutputStream out= new FileOutputStream("c:\\data\\output-text.txt");
		         DataOutputStream dos = new DataOutputStream(out);
		         dos.writeInt(bytes.length);
		         dos.write(bytes, 0, bytes.length);
		         System.out.println("Image sent to server. ");
			  } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			
		}
		//export button
		/*
		if(event.getSource() == exportBTN){
			String problem = problemTF.getText();
			String solution = solutionTF.getText();
			String consequence = consequencesTF.getText();
			Disk disk = new Disk(problem, solution, consequence);
			try {
				disk.write();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// call naar export.java
		}*/
	}
}
