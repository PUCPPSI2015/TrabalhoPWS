import java.awt.*;

public abstract class Figura
{
    protected Color corContorno, corInterior, cor;
	  
    protected Figura ()
    {
        this.corContorno = Color.black;
        this.corInterior = Color.black;
    }
	  
    protected Figura (Color cor, Color corI)
    {
        this.setCorContorno (cor);
        this.setCorInterior(corI);
    }
    
    protected Figura (Color cor)
    {
        this.setCorContorno(cor);
    }
    
    protected void setCor (Color cor)
    {
        this.corInterior = cor;
    }
	  
    protected void setCorContorno (Color cor)
    {
        this.corContorno = cor;
    }
	  
    protected void setCorInterior (Color cor)
    {
        this.corInterior = cor;
    }
    
    protected Color getCorContorno()
    {
    	return this.corContorno;
    }
    
    protected Color getCorInterior()
    {
    	return this.corInterior;
    }

    public abstract String toString       ();
    public abstract String toSvg          ();
    public abstract void   torneSeVisivel (Graphics g, Graphics l);
    
    
}