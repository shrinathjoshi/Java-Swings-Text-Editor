// Java program to create a Simple  Text Editor

import javax.swing.JFileChooser;
import javax.swing.JFileChooser;
import javax.swing.JFileChooser;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.*;
public class Editor extends JFrame
{
	private JFileChooser fc=new JFileChooser();
	private JTextArea textArea=new JTextArea(20,60);


	public Editor()
	{
		JScrollPane  scrollpane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


		FileFilter textFilter=new FileNameExtensionFilter("Plain Text","txt");
		fc.setFileFilter(textFilter);

		add(scrollpane);
		JMenuBar menuBar =new JMenuBar();
		setJMenuBar(menuBar);
		JMenu file=new JMenu("Files");
		menuBar.add(file);


		file.add(Open);
		file.add(Save);
		file.addSeparator();
		file.add(Exit);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	
	}


	Action Open=new AbstractAction("Open file"){

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
			{
				openFile(fc.getSelectedFile().getAbsolutePath());
			}
	
		}
	};
	


	Action Save=new AbstractAction("Save file"){

		@Override
		public void actionPerformed(ActionEvent e)
		{
			saveFile();
		}
	};
	


	Action Exit=new AbstractAction("Exit"){

		@Override
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	};
	

	public void openFile(String fileName)
	{
		FileReader fr=null;
		try
		{
			fr=new FileReader(fileName);
			textArea.read(fr,null);
			fr.close();
			setTitle(fileName);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	} 

	public void saveFile()
	{
		if(fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
			FileWriter fw=null;
			try
			{
				fw=new FileWriter(fc.getSelectedFile().getAbsolutePath()+".txt");
				textArea.write(fw);
				fw.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}


	public static void main(String args[])
	{
		new Editor();
	} 


}



