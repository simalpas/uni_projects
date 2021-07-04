
/**
 * class Fish - is a subclass of Pet
 * TMA02 Q3
 * 
 * @author (M250 module team) 
 * @version (v1.0)
 */
public class Fish extends Pet
                  implements Lovable
{
   private int tankWidth;
   private int tankDepth;
   private int tankHeight;
   private double food;

   /**
    * Constructor for objects of class Fish
    */
   public Fish(String aName, String aDescription)
   {
      super(aName, aDescription);
   }

   public void setTank(int aWidth, int aDepth, int aHeight)
   {
      tankWidth = aWidth;
      tankDepth = aDepth;
      tankHeight = aHeight;
   }
   
   public void stroke()
   {
      System.out.println("Don't stroke your fish");
   }
   
   public boolean canStroke()
   {
      return false;
   }
   
   public void feed()
   {
      food = tankWidth * tankDepth * tankHeight * 0.05; // amount of food for this tank
   }
   
}
