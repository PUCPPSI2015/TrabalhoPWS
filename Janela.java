import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.*;

import java.io.*;
import java.util.*;

public class Janela extends JFrame 
{
	private static final long serialVersionUID = 1L;

	private JButton btnPonto   = new JButton ("Ponto"),
                    btnLinha   = new JButton ("Linha"),
                    btnCirculo = new JButton ("Circulo"),
                    btnElipse  = new JButton ("Elipse"),
                    btnCores   = new JButton ("Cores"),
                    btnAbrir   = new JButton ("Abrir"),
                    btnSalvar  = new JButton ("Salvar"),
                    btnApagar  = new JButton ("Apagar"),
                    btnSair    = new JButton ("Sair");

    private MeuJPanel pnlDesenho = new MeuJPanel ();
    
    private JLabel statusBar1 = new JLabel ("Mensagem:"),
                   statusBar2 = new JLabel ("Coordenada:");

    boolean esperaPonto, esperaInicioReta, esperaFimReta, esperaInicioCirculo, esperaFimCirculo,
            esperaInicioElipse, esperaFimElipse, Salvar;

    private Color corAtual = Color.black;
    private Ponto p1,p2,p3;
    
    private Vector<Figura> figuras = new Vector<Figura>();

    public Janela ()
    {
        super("Editor Gr�fico");

        try
        {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo linha.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo circulo.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCores.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo abrir.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo salvar.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo apagar.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo sair.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        btnPonto.addActionListener (new DesenhoDePonto());
        btnLinha.addActionListener (new DesenhoDeReta ());
        btnCirculo.addActionListener (new DesenhoDeCirculo ());
        btnElipse.addActionListener (new DesenhoDeElipse ());
        btnSalvar.addActionListener (new Salvar ());

        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnCores);
        pnlBotoes.add (btnApagar);
        pnlBotoes.add (btnSair);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);
        
        this.addWindowListener (new FechamentoDeJanela());

        this.setSize (700,500);
        this.setVisible (true);
    }

    private class MeuJPanel extends    JPanel 
                            implements MouseListener,
                                       MouseMotionListener
    {
		private static final long serialVersionUID = 1L;

		public MeuJPanel()
        {
            super();

            this.addMouseListener       (this);
            this.addMouseMotionListener (this);
        }

        public void paint (Graphics g)
        {
            for (int i=0 ; i<figuras.size(); i++)
                figuras.get(i).torneSeVisivel(g);
        }
        
        public void mousePressed (MouseEvent e)
        {
            if (esperaPonto)
            {
                figuras.add (new Ponto (e.getX(), e.getY(), corAtual));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = false;
            }
            else
                if (esperaInicioReta)
                {
                    p1 = new Ponto (e.getX(), e.getY(), corAtual);
                    esperaInicioReta = false;
                    esperaFimReta = true;
                    statusBar1.setText("Mensagem: clique o ponto final da reta");    
                 }
                 else
                    if (esperaFimReta)
                    {
                        esperaInicioReta = false;
                        esperaFimReta = false;
                        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        statusBar1.setText("Mensagem:");    
                    }
                    else
                    	if (esperaInicioCirculo)
                        {
                    		p2 = new Ponto (e.getX(), e.getY(), corAtual);
                    		esperaInicioCirculo = false;
                    		esperaFimCirculo = true;
                            statusBar1.setText("Mensagem: clique o ponto final do Circulo");
                        }
                    	else
                        	if (esperaFimCirculo)
                            {
                        		
                        		double r = Math.sqrt( Math.pow( (p2.getX() - e.getX()),2 ) +
                                                      Math.pow( (p2.getY() - e.getY()),2 ) );
                        		
                        		esperaInicioCirculo = false;
                        		esperaFimCirculo = false;
                                figuras.add (new Circulo (p2.getX(), e.getY(), (int)r, corAtual));
                                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                statusBar1.setText("Mensagem:");
                            }
	                    	else
	                        	if (esperaInicioElipse)
	                            {
	                        		
	                        		p3 = new Ponto (e.getX(), e.getY(), corAtual);
	                        		
	                        		esperaInicioElipse = false;
	                        		esperaFimElipse = true;
	                                statusBar1.setText("Mensagem: clique o ponto final da Elipse");
	                            }
	                        	else
		                        	if (esperaFimElipse)
		                            {
		                        		
		                        		double r1 = Math.sqrt( Math.pow( (p3.getX() - e.getX()),2 ) +
                                                               Math.pow( (p3.getY() - e.getY()),2 ) );

		                            	double r2 = r1/2;
		                        		
		                            	esperaInicioElipse = false;
		                        		esperaFimElipse = false;
		                        		
		                                figuras.add (new Elipse (p3.getX(), p3.getY(), (int)r1, (int)r2, corAtual));
		                                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
		                                statusBar1.setText("Mensagem:");
		                            }
		                        	else
		                            	if (Salvar)
		                                {
		                            		Salvar = false;
		                                }
        }
        
        public void mouseReleased (MouseEvent e)
        {}
        
        public void mouseClicked (MouseEvent e)
        {}
        
        public void mouseEntered (MouseEvent e)
        {}

        public void mouseExited (MouseEvent e)
        {}
        
        public void mouseDragged(MouseEvent e)
        {}

        public void mouseMoved(MouseEvent e)
        {
            statusBar2.setText("Coordenada: "+e.getX()+","+e.getY());
        }
    }

    private class DesenhoDePonto implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
              esperaPonto      = true;
              esperaInicioReta = false;
              esperaFimReta    = false;

              statusBar1.setText("Mensagem: clique o local do ponto desejado");
          }
    }

    private class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = true;
            esperaFimReta    = false;

            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }
    
    private class DesenhoDeCirculo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioCirculo = true;
            esperaFimCirculo    = false;
            
            statusBar1.setText("Mensagem: clique o local do Circulo desejado");
        }
    }
    
    private class DesenhoDeElipse implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	esperaPonto      = false;
            esperaInicioElipse = true;
            esperaFimElipse    = false;
            statusBar1.setText("Mensagem: clique o local da Elipse desejado");
        }
    }
    
    private class Salvar implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            Salvar = true;
            
            
        }  
    }

    private class FechamentoDeJanela extends WindowAdapter
    {
        public void windowClosing (WindowEvent e)
        {
            System.exit(0);
        }
    }
}
