import java.awt.*;
import java.util.*;

public class Linha extends Figura
{
    protected Ponto p1, p2;
	
    public Linha (int x1, int y1, int x2, int y2)
    {
        super();

        this.p1 = new Ponto (x1,y1);
        this.p2 = new Ponto (x2,y2);
    }
	
    public Linha (int x1, int y1, int x2, int y2, Color cor)
    {
        super(cor);

        this.p1 = new Ponto (x1,y1,cor);
        this.p2 = new Ponto (x2,y2,cor);
    }

    public Linha (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x1  = Integer.parseInt(quebrador.nextToken());
        int   y1  = Integer.parseInt(quebrador.nextToken());

        int   x2  = Integer.parseInt(quebrador.nextToken());
        int   y2  = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B

        this.p1  = new Ponto (x1,y1,cor);
        this.p2  = new Ponto (x2,y2,cor);
        this.cor = cor;
    }

    public void setP1 (int x, int y)
    {
        this.p1 = new Ponto (x,y,this.getCor());
    }

    public void setP2 (int x, int y)
    {
        this.p2 = new Ponto (x,y,this.getCor());
    }

    public Ponto getP1 ()
    {
        return this.p1;
    }

    public Ponto getP2 ()
    {
        return this.p2;
    }

    public void torneSeVisivel (Graphics g)
    {
        g.setColor(this.cor);
        g.drawLine(this.p1.getX(), this.p1.getY(),   // ponto inicial
                   this.p2.getX(), this.p2.getY());  // ponto final
    }

    public String toString()
    {
        return "r:" +
               this.p1.getX() +
               ":" +
               this.p1.getY() +
               ":" +
               this.p2.getX() +
               ":" +
               this.p2.getY() +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }
    
    public int hashCode()
    {
    	int resultado = 1;
    	
    	resultado = resultado*7+this.p1.getX();
    	resultado = resultado*7+this.p1.getY();
    	resultado = resultado*7+this.p2.getX();
    	resultado = resultado*7+this.p2.getY();
    	resultado = resultado*7+this.getCor().getBlue();
    	resultado = resultado*7+this.getCor().getRed();
    	resultado = resultado*7+this.getCor().getGreen();
    	
    	return resultado;
    }
    
    public boolean equals(Object obj)
    {
    	if(this==obj)
    		return true;
    	if(obj==this)
    		return false;
    	if(obj instanceof Linha)
    	{
    		Linha lin =  (Linha)obj;
    		if(lin.p1  == this.p1 &&
    		   lin.p2  == this.p2 &&
    		   lin.cor == this.cor)
    		   return true;
    	}
    	return false;
    }
    
    public int compareTo (Linha l)
    {
        if (this.p1.getX()<l.p1.getX())
             return -7;

        if (this.p1.getY()<l.p1.getY())
            return -7;

        if (this.p2.getX()<l.p2.getX())
            return -7;
        
        if (this.p2.getY()<l.p2.getY())
            return -7;
        
        if (this.cor.getRed()<l.cor.getRed())
            return -7;
       
        if (this.cor.getGreen()<l.cor.getGreen())
           return -7;
       
        if (this.cor.getBlue()<l.cor.getBlue())
           return -7;
        
        if (this.p1.getX()>l.p1.getX())
            return 7;

        if (this.p1.getY()>l.p1.getY())
           return 7;
        
        if (this.p2.getX()>l.p2.getX())
            return 7;

        if (this.p2.getY()>l.p2.getY())
           return 7;

        if (this.cor.getRed()>l.cor.getRed())
             return 7;
        
        if (this.cor.getGreen()>l.cor.getGreen())
            return 7;
        
        if (this.cor.getBlue()>l.cor.getBlue())
            return 7;
        
        return 0;
    }
    
    public Object clone ()
    {
        Linha l = null;

        try
        {
            l = new Linha (this.p1.getX(),this.p1.getY(),this.p2.getX(),this.p2.getY(),this.cor);
        }
        catch (Exception erro)
        {}

        return l;
    }
    
    public Linha (Linha modelo)
    {
    	this (modelo.p1.getX(), modelo.p1.getY(), modelo.p1.getX(), modelo.p1.getY(), modelo.cor);
    }
}