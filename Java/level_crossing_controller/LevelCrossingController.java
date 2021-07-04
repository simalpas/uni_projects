import ou.*;
/**
 * LevelCrossingController for TMA03Q1.
 * 
 * @author Simon Malpas
 * @version 070421
 */
public class LevelCrossingController
{  
   // Declare Constants
   public static final int MIN_REPEATS = 4;
   // instance variables
   
   private Light topLeft;
   private Light topRight;
   private Light bottom;
   private boolean trainComing;
   private int state; //the state of the level crossing lights (0<=x<=3).
   
   /**
    * Constructor, takes 3 lights as arguments, sets the positions using a
    * built in method, initialises the state as 0, and trainComing as
    * false.
    * @param aTopLeft a Light
    * @param aTopRight a Light
    * @param aBottom a Light
    */
   public LevelCrossingController(Light aTopLeft, 
                                  Light aTopRight, 
                                  Light aBottom)
   {
      this.topLeft = aTopLeft;
      this.topRight = aTopRight;
      this.bottom = aBottom;
      setPositions();
      this.state = 0;
      this.trainComing = false;
      colourAllLights();
   }
   
   /**
    * @return trainComing
    */
   public boolean getTrainComing()
   {
       return trainComing;
   }

   /**
    * @param trainComing
    * setter for trainComing
    */
   public void setTrainComing(boolean trainComing)
   {
       this.trainComing = trainComing;
   }
      
   /**
    * Sets the positions of the lights.
    */
   private void setPositions() 
   {
      this.bottom.setXPos(100);
      this.bottom.setYPos(200);      
      this.topLeft.setXPos(0);
      this.topLeft.setYPos(100);      
      this.topRight.setXPos(200);
      this.topRight.setYPos(100);
   }   
  
   /**
    * Find out how many times red lights should flash at the crossing.
    * Simulates length of train at crossing.
    * @return repeats
    * 
    *  'The method should ask the user to enter the number of times the 
    *  red lights should flash, until a valid input is received, and 
    *  then return this number.'
    *  As the spec is unclear, the method will loop until a valid input 
    *  is received, even if an exception is thrown, or cancel is pressed.
    */   
    public static int findNumRepeats()
    {
       int repeats = 0;
       boolean again = true;
       while(again)
       {
          try
          {
             String timesAsString =              
                  OUDialog.request(
                       "How many times should the red lights"
                     + " flash? ("
                     + LevelCrossingController.MIN_REPEATS
                     + " or more times)");
             // not necessary to check for null as will throw an exception
             // which will be caught, then the while loop can execute again.
             if (timesAsString != null)
             {
                repeats = Integer.parseInt(timesAsString);
             }
             // Prefered over nested if statements as gives a meaningful
             // response if 'cancel' is clicked.
             if (repeats >= LevelCrossingController.MIN_REPEATS)
             {
                again = false; // return repeats; would also work here
             }
             else
             {
                OUDialog.alert("Number entered less than minimum ( "
                             + LevelCrossingController.MIN_REPEATS
                             + " ).");
             }
          }
          // will catch all possible Exceptions not just 
          // NumberFormatExceptions
          catch(Exception anException) 
          {
             OUDialog.alert("Integer not detected. "
                          + "Please ensure an integer is entered."
                          + "\n(" + anException + ")");
          }       
       }
       return repeats;
   }
    
   /**
    * Causes execution to pause for a number of milliseconds.
    */
    public static void delay(int time)
    {
       try
       {
          Thread.sleep(time); 
       }
       catch (Exception e)
       {
          System.out.println(e);
       } 
    }
    
   /**
    * Sets the colour of the light on the level crossing.
    * @param aLight
    * @param aColour
    */
   public void colourLight(Light aLight, OUColour aColour)
   {
      aLight.setColour(aColour);
   }
   
   /**
    * Cycles the state of the lights according to predetermined order.
    */
   public void changeState()
   {
      if (getTrainComing()){
         if (this.state >= 0 && this.state <= 2)
         {
            this.state += 1;
         }
         else //can only be state == 3
         {
            this.state = 2;
         }
         /*
          * unnecesary as state variable is encapsulated and cannot hold 
          * values outside the range 0->3 unless there is a bug.
         else 
         {
            this.state = 0;
         }*/
      }
      else
      {
         this.state = 0;
      }
   }
   
   /**
    * Uses the value of state to determine the colour of the lights and
    * sets them as such.
    * Turns off (set to black) all lights before colouring the lamp 
    * that is supposed to be lit according to the specification 
    */
   public void colourAllLights()
   {
      /* The following could be used to avoid repeatedly typing the call
       * colourLight().

      Light[] lights = {this.bottom, this.topLeft, this.topRight};
      for (Light eachLight : lights)
      {
         colourLight(eachLight, OUColour.BLACK);
      }
      */
      colourLight(this.topLeft, OUColour.BLACK);
      colourLight(this.topRight, OUColour.BLACK);
      colourLight(this.bottom, OUColour.BLACK);
      if (this.state == 1)
      {
         colourLight(this.bottom, OUColour.ORANGE);
      }
       if (this.state == 2)
      {
         colourLight(this.topLeft, OUColour.RED);
      }
      if (this.state == 3)
      {
         colourLight(this.topRight, OUColour.RED);
      }
   }
   
   /*
    * Helper method for doTrainApproaching()
    * Changes the state to the next in sequence (dependent on
    * train approach status) and updates lights accordingly.
    */   
   private void updateStateAndLights()
   {
      this.changeState();
      this.colourAllLights();
   }
   
   /**
    * Automates a level crossing, asking for input for the number of
    * times to flash the lights. Uses delay() to slow down the action.
    */
   public void doTrainApproaching()
   {
      // Make the level crossing safe
      System.out.println("Train Approaching");
      this.setTrainComing(true);
      LevelCrossingController.delay(800); 
      
      this.updateStateAndLights();
      LevelCrossingController.delay(800);
      
      System.out.println("Barrier lowered");
      
      //Find the number of repeats required
      int numRepeats = LevelCrossingController.findNumRepeats();
      LevelCrossingController.delay(800);
      
      for (int i = 1; i <= numRepeats; i++)
      {
         updateStateAndLights();
         LevelCrossingController.delay(600);
      }
      
      // set trainComing to false and switch off all lights
      this.setTrainComing(false);
      updateStateAndLights();
      LevelCrossingController.delay(800);
      System.out.println("Barrier raised");
   }
}


