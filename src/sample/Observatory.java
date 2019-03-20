package sample;

import java.util.ArrayList;
import java.util.Objects;
/**
 * An Observatory class
 *@author Michael Dankwah AGYEMAN-PREMPEH
 *@author Alhassan ISSIFU
 *@author Francis AWEENAGUA
 *@author Eugenia AKPO
 */
public class Observatory {
    private String name,country;
    private int yearStarted;
    private double areaInSquareKilometers;
    private ArrayList<Galamsey> events=new ArrayList<Galamsey>();
    private Integer numberOfGalamseyEvents = 0;
    /**
     * Default constructor
     */
    public Observatory(){}
    /**
     * Overloaded constructor
     * @param name
     * @param country
     * @param yearStarted
     * @param areaInSquareKilometers
     * @param events
     */
    public Observatory(String name, String country, int yearStarted, double areaInSquareKilometers, ArrayList<Galamsey> events) {
        this.name = name;
        this.country = country;
        this.yearStarted = yearStarted;
        this.areaInSquareKilometers = areaInSquareKilometers;
        this.events = events;
    }
    public Observatory(String name, String country, int yearStarted, double areaInSquareKilometers) {
        this.name = name;
        this.country = country;
        this.yearStarted = yearStarted;
        this.areaInSquareKilometers = areaInSquareKilometers;
    }

    public double getAreaInSquareKilometers() {
        return areaInSquareKilometers;
    }

    public void setAreaInSquareKilometers(double areaInSquareKilometers) {
        this.areaInSquareKilometers = areaInSquareKilometers;
    }

    public Integer getNumberOfGalamseyEvents() {
        return numberOfGalamseyEvents;
    }

    public void setNumberOfGalamseyEvents(Integer numberOfGalamseyEvents) {
        this.numberOfGalamseyEvents = numberOfGalamseyEvents;
    }

    public void addEvent(Galamsey g){
        this.events.add(g);
        numberOfGalamseyEvents += 1;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public int getYearStarted() { return yearStarted; }
    public void setYearStarted(int yearStarted) { this.yearStarted = yearStarted; }
    public double getAreaInSquareMeters() { return areaInSquareKilometers; }
    public void setAreaInSquareMeters(double areaInSquareMeters) { this.areaInSquareKilometers = areaInSquareMeters; }
    public ArrayList<Galamsey> getEvents() { return events; }
    public void setEvents(ArrayList<Galamsey> events) { this.events = events; }
    /**
     * toString method that returns the details of an observatory as a string
     * @return string details of observatory
     */
    @Override
    public String toString() {
        return "Observatory{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", yearStarted=" + yearStarted +
                ", areaInSquareMeters=" + areaInSquareKilometers +
                ", events=" + events +
                '}'; }
    /**
     * equals method to compare observatories
     * @param o the object to compare with main object
     * @return boolean true if equal and false if unequal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Observatory)) return false;
        Observatory that = (Observatory) o;
        return getYearStarted() == that.getYearStarted() &&
                Double.compare(that.getAreaInSquareMeters(), getAreaInSquareMeters()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getEvents(), that.getEvents());  }
    /**
     * hash function
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountry(), getYearStarted(), getAreaInSquareMeters(), getEvents()); }
    /**
     * gets the largest galamsey colour values
     * @return the largest galamsey colour value recorded
     */
    public int largestGalamseyColourValueRecorded(){
        int green=0,yellow=0,brown=0;
        for(Galamsey i : this.getEvents()){
            if(i.getVegetationColourValue()==1){ green+=1; }
            if(i.getVegetationColourValue()==2){ yellow+=1; }
            if(i.getVegetationColourValue()==3){ brown+=1; }
        }
        if(yellow==0 && brown==0 && green==0){return 0;}
        if(brown>=yellow && brown>=green){return 3;}
        if(yellow>=green && yellow>=brown){return 2;}
        if(green>=yellow && green>=brown){return 1;}
        return 0;
    }
    /**
     * gets the average galamsey colour value recorded
     * @return average galamsey colour value recorded
     */
    public double averageGalamseyColourValueRecorded() {
        double sum = 0;
        int count = 0;
        for (Galamsey i : this.getEvents()) {
            sum += i.getVegetationColourValue();
            count += 1;
        }
        return sum / count;
    }
    /**
     * Creates a list of all galamsey recorded at the observatory with a colour value greater than a given number
     * @param number arbitrary number to compare colour values to
     * @return
     */
    public ArrayList<Galamsey> galamseysWithColourValueGreaterThan(double number) {

        ArrayList<Galamsey> list = new ArrayList<Galamsey>();
        for (Galamsey i : this.getEvents()) {
            if (i.getVegetationColourValue() > number) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Creates a list of all galamsey recorded at the observatory with a colour value lesser than a given number
     * @param number arbitrary number to compare colour values to
     * @return
     */
    public ArrayList<Galamsey> galamseysWithColourValueLesserThan(double number) {

        ArrayList<Galamsey> list = new ArrayList<Galamsey>();
        for (Galamsey i : this.getEvents()) {
            if (i.getVegetationColourValue() < number) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Creates a list of all galamsey recorded at the observatory with a colour value equal to a given number
     * @param number arbitrary number to compare colour values to
     * @return
     */
    public ArrayList<Galamsey> galamseysWithColourValueEqualTo(double number) {

        ArrayList<Galamsey> list = new ArrayList<Galamsey>();
        for (Galamsey i : this.getEvents()) {
            if (i.getVegetationColourValue() == number) {
                list.add(i);
            }
        }
        return list;
    }
}