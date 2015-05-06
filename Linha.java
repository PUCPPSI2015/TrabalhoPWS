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
	
    public Linha (int x1, int y1, int x2, int y2, Color cor, Color corI)
    {
        super(cor,corI);

        this.p1 = new Ponto (x1,y1,cor,corI);
        this.p2 = new Ponto (x2,y2,cor,corI);
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
        Color corI = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                				Integer.parseInt(quebrador.nextToken()),  // G
                				Integer.parseInt(quebrador.nextToken())); // B

        this.p1  = new Ponto (x1,y1,cor,corI);
        this.p2  = new Ponto (x2,y2,cor,corI);
        this.corContorno = cor;
    }

    public void setP1 (int x, int y)
    {
        this.p1 = new Ponto (x,y,this.getCorContorno(),this.corInterior);
    }

    public void setP2 (int x, int y)
    {
        this.p2 = new Ponto (x,y,this.getCorContorno(),this.corInterior);
    }

    public Ponto getP1 ()
    {
        return this.p1;
    }

    public Ponto getP2 ()
    {
        return this.p2;
    }

    public void torneSeVisivel (Graphics g, Graphics l)
    {
        g.setColor(this.corContorno);
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
               this.getCorInterior().getBlue();
    }
    
    public int hashCode()
    {
    	int resultado = 1;
    	
    	resultado = resultado*7+this.p1.getX();
    	resultado = resultado*7+this.p1.getY();
    	resultado = resultado*7+this.p2.getX();
    	resultado = resultado*7+this.p2.getY();
    	resultado = resultado*7+this.getCorContorno().getBlue();
    	resultado = resultado*7+this.getCorContorno().getRed();
    	resultado = resultado*7+this.getCorContorno().getGreen();
    	
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
    		   lin.corContorno == this.corContorno)
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
        
        if (this.corContorno.getRed()<l.corContorno.getRed())
            return -7;
       
        if (this.corContorno.getGreen()<l.corContorno.getGreen())
           return -7;
       
        if (this.corContorno.getBlue()<l.corContorno.getBlue())
           return -7;
        
        if (this.p1.getX()>l.p1.getX())
            return 7;

        if (this.p1.getY()>l.p1.getY())
           return 7;
        
        if (this.p2.getX()>l.p2.getX())
            return 7;

        if (this.p2.getY()>l.p2.getY())
           return 7;

        if (this.corContorno.getRed()>l.corContorno.getRed())
             return 7;
        
        if (this.corContorno.getGreen()>l.corContorno.getGreen())
            return 7;
        
        if (this.corContorno.getBlue()>l.corContorno.getBlue())
            return 7;
        
        return 0;
    }
    
    public Object clone ()
    {
        Linha l = null;

        try
        {
            l = new Linha (this.p1.getX(),this.p1.getY(),this.p2.getX(),this.p2.getY(),this.corContorno,this.corInterior);
        }
        catch (Exception erro)
        {}

        return l;
    }
    
    public Linha (Linha modelo)
    {
    	this (modelo.p1.getX(), modelo.p1.getY(), modelo.p1.getX(), modelo.p1.getY(), modelo.corContorno, modelo.corInterior);
    }
}