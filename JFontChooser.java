import java.awt.Component;
import java.awt.Font; //Possbilita trabalhar com as fontes;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JLabel; //Permite criar os JLabels;
import javax.swing.JFrame; //Possibilita a criação do Frame (em outras palavras a "tela");
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;

public class JFontChooser extends JFrame {//Temos que extender essa classe com JFrame;

    JMenu label; //aqui e crio um JLabel;
    private Component fontListModel;
    private JScrollPane fontListScroller;
    protected JList list;
    protected JScrollPane scrollPane;
    protected String[] nomedasfont;

    //neste ponto eu crio o construtor da "tela":
    public JFontChooser() {

        setVisible(true); //esse método permite a tela ser visível, ou seja só aparece se estiver "true";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //adicionei isso para encerrar a aplicação quando clicar no "X";
        setSize(500, 500); //tamanho da tela;
        
        
        
        
        Vector<Font> fonts = new Vector<Font>();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                for (Font font : ge.getAllFonts()) {
                    if (font.canDisplayUpTo(font.getName()) != 0) {
                        fonts.add(font);
                    }
                }
        
        
        
        
        
        label = new JMenu();
       
       
        label.setText("Hello World"); //você pode editar o texto que o JLabel vai exibir usando esse método;

        //aqui que vamos alterar a fonte. Nesse método você pode alterar o tipo da fonte, o estilo da fonte e o tamanho;
        label.setFont(new Font("Times New Roman", 
                Font.BOLD // aqui você coloca o estilo que pode ser BOLD, PLAIN, ITALIC
                , 90));


        
        list = new JList(fonts);
        list.setSize(100,100);
        scrollPane = new JScrollPane(list);
        
        getContentPane().add(scrollPane);
        
        JPanel panel = new JPanel();
        scrollPane.setRowHeaderView(panel);
        
        JButton btnAeeeeee = new JButton("Select");
        panel.add(btnAeeeeee);
        

    }
}


