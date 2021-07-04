/**
 * TMA02 Q2
 * 
 * Objects of the Car class model real-world cars that have attributes
 * representing manufacturer, model, year of registration, kerb weight (in kg),
 * power to weight ratio (in kW/kg), and the road tax cost in £.
 * In reality most of these instance variables would not have setter methods,
 * however for testing purposes these have been implemented.
 * 
 * Car is an example of a composite class.
 * 
 * An object of the Car class has-an object of the Engine class,
 * which represents the engine in the car.
 *
 * The value of powerWeightRatio is computed and a string is returned.
 * The tax per year is returned by comparing Engine capacity and year of
 * registration.
 * This is an example of state-dependent behaviour.
 * powerWeightRatio or taxPerYear are not represented by an instance variables.
 * 
 * @author Simon Malpas
 * @version 18012021
 */
public class Car
{
   private String manufacturer;
   private String model;
   private int kerbWeight;
   private Engine engine;
   // Would probably make the following 'final' but have left as a
   // variable to allow testing and illustrating the method getTaxPerYear()
   private int yearOfRegistration;


   /**
   * Constructor for objects of class Car. Requires arguments in the order,
   * manufacturer, model, yearOfRegistration, kerbWeight, Engine.
   */
   public Car(String aManufacturer, String aModel, int aYearOfRegistration, 
              int aKerbWeight,  Engine anEngine)
   {
   this.manufacturer = aManufacturer;
   this.model = aModel;
   this.yearOfRegistration = aYearOfRegistration;
   this.kerbWeight = aKerbWeight;
   this.engine = anEngine;
   }
   
   /**
    * Constructor that takes an exiting engine object as argument, and uses defaults for
    * other fields
    */
   public Car(Engine anEngine)
   {
      this( "Manufacturer", "Model", 1900, 0, anEngine);
   }
   
   /**
    * Zero-argument constructor for objects of class Car. Uses default values
    * for car, and call the zero-argument constructor for Class Engine.
    */
   public Car()
   {
   this( "Manufacturer", "Model", 1900, 0, new Engine() );
   }

   /**
    * Setter method for manufacturer variable
    */
   public void setManufacturer(String aManufacturer)
   {
      this.manufacturer = aManufacturer;
   }
   
   /**
   * Getter method for manufacturer variable
   */
   public String getManufacturer()
   {
      return this.manufacturer;
   }
   
   /**
    * Setter method for model variable
    */
   public void setmodel(String aModel)
   {
      this.model = aModel;
   }
   
   /**
   * Getter method for model variable
   */
   public String getModel()
   {
      return this.model;
   }
   
   /**
    * Setter method for yearOfRegistration variable
    */
   public void setYearOfRegistration(int aYearOfRegistration)
   {
      this.yearOfRegistration = aYearOfRegistration;
   }
   
   /**
   * Getter method for yearOfRegistration variable
   */
   public int getYearOfRegistration()
   {
      return this.yearOfRegistration;
   }
   
   /**
    * Setter method for kerbWeight variable
    */
   public void setKerbWeight(int aKerbWeight)
   {
      this.kerbWeight = aKerbWeight;
   }
   
   /**
   * Getter method for kerbWeight variable
   */
   public int getKerbWeight()
   {
      return this.kerbWeight;
   }

   /**
    * Method to calculate the power to weight ratio of the car from the 
    * kerb weight and the peak power of the Engine. Sends a message to the
    * Engine object to obtain the peak power. As the peak power is of type 
    * double the calculation automatically casts the kerb weight to a double 
    * so the value returned is also a double. If kerb weight is zero the 
    * calculation will return NaN as a number divided by zero is undefined. 
    * In this case the method returns an error. Rounding is done by casting 
    * to a string, and returning the first 5 chars. This is sufficient accuracy 
    * for power to weight ratio in cars. Rounding is only done in the case that 
    * the calculated value is more than 5 digits including the decimal point.
    */
   public String powerWeightRatio()
   {
      if (this.getKerbWeight() == 0 )
      {
         return "Error - Kerb Weight is zero, no calculation possible";
      }
      else if (
               String.valueOf
               (
               this.engine.getPeakPower() / this.getKerbWeight() 
                ).length() > 5
               )
      {
         return String.valueOf
                (
                   this.engine.getPeakPower() / this.getKerbWeight()
                 ).substring(0,5) + "kW/kg";
      }
      return String.valueOf
             (
              this.engine.getPeakPower() / this.getKerbWeight()
              ) + "kW/kg";
   }
   
   /**
    * Calculates the vehicle tax payable per annum on the Car, based on the 
    * engine capacity and the year of registration. Note this is not accurate, 
    * but an approximation to illustrate how such a feature may be implemented.
    */
   public String getTaxPerYear()
   {
      if (this.yearOfRegistration <= 1980)
      {
         return "Tax exempt due to age";
      }
      else if (this.engine.getCapacity() >= 3000)
      {
         return "£580";
      }
      else if (this.engine.getCapacity() >= 2500)
      {
         return "£330";
      }
      else if (this.engine.getCapacity() >= 2000)
      {
         return "£265";
      }
      else if (this.engine.getCapacity() >= 1000)
      {
         return "£165";
      }
      else
      {
         return "£0";
      }
   }
      
   /**
    * Method to return the state of the object in a human readable form.
    */
   @Override
   public String toString()
   {
      return "Manufacturer: " + this.manufacturer + ", "
           + "Model: " + this.model  + ", "
           + "Registration Year: " + this.yearOfRegistration + ", "
           + "Kerb Weight: " + this.kerbWeight + "kg, "
           + "Tax per year: " + this.getTaxPerYear() + ", "
           + "Engine " + this.engine;
   }
}
