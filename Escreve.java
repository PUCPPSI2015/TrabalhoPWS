import java.awt.*;
import java.util.*;

public class Escreve extends Figura
{
	protected Ponto p1;
    

	protected String c;
    protected Font fonte;
    

    public Escreve (int x, int y, String c, Font f)
    {
        super ();

        this.p1 = new Ponto (x,y);
        this.c = c;
        this.fonte = f;
    }
	  
    public Escreve (int x, int y, String c, Font f, Color cor)
    {
        super (cor);
        this.p1 = new Ponto (x,y);
        this.c = c;
        this.fonte = f;
    }

    public Escreve (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int x = Integer.parseInt(quebrador.nextToken());

        int y = Integer.parseInt(quebrador.nextToken());
        this.c = quebrador.nextToken().toString();
        
        String family = quebrador.nextToken();
        int style = Integer.parseInt(quebrador.nextToken());
        int size =  Integer.parseInt(quebrador.nextToken());
        
        
        this.p1 = new Ponto (x,y);
        this.corContorno = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                              		  Integer.parseInt(quebrador.nextToken()),  // G
                                      Integer.parseInt(quebrador.nextToken())); // B
        
        this.fonte = new Font(family, style, size);
    }

    public void setP1(Ponto p1) {
		this.p1 = p1;
	}
    public void setText (String c){
    	this.c = c;
    }
    
    public void setFont (Font f){
    	this.fonte = f;
    }
	  
    public Ponto getP1 ()
    {
        return this.p1;
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
    	g.setColor(this.corContorno); 
        g.drawString(this.c, this.p1.getX(), this.p1.getY());
    }

    public String toString()
    {
    	System.out.println( this.getCorContorno().getRed());
        return "s:" +
        		this.p1.getX() +
               ":" +
               this.p1.getY() +
               ":" +
               this.c +
               ":" +
               this.fonte.getFamily() +
               ":" +
               this.fonte.getStyle() +
               ":" +
               this.fonte.getSize() +
               ":" +
               this.getCorContorno().getRed() +
               ":" +
               this.getCorContorno().getGreen() +
               ":" +
               this.getCorContorno().getBlue();
    }
    
    public String toSvg()
    {
        return  "";
    }
    
    public int hashCode()
    {
    	int resultado=1;
    	
    	resultado = resultado*7 + Integer.parseInt(this.c);
    	resultado = resultado*7 + this.fonte.hashCode();
    	resultado = resultado*7 + this.corContorno.getRed();
    	resultado = resultado*7 + this.corContorno.getGreen();
    	resultado = resultado*7 + this.corContorno.getBlue();
    	
    	return resultado;
    	 	
    }
    
    /* public boolean equals(Object obj)
    {
    	if (this==obj){
    		return true;
    	}
    	if (obj==null){
    		return false;
    	}
    	if (obj instanceof Escreve){
    		Escreve po = (Escreve)obj;
    		
    		//if(po.x                     == this.x                     && 
    		  // po.y                     == this.y                     &&
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
    } */
    
    /*
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
    }*/
}
