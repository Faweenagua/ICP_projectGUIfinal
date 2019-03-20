package sample;

/**
 *A Galamsey class that identifies or detects Galamsey areas.
 *@author Michael Dankwah AGYEMAN-PREMPEH
 *@author Alhassan ISSIFU
 *@author Francis AWEENGUA
 *@author Eugenia AKPO
 */
public class Galamsey {

    //The instance variables
    private String vegetationColour;
    private int colourValue;
    private double latitude;
    private double longitude;
    private int yearOfEvent;

    /**
     * The default constructor
     */
    public Galamsey() {};


    /**
     * Overloaded constructor 1
     * @param vegCol represents the vegetation colour
     * @param colVal represents the value assigned to a particular vegetation colour
     */
    public Galamsey(String vegCol, int colVal) {
        this.vegetationColour = vegCol;
        this.colourValue = colVal;
    };

    /**
     * Oveloaded constructor 2
     * @param Lat is the latitude of the identified Galamsey area
     * @param Long is the longitude of the identified Galamsey area
     * @param EventYear is the year the Galamsey event took place
     */
    public Galamsey( double Lat, double Long, int EventYear) {
        this.latitude = Lat;
        this.longitude = Long;
        this.yearOfEvent = EventYear;
    }

    /**
     * Overloaded constructor 3
     * @param vegCol represents the vegetation colour
     * @param colVal represents the value assigned to a particular vegetation colour
     * @param Lat is the latitude of the identified Galamsey area
     * @param Long is the longitude of the identified Galamsey area
     * @param EventYear is the year the Galamsey event took place
     */
    public Galamsey(String vegCol, int colVal, double Lat, double Long, int EventYear) {
        this.vegetationColour = vegCol;
        this.colourValue = colVal;
        this.latitude = Lat;
        this.longitude = Long;
        this.yearOfEvent = EventYear;
    };

    /**
     * SETTER/MUTATOR METHODS FOR GALAMSEY CLASS
     */

    /**
     * Mutator method for color of vegetation
     * @param vegCol
     */
    public void setVegetationColour(String vegCol) {
        this.vegetationColour = vegCol;

        if (vegCol.toLowerCase().equals("green")) this.setVegetationColourValue(1);
        if (vegCol.toLowerCase().equals("yellow")) this.setVegetationColourValue(2);
        if (vegCol.toLowerCase().equals("brown")) this.setVegetationColourValue(3);
    }
    /**
     * Mutator method for value of respective vegetation colour
     * @param vegColval
     */
    public void setVegetationColourValue(int vegColval) {
        this.colourValue = vegColval;
    }

    /**
     * Mutator method for latitude of vegetation
     * @param vegLat
     */
    public void setVegetationLatitude(double vegLat) {
        this.latitude = vegLat;
    }

    /**
     * Mutator method for longitude of vegetation
     * @param vegLong
     */
    public void setVegetationLongitude(double vegLong) {
        this.longitude = vegLong;
    }

    /**
     * Mutator method for year of the event
     * @param eventYear
     */
    public void setEventYear(int eventYear) {
        this.yearOfEvent = eventYear;
    }


    /**
     * GETTER/ACCESSOR METHODS FOR GALAMSEY CLASS
     */

    /**
     * Accessor method for colour of vegetation
     * @return vegetationColour
     */
    public String getVegetationColour() {
        return vegetationColour;
    }

    /**
     * Accessor method for value of respective vegetation colour
     * @return colourValue
     */
    public int getVegetationColourValue() {
        return colourValue;
    }

    /**
     * Accessor method for latitude of vegetation
     * @return latitude
     */
    public double getVegetationLatitude() {
        return latitude;
    }

    /**
     * Accessor method for longitude of vegetation
     * @return longitude
     */
    public double getVegetationLongitude() {
        return longitude;
    }

    /**
     * Accessor method for year of Event
     * @return yearOfEvent
     */
    public int getEventYear() {
        return yearOfEvent;
    }


    /**
     * Writing in the Degree Minute Second Format
     * @return the value of the value of both the latitude and longitude in the Degree Minute Seconds Format
     */
    public  String getFormattedLocationOfVegetationLatitudeandLongitude(){
        try {
            int latSeconds = (int) Math.round(this.latitude * 3600);
            int latDegrees = latSeconds / 3600;
            latSeconds = Math.abs(latSeconds % 3600);
            int latMinutes = latSeconds / 60;
            latSeconds %= 60;

            int longSeconds = (int) Math.round(this.longitude * 3600);
            int longDegrees = longSeconds / 3600;
            longSeconds = Math.abs(longSeconds % 3600);
            int longMinutes = longSeconds / 60;
            longSeconds %= 60;

            String latDegree = latDegrees >= 0 ? "N" : "S";
            String lonDegrees = longDegrees >= 0 ? "E" : "W";

            return  Math.abs(latDegrees) + "°" + latMinutes + "'" + latSeconds
                    + "\"" + latDegree +" "+ Math.abs(longDegrees) + "°" + longMinutes
                    + "'" + longSeconds + "\"" + lonDegrees;
        } catch (Exception e) {
            return ""+ String.format("%8.5f", latitude) + "  "
                    + String.format("%8.5f", longitude) ;
        }

    }


    /**
     * AUXILIARY METHOD 1
     * toString method for Galamsey class
     */
    public String toString() {
        return ("The colour of the vegetation is "+ getVegetationColour()+" with an assigned colour value of "
                +getVegetationColourValue()+" with the coordinates, " + getFormattedLocationOfVegetationLatitudeandLongitude() +
                " which happened on in the year " + getEventYear());
    }

    /**
     * AUXILIARY METHOD 2
     * EqualsMethod method for Galamsey class
     */
    public boolean equals(Object otherGalamsey) {

        //Comparing the instance variables/values of Galamsey Objects
        //Using "equals" BUT "==" for primitives (i.e. double,int)

        //Checking if the calling object (i.e. Galamsey object) is at the same memory address
        //as Object "otherGalamsey"
        if(otherGalamsey == this) {return true;}

        //Checking if the Object "otherGalamsey" is null
        if(otherGalamsey == null) {return false;}


        //Checking if Object "otherGalamsey" is a "type" of Galamsey
        if(!(otherGalamsey instanceof Galamsey)) return false;

        return(  this.vegetationColour.equals(((Galamsey)otherGalamsey).vegetationColour) &&
                this.colourValue==(((Galamsey)otherGalamsey).colourValue) &&
                this.latitude==(((Galamsey)otherGalamsey).latitude) &&
                this.longitude==(((Galamsey)otherGalamsey).longitude) &&
                this.yearOfEvent==(((Galamsey)otherGalamsey).yearOfEvent) );
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Instantiation of two Galamsey Classes with their necessary parameter
         */
        Galamsey areaOne = new Galamsey("Blue",2,-3.88,-4.00,2019);
        Galamsey areaTwo = new Galamsey("Green",3,3.78,4.00,2018);

        System.out.println("Area One: " + areaOne.toString());
        System.out.println("\nArea Two: " + areaTwo.toString());

        System.out.println("\nareaOne.equals(areaTwo): " + areaOne.equals(areaTwo));
        System.out.println("\nareaOne.equals(areaOne): " + areaOne.equals(areaOne));


    }



}