/**
 * TMA02 Q3
 * 
 * @author Simon Malpas 
 * @version 20012021
 */
public class Dog extends Pet
                 implements Lovable
{
   // instance variables
   private int happiness;
   private int energyLevel;
   
   /**
    * Getter method for happiness
    */
   public int getHappiness()
   {
      return this.happiness;
   }

      /**
    * Getter method for energyLevel
    */
   public int getEnergyLevel()
   {
      return this.energyLevel;
   }

   /**
    * 2 argument constructor that initialises inherited instance variables, and
    * assigns the value of 2 to  happiness. Passed arguments in the order:
    * name, description.
    */
    public Dog(String aName, String aDescription)
   {
      super(aName, aDescription);
      this.happiness = 2;
   }
   
   /**
    * Decreases happiness down to a minimum of 0 in steps of 1.
    */
   public void decrementHappiness()
   {
      if ( this.happiness > 0 )
      {
         this.happiness--;
      }
   }
   
   /**
    * Decreases energyLevel down to a minimum of 0 in steps of 1.
    */
   public void decrementEnergyLevel()
   {
      if ( this.energyLevel > 0 )
      {
         this.energyLevel--;
      }
   }
   
   /**
    * Increases happiness in steps of 1, no maximum value.
    */
   public void incrementHappiness()
   {
      this.happiness++;
   }
   
   /**
    * Increases energyLevel in steps of 1, no maximum value.
    */
   public void incrementEnergyLevel()
   {
      this.energyLevel++;
   }
   
   /**
    * Repeatedly (as long as energyLevel is above 0) prints out 
    * "I'm going for a walk!", increases happiness by 1, then prints 
    * out "I'm getting hungry" and decrements energyLevel by 1.
    */
   public void walkies()
   {
      
      while (this.getEnergyLevel() > 0)
      {
         System.out.println("I'm going for a walk!");
         this.incrementHappiness();
         System.out.println("I'm getting hungry");
         this.decrementEnergyLevel();
      }
   }
   
   /**
    * Returns true if happiness is above 0 and energyLevel is above 0. 
    * If happiness is 0 prints out "Not happy, can't sleep" and returns false. 
    * If energyLevel is 0 prints out "Hungry, can't sleep" and return false.
    * If both are 0, prints both statements and returns false.
    */
   public boolean sleep()
   {
      if (this.getHappiness() > 0 && this.getEnergyLevel() >0)
      {
         return true;
      }
      if (this.getHappiness() ==0)
      {
         System.out.println("Not happy, can't sleep");
      }
      if (this.getEnergyLevel() == 0)
      {
         System.out.println("Hungry, can't sleep");
      }
      return false;
   }
   
   /**
    * Prints out "No walkies :-(" and decrements happiness (down to a 
    * minimum of 0). Assumption of question is that the happiness is 
    * only decreased by 1, the helper method already checks to make 
    * sure that happiness can never be decreased below 0.
    */
   public void noWalkies()
   {
      System.out.println("No walkies :-(");
      this.decrementHappiness();
   }
   
   /** 
   * stub for stroke() method, returns no value
   */
   public void stroke()
   {
   }
   
   /** 
    * stub for canStroke() method, returns false
    */
   public boolean canStroke()
   {
     return false;
   }
   
   /** 
    * stub for feed() method, returns no value
    */
   public void feed()
   {
   }
}
