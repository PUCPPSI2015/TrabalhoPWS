import java.awt.*;
import java.util.*;

public class Elipse extends Figura
{
    protected Ponto centro;

    protected int raio1, raio2;
	
    public Elipse (int x, int y, int r1, int r2)
    {
        super ();

        this.centro = new Ponto (x,y);

        this.raio1  = r1;
        this.raio2  = r2;
    }
	
    public Elipse (int x, int y, int r1, int r2, Color cor)
    {
        super (cor);

        this.centro = new Ponto (x,y);

        this.raio1  = r1;
        this.raio2  = r2;
    }

    public Elipse (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   r1  = Integer.parseInt(quebrador.nextToken());
        int   r2  = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B

        this.centro = new Ponto (x,y,cor);
        this.raio1  = r1;
        this.raio2  = r2;
        this.corContorno    = cor;
    }

    public void setCentro (int x, int y)
    {
        this.centro = new Ponto (x,y,this.getCorContorno());
    }

    public void setRaio1 (int r1)
    {
        this.raio1 = r1;
    }

    public void setRaio2 (int r2)
    {
        this.raio2 = r2;
    }

    public Ponto getCentro ()
    {
        return this.centro;
    }

    public int getRaio1 ()
    {
        return this.raio1;
    }

    public int getRaio2 ()
    {
        return this.raio2;
    }

    public void torneSeVisivel (Graphics g)
    {
        g.setColor (this.corContorno);
        g.drawOval (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
			
    }

    public String toString()
    {
        return "e:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raio1 +
               ":" +
               this.raio2 +
               ":" +
               this.getCorContorno().getRed() +
               ":" +
               this.getCorContorno().getGreen() +
               ":" +
               this.getCorContorno().getBlue();
    }
    
    public int hashCode()
    {
    	int resultado =1;
    	
    	resultado = resultado*7+this.raio1;
    	resultado = resultado*7+this.raio2;
    	resultado = resultado*7+this.centro.getX();
    	resultado = resultado*7+this.centro.getY();
    	resultado = resultado*7+this.corContorno.getBlue();
    	resultado = resultado*7+this.corContorno.getGreen();
    	resultado = resultado*7+this.corContorno.getRed();
    	
    	return resultado;
    }
    
    public boolean equals(Object obj)
    {
    	if(this==obj)
    		return true;
    	if(obj==this)
    		return false;
    	
    	if(obj instanceof Elipse)
    	{
    		Elipse elip = (Elipse)obj;
    		
    		if(elip.raio1  == this.raio1  &&
    		   elip.raio2  == this.raio2  &&
    		   elip.centro == this.centro &&
    		   elip.corContorno    == this.corContorno)
    		   return true;
    			
    	}
    	return false;
    }
    
    public int compareTo (Elipse e)
    {
        if (this.centro.getX()<e.centro.getX())
             return -7;

        if (this.centro.getY()<e.centro.getY())
            return -7;

        if (this.raio1<e.raio1)
            return -7;
        
        if (this.raio2<e.raio2)
            return -7;
        
        if (this.corContorno.getRed()<e.corContorno.getRed())
            return -7;
       
       if (this.corContorno.getGreen()<e.corContorno.getGreen())
           return -7;
       
       if (this.corContorno.getBlue()<e.corContorno.getBlue())
           return -7;
        
        if (this.centro.getX()>e.centro.getX())
            return 7;

        if (this.centro.getY()>e.centro.getY())
           return 7;
        
        if (this.raio1>e.raio1)
            return 7;
        
        if (this.raio2>e.raio2)
            return 7;

        if (this.corContorno.getRed()>e.corContorno.getRed())
             return 7;
        
        if (this.corContorno.getGreen()>e.corContorno.getGreen())
            return 7;
        
        if (this.corContorno.getBlue()>e.corContorno.getBlue())
            return 7;
        
        return 0;
    }
    
    public Object clone ()
    {
        Elipse e = null;

        try
        {
            e = new Elipse (this.centro.getX(),this.centro.getY(),this.raio1, this.raio2,this.corContorno);
        }
        catch (Exception erro)
        {}

        return e;
    }
    
    public Elipse (Elipse modelo)
    {
    	this (modelo.getCentro().getX(), modelo.getCentro().getY(), modelo.raio1, modelo.raio2,modelo.corContorno);
    }
    
}