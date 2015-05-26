import java.awt.Color;
import java.awt.Graphics;
import java.util.StringTokenizer;


public class Retangulo extends Figura {
	
    protected Ponto p1, p2;
    protected int w, h , lado;
	
    public Retangulo (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
    {
        super();

        this.p1 = new Ponto (x1,y1);
        this.p2 = new Ponto (x2,y2);
    }
	
    public Retangulo (int x1, int y1, int x2, int y2, Color cor, Color corI)
    {
        super(cor,corI);

        this.p1 = new Ponto (x1,y1,cor,corI);
        this.p2 = new Ponto (x2,y2,cor,corI);
        
        this.w = p1.getX() - p2.getX();
        if(this.w < 0) this.w = -this.w;
        this.h = p1.getY() - p2.getY();
        if(this.h < 0) this.h = -this.h;
        if(this.w > this.h) this.lado = this.w;
        else this.lado = this.h;
       
    }

    public Retangulo (String s)
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
        
    }

    public void setP1 (int x, int y)
    {
        this.p1 = new Ponto (x,y,this.getCorContorno(),this.getCorInterior());
    }

    public void setP2 (int x, int y)
    {
        this.w = x;
    }
    public void setP3 (int x, int y)
    {
        this.h = x;
    }


    public Ponto getP1 ()
    {
        return this.p1;
    }

    public int getw()
    {
        return this.w;
    }
    public int geth()
    {
        return this.h;
    }


    public void torneSeVisivel (Graphics g, Graphics l)
    {
        g.setColor(this.corContorno);
        l.setColor(this.corInterior);
        g.drawRect( p1.getX(), p1.getY(),p2.getX()/2, p2.getY());
        l.fillRect( p1.getX(), p1.getY(),p2.getX()/2, p2.getY());
        System.out.println(lado);
       
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
    		if(lin.p1  == this.p1 				   &&
    		   lin.p2  == this.p2 				   &&
    		   lin.corContorno == this.corContorno &&
    		   lin.corInterior == this.corInterior)
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
        
        if (this.corInterior.getRed()<l.corInterior.getRed())
            return -7;
       
        if (this.corInterior.getGreen()<l.corInterior.getGreen())
            return -7;
       
        if (this.corInterior.getBlue()<l.corInterior.getBlue())
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
        
        if (this.corInterior.getRed()<l.corInterior.getRed())
            return 7;
       
        if (this.corInterior.getGreen()<l.corInterior.getGreen())
            return 7;
       
        if (this.corInterior.getBlue()<l.corInterior.getBlue())
            return 7;
        
        return 0;
    }
    
}