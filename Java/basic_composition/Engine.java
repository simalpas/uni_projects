/**
 * TMA02 Q2
 * 
 * Objects of the Engine class model real-world engines that have attributes
 * representing capacity and peak power (in kW).
 * 
 * In the context of the Car class, Engine is a componant class.
 * 
 * @author Simon Malpas
 * @version 16012021
 */
public class Engine
{
   private int capacity;
   private double peakPower;

   /**
    * Constructor for objects of class Engine, using arguments of capacity in cc
    * and peak power output in kW.
    */
   public Engine(int aCapacity, double aPeakPower)
   {
      this.capacity = aCapacity;
      this.peakPower = aPeakPower;
   }
   
   /**
    * Zero-argument constructor for objects of class Engine using default values
    * for capacity and peak power.
    */
   public Engine()
   {
   this(0, 0.0);
   }
   
      /**
    * Setter method for capacity variable
    */
   public void setCapacity(int aCapacity)
   {
      this.capacity = aCapacity;
   }
   
   /**
   * Getter method for capacity variable
   */
   public int getCapacity()
   {
      return this.capacity;
   }

   /**
    * Setter method for peakPower variable
    */
   public void setPeakPower(double aPeakPower)
   {
      this.peakPower = aPeakPower;
   }
   
   /**
   * Getter method for peakPower variable
   */
   public double getPeakPower()
   {
      return this.peakPower;
   }

   /**
    * Method to return a human readable form of the object.
    */
   @Override
   public String toString()
   {
      return "Capacity: " + this.capacity + "cc, "
           + "Peak Power Output: " + this.peakPower + "kW";
   }
}