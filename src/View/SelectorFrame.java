package View;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Context;
import Model.Pattern;

public class SelectorFrame extends MyFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel categoryLAB, subCategoryLAB;
	private JComboBox categoryList, purposeList, scopeList;
	ArrayList<String> categoryString = new ArrayList<>();
	ArrayList<String> purposeString = new ArrayList<>(); 
	ArrayList<String> scopeString = new ArrayList<>();
	
	public SelectorFrame(ArrayList<Pattern> p){
		for(Pattern p1 : p){
			categoryString.add("");
			purposeString.add("");
			scopeString.add("");
		}
		setLayout(new FlowLayout());
		JPanel hulp1 = new JPanel();
		add(hulp1);
		
		categoryLAB = new JLabel("Category");
		hulp1.add(categoryLAB);
		
		categoryList = new JComboBox((ComboBoxModel) categoryString);
		//categoryList.setSelectedIndex(1);
		categoryList.addActionListener(this);
		hulp1.add(categoryList);
		
		
		JPanel hulp2 = new JPanel();
		add(hulp2);
		
		subCategoryLAB = new JLabel("subcategory");
		hulp2.add(subCategoryLAB);
		
		purposeList = new JComboBox((ComboBoxModel) purposeString);
		//purposeList.setSelectedIndex(1);
		purposeList.addActionListener(this);
		purposeList.setVisible(false);
		hulp2.add(purposeList);
		
		scopeList = new JComboBox((ComboBoxModel) scopeString);
		//scopeList.setSelectedIndex(2);
		scopeList.addActionListener(this);
		scopeList.setVisible(false);
		hulp2.add(scopeList);
		
		setSize(400,400);
		setVisible(true);
		setTitle("Pattern Selector");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent e){
		int category;
		if(e.getSource() == categoryList){
			category = categoryList.getSelectedIndex();
			if(category == 0){
				purposeList.setVisible(true);
				scopeList.setVisible(false);
			}
			else if(category == 1){
				scopeList.setVisible(true);
				purposeList.setVisible(false);
			}
		}
	}

}