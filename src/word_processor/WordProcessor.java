package word_processor;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.*;

public class WordProcessor {
    public static void main(String[] args) {
        ProcessorMenu frame=new ProcessorMenu();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class ProcessorMenu extends JFrame {
    public ProcessorMenu(){

        setTitle("Word Processor");

        setBounds(500,300,550,400);

        ProcessorPanel panel=new ProcessorPanel();

        add(panel);

        setVisible(true);
    }
}

class ProcessorPanel extends JPanel{

    private JTextPane textArea;

    private JMenu font, style, size;

    private Font fonts;

    public ProcessorPanel(){
        setLayout(new BorderLayout());

        JPanel panelMenu=new JPanel();

        JMenuBar bar=new JMenuBar();

        // Creating JMenuBar options

        font=new JMenu("Font");

        style=new JMenu("Style");

        size=new JMenu("Size");

        // Creating JMenu items
        configureMenu("Arial","font","Arial",9,10);

        configureMenu("Georgia","font","Georgia",9,10);

        configureMenu("Verdana","font","Verdana",9,10);

        //--------------------------------

        configureMenu("Bold","style","",Font.BOLD,1);

        configureMenu("Italic","style","",Font.ITALIC,1);

        //--------------------------------

        configureMenu("12","size","",9,12);

        configureMenu("16","size","",9,16);

        configureMenu("20","size","",9,20);

        configureMenu("24","size","",9,24);


        // Adding options to bar

        bar.add(font);

        bar.add(style);

        bar.add(size);

        // Adding bar to panel and setting layout

        panelMenu.add(bar);

        add(panelMenu, BorderLayout.NORTH);

        textArea=new JTextPane();

        add(textArea, BorderLayout.CENTER);


    }

    public void configureMenu(String menuItemText, String menuPlacement, String font, int style, int size){

        JMenuItem itemMenu=new JMenuItem(menuItemText);

        if(menuPlacement.equals("font")){
            this.font.add(itemMenu);

            if(font.equals("Arial")){
                itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("changeFont","Arial"));
            }else if(font.equals("Georgia")){
                itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("changeFont","Georgia"));
            }else if(font.equals("Verdana")){
                itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("changeFont","Verdana"));

            }

        }else if(menuPlacement.equals("style")){

            this.style.add(itemMenu);

            if(style==Font.BOLD){
                itemMenu.addActionListener(new StyledEditorKit.BoldAction());
            }else if(style==Font.ITALIC){
                itemMenu.addActionListener(new StyledEditorKit.ItalicAction());

            }

        }else if(menuPlacement.equals("size")){

            this.size.add(itemMenu);

            itemMenu.addActionListener(new StyledEditorKit.FontSizeAction("modifySize",size));
        }

    }




}