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
        configureMenu("Arial","font","",1,1);

        configureMenu("Courier","font","",1,1);

        configureMenu("Verdana","font","",1,1);

        //--------------------------------

        configureMenu("Bold","style","",1,1);

        configureMenu("Italic","style","",1,1);

        //--------------------------------

        configureMenu("12","size","",1,1);

        configureMenu("16","size","",1,1);

        configureMenu("20","size","",1,1);

        configureMenu("24","size","",1,1);


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

        itemMenu.addActionListener(new MenuListener());
    }

    private class MenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            textArea.setFont(new Font("Courier", Font.PLAIN, 20));

        }
    }


}