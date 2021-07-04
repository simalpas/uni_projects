This project contains an example of composition. 

=========================================================================

The classes Car and Engine are related to one another by composition: 
a A Car has-an Engine.

==========================================================================

Test statements:

Engine m198 = new Engine(2996, 179);
Car merc = new Car("Mercedes-Benz", "300 SL", 1957, 1500, m198);
merc.toString();

merc.powerWeightRatio();

merc.getTaxPerYear();

m198.setPeakPower(750);
merc.setYearOfRegistration(2000);
merc.toString();

merc.powerWeightRatio();

merc.getTaxPerYear();





