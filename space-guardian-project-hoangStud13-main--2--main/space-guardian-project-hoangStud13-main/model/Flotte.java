package model;

import java.util.Scanner;

import app.SpacePatrolApp;
import app.SpacePatrolGame;

public class Flotte 
{
    private SpaceShip[] flottenArray = new SpaceShip[5];
    private static int anzahlRaumschiffe = 0;
    private static int flottenArrayLaenge = 4;
    private SpacePatrolGame meinGame = new SpacePatrolGame();

    /**
     * Konstruktor für die Klasse Flotte, soll 3 Standard Raumschiffe anlegen
     */
    public Flotte()
    {
        Superpower superpower1 = new Superpower("Wookiee-Lachsalven","Dieses Raumschiff feuert spezielle Lachraketen ab, die nicht nur Schaden anrichten, sondern auch ein wütendes, aber herzhaftes Wookiee-Gelächter auslösen.");
        Superpower superpower2 = new Superpower("Adlerauge-Hypersicht","Das Millennium Adler navigiert durch Dimensionen mit dem Adlerauge-Hypersicht-System, eine unschätzbare Fähigkeit für strategische Schlachten und gefährliche Missionen.");
        Superpower superpower3 = new Superpower("Darth Baggers Bagger","Darth Baggers Bagger baggert seine Gegner weg");

        SpaceShip spaceship1 = new SpaceShip("Chewbacca's Chortle-Cruiser",superpower1);
        SpaceShip spaceship2 = new SpaceShip("Millenium Adler",superpower2);
        SpaceShip spaceship3 = new SpaceShip("Millenium Bagger",superpower3);

        schiffHinzufuegen(spaceship1);
        schiffHinzufuegen(spaceship2);
        schiffHinzufuegen(spaceship3);

    }

 


    /**
     * Diese Methode fügt ein Raumschiff in das flottenArray hinzu
     * Iteriert durch das Array, wenn flottenArray[i]==null ist, bedeutet es
     * das der Index frei ist, an der Stelle soll das Raumschiff hinzugefügt werden
     * @param spaceship Raumschiffobjekt das hinzugefügt werden soll
     */
    public void schiffHinzufuegen(SpaceShip spaceship)
    {
        boolean freierPlatzGefunden = false;
        for(int i = 0; i<flottenArray.length;i++)
        {
            
            if (flottenArray[i] == null)
            {
                flottenArray[i] = spaceship;
                anzahlRaumschiffe++;
                freierPlatzGefunden = true;
                i = 5; // Bricht Schleife ab, da sonst das Raumschiff in jedes Slot hinzugefügt wird
            }
            
        }
        if(freierPlatzGefunden == false)
        {
            System.out.println("Kein freier Platz im Hangar. Entferne ein Raumschiff, um ein neues anzulegen!");
        }
    }

     /**
      * Methode soll ein Raumschiff an Index i zurückgeben
      * @param i index, des Raumschiffes das zurückgegeben werden soll
      * @return Ein SpaceShip Objekt wird zurückgegeben oder ein null
      */
     public SpaceShip getShipAtIndex(int i) 
     {
        return flottenArray[i];
     }


     /** Soll die Daten eines Raumschiffes auf der Konsole ausgeben
     * @param i Auf der Konsole hat man die Möglichkeit ein Raumschiff anhand ihrer zugewiesenen Zahl auszuwählen,
     * i ist die Zahl die eingegeben wurde und der Index wo sich das 
     * Raumschiff im Array befindet
     */
    public void zeigeDaten(int i)
     {
        System.out.println(
            "SPACE PATROL APP 1.0 " + "\n"+
            ""+flottenArray[i].getName() +"\n"+
            "Lebenspunkte: "+ flottenArray[i].getHealtPointsCurrent() +"\n"+ 
            "Erfahrungspunkte: " + flottenArray[i].getExperiencePoints()+"\n"+
            "Superkraft: "+ flottenArray[i].getSuperpower().getName()+"\n"+
            "Kampfbereitschaft: " +flottenArray[i].isReadyToFight()+"\n"+
            "Lebensstatus: "+ flottenArray[i].isAlive()
        );
     }
   


    /**

    Entfernt das Raumschiff an der angegebenen Indexposition aus der Flotte.
    @param i Der Index der zu entfernenden Raumschiffsposition.
    */ 
    public void löcheRaumschiff(int i) {
        if (i >= 0 && i < flottenArray.length && flottenArray[i] != null) {
            flottenArray[i] = null;
            anzahlRaumschiffe--;
        }
            
    
    }


     



    public void patrouillieren()
    {
        
        System.out.println("SPACE PATROL 1.0");
       if ((Math.random()*101) < 91) // Wahrscheinlichkeit auf Raumschiff Kontakt
       {
        System.out.println("Ein Raumschiff wurde gesichtet!");

            if((Math.random()*101) < 61) // Prüft ob freundliches oder feindliches Raumschiff
            {
          
                System.out.println("Es ist ein feindliches Raumschiff!" );
                meinGame.fightSequence(flottenArray);
            }
            else
            {
                System.out.println("Freundliches Raumschiff entdeckt, keine Sorge Captain");
            }
       }
       else
       {
        System.out.println("Kein Raumschiff gesichtet!");
       }


    
    }

    /**
     * Setzt ein Raumschiff in der Flotte auf null
     * @param i, index des Schiffes in der Flotte
     */
    public void setFlottenArrayAtIndexToNull(int i)
    {
        flottenArray[i] = null;
    }

    /**
     * Gibt einem Flottenarray ein neues Schiff an Stelle i
     * @param i Stelle wo das Schiff hin soll
     * @param ship das Schiffobjekt
     */
    
    public void setFlottenArray(int i, SpaceShip ship)
    {
flottenArray[i] = ship;
    }

    // Getter und Setter
   //--------------------------------------------------------------

    public SpaceShip[] getFlottenArray() {
        return flottenArray;
    }


    public void setFlottenArray(SpaceShip[] flottenArray) {
        this.flottenArray = flottenArray;
    }


    public static int getAnzahlRaumschiffe() {
        return anzahlRaumschiffe;
    }


    public static void setAnzahlRaumschiffe(int anzahlRaumschiffe) {
        Flotte.anzahlRaumschiffe = anzahlRaumschiffe;
    }


    public static int getFlottenArrayLaenge() {
        return flottenArrayLaenge;
    }


    public static void setFlottenArrayLaenge(int flottenArrayLaenge) {
        Flotte.flottenArrayLaenge = flottenArrayLaenge;
    }
    


}
