import java.awt.*;
import java.util.*;

public class Escreve extends Figura
{
    protected int x,  y;
    protected String c;
    protected Font fonte;
    

    public Escreve (int x, int y, String c, Font f)
    {
        super ();

  	    this.x = x;
        this.y = y;
        this.c = c;
        this.fonte = f;
    }
	  
    public Escreve (int x, int y, String c, Font f, Color cor)
    {
        super (cor);
  	    this.x = x;
        this.y = y;
        this.c = c;
        this.fonte = f;
    }

    public Escreve (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        this.x = Integer.parseInt(quebrador.nextToken());
        this.y = Integer.parseInt(quebrador.nextToken());
        this.c = quebrador.nextToken();
        this.fonte = Font.getFont(quebrador.nextToken());

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
    public void setText (String c){
    	this.c = c;
    }
    
    public void setFont (Font f){
    	this.fonte = f;
    }
	  
    public int getX ()
    {
        return this.x;
    }
	  
    public int getY ()
    {
    	return this.y;
    }
    public String getText ()
    {
    	return this.c;
    }
    
    public Font getFont (){
    	return this.fonte;
    }
	  
    public void torneSeVisivel (Graphics g, Graphics l)
    {
    	g.setFont(this.fonte); 
        g.drawString(this.c, x, y);; 
    }

    public String toString()
    {
        return "s:" +
               this.x +
               ":" +
               this.y +
               ":" +
               this.c +
               ":" +
               this.fonte +
               ":" +
               this.getCorContorno().getRed() +
               ":" +
               this.getCorContorno().getGreen() +
               ":" +
               this.getCorContorno().getBlue() +
               ":";
    }
    
    public String toSvg()
    {
        return  "";
    }
    
    public int hashCode()
    {
    	int resultado=1;
    	resultado = resultado*7 + this.x;
    	resultado = resultado*7 + this.y;
    	resultado = resultado*7 + Integer.parseInt(this.c);
    	resultado = resultado*7 + this.fonte.hashCode();
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
    	if (obj instanceof Escreve){
    		Escreve po = (Escreve)obj;
    		
    		if(po.x                     == this.x                     && 
    		   po.y                     == this.y                     &&
    		   po.c                     == this.c                     &&
    		   po.fonte                 == this.fonte                 &&
    		   po.corContorno.getRed()  == this.corContorno.getRed()  &&
    		   po.corContorno.getBlue() == this.corContorno.getBlue() &&
    		   po.corContorno.getRed()  == this.corContorno.getRed())
    		{
    			return true;    			
    		}
    	}
    	return false;
    }
    
    public int compareTo (Escreve p)
    {
        if (this.getX()<p.getX())
             return -7;

        if (this.getY()<p.getY())
            return -7;
        
        if (this.c.compareTo(p.c)<0)
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
        
        if (this.c.compareTo(p.c)>0)
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
        Escreve p = null;

        try
        {
            p = new Escreve (this.getX(),this.getY(), this.getText(), this.getFont(), this.corInterior);
        }
        catch (Exception erro)
        {}

        return p;
    }
    
    public Escreve (Escreve modelo)
    {
    	this (modelo.getX(),modelo.getY(), modelo.getText(),modelo.fonte,modelo.corInterior);
    }
}
