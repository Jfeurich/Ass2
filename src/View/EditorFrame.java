//package View;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//
//import org.apache.commons.codec.binary.*;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//
//import logic.Disk; // importeren export class
//import logic.Json;
//import Model.Context;
//import Model.Pattern;
//import java.io.InputStream;
//
//public class EditorFrame extends JFrame implements ActionListener {
//	private JTextField contextTF, contextdefTF, problemTF, solutionTF, diagramTF, consequencesTF;
//	private JList lister;
//	private JLabel contextLAB, contextdefLAB, problemLAB, solutionLAB, diagramLAB, consequencesLAB, plaatjeslabel;
//	private JButton uploadBTN,saveBTN, loadBTN, importBTN, exportBTN;
//	private JPanel contextPANEL, problemPANEL,solutionPANEL, diagramPANEL, consequencePANEL;
//	private String filepath, filepad;///
//	private Image image;////
//	private String stringImage;
//	private ArrayList<Pattern> patterns;
//	private ArrayList<Context> context;
//
//	private String imageName;
//
//	public EditorFrame(ArrayList<Pattern> plist) {
//		this.patterns = plist;
//		setLayout(new FlowLayout());
//
//		saveBTN = new JButton("Save"); add(saveBTN);
//		saveBTN.addActionListener(this);
//		loadBTN = new JButton("Load");add(loadBTN);
//		loadBTN.addActionListener(this);
//		JList lister = new JList(patterns.toArray());
//		add(lister);
//
//		contextPANEL = new JPanel();
//		add(contextPANEL);
//
//		problemPANEL = new JPanel();
//		add(problemPANEL);
//
//		solutionPANEL = new JPanel();
//		add(solutionPANEL);
//
//		 diagramPANEL = new JPanel();
//		add(solutionPANEL);
//
//		consequencePANEL = new JPanel();
//		add(consequencePANEL);
//
//
//		contextLAB = new JLabel("Context"); contextPANEL.add(contextLAB);
//		contextTF = new JTextField(20); contextPANEL.add(contextTF);
//
//		// context definition
//		contextdefLAB = new JLabel("Context Definition"); contextPANEL.add(contextLAB);
//		contextdefTF = new JTextField(20); contextPANEL.add(contextdefTF);
//
//
//		problemLAB = new JLabel("Problem"); problemPANEL.add(problemLAB);
//		problemTF = new JTextField(20); problemPANEL.add(problemTF);
//
//		uploadBTN = new JButton("Upload Diagram"); solutionPANEL.add(uploadBTN);
//		uploadBTN.addActionListener(this);
//
//		solutionLAB = new JLabel("Solution"); solutionPANEL.add(solutionLAB);
//		solutionTF = new JTextField(20); solutionPANEL.add(solutionTF);
//
//		diagramLAB = new JLabel("Diagram"); diagramPANEL.add(diagramLAB);
//		diagramTF = new JTextField(20); diagramPANEL.add(diagramTF);
//
//		consequencesLAB = new JLabel("Consequence"); consequencePANEL.add(consequencesLAB);
//		consequencesTF = new JTextField(20);consequencePANEL.add(consequencesTF);
//
//		importBTN = new JButton("Import Patterns"); add(importBTN);
//		importBTN.addActionListener(this);
//
//		exportBTN = new JButton("Export Patterns"); add(exportBTN);
//		exportBTN.addActionListener(this);
//
//		plaatjeslabel = new JLabel("");
//		this.add(plaatjeslabel);
//		Image image = null;
//
//
//		 //Imagepadfile ophalen van Pattern
//		for(Pattern p  : patterns){
//			Image image3;
//			File file =p.getDiagram();
//			try {
//				image3 = ImageIO.read(file);
//				JLabel lab = new JLabel();
//				lab.setIcon(new ImageIcon(image3));
//				this.add(lab);
//				this.setVisible(true);
//				this.repaint();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			////
//
//		}
//
//		setSize(400, 500);
//		setVisible(true);
//		setTitle("Editor Pattern");
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}
//
//	public void actionPerformed(ActionEvent event){
//		// save button
//		if(event.getSource() == saveBTN){
//			//sla de gewijzigde patterns op in het JSon bestand
//			//Hier wordt de arraylijst naar een te exporteren JSon bestand omgezet.
//			String problem = problemTF.getText();
//			String solution = solutionTF.getText();
//			String consequence = consequencesTF.getText();
//			String context = contextTF.getText();
//			String contextdefinition = contextdefTF.getText();
//			// nieuwe arraylist
//			String filepadImage = "JsonObjects/diagrammen/"+ imageName;
//			Pattern nieuwePattern = new Pattern(name);
//			System.out.println("Filepad:" + (nieuwePattern.getDiagram()));
//			// context toevoegen
//			Context c = new Context(context,contextdefinition);
//			ArrayList<Context> contextArrayList = new ArrayList<Context>();
//			contextArrayList.add(c);
//
//			nieuwePattern.setContext(contextArrayList);
//			// patterns opslaan
//			patterns.add(nieuwePattern);
//			Disk.savePattern(patterns);
//			Json.savePattern(patterns);
//
//			/* Image bestand opslaan in map */
//			 File outputfile = new File(filepadImage);
//			  BufferedImage bi;
//			try {
//				bi = ImageIO.read(new File(filepad));
//				 ImageIO.write(bi, "png", outputfile);
//
//				 System.out.println();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		if(event.getSource() == loadBTN){
//			//haal het geselecteerde patroon op uit de arraylijst en vul de velden in
//			Pattern p = (Pattern) lister.getSelectedValue();
//			contextTF.setText(p.getAllConsequences());
//			problemTF.setText(p.getAllProblems());
//			solutionTF.setText(p.getSolution());
//			consequencesTF.setText(p.getAllConsequences());
//		}
//
//		if(event.getSource() == importBTN){
//
//			/* decode code
//			byte[] b = base.decodeBase64(encodedImage);
//			BufferedImage img2 = ImageIO.read(new ByteArrayInputStream(b));*/
//			// call naar import.java
//		}
//
//		if(event.getSource() == uploadBTN){
//			//Koppel een plaatje aan het pattern
//			FileDialog fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
//			fd.setDirectory("C:\\");
//			fd.setFile("*.png");
//			fd.setVisible(true);
//			String filename = fd.getFile();
//			String filterPath = fd.getDirectory();
//			if (filename == null)
//			  System.out.println("You cancelled the choice");
//			else
//				filepath = "" + filename;
//				System.out.println("filterPath:" + filterPath);
//				System.out.println("You chose " + filename);
//				filepad = filterPath + filename;
//				setImageName(filename);
//			try {
//				File sourceimage = new File(filepad);
//				image = ImageIO.read(sourceimage);
//			} catch (IOException e){
//				e.printStackTrace();
//			}
//
//			// plaatje op scherm zetten
//			plaatjeslabel.setIcon(new ImageIcon(image));
//			this.add(plaatjeslabel);
//			this.setVisible(true);
//			this.repaint();
//
//			// Image omzetten voor JSON
//			BufferedImage img;
//			try {
//				img = ImageIO.read(new File(filepad));
//				ByteArrayOutputStream baos = new ByteArrayOutputStream();
//				ImageIO.write(img, "jpg", baos);
//				baos.flush();
//				Base64 base = new Base64(false);
//				String encodedImage = base.encodeToString(baos.toByteArray());
//				baos.close();
//				encodedImage = java.net.URLEncoder.encode(encodedImage, "ISO-8859-1");
//				setStringImage(encodedImage);
//			}
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//		if(event.getSource() == exportBTN){
//			Disk.savePattern(patterns);
//			Json.savePattern(patterns);
//		}
//	}
//
//	public void  setStringImage(String s){
//		 stringImage = s;
//	}
//
//	public void setImageName(String s){
//		imageName = s;
//	}
//}
