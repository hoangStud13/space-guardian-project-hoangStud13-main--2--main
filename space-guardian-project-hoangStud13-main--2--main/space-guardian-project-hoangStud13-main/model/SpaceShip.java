package model;

import java.util.UUID;
/**
 * @author Hoang Nguyen
 * Klasse Spaceship, hat die Methoden attacke, fliehen und regenerieren
 */
public class SpaceShip {
private String id;
private String name;
private int healtPointsMax = 50;
private int healtPointsCurrent = healtPointsMax;
private int experiencePoints = 0;
private Superpower superpower;
private boolean readyToFight = true;
private boolean inFight = false;
private boolean alive = true;
//private String nameZerstört = this.getName()+" (Zerstört)";
//private String nameRegenerieren = this.getName()+" (Regeneriert sich)";

/**
 * 
 * @param name Name des Raumschiffes
 * @param Superpower Ein Objekt der Klasse Superpower wird an den Konstruktor gegeben
 */
public SpaceShip(String name, Superpower superpower)
{
 id = UUID.randomUUID().toString();
 this.name = name;
 this.superpower = superpower;
}


/**
 * die Methode soll den schaden einer attacke simulieren
 * Man kann zwischen 0 und 5 schaden machen, bei kritischen Treffern auch mehr
 * @return je nachdem welche Bedingung zutrifft, wird entweder der normale schaden zurückgegeben oder der schaden * 2
 */
 public int attack()
 {
    double schaden = Math.random()*6;
    if ((Math.random()*100)<(this.experiencePoints*2) || (this.experiencePoints*2)>99)
    {
        return (int)schaden*2;
    }
    else
    {

        return (int)schaden;
    }
 }


/**
 * Methode takeDamage soll einen schaden aufnehmen und von den Lebenspunkten abziehen
 * @param erlittenerSchaden ist der Schaden den die Methode attack zurückgibt
 */

 public void takeDamage(int erlittenerSchaden)
 {
    this.healtPointsCurrent -= erlittenerSchaden;
    if(this.healtPointsCurrent<=0)
    {
        this.alive = false;
        this.readyToFight = false;
    }
 }

/**
 * Methode flee() gibt an ob das Raumschiff während eines Kampfes erfolgreich fliehen konnte
 * die Wahrscheinlichkeit erfolgreich zu fliehen beträgt 80%, in beiden Fällen wird etwas auf der Konsole zurückgegeben 
 */
 public boolean flee()
 {
    if ((Math.random()*100)<=1)
    {
       System.out.println("Raumschiff: "+this.name +" ist erfolgreich geflohen.");
       return true;
    }
    else
    {
         System.out.println("Raumschiff: "+this.name +" hat es nicht geschafft zu fliehen");
         return false;
    }
 }

 /**
 * Methode regenerate() soll ein Raumschiff regenerieren und vom Kampf zurückziehen und ein neues Raumschiff auszuwählen
 */
 public void regenerate()
 {
     System.out.println("Raumschiff: "+this.name +" regeneriert sich");
     this.healtPointsCurrent = this.healtPointsMax;
    
     // Flottenklasse, Auswahl Menü
 }


 /**
  * Soll die einzelnen Daten eines Raumschiffes auf der Konsole anzeigen
  */
public void showShipData()
{
    System.out.println(
    "Raumschiffname: "+ this.name + "\n"+
    "Maximale Lebenspunkte: "+this.healtPointsMax +"\n"+
    "Aktuelle Lebenspunkte: "+this.healtPointsCurrent +"\n"+
    "Erfahrungspunkte: "+experiencePoints +"\n"+
    "Kampfbereitschaft: "+ this.readyToFight +"\n"+
    "Lebensstatus: "+ this.alive
    );
}

/**
 * Zeigt wichtigste Daten von Objekt
 */

 public void showSpaceShip()
 {
    
 }

public void checkLevelAndIncrease()
{
    if (getExperiencePoints()%3 == 0)
    {
        this.setHealtPointsMax(getHealtPointsMax()+1);
    }
}


/**
 * Soll Leben zeigen
 */




//Weiter unten befinden sich für alle Attribute getter und setter Methoden
//------------------------------------------------------------------------------------------
public String getId() {
    return id;
}


public void setId(String id) {
    this.id = id;
}


public String getName() {
    return name;
}


public void setName(String name) {
    this.name = name;
}


public int getHealtPointsMax() {
    return healtPointsMax;
}


public void setHealtPointsMax(int healtPointsMax) {
    this.healtPointsMax = healtPointsMax;
}


public int getHealtPointsCurrent() {
    return healtPointsCurrent;
}


public void setHealtPointsCurrent(int healtPointsCurrent) {
    this.healtPointsCurrent = healtPointsCurrent;
}


public int getExperiencePoints() {
    return experiencePoints;
}


public void setExperiencePoints(int experiencePoints) {
    this.experiencePoints = experiencePoints;
}


public Superpower getSuperpower() {
    return superpower;
}


public void setSuperpower(Superpower superpower) {
    this.superpower = superpower;
}


public boolean isReadyToFight() {
    return readyToFight;
}


public void setReadyToFight(boolean readyToFlight) {
    this.readyToFight = readyToFlight;
}


public boolean isInFight() {
    return inFight;
}


public void setInFight(boolean inFight) {
    this.inFight = inFight;
}


public boolean isAlive() {
    return alive;
}


public void setAlive(boolean alive) {
    this.alive = alive;
}
}


