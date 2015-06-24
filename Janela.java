import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;
import java.util.*;
import java.util.Timer;
public class Janela extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JMenu mnuEArquivo   = new JMenu ("Arquivo"),
	mnuFiguras  = new JMenu ("Figuras"),
	mnuCores  = new JMenu ("Cores"),
	mnuTexto  = new JMenu ("Texto");
	private JMenuItem btnAbrir   = new JMenuItem ("Abrir"),
	btnSalvar  = new JMenuItem ("Salvar"),
	btnSair    = new JMenuItem ("Sair"),
	btnPonto   = new JMenuItem ("Ponto"),
	btnLinha   = new JMenuItem ("Linha"),
	btnCirculo = new JMenuItem ("Circulo"),
	btnElipse  = new JMenuItem ("Elipse"),
	btnQuadrado = new JMenuItem ("Quadrado"),
	btnTriangulo = new JMenuItem ("Triangulo"),
	btnRetangulo = new JMenuItem ("Retangulo"),
	btnCorContorno  = new JMenuItem ("Cor Contorno"),
	btnCorInterior  = new JMenuItem ("Cor Interior"),
	btnEscreve = new JMenuItem ("Escreve"),
	btnExportar  = new JMenuItem ("Exportar pagina da web simples (html5)"),
	btnExportarAnimado  = new JMenuItem ("Exportar pagina da web animada (css3)"),
	btnExportarVetor  = new JMenuItem ("Exportar como vetor (Svg)"),
	btnFonte  = new JMenuItem ("Fontes");
	private JButton btnApagar  = new JButton ("Apagar");
	private MeuJPanel pnlDesenho = new MeuJPanel ();
	private JLabel statusBar1 = new JLabel ("Mensagem:"),
	statusBar2 = new JLabel ("Coordenada:");
	boolean esperaPonto, esperaInicioReta, esperaFimReta, esperaInicioCirculo, esperaFimCirculo,
	esperaInicioElipse, esperaElipse, esperaFimElipse, esperaQuadrado, esperaFimQuadrado,
	esperaRetangulo, esperaFimRetangulo,esperaInicioTriangulo, esperaTriangulo, esperaFimTriangulo, 
	Salvar, Abrir, AbrirCorContorno, AbrirCorInterior, esperaEscreve, Sair, Exportar;
	private Color corContorno = Color.black;
	private Color corInterior = new Color(0,0,0,0);
	private Ponto p1,p2,p3,p4;
	private Font FonteEscolhida = new Font("Serif", Font.ITALIC, 20);
	private Vector<Figura> figuras = new Vector<Figura>();
	public Janela ()
	{
		super("Editor Grafico ");
		try
		{
			Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
			btnPonto.setIcon(new ImageIcon(btnPontoImg));
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog (null,
				"Arquivo ponto.jpg n„o foi encontrado",
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
				"Arquivo linha.jpg nÔøΩo foi encontrado",
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
				"Arquivo circulo.jpg nÔøΩo foi encontrado",
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
				"Arquivo elipse.jpg nÔøΩo foi encontrado",
				"Arquivo de imagem ausente",
				JOptionPane.WARNING_MESSAGE);
		}
		try
		{
			Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
			btnCorContorno.setIcon(new ImageIcon(btnCoresImg));
			btnCorInterior.setIcon(new ImageIcon(btnCoresImg));
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog (null,
				"Arquivo cores.jpg nÔøΩo foi encontrado",
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
				"Arquivo abrir.jpg nÔøΩo foi encontrado",
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
				"Arquivo salvar.jpg nÔøΩo foi encontrado",
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
				"Arquivo apagar.jpg nÔøΩo foi encontrado",
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
				"Arquivo sair.jpg nÔøΩo foi encontrado",
				"Arquivo de imagem ausente",
				JOptionPane.WARNING_MESSAGE);
		}
		try
		{
			Image btnQuadradoImg = ImageIO.read(getClass().getResource("resources/quadrado.jpg"));
			btnQuadrado.setIcon(new ImageIcon(btnQuadradoImg));
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog (null,
				"Arquivo sair.jpg nÔøΩo foi encontrado",
				"Arquivo de imagem ausente",
				JOptionPane.WARNING_MESSAGE);
		}
		try
		{
			Image btnRetanguloImg = ImageIO.read(getClass().getResource("resources/retangulo.jpg"));
			btnRetangulo.setIcon(new ImageIcon(btnRetanguloImg));
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog (null,
				"Arquivo sair.jpg nÔøΩo foi encontrado",
				"Arquivo de imagem ausente",
				JOptionPane.WARNING_MESSAGE);
		}
		try
		{
			Image btnTrianguloImg = ImageIO.read(getClass().getResource("resources/triangulo.jpg"));
			btnTriangulo.setIcon(new ImageIcon(btnTrianguloImg));
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog (null,
				"Arquivo sair.jpg nÔøΩo foi encontrado",
				"Arquivo de imagem ausente",
				JOptionPane.WARNING_MESSAGE);
		}
		btnPonto.addActionListener (new DesenhoDePonto());
		btnLinha.addActionListener (new DesenhoDeReta ());
		btnCirculo.addActionListener (new DesenhoDeCirculo ());
		btnElipse.addActionListener (new DesenhoDeElipse ());
		btnQuadrado.addActionListener (new AbrirQuadrado());
		btnRetangulo.addActionListener (new AbrirRetangulo());
		btnTriangulo.addActionListener (new AbrirTriangulo());
		btnSalvar.addActionListener (new Salvar ());
		btnExportar.addActionListener (new Exportar ());
		btnExportarAnimado.addActionListener (new ExportarAnimado ());
		btnExportarVetor.addActionListener (new ExportarVetor ());
		btnAbrir.addActionListener (new Abrir ());
		btnCorContorno.addActionListener (new AbrirCorContorno() );
		btnCorInterior.addActionListener (new AbrirCorInterior() );
		btnFonte.addActionListener (new AbrirFontes() );
		btnSair.addActionListener(new Sair());
		btnEscreve.addActionListener(new DesenhoEscreve() );
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				pnlDesenho.paint(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
			}
		});
		Timer temporizador = new Timer();
        temporizador.scheduleAtFixedRate(new TimerTask() {
          @Override
          public void run() {
        	  pnlDesenho.paint(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
          }
        },0,100);
		
		JPanel     pnlBotoes = new JPanel();
		JMenuBar    barMenus = new JMenuBar();
		FlowLayout flwBotoes = new FlowLayout(); 
		pnlBotoes.setLayout (flwBotoes);
		pnlBotoes.add(barMenus);
		barMenus.add(mnuEArquivo);
		mnuEArquivo.add(btnAbrir);
		mnuEArquivo.add (btnSalvar);
		mnuEArquivo.add (btnExportar);
		mnuEArquivo.add (btnExportarAnimado);
		mnuEArquivo.add (btnExportarVetor);
		mnuEArquivo.addSeparator();
		mnuEArquivo.add (btnSair);
		barMenus.add(mnuFiguras);
		mnuFiguras.add (btnPonto);
		mnuFiguras.add (btnLinha);
		mnuFiguras.add (btnCirculo);
		mnuFiguras.add (btnElipse);
		mnuFiguras.add (btnQuadrado);
		mnuFiguras.add (btnRetangulo);
		mnuFiguras.add (btnTriangulo);
		barMenus.add(mnuCores);
		mnuCores.add (btnCorContorno);
		mnuCores.add (btnCorInterior);
		barMenus.add(mnuTexto);
		mnuTexto.add (btnEscreve);
		mnuTexto.add (btnFonte);
		pnlBotoes.add (btnApagar);
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
		this.setSize (1200,800);
		this.setVisible (true);
		this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}
	int windowWidth = getWidth();
	int windowHeight = getHeight();
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
		public void paint (Graphics g, Graphics l)
		{
			for (int i=0 ; i<figuras.size(); i++)
				figuras.get(i).torneSeVisivel(g,l);
		}
		public void limpa (Graphics g)
		{
			g.clearRect(0, 0, 10000, 10000);
		}
		
		public void mousePressed (MouseEvent e)
		{

            if (esperaPonto)
            {
                figuras.add (new Ponto (e.getX(), e.getY(), corContorno, corInterior));
                pnlDesenho.paint(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
                
            }
            else if (esperaInicioReta)
            {
                p1 = new Ponto (e.getX(), e.getY(), corContorno, corInterior);
                esperaInicioReta = false;
                esperaFimReta = true;
                statusBar1.setText("Mensagem: Clique e arraste para desenhar uma reta");

             }
             

            else if (esperaInicioCirculo)
            {
        		p2 = new Ponto (e.getX(), e.getY(), corContorno, corInterior);
        		esperaInicioCirculo = false;
        		esperaFimCirculo = true;
                statusBar1.setText("Mensagem: clique e arraste para desenhar um circulo");
            }
        	else if (esperaInicioElipse)
            {
        		
        		p3 = new Ponto (e.getX(), e.getY(), corContorno, corInterior);
        		
        		esperaInicioElipse = false;
        		esperaElipse = true;
        		esperaFimElipse = true;
                statusBar1.setText("Mensagem: clique o ponto final da Elipse");
            }
        	else if (esperaElipse)
            {
        		
        		p4 = new Ponto (e.getX(), e.getY(), corContorno, corInterior);
        		
            	esperaInicioElipse = false;
            	esperaElipse = false;
        		esperaFimElipse = true;
        		
                statusBar1.setText("Mensagem:clique o pronto da Elipse");
            }
        	else if (esperaFimElipse)
            {
        		
        		double r1 = Math.sqrt( Math.pow( (p3.getX() - e.getX()),2 ) +
                                       Math.pow( (p3.getY() - e.getY()),2 ) );

            	double r2 = Math.sqrt( Math.pow( (p4.getX() - e.getX()),2 ) +
                                       Math.pow( (p4.getY() - e.getY()),2 ) );
        		
            	esperaInicioElipse = false;
        		esperaFimElipse = false;
        		
                figuras.add (new Elipse (p3.getX(), p3.getY(), (int)r1, (int)r2, corContorno,corInterior));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem:");
            }
            else if (esperaQuadrado)
            {
                p1 = new Ponto (e.getX(), e.getY(), corContorno, corInterior);
                esperaQuadrado = false;
                esperaFimQuadrado = true;
                statusBar1.setText("Mensagem: clique o ponto final do Quadrado");    
             }
             else if (esperaFimQuadrado)
            {
                esperaQuadrado = false;
                esperaFimQuadrado = false;
                figuras.add (new Quadrado(p1.getX(), p1.getY(), e.getX(), e.getY(), corContorno,corInterior));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem:");    
            }
             else if (esperaRetangulo)
             {
                 p1 = new Ponto (e.getX(), e.getY(), corContorno, corInterior);
                 esperaRetangulo = false;
                 esperaFimRetangulo = true;
                 statusBar1.setText("Mensagem: clique o ponto final do Retangulo");    
              }
              else if (esperaFimRetangulo)
             {
                 esperaRetangulo = false;
                 esperaFimRetangulo = false;
                 figuras.add (new Retangulo(p1.getX(), p1.getY(), e.getX(), e.getY(), corContorno,corInterior));
                 figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
                 statusBar1.setText("Mensagem:");    
             }
              else if (esperaEscreve)
              {
                  p1 = new Ponto (e.getX(), e.getY(), corContorno, corInterior);
                  esperaEscreve = false;
                  JFrame frame = new JFrame();
                  String palavra = JOptionPane.showInputDialog(frame, "Digite a palavra:");
                  String c = palavra;
                  figuras.add (new Escreve(e.getX(), e.getY(), c, FonteEscolhida,  corContorno));
                  figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
                  statusBar1.setText("Mensagem:");    
               }
            
             else if (esperaInicioTriangulo)
             {
                 p1 = new Ponto (e.getX(), e.getY(), corContorno, corInterior);
                 esperaInicioTriangulo = false;
                 esperaTriangulo = true;
                 esperaFimTriangulo = false;
                 statusBar1.setText("Mensagem: clique o ponto final do Triangulo");    
              }
             else if (esperaTriangulo)
             {
                 p2 = new Ponto (e.getX(), e.getY(), corContorno, corInterior);
                 esperaInicioTriangulo = false;
                 esperaTriangulo = false;
                 esperaFimTriangulo = true;
                 statusBar1.setText("Mensagem: clique o ponto final do Triangulo");    
              }
              else if (esperaFimTriangulo)
             {
            	 esperaInicioTriangulo = false;
                 esperaTriangulo = false;
                 esperaFimTriangulo = false;
                 figuras.add (new Triangulo(e.getX(), e.getY(), p2.getX(), p2.getY(),
                		 					p1.getX(), p1.getY(),corContorno,corInterior));
                 figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
                 statusBar1.setText("Mensagem:");    
             }
        	else if (Salvar)
	        {
	    		Salvar = false;
	        }
	    	else if (Abrir)
            {
        		Abrir = false;
            }
	    	else if (Sair)
            {
        		Sair = false;
            }
		}
		public void mouseReleased (MouseEvent e)
		{
			if (esperaFimReta)
            {
                esperaInicioReta = false;
                esperaFimReta = false;
                figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corContorno,corInterior));
                pnlDesenho.paint(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
                    
            }
            else if (esperaFimCirculo)
            {
        		
        		double r = Math.sqrt( Math.pow( (p2.getX() - e.getX()),2 ) +
                                      Math.pow( (p2.getY() - e.getY()),2 ) );
        		
        		esperaInicioCirculo = false;
        		esperaFimCirculo = false;
                figuras.add (new Circulo (p2.getX(), p2.getY(), (int)r, corContorno, corInterior));
                pnlDesenho.paint(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
            }

			
			
		}
		public void mouseClicked (MouseEvent e)
		{}
		public void mouseEntered (MouseEvent e)
		{}
		public void mouseExited (MouseEvent e)
		{}
		public void mouseDragged(MouseEvent e)
		{
			if (esperaFimReta)
            {
                pnlDesenho.limpa(pnlDesenho.getGraphics());
                figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corContorno,corInterior));
                pnlDesenho.paint(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
                figuras.removeElementAt(figuras.size() - 1);
                    
            }
            else if (esperaFimCirculo)
            {
        		pnlDesenho.limpa(pnlDesenho.getGraphics());
        		double r = Math.sqrt( Math.pow( (p2.getX() - e.getX()),2 ) +
                                      Math.pow( (p2.getY() - e.getY()),2 ) );
                figuras.add (new Circulo (p2.getX(), p2.getY(), (int)r, corContorno, corInterior));
                pnlDesenho.paint(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
                figuras.removeElementAt(figuras.size() - 1);
            }
		}
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
			esperaPonto         = false;
			esperaInicioCirculo = true;
			esperaFimCirculo    = false;
			statusBar1.setText("Mensagem: clique o local do Circulo desejado");
		}
	}
	private class DesenhoDeElipse implements ActionListener
	{
		public void actionPerformed (ActionEvent e)    
		{
			esperaPonto        = false;
			esperaInicioElipse = true;
			esperaFimElipse    = false;
			statusBar1.setText("Mensagem: clique o local da Elipse desejado");
		}
	}
	private class DesenhoEscreve implements ActionListener
	{
		public void actionPerformed (ActionEvent e)    
		{
			esperaPonto        = false;
			esperaEscreve = true;
			statusBar1.setText("Mensagem: clique o local onde deseja escrever");
		}
	}
	private class Sair implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			Sair = true;
			switch(JOptionPane.showConfirmDialog(null,"Deseja salvar antes de sair?, seu gatinho :3"))
			{  
				case JOptionPane.OK_OPTION:{ 
					Salvar=true;
					new Salvar().actionPerformed(e);
				}
				case JOptionPane.NO_OPTION:{
					System.exit(0);
				}
			}	
		}
	}
	private class Salvar implements ActionListener
	{
		public void actionPerformed (ActionEvent e)    
		{
			Salvar = true;  
			JFileChooser chooser;
			chooser = new JFileChooser();
			String caminho = "";
			File file = null;
			int retorno = chooser.showSaveDialog(null);
			if (retorno==JFileChooser.APPROVE_OPTION)
				{      caminho = chooser.getSelectedFile().getAbsolutePath();
					if(!caminho.equals(""))
					{
						file = new File(caminho);
						boolean existe = file.exists();
						if(!existe){
							file = new File(caminho+".pws");
						}
						else{
							JOptionPane.showMessageDialog(null,"O arquivo jÔøΩ ecziste! Deseja substituÔøΩ-lo??? (te amo :3)");
						}
						String[] stringDividida = figuras.toString().split(",");
						try{
							BufferedWriter buffer = new BufferedWriter(new FileWriter (file));
							for(int i = 0; i < figuras.size(); i++)
							{
								buffer.write(stringDividida[i]+"\n");
							}
							buffer.close();
							JOptionPane.showMessageDialog(null,"Arquivo gravado com " +
								"sucesso","Conclu√≠do",JOptionPane.INFORMATION_MESSAGE);
						}
						catch(Exception err)
						{
							JOptionPane.showMessageDialog(null,err.getMessage(),
								"Aten√ß√£o",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else if(retorno==JFileChooser.CANCEL_OPTION)
				{
					JOptionPane.showMessageDialog(null,"O arquivo n√£o foi salvo! (lindo :3)");
				}
			}
		}
		private class Abrir implements ActionListener
		{
			public void actionPerformed (ActionEvent e)    
			{
				Abrir = true;
				JFileChooser chooser;
				chooser = new JFileChooser();
				String caminho = "";
				File arquivo = null;
				int retorno = chooser.showOpenDialog(null);    
				if (retorno==JFileChooser.APPROVE_OPTION)
					caminho = chooser.getSelectedFile().getAbsolutePath();
				if(!caminho.equals(""))
				{
					arquivo = new File(caminho);
					if (!arquivo.getAbsolutePath().endsWith(".pws"))  
 	     			arquivo = new File(arquivo.getAbsolutePath() + ".pws");//adicionar extensao
 	     		try 
 	     		{    
 	     			FileReader reader = new FileReader(arquivo);
 	     			BufferedReader br = new BufferedReader(reader);
 	     			String linha;
 	     			while ((linha = br.readLine()) != null) {
 						linha = linha.substring(1,  linha.length());//tira o [ ou o espaÔøΩo iniciau dazlinhas
 						StringTokenizer quebrador = new StringTokenizer(linha,":");
 						String token = quebrador.nextToken();
 						char definidor = token.charAt(0);
 						char ultimo = linha.charAt(linha.length()-1 );
 						char br2 = ']';
 			           if (ultimo == br2){ //ultima linha!
 			           	linha = linha.substring(0,  linha.length()-1);
 			           }
 			           if(definidor == 'p'){
 			           	figuras.add(new Ponto (linha));
 			           	figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
 			           }
 			           else
 			           	if(definidor == 'r'){
 			           		figuras.add(new Linha (linha));
 			           		figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
 			           	}
 			           	else
 			           		if(definidor == 'c'){
 			           			figuras.add(new Circulo (linha));
 			           			figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
 			           		}
 			           		else
 			           			if(definidor == 'e'){
 			           				figuras.add(new Elipse (linha));
 			           				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
 			           			}else
 			           			if(definidor == 'q'){
 			           				figuras.add(new Quadrado (linha));
 			           				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
 			           			}else
 			           			if(definidor == 'g'){
 			           				figuras.add(new Retangulo (linha));
 			           				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
 			           			}else
 			           			if(definidor == 't'){
 			           				figuras.add(new Triangulo (linha));
 			           				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
 			           			}else
 			           			if(definidor == 's'){
 			           				figuras.add(new Escreve (linha));
 			           				figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
 			           			}
 			           		}
 			           		pnlDesenho.paint(pnlDesenho.getGraphics(),pnlDesenho.getGraphics());
 			           		br.close(); 
 			           	}
 			           	catch (Exception err)
 			           	{
 			           		System.out.println("Erro: " + err.getMessage());
 			           	}
 			           }
 			     }
 			}
 			private class Exportar implements ActionListener{
 				public void actionPerformed (ActionEvent e)    
 				{
 					Salvar = true;  
 					JFileChooser chooser;
 					chooser = new JFileChooser();
 					String caminho = "";
 					File file = null;
 					int retorno = chooser.showSaveDialog(null);
 					if (retorno==JFileChooser.APPROVE_OPTION)
 						{      caminho = chooser.getSelectedFile().getAbsolutePath();
 							if(!caminho.equals(""))
 							{
 								file = new File(caminho);
 								boolean existe = file.exists();
 								if(!existe){
 									file = new File(caminho+".html");
 								}
 								else{
 									JOptionPane.showMessageDialog(null,"O arquivo ja existe! Deseja substitui-lo???");
 								}
 								String stringFinal = "<!DOCTYPE html><!-- feito por alunos: Guilherme, Renan e Victor! --><html lang='pt-br'><head><meta charset='utf-8' /><meta name='theme-color' content='#000'><title>Editor muito louco</title><style>*{margin: 0;padding: 0;}svg * {-webkit-transform-origin: 50% 50%;-moz-transform-origin: 50% 50%;-ms-transform-origin: 50% 50%;-o-transform-origin: 50% 50%;transform-origin: 50% 50%;-webkit-transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);-moz-transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);-ms-transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);-o-transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);}svg *:hover{-webkit-transform: scale(1.3);-moz-transform: scale(1.3);-ms-transform: scale(1.3);-o-transform: scale(1.3);transform: scale(1.3);}</style></head><body data-tipo='feito no java' data-exportacao=-'simples'><svg version='1.1' id='editorExported' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='0px' y='0px' style='position: absolute;'width='100%' height='100%'  xml:space='preserve'>";
 								for(int i = 0; i < figuras.size(); i++)
 								{
 									stringFinal += figuras.get(i).toSvg();
 								}
 								stringFinal += "</svg><script type='text/javascript'></script></body></html>";
 								try{
 									BufferedWriter buffer = new BufferedWriter(new FileWriter (file));
 									buffer.write(stringFinal);
 									buffer.close();
 									JOptionPane.showMessageDialog(null,"Arquivo gravado com " +
 										"sucesso","ConcluÃ­do",JOptionPane.INFORMATION_MESSAGE);
 								}
 								catch(Exception err)
 								{
 									JOptionPane.showMessageDialog(null,err.getMessage(),
 										"AtenÃ§Ã£o",JOptionPane.WARNING_MESSAGE);
 								}
 							}
 						}
 						else if(retorno==JFileChooser.CANCEL_OPTION)
 						{
 							JOptionPane.showMessageDialog(null,"O arquivo nÃ£o foi exportado! (lindo :3)");
 						}
 					}
 				}
 				private class ExportarAnimado implements ActionListener{
 					public void actionPerformed (ActionEvent e)    
 					{
 						Salvar = true;  
 						JFileChooser chooser;
 						chooser = new JFileChooser();
 						String caminho = "";
 						File file = null;
 						int retorno = chooser.showSaveDialog(null);
 						if (retorno==JFileChooser.APPROVE_OPTION)
 							{      caminho = chooser.getSelectedFile().getAbsolutePath();
 								if(!caminho.equals(""))
 								{
 									file = new File(caminho);
 									boolean existe = file.exists();
 									if(!existe){
 										file = new File(caminho+".html");
 									}
 									else{
 										JOptionPane.showMessageDialog(null,"O arquivo ja existe! Deseja substitui-lo???");
 									}
 									String stringFinal = "<!DOCTYPE html><!-- feito por alunos: Guilherme, Renan e Victor! --><html lang='pt-br'><head>  <meta charset='utf-8' />    <meta name='theme-color' content='#000'>    <title>Editor muito louco</title>   <style>     *{          margin: 0;          padding: 0;     }       svg * {         -webkit-transform-origin: 50% 50%;          -moz-transform-origin: 50% 50%;         -ms-transform-origin: 50% 50%;          -o-transform-origin: 50% 50%;           transform-origin: 50% 50%;          -webkit-transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);            -moz-transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);           -ms-transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);            -o-transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);         transition: all 0.2s cubic-bezier(.02,.01,.74,1.46);        }       svg *:hover{            -webkit-transform: scale(1.3);          -moz-transform: scale(1.3);         -ms-transform: scale(1.3);          -o-transform: scale(1.3);           transform: scale(1.3);      }       svg * {         -webkit-animation: giragostoso 10s linear infinite;         -moz-animation: giragostoso 10s linear infinite;            animation: giragostoso 10s linear infinite;         -ms-animation: giragostoso 10s linear infinite;     }       @-moz-keyframes giragostoso {           from {              transform: rotateX(10deg) rotateY(-360deg);         }           to {                transform: rotateX(10deg) rotateY(0deg);            }       }       @-webkit-keyframes giragostoso {            from {              transform: rotateX(10deg) rotateY(-360deg);         }           to {                transform: rotateX(10deg) rotateY(0deg);            }       }       @keyframes giragostoso {            from {              transform: rotateX(10deg) rotateY(-360deg);         }           to {                transform: rotateX(10deg) rotateY(0deg);            }       }       @-moz-keyframes giragostoso {           from {              transform: rotateX(10deg) rotateY(-360deg);         }           to {                transform: rotateX(10deg) rotateY(0deg);            }       }       @-webkit-keyframes giragostoso {            from {              transform: rotateX(10deg) rotateY(-360deg);         }           to {                transform: rotateX(10deg) rotateY(0deg);            }       }       @keyframes giragostoso {            from {              transform: rotateX(10deg) rotateY(-360deg);         }           to {                transform: rotateX(10deg) rotateY(0deg);            }       }       svg * {         transform-origin: 50% 50%;          animation: giragostoso 10s linear infinite ;        }       @keyframes giragostoso {            from {              transform: rotateX(10deg) rotateY(-360deg);         }           to {                transform: rotateX(10deg) rotateY(0deg);            }       }   </style></head><body data-tipo='feito no java' data-exportacao=-'simples'>  <svg version='1.1' id='editorExported' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='0px' y='0px' style='position: absolute;'width='100%' height='100%'  xml:space='preserve'>";
 									for(int i = 0; i < figuras.size(); i++)
 									{
 										stringFinal += figuras.get(i).toSvg();
 									}
 									stringFinal += "</svg><script type='text/javascript'></script></body></html>";
 									try{
 										BufferedWriter buffer = new BufferedWriter(new FileWriter (file));
 										buffer.write(stringFinal);
 										buffer.close();
 										JOptionPane.showMessageDialog(null,"Arquivo gravado com " +
 											"sucesso","ConcluÃ­do",JOptionPane.INFORMATION_MESSAGE);
 									}
 									catch(Exception err)
 									{
 										JOptionPane.showMessageDialog(null,err.getMessage(),
 											"AtenÃ§Ã£o",JOptionPane.WARNING_MESSAGE);
 									}
 								}
 							}
 							else if(retorno==JFileChooser.CANCEL_OPTION)
 							{
 								JOptionPane.showMessageDialog(null,"O arquivo nÃ£o foi exportado! (lindo :3)");
 							}
 						}
 					}
 					private class ExportarVetor implements ActionListener{
 						public void actionPerformed (ActionEvent e)    
 						{
 							Salvar = true;  
 							JFileChooser chooser;
 							chooser = new JFileChooser();
 							String caminho = "";
 							File file = null;
 							int retorno = chooser.showSaveDialog(null);
 							if (retorno==JFileChooser.APPROVE_OPTION)
 								{      caminho = chooser.getSelectedFile().getAbsolutePath();
 									if(!caminho.equals(""))
 									{
 										file = new File(caminho);
 										boolean existe = file.exists();
 										if(!existe){
 											file = new File(caminho+".svg");
 										}
 										else{
 											JOptionPane.showMessageDialog(null,"O arquivo ja existe! Deseja substitui-lo???");
 										}
 										String stringFinal = "<?xml version='1.0' encoding='iso-8859-1'?><!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.0//EN' 'http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd'><svg xmlns='http://www.w3.org/2000/svg' xmlns:odm='http://product.corel.com/CGS/11/cddns/' xml:space='preserve' width='288mm' height='180mm' style='shape-rendering:geometricPrecision; text-rendering:geometricPrecision; image-rendering:optimizeQuality; fill-rule:evenodd'>";
 										for(int i = 0; i < figuras.size(); i++)
 										{
 											stringFinal += figuras.get(i).toSvg();
 										}
 										stringFinal += "</svg>";
 										try{
 											BufferedWriter buffer = new BufferedWriter(new FileWriter (file));
 											buffer.write(stringFinal);
 											buffer.close();
 											JOptionPane.showMessageDialog(null,"Arquivo gravado com " +
 												"sucesso","ConcluÃ­do",JOptionPane.INFORMATION_MESSAGE);
 										}
 										catch(Exception err)
 										{
 											JOptionPane.showMessageDialog(null,err.getMessage(),
 												"AtenÃ§Ã£o",JOptionPane.WARNING_MESSAGE);
 										}
 									}
 								}
 								else if(retorno==JFileChooser.CANCEL_OPTION)
 								{
 									JOptionPane.showMessageDialog(null,"O arquivo nÃ£o foi exportado! (lindo :3)");
 								}
 							}
 						}
 						private class AbrirCorContorno implements ActionListener
 						{
 							public void actionPerformed (ActionEvent e)   {
 								corContorno = JColorChooser.showDialog(null, "Escolha uma cor para contorno (S2 :3)", corContorno);
 							}
 						}
 						private class AbrirCorInterior implements ActionListener
 						{
 							public void actionPerformed (ActionEvent e)   {
 								corInterior = JColorChooser.showDialog(null, "Escolha uma cor para o preenchimento (gatinho :3)", corInterior);
 							}
 						}
 						private class AbrirFontes implements ActionListener
 						{
 							public void actionPerformed (ActionEvent e)   {
 								JFontChooser fontChooser = new JFontChooser();
 								fontChooser.show();
 								if (fontChooser.getReturnStatus() == fontChooser.RET_OK)
 								{
 									Font font = fontChooser.getFont();
 									FonteEscolhida = font;
 									System.out.println("Selected Font : " + font);
 								}
 							}
 						}
 						private class AbrirQuadrado implements ActionListener
 						{
 							public void actionPerformed (ActionEvent e)    
 							{
 								esperaPonto      = false;
 								esperaQuadrado   = true;
 								esperaFimQuadrado= false;
 								statusBar1.setText("Mensagem: clique o ponto inicial do Quadrado");
 							}
 						}
 						private class AbrirRetangulo implements ActionListener
 						{
 							public void actionPerformed (ActionEvent e)    
 							{
 								esperaPonto       = false;
 								esperaRetangulo   = true;
 								esperaFimRetangulo= false;
 								statusBar1.setText("Mensagem: clique o ponto inicial do Retangulo");
 							}
 						}
 						private class AbrirTriangulo implements ActionListener
 						{
 							public void actionPerformed (ActionEvent e)    
 							{
 								esperaPonto           = false;
 								esperaInicioTriangulo = true;
 								esperaTriangulo       = false;
 								esperaFimTriangulo    = false;
 								statusBar1.setText("Mensagem: clique o ponto inicial do Triangulo");
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
