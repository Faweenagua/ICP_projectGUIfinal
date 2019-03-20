package sample;

import java.util.*;

/**
 * This class holds information about all observatories
 * @author Eugenia Mawuenya AKPO
 * @author Michael Dankwah AGYEMAN-PREMPEH
 * @author Issifu ALHASSAN
 * @author Francis AWEEENAGUA
 * @version 1.0.0
 */
public class Monitoring {
    public static ArrayList<Observatory> observatories = new ArrayList<Observatory>();
    /**
     * The default Constructor
     */
    public Monitoring(){}
    /**
     * getObservatoryWithLargestAverage takes no parameters and returns the largest average recorded amongst the observatories
     * @return observatory
     */
    private static ArrayList<Double> largestAverage=new ArrayList<Double>();
    private static double highest=0;
    private static Observatory observatory;
    public static Observatory getObservatoryWithLargestAverage(){
        for(Observatory i: observatories) {
            largestAverage.add(i.averageGalamseyColourValueRecorded());
            for(int j=0;j< largestAverage.size();j++) {if(largestAverage.get(j)>highest) {
                highest = largestAverage.get(j);
            }
                if(i.averageGalamseyColourValueRecorded()==highest) { observatory = i;}
            }
        }
        //System.out.println(observatory);
        return observatory;
    }
    /**
     * getLargestGalamseyColourValueEverRecorded is a method that returns the largest Galamsey colour value ever recorded
     * @return largestGalamseyColourValue
     */
    private static   ArrayList<Integer> list= new ArrayList<Integer>();
    private static   int largestGalamseyColourValue=0;
    public static int getLargestGalamseyColourValueEverRecorded(){
        for(Observatory i:observatories) {
            list.add(i.largestGalamseyColourValueRecorded());
            for (int j=0;j<list.size();j++) {
                if(list.get(j) > largestGalamseyColourValue) {
                    largestGalamseyColourValue=list.get(j);
                }
            }
        }
        //System.out.println(largestGalamseyColourValue);
        return largestGalamseyColourValue;
    }
    /**
     * This method returns a list of all Galamsey whose vegetation colour value is greater than some arbitrary constant
     * @param number is the arbitrary constant
     * @return List containing Galamsey events with coulour values less than "number"
     */
    public static ArrayList<Galamsey> ListOfGalamseysWithColourValueGreaterThan(double number) {
        ArrayList<Galamsey> List=new ArrayList<Galamsey>();
        for(Observatory i: observatories) {
            List.addAll(i.galamseysWithColourValueGreaterThan(number));
        }
        //System.out.println(List);
        return List;
    }

    /**
     * This method returns a list of all Galamsey whose vegetation colour value is less than some arbitrary constant
     * @param number is the arbitrary constant
     * @return List containing Galamsey events with coulour values less than "number"
     */

    public static ArrayList<Galamsey> ListOfGalamseysWithColourValueLessThan(double number) {
        ArrayList<Galamsey> List=new ArrayList<Galamsey>();
        for(Observatory i: observatories) {
            List.addAll(i.galamseysWithColourValueLesserThan(number));
        }
        //System.out.println(List);
        return List;
    }

    /**
     * This method returns a list of all Galamsey whose vegetation colour value is equal to some arbitrary constant
     * @param number is the arbitrary constant
     * @return List containing Galamsey events with coulour values equal to "number"
     */

    public static ArrayList<Galamsey> ListOfGalamseysWithColourValueEqualTo(double number) {
        ArrayList<Galamsey> List=new ArrayList<Galamsey>();
        for(Observatory i: observatories) {
            List.addAll(i.galamseysWithColourValueEqualTo(number));
        }
        //System.out.println(List);
        return List;
    }
    /**
     * Checks the Observatory list for any observatory with a specified name.
     * @param nameOfObservatory a string of the name of observatory you want to check.
     * @return returns true if name is in observatory list, and false if not.
     */
    public static boolean checkObservatoryList(String nameOfObservatory){
        boolean isItEqual = false;
        for(Observatory anObservatory : observatories){
            if(anObservatory.getName().equals(nameOfObservatory)){
                isItEqual = true;
                break;
            }
        }
        return isItEqual;
    }
    public static Observatory getObservatoryWithLargestArea(){
        ArrayList<Double> largestArea=new ArrayList<Double>();
        double Area=0;
        Observatory observatory1 = null;
        for(Observatory i: observatories) {
            largestArea.add(i.getAreaInSquareMeters());
            for(int j=0;j< largestArea.size();j++) {if(largestArea.get(j)>Area) {
                Area = largestArea.get(j);}
                if(i.getAreaInSquareMeters()==Area) {observatory1 = i;}
            }
        }
        System.out.println("Area is "+Area);
        System.out.println("The observatory with the largest Area is "+observatory1);
        return observatory1;
    }

    public static Observatory getObservatoryWithLargestNumberOfEvents() {
        if (observatories.isEmpty()) {
            return null;
        }
        Observatory obs = null;
        int curLarge = 0;
        for (Observatory i : observatories) {
            if (i.getEvents().size() > curLarge) {
                obs = i;
            }
        }

        return obs;
    }

    /**
     * Operations are executed in the main method
     * @param args
     */
    public static void main(String[] args) {
        Monitoring monitor =new Monitoring();
        Galamsey g = new Galamsey ("brown",3);
        Galamsey q = new Galamsey ("brown",3);
        Galamsey r = new Galamsey ("yellow",2);
        Galamsey y = new Galamsey ("green",1);
        Galamsey u = new Galamsey ("green",1);
        Galamsey p = new Galamsey ("brown",3);
        Galamsey a = new Galamsey ("green",1);
        Galamsey s = new Galamsey ("yellow",2);
        Galamsey d = new Galamsey ("green",1);
        Galamsey h = new Galamsey ("brown",3);
        ArrayList<Galamsey> events =new ArrayList<Galamsey>();
        ArrayList<Galamsey> event =new ArrayList<Galamsey>();
        events.add(g);
        events.add(q);
        events.add(r);
        event.add(y);
        events.add(u);
        event.add(p);
        events.add(a);
        event.add(s);
        events.add(d);
        event.add(h);
        Observatory e = new Observatory("force","Ghana",2000, 50000,events);
        Observatory t = new Observatory("force2","Togo",3000, 100000,event);
        monitor.observatories.add(e);
        monitor.observatories.add(t);
        monitor.getObservatoryWithLargestAverage();
        monitor.getLargestGalamseyColourValueEverRecorded();
        monitor.ListOfGalamseysWithColourValueGreaterThan(0);
    }
}
