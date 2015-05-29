import java.awt.*;

public abstract class Figura
{
    protected Color corContorno, corInterior;
	  
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
    public abstract void   torneSeVisivel (Graphics g, Graphics l);
    
    
}