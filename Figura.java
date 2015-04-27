import java.awt.*;

public abstract class Figura
{
    protected Color corContorno;
	  
    protected Figura ()
    {
        this.corContorno = Color.black;
    }
	  
    protected Figura (Color cor)
    {
        this.setCorContorno (cor);
    }
	  
    protected void setCorContorno (Color cor)
    {
        this.corContorno = cor;
    }
	  
    protected Color getCorContorno()
    {
  	return this.corContorno;
    }

    public abstract String toString       ();	  
    public abstract void   torneSeVisivel (Graphics g);
}