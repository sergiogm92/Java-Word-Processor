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

    JButton boldButton, italicButton, underlineButton, blueButton, yellowButton, redButton, leftButton, centerButton, rightButton, justifyButton;

    JToolBar toolBar;

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

        // Creating and adding the textArea

        textArea=new JTextPane();

        add(textArea, BorderLayout.CENTER);

        // Creating a simple popUp for bold and italic

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

        // Creating a toolBar

        toolBar=new JToolBar();

        configureToolBar("src/img/bold.png").addActionListener(new StyledEditorKit.BoldAction());

        configureToolBar("src/img/italic.png").addActionListener(new StyledEditorKit.ItalicAction());

        configureToolBar("src/img/underline.png").addActionListener(new StyledEditorKit.UnderlineAction());

        toolBar.addSeparator();

        configureToolBar("src/img/blue.png").addActionListener(new StyledEditorKit.ForegroundAction("blue",Color.BLUE));

        configureToolBar("src/img/yellow.png").addActionListener(new StyledEditorKit.ForegroundAction("yellow",Color.YELLOW));

        configureToolBar("src/img/red.png").addActionListener(new StyledEditorKit.ForegroundAction("red",Color.RED));

        toolBar.addSeparator();

        configureToolBar("src/img/left.png").addActionListener(new StyledEditorKit.AlignmentAction("left",0));

        configureToolBar("src/img/center.png").addActionListener(new StyledEditorKit.AlignmentAction("center",1));

        configureToolBar("src/img/right.png").addActionListener(new StyledEditorKit.AlignmentAction("right",2));

        configureToolBar("src/img/justify.png").addActionListener(new StyledEditorKit.AlignmentAction("justify",3));

        toolBar.setOrientation(SwingConstants.VERTICAL);

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

    public JButton configureToolBar(String path){

        JButton button=new JButton(new ImageIcon(path));

        toolBar.add(button);

        return button;
    }




}