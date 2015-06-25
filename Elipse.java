import java.awt.*;
import java.util.*;

public class Elipse extends Figura
{
    protected Ponto canto;

    protected int raio1, raio2;
	
    public Elipse (int x, int y, int r1, int r2)
    {
        super ();

        this.canto = new Ponto (x,y);

        this.raio1  = r1;
        this.raio2  = r2;
    }
	
    public Elipse (int x, int y, int r1, int r2, Color cor, Color corI)
    {
        super (cor, corI);

        this.canto = new Ponto (x,y);

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
        
        Color corI = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                Integer.parseInt(quebrador.nextToken()),  // G
                Integer.parseInt(quebrador.nextToken()),  // B
				Integer.parseInt(quebrador.nextToken())); // A

        this.canto = new Ponto (x,y,cor,corI);
        this.raio1  = r1;
        this.raio2  = r2;
        this.corContorno    = cor;
        this.corInterior    = corI;
    }

    public void setCanto (int x, int y)
    {
        this.canto = new Ponto (x,y,this.getCorContorno(),this.getCorInterior());
    }

    public void setRaio1 (int r1)
    {
        this.raio1 = r1;
    }

    public void setRaio2 (int r2)
    {
        this.raio2 = r2;
    }

    public Ponto getCanto ()
    {
        return this.canto;
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
        l.setColor (this.corInterior);
        l.fillOval (this.canto.getX(), this.canto.getY(), raio1, raio2);
        g.setColor (this.corContorno);
        g.drawOval (this.canto.getX(), this.canto.getY(), raio1, raio2);
        
			
    }

    public String toString()
    {
        return "e:" +
               this.canto.getX() +
               ":" +
               this.canto.getY() +
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
               this.getCorInterior().getBlue() +
        	   ":" +
        	   this.getCorInterior().getAlpha();
    }
    
    public String toSvg()
    {
        return "<ellipse " +
               "cx='" + this.canto.getX() + "' " +
               "cy='" + this.canto.getY() + "' " +
               "rx='" + raio1 + "' " +
               "ry='" + raio2 + "' " +
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
    	
    	resultado = resultado*7+this.raio1;
    	resultado = resultado*7+this.raio2;
    	resultado = resultado*7+this.canto.getX();
    	resultado = resultado*7+this.canto.getY();
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
    		   elip.canto == this.canto &&
    		   elip.corContorno    == this.corContorno)
    		   return true;
    			
    	}
    	return false;
    }
    
    public int compareTo (Elipse e)
    {
        if (this.canto.getX()<e.canto.getX())
             return -7;

        if (this.canto.getY()<e.canto.getY())
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
        
        if (this.canto.getX()>e.canto.getX())
            return 7;

        if (this.canto.getY()>e.canto.getY())
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
            e = new Elipse (this.canto.getX(),this.canto.getY(),this.raio1, this.raio2,this.corContorno,this.corInterior);
        }
        catch (Exception erro)
        {}

        return e;
    }
    
    public Elipse (Elipse modelo)
    {
    	this (modelo.getCanto().getX(), modelo.getCanto().getY(), modelo.raio1, modelo.raio2,modelo.corContorno,modelo.corInterior);
    }
    
}