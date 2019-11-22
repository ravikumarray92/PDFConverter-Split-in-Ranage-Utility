package com.pdf.converter;
 
import java.io.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.filechooser.*; 
public class FileChooser extends JFrame implements ActionListener { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Jlabel to show the files user selects 
	static JLabel l; 

	// a default constructor 
	FileChooser() 
	{ 
	} 

	public void renderFileChooser() 
	{ 
		// frame to contains GUI elements 
		JFrame f = new JFrame("file chooser"); 

		// set the size of the frame 
		f.setSize(400, 400); 

		// set the frame's visibility 
		f.setVisible(true); 

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		// button to open save dialog 
		JButton button1 = new JButton("Convert"); 

		// button to open open dialog 
		JButton button2 = new JButton("Select"); 

		// make an object of the class filechooser 
		FileChooser f1 = new FileChooser(); 

		// add action listener to the button to capture user 
		// response on buttons 
		button1.addActionListener(f1); 
		button2.addActionListener(f1); 

		// make a panel to add the buttons and labels 
		JPanel p = new JPanel(); 

		// add buttons to the frame 
		p.add(button1); 
		p.add(button2); 

		// set the label to its initial value 
		l = new JLabel("no file selected"); 

		// add panel to the frame 
		p.add(l); 
		f.add(p); 

		f.show(); 
	} 
	public void actionPerformed(ActionEvent evt) 
	{ 
		// if the user presses the save button show the save dialog 
		String com = evt.getActionCommand(); 

		if (com.equals("Convert")) { 
			// create an object of JFileChooser class 
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

			// invoke the showsSaveDialog function to show the save dialog 
			int r = j.showSaveDialog(null); 

			// if the user selects a file 
			if (r == JFileChooser.APPROVE_OPTION) 

			{ 
				// set the label to the path of the selected file 
				l.setText(j.getSelectedFile().getAbsolutePath()); 
			} 
			// if the user cancelled the operation 
			else
				l.setText("the user cancelled the operation"); 
		} 

		// if the user presses the open dialog show the open dialog 
		else { 
			// create an object of JFileChooser class 
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

			// invoke the showsOpenDialog function to show the save dialog 
			int r = j.showOpenDialog(null); 

			// if the user selects a file 
			if (r == JFileChooser.APPROVE_OPTION) 

			{ 
				// set the label to the path of the selected file 
				l.setText(j.getSelectedFile().getAbsolutePath()); 
			} 
			// if the user cancelled the operation 
			else
				l.setText("the user cancelled the operation"); 
		} 
	} 
} 
