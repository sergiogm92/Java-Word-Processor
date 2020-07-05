package word_processor;
import javax.swing.*;
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
        }else if(menuPlacement.equals("style")){
            this.style.add(itemMenu);
        }else if(menuPlacement.equals("size")){
            this.size.add(itemMenu);
        }

        itemMenu.addActionListener(new MenuListener(menuItemText, font, style, size));
    }

    private class MenuListener implements ActionListener{

        private String textType, menu;

        private int textStyle, textSize;

        MenuListener(String menuSelected, String textTypeSelected, int textStyleSelected, int textSizeSelected){

            menu = menuSelected;

            textType = textTypeSelected;

            textStyle = textStyleSelected;

            textSize = textSizeSelected;

        }


        @Override
        public void actionPerformed(ActionEvent e) {

            fonts = textArea.getFont();

            if(menu.equals("Arial") || menu.equals("Georgia") || menu.equals("Verdana")){

                textStyle = fonts.getStyle();

                textSize = fonts.getSize();


            }else if(menu.equals("Bold") || menu.equals("Italic")){

                textType = fonts.getFontName();

                textSize = fonts.getSize();

            }else if(menu.equals("12") || menu.equals("16") || menu.equals("20") || menu.equals("24")){

                textType = fonts.getFontName();

                textStyle = fonts.getStyle();

            }

            textArea.setFont(new Font(textType, textStyle, textSize));

        }
    }


}