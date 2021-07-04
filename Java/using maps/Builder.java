import java.util.*;

/**
 * The class Builder is used to hold data about the builder's 
 * on site  contractors, and their contact details and trade. 
 * 
 * @author Simon Malpas
 * @version 15042021
 */
 public class Builder
 {
   // instance variables 
   private Map<String, Contractor> contractors;
   
   /**
     * Constructor for objects of class Builder
     */
   public Builder()
   {
      super();
      contractors = new HashMap<>();
   }
   
   /**
    * Adds contractors to the map.
    * @param aReg vehicle registration
    * @param aName contractor's name
    * @param anAddress Contractor's address
    * @param aTrade Contractor's trade
    */
   public void addContractor(String aReg, 
                             String aName, 
                             String anAddress, 
                             String aTrade)
   {
      Contractor aContractor = new Contractor(aName, anAddress, aTrade);
      contractors.put(aReg, aContractor);
   }
   
   /**
    * Iterates through the values of the map, printing attributes of
    * the contractor object.
    */
   public void printContractors()
   {
      for (Contractor eachContractor : contractors.values())
      {
         System.out.println(eachContractor.toString());
      }
   }
   
   /**
    * Returns a Contractor found using reg number, if not found alerts
    * user, confirming reg, and returns null
    * @param aReg vehicle registration
    * @return Contractor (or null if not found).
    */
   public Contractor findContractor(String aReg)
   {
      Contractor aContractor = contractors.get(aReg); 
      if (aContractor != null)
       {
          return contractors.get(aReg);
       }
       else
       {
          System.out.println("Contractor with registration: "
                           + aReg
                           + ", not found."
                           );
          return null; // or contractors.get(aReg);
       }
   }
   
   /**
    * Finds contractors according to trade and returns them as an unordered
    * set.
    * @param aTrade string to search for in Contractor trade.
    */
   public Set<Contractor> findContractorsForTrade(String aTrade)
   {
      Set<Contractor> forTrade = new HashSet<>();
      for ( Contractor eachContractor : contractors.values())
      {
         if (eachContractor.getTrade().equals(aTrade))
         {
            forTrade.add(eachContractor);
         }
      }
      /*if (forTrade.size() == 0)
      {
         System.out.println("No contractors found for trade: "
                          + aTrade
                          );
      }*/
      return forTrade;
   }
}
