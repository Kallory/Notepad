
package simplenotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class GUI implements ActionListener{
    
    JFrame window;
    
    // text area
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    // top menu bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    // file menu
    JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;
    // format menu
    JMenuItem itemWrap, itemFontArial, itemFontTNR, itemFontSize8, itemFontSize12, itemFontSize16, itemFontSize20, itemFontSize24, itemFontSize28;
    JMenu menuFont, menuFontSize;
    
    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    
    public static void main(String[] args) {
        
        new GUI();
    }
    
    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        
        format.selectedFont = "Arial";
        format.createFont(12);
        window.setVisible(true);
    }
    
    public void createWindow() {
        window = new JFrame("JNote");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void createTextArea() {
        textArea = new JTextArea();
        
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    
    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }
    
    public void createFileMenu() {
        itemNew = new JMenuItem("New");
        itemNew.addActionListener(this);
        itemNew.setActionCommand("New");
        menuFile.add(itemNew);
        
        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("Open");
        menuFile.add(itemOpen);
        
        itemSave = new JMenuItem("Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("Save");
        menuFile.add(itemSave);
        
        itemSaveAs = new JMenuItem("Save As");
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("Save As");
        menuFile.add(itemSaveAs);
        
        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("Exit");
        menuFile.add(itemExit);
    }
    
    public void createFormatMenu() {
        itemWrap = new JMenuItem("Word wrap: Off");
        itemWrap.addActionListener(this);
        itemWrap.setActionCommand("Word wrap");
        menuFormat.add(itemWrap);
        
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);
        
        itemFontArial = new JMenuItem("Arial");
        itemFontArial.addActionListener(this);
        itemFontArial.setActionCommand("Arial");
        menuFont.add(itemFontArial);
        
        itemFontTNR = new JMenuItem("Times New Roman");
        itemFontTNR.addActionListener(this);
        itemFontTNR.setActionCommand("Times New Roman");
        menuFont.add(itemFontTNR);
        
        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);
        
        itemFontSize8 = new JMenuItem("8");
        itemFontSize8.addActionListener(this);
        itemFontSize8.setActionCommand("8");
        menuFontSize.add(itemFontSize8);

        itemFontSize12 = new JMenuItem("12");
        itemFontSize12.addActionListener(this);
        itemFontSize12.setActionCommand("12");
        menuFontSize.add(itemFontSize12);

        itemFontSize16 = new JMenuItem("16");
        itemFontSize16.addActionListener(this);
        itemFontSize16.setActionCommand("16");
        menuFontSize.add(itemFontSize16);

        itemFontSize20 = new JMenuItem("20");
        itemFontSize20.addActionListener(this);
        itemFontSize20.setActionCommand("20");
        menuFontSize.add(itemFontSize20);

        itemFontSize24 = new JMenuItem("24");
        itemFontSize24.addActionListener(this);
        itemFontSize24.setActionCommand("24");
        menuFontSize.add(itemFontSize24);
        
        itemFontSize28 = new JMenuItem("28");
        itemFontSize28.addActionListener(this);
        itemFontSize28.setActionCommand("28");
        menuFontSize.add(itemFontSize28);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String command = e.getActionCommand();
       
       switch(command) {
           case "New": file.newFile(); break;
           case "Open": file.open(); break;
           case "Save": file.save(); break;
           case "Save As": file.saveAs() ;break;
           case "Exit": file.exit(); break;
           case "Word wrap": format.wordWrap(); break;
           case "Arial": format.setFont(command); break;
           case "Times New Roman": format.setFont(command); break;
           case "8": format.createFont(8); break;
           case "12": format.createFont(12); break;
           case "16": format.createFont(16); break;
           case "20": format.createFont(20); break;
           case "24": format.createFont(24); break;
           case "28": format.createFont(28); break;
       }
    }
}
