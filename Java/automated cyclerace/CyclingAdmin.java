import java.util.*;
import java.io.*;
import ou.*;
/**
 * Class CyclingAdmin - carries out administrative tasks for a cycling race.
 * 
 * @author Simon Malpas
 * @version 29042021
 */
public class CyclingAdmin
{
  
   /* instance variables */
   private List<Cyclist> cyclists;
   /* static variables */
   public static final int MIN_RACE_TIME = 6000;   //the minimum time to
            //complete the race in tenths of a second (i.e. 10 mins)
   
   /**
    * Constructor for objects of class CyclingAdmin
    */
   public CyclingAdmin()
   {
      super();
      cyclists = new ArrayList<>();
   }
   
   /**
    * Clears the cyclists list.
    */   
   public void clear()
   {
       this.cyclists.clear();
   }
   
   /**
    * Replaces all cyclists currently stored in memory, and populates from 
    * selected file. Text file is in the form of csv with each 
    * entry on a new line.
    */
   public void readInCyclists()
   {
      this.clear();
      String pathname = OUFileChooser.getFilename();
      File aFile = new File(pathname);
      BufferedReader bufferedFileReader = null;
      try
      {
         String aName;
         String aRaceCat;
         Scanner aScanner;
         bufferedFileReader = new BufferedReader(new FileReader(aFile));
         String currentLine = bufferedFileReader.readLine();
         while (currentLine != null)
         {
            aScanner = new Scanner(currentLine);
            aScanner.useDelimiter(",");
            aName = aScanner.next();
            // use helper method to get race category.
            aRaceCat = this.getRaceCat(aScanner.nextInt());
            Cyclist aCyclist = new Cyclist(aName, aRaceCat);
            cyclists.add(aCyclist);
            currentLine = bufferedFileReader.readLine();
         }
      }
      catch (Exception anException)
      {
         System.out.println("Error: " + anException);
      }
      finally
      {
         try
         {
            bufferedFileReader.close();
         }
         catch (Exception anException)
         {
            System.out.println("Error: " + anException);
         }
      }
   }
   
   /**
    * Helper method for readInCyclists()
    * @param (int) age of cyclist
    */
   private String getRaceCat(int age)
   {
      if (age < 18)
      {
         return "Junior";
      }
      else if (age < 40)
      {
         return "Adult";
      }
      return "Veteran";
   }
   
   /**
    * Assigns a random number between 6000 and 12000 inclusive
    * to each cyclist as their race time.
    */
   public void rideRace()
   {
      Random generator = new Random();
      for (Cyclist eachCyclist : cyclists)
      {
         eachCyclist.setTime(generator.nextInt(MIN_RACE_TIME + 1) + MIN_RACE_TIME);
      }
   }
   
   /**
    * Displays the results of the race, fastest first.
    */
   public void displayResults()
   {
      List<Cyclist> results = new ArrayList<>(cyclists);
      Collections.sort(results);
      for (Cyclist eachCyclist : results)
      {
         System.out.println(eachCyclist.toString());
      }
   }
}

