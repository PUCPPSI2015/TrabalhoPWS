import java.awt.*;
import java.util.*;

public class Circulo extends Figura
{
    protected Ponto canto;
    protected int   raio;
	
    public Circulo (int x, int y, int r)
    {
        super ();
        this.canto = new Ponto (x,y);
        this.raio   = r;
    }
	
    public Circulo (int x, int y, int r, Color cor, Color corI)
    {
        super (cor, corI);
        this.canto = new Ponto (x,y);
        this.raio   = r;
    }

    public Circulo (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");
        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   r   = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
        
        Color corI = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                				Integer.parseInt(quebrador.nextToken()),  // G
                				Integer.parseInt(quebrador.nextToken()),  // B
                				Integer.parseInt(quebrador.nextToken())); // A

        this.canto = new Ponto (x,y,cor,corI);
        this.raio   = r;
        this.corContorno    = cor;
        this.corInterior    = corI;
    }

    public void setCanto (int x, int y)
    {
        this.canto = new Ponto (x,y,this.getCorContorno(),this.getCorInterior());
    }

    public void setRaio (int r)
    {
        this.raio = r;
    }

    public Ponto getCanto ()
    {
        return this.canto;
    }

    public int getRaio ()
    {
        return this.raio;
    }

    public void torneSeVisivel (Graphics g, Graphics l)
    {
    	l.setColor (this.corInterior);
        g.setColor (this.corContorno);
        l.fillOval (this.canto.getX(), this.canto.getY(), raio, raio);
        g.drawOval (this.canto.getX(), this.canto.getY(), raio, raio);
			
    }

    public String toString()
    {
        return "c:" +
               this.canto.getX() +
               ":" +
               this.canto.getY() +
               ":" +
               this.raio +
               ":" +
               this.getCorContorno().getRed() +
               ":" +
               this.getCorContorno().getGreen() +
               ":" +
               this.getCorContorno().getBlue() +
               ":" +
               this.getCorInterior().getRed() +
               ":" +
               this.getCorInterior().getGreen() +
               ":" +
               this.getCorInterior().getBlue() +
        	   ":" +
        	   this.getCorInterior().getAlpha();
    }
    
    public String toSvg()
    {
        return "<circle " +
               "cx='" + this.canto.getX() + "' " +
               "cy='" + this.canto.getY() + "' " +
               "r='" + raio + "' " +
               "style='fill: rgb(" + this.getCorInterior().getRed() +
               "," + this.getCorInterior().getGreen() +
               "," + this.getCorInterior().getBlue() +
               "); stroke: rgb(" + this.getCorContorno().getRed() +
               "," + this.getCorContorno().getGreen() +
               "," + this.getCorContorno().getBlue() +
               ");'" + "/>";
 
    }
    
    public int hashCode()
    {
    	int resultado =1;
    	
    	resultado = resultado*7 + this.raio;
    	resultado = resultado*7 + this.canto.getX();
    	resultado = resultado*7 + this.canto.getY();
    	resultado = resultado*7 + this.corContorno.getRed();
    	resultado = resultado*7 + this.corContorno.getGreen();
    	resultado = resultado*7 + this.corContorno.getBlue();
    	
    	return resultado;
    }
    
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;
        
        if (obj instanceof Circulo)
        {
        	Circulo cir = (Circulo)obj;

            if (cir.canto    == this.canto   &&
            	cir.raio == this.raio          &&
            	cir.corContorno == this.corContorno)
                return true;
        }
        return false;
    }
    
    public int compareTo (Circulo c)
    {
        if (this.canto.getX()<c.canto.getX())
             return -7;

        if (this.canto.getY()<c.canto.getY())
            return -7;

        if (this.raio<c.raio)
            return -7;
        
        if (this.corContorno.getRed()<c.corContorno.getRed())
            return -7;
       
       if (this.corContorno.getGreen()<c.corContorno.getGreen())
           return -7;
       
       if (this.corContorno.getBlue()<c.corContorno.getBlue())
           return -7;
        
        if (this.canto.getX()>c.canto.getX())
            return 7;

        if (this.canto.getY()>c.canto.getY())
           return 7;
        
        if (this.raio>c.raio)
            return 7;

        if (this.corContorno.getRed()>c.corContorno.getRed())
             return 7;
        
        if (this.corContorno.getGreen()>c.corContorno.getGreen())
            return 7;
        
        if (this.corContorno.getBlue()>c.corContorno.getBlue())
            return 7;
        
        return 0;
    }
    
    public Object clone ()
    {
        Circulo c = null;

        try
        {
            c = new Circulo (this.canto.getX(),this.canto.getY(),this.raio,this.corContorno,this.corInterior);
        }
        catch (Exception erro)
        {}

        return c;
    }
    
    public Circulo (Circulo modelo)
    {
    	this (modelo.getCanto().getX(), modelo.getCanto().getY(), modelo.raio,modelo.corContorno,modelo.corInterior);
    }
    
}