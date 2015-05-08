/*import java.awt.*;
import java.util.*;

public class Triangulo extends Figura
{
    protected Ponto p1,p2,p3;
	
    public Triangulo (int x, int y, int z)
    {
        super ();
    }
	
    public Triangulo (int x, int y, int z, Color cor, Color corI)
    {
        super (cor, corI);
    }

    public Triangulo (String s)
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
        
        Color corI = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken())); // B

        this.centro = new Ponto (x,y,cor,corI);
        this.raio1  = r1;
        this.raio2  = r2;
        this.corContorno    = cor;
    }

    public void setCentro (int x, int y)
    {
        this.centro = new Ponto (x,y,this.getCorContorno(),this.getCorInterior());
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

    public void torneSeVisivel (Graphics g, Graphics l)
    {
        g.setColor (this.corContorno);
        g.drawOval (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
        l.setColor (this.corInterior);
        l.fillOval (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
			
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
            e = new Elipse (this.centro.getX(),this.centro.getY(),this.raio1, this.raio2,this.corContorno,this.corInterior);
        }
        catch (Exception erro)
        {}

        return e;
    }
    
    public Elipse (Elipse modelo)
    {
    	this (modelo.getCentro().getX(), modelo.getCentro().getY(), modelo.raio1, modelo.raio2,modelo.corContorno,modelo.corInterior);
    }
    
}*/