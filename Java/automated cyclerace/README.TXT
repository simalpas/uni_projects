CyclingAdmin ca = new CyclingAdmin();
ca.readInCyclists();
ca.rideRace();
ca.displayResults();

// OUFileChooser.setPath("C:/GitHub/m250/TMA03/TMA03_Q4_Sol");

// testing toString() and compareTo()
Cyclist c = new Cyclist("joe", "Junior");
Cyclist d = new Cyclist("sam", "Adult");
c.setTime(11999);
d.setTime(7000);
c.toString();
c.compareTo(d);
d.compareTo(c);
