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
    public ProcessorPanel(){
        setLayout(new BorderLayout());

        JPanel panelMenu=new JPanel();

        JMenuBar bar=new JMenuBar();

        // Creating JMenuBar options

        JMenu font=new JMenu("Font");

        JMenu style=new JMenu("Style");

        JMenu size=new JMenu("Size");

        // Creating JMenu items

        JMenuItem arial=new JMenuItem("Arial");

        JMenuItem courier=new JMenuItem("Courier");

        JMenuItem verdana=new JMenuItem("Verdana");

        JMenuItem bold=new JMenuItem("Bold");

        JMenuItem italic=new JMenuItem("Italic");

        JMenuItem size_12=new JMenuItem("12");

        JMenuItem size_16=new JMenuItem("16");

        JMenuItem size_20=new JMenuItem("20");

        JMenuItem size_24=new JMenuItem("24");

        // Adding items to menu

        font.add(arial);

        font.add(courier);

        font.add(verdana);

        style.add(bold);

        style.add(italic);

        size.add(size_12);

        size.add(size_16);

        size.add(size_20);

        size.add(size_24);

        // Adding options to bar

        bar.add(font);

        bar.add(style);

        bar.add(size);

        // Adding bar to panel and setting layout

        panelMenu.add(bar);

        add(panelMenu, BorderLayout.NORTH);
        
    }
}