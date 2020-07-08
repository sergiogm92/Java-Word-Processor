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
        configureMenu("Arial","font","Arial",9,10, "");

        configureMenu("Georgia","font","Georgia",9,10, "");

        configureMenu("Verdana","font","Verdana",9,10, "");

        //--------------------------------

        configureMenu("Bold","style","",Font.BOLD,1, "src/img/bold.png");

        configureMenu("Italic","style","",Font.ITALIC,1, "src/img/italic.png");

        //--------------------------------

        configureMenu("12","size","",9,12,"");

        configureMenu("16","size","",9,16,"");

        configureMenu("20","size","",9,20,"");

        configureMenu("24","size","",9,24,"");


        // Adding options to bar

        bar.add(font);

        bar.add(style);

        bar.add(size);

        // Adding bar to panel and setting layout

        panelMenu.add(bar);

        add(panelMenu, BorderLayout.NORTH);

        textArea=new JTextPane();

        add(textArea, BorderLayout.CENTER);

        JPopupMenu popupMenu=new JPopupMenu();

        JMenuItem bold=new JMenuItem("Bold", new ImageIcon("src/img/bold.png"));

        JMenuItem italic=new JMenuItem("Italic", new ImageIcon("src/img/italic.png"));

        bold.addActionListener(new StyledEditorKit.BoldAction());

        italic.addActionListener(new StyledEditorKit.ItalicAction());

        bold.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

        italic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));

        popupMenu.add(bold);

        popupMenu.add(italic);

        textArea.setComponentPopupMenu(popupMenu);

        JToolBar toolBar=new JToolBar();

        toolBar.setOrientation(SwingConstants.VERTICAL);

        JButton boldButton=new JButton(new ImageIcon("src/img/bold.png"));

        JButton italicButton=new JButton(new ImageIcon("src/img/italic.png"));

        JButton underlineButton=new JButton(new ImageIcon("src/img/underline.png"));

        boldButton.addActionListener(new StyledEditorKit.BoldAction());

        italicButton.addActionListener(new StyledEditorKit.ItalicAction());

        underlineButton.addActionListener(new StyledEditorKit.UnderlineAction());

        toolBar.add(boldButton);

        toolBar.add(italicButton);

        toolBar.add(underlineButton);

        add(toolBar, BorderLayout.WEST);


    }

    public void configureMenu(String menuItemText, String menuPlacement, String font, int style, int size, String icon){

        JMenuItem itemMenu=new JMenuItem(menuItemText, new ImageIcon(icon));

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
                itemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
            }else if(style==Font.ITALIC){
                itemMenu.addActionListener(new StyledEditorKit.ItalicAction());
                itemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
            }

        }else if(menuPlacement.equals("size")){

            this.size.add(itemMenu);

            itemMenu.addActionListener(new StyledEditorKit.FontSizeAction("modifySize",size));
        }

    }




}