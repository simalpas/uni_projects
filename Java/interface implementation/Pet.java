
/**
 * Class Pet is an abstract class for all pets.
 * 
 * @author (M250 module team) 
 * @version (1.0)
 */
public abstract class Pet
{
   private String name;
   private String description;

   /**
    * Constructor for objects of class Pet
    */
   public Pet(String aName,String aDescription)
   {
      name = aName;
      description = aDescription;
   }

   public void setName(String aName)
   {
      name = aName;
   }
   
  
   public void setDescription(String aDescription)
   {
      description = aDescription;
   }
   
   public String getName()
   {
      return name;
   }
   
  
   public String getDescription()
   {
      return description;
   }

}
