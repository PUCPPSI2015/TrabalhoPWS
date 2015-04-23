import java.awt.*;
import java.util.*;

public class Circulo extends Figura
{
    protected Ponto centro;
    protected int   raio;
	
    public Circulo (int x, int y, int r)
    {
        super ();

        this.centro = new Ponto (x,y);
        this.raio   = r;
    }
	
    public Circulo (int x, int y, int r, Color cor)
    {
        super (cor);

        this.centro = new Ponto (x,y);
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

        this.centro = new Ponto (x,y,cor);
        this.raio   = r;
        this.cor    = cor;
    }

    public void setCentro (int x, int y)
    {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public void setRaio (int r)
    {
        this.raio = r;
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int getRaio ()
    {
        return this.raio;
    }

    public void torneSeVisivel (Graphics g)
    {
        g.setColor (this.cor);
        g.drawOval (this.centro.getX()-raio, this.centro.getY()-raio, 2*raio, 2*raio);
			
    }

    public String toString()
    {
        return "c:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raio +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }
    
    // ****CONFERIR DAQUI PARA BAIXO****
    
    public int hashCode()
    {
    	int resultado =1;
    	
    	resultado = resultado*7 + this.raio;
    	resultado = resultado*7 + this.centro.getX();
    	resultado = resultado*7 + this.centro.getY();
    	resultado = resultado*7 + this.cor.getRed();
    	resultado = resultado*7 + this.cor.getGreen();
    	resultado = resultado*7 + this.cor.getBlue();
    	
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

            if (cir.centro    == this.centro   &&
            	cir.raio == this.raio          &&
            	cir.cor == this.cor)
                return true;
        }
        return false;
    }
    
    public int compareTo (Circulo c)
    {
        if (this.centro.getX()<c.centro.getX())
             return -7;

        if (this.centro.getY()<c.centro.getY())
            return -7;

        if (this.raio<c.raio)
            return -7;
        
        if (this.cor.getRed()<c.cor.getRed())
            return -7;
       
       if (this.cor.getGreen()<c.cor.getGreen())
           return -7;
       
       if (this.cor.getBlue()<c.cor.getBlue())
           return -7;
        
        if (this.centro.getX()>c.centro.getX())
            return 7;

        if (this.centro.getY()>c.centro.getY())
           return 7;
        
        if (this.raio>c.raio)
            return 7;

        if (this.cor.getRed()>c.cor.getRed())
             return 7;
        
        if (this.cor.getGreen()>c.cor.getGreen())
            return 7;
        
        if (this.cor.getBlue()>c.cor.getBlue())
            return 7;
        
        return 0;
    }
    
    public Object clone ()
    {
        Circulo c = null;

        try
        {
            c = new Circulo (this.centro.getX(),this.centro.getY(),this.raio,this.cor);
        }
        catch (Exception erro)
        {}

        return c;
    }
    
    public Circulo (Circulo modelo)
    {
    	this (modelo.getCentro().getX(), modelo.getCentro().getY(), modelo.raio,modelo.cor);
    }
    
}