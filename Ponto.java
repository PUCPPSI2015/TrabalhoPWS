import java.awt.*;
import java.util.*;

public class Ponto extends Figura
{
    protected int x,  y;

    public Ponto (int x, int y)
    {
        super ();

  	this.x = x;
        this.y = y;
    }
	  
    public Ponto (int x, int y, Color cor, Color corI)
    {
        super (cor,corI);

  	    this.x = x;
        this.y = y;
    }

    public Ponto (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        this.x = Integer.parseInt(quebrador.nextToken());
        this.y = Integer.parseInt(quebrador.nextToken());

        this.corContorno = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                              Integer.parseInt(quebrador.nextToken()),  // G
                              Integer.parseInt(quebrador.nextToken())); // B
    }

    public void setX (int x)
    {
        this.x = x;
    }
	  
    public void setY (int y)
    {
        this.y = y;
    }
	  
    public int getX ()
    {
        return this.x;
    }
	  
    public int getY ()
    {
    	return this.y;
    }
	  
    public void torneSeVisivel (Graphics g, Graphics l)
    {
    	g.setColor (this.corContorno);
    	g.drawLine (this.x,this.y,this.x,this.y);
    }

    public String toString()
    {
        return "p:" +
               this.x +
               ":" +
               this.y +
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
    
    public String toSvg()
    {
        return "<line " +
               "x1='" + this.x + "' " +
               "y1='" + this.y + "' " +
               "x2='" + this.x + "' " +
               "y2='" + this.y + "' " +
               "style='fill: rgb(" + this.getCorInterior().getRed() +
               "," + this.getCorContorno().getGreen() +
               "," + this.getCorContorno().getBlue() +
               "); stroke: rgb(" + this.getCorContorno().getRed() +
               "," + this.getCorContorno().getGreen() +
               "," + this.getCorContorno().getBlue() +
               ");'" + "/>";
 
    }
    
    public int hashCode()
    {
    	int resultado=1;
    	resultado = resultado*7 + this.x;
    	resultado = resultado*7 + this.y;
    	resultado = resultado*7 + this.corContorno.getRed();
    	resultado = resultado*7 + this.corContorno.getGreen();
    	resultado = resultado*7 + this.corContorno.getBlue();
    	
    	return resultado;
    	 	
    }
    
    public boolean equals(Object obj)
    {
    	if (this==obj){
    		return true;
    	}
    	if (obj==null){
    		return false;
    	}
    	if (obj instanceof Ponto){
    		Ponto po = (Ponto)obj;
    		
    		if(po.x                     == this.x                     && 
    		   po.y                     == this.y                     &&
    		   po.corContorno.getRed()  == this.corContorno.getRed()  &&
    		   po.corContorno.getBlue() == this.corContorno.getBlue() &&
    		   po.corContorno.getRed()  == this.corContorno.getRed())
    		{
    			return true;    			
    		}
    	}
    	return false;
    }
    
    public int compareTo (Ponto p)
    {
        if (this.getX()<p.getX())
             return -7;

        if (this.getY()<p.getY())
            return -7;
        
        if (this.corContorno.getRed()<p.corContorno.getRed())
            return -7;
       
        if (this.corContorno.getGreen()<p.corContorno.getGreen())
           return -7;
       
        if (this.corContorno.getBlue()<p.corContorno.getBlue())
           return -7;
        
        if (this.getX()>p.getX())
            return 7;

        if (this.getY()>p.getY())
           return 7;

        if (this.corContorno.getRed()>p.corContorno.getRed())
             return 7;
        
        if (this.corContorno.getGreen()>p.corContorno.getGreen())
            return 7;
        
        if (this.corContorno.getBlue()>p.corContorno.getBlue())
            return 7;
        
        return 0;
    }
    
    public Object clone ()
    {
        Ponto p = null;

        try
        {
            p = new Ponto (this.getX(),this.getY(),this.corContorno,this.corInterior);
        }
        catch (Exception erro)
        {}

        return p;
    }
    
    public Ponto (Ponto modelo)
    {
    	this (modelo.getX(), modelo.getY(), modelo.corContorno,modelo.corInterior);
    }
}