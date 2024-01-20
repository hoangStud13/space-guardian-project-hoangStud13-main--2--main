package app;

import java.util.Scanner;

import model.EnemySpaceShip;
import model.SpaceShip;
import model.Flotte;

public class SpacePatrolGame {
    private int zähler = 0; // Sorgt dafür dass Zeile 35 es genau einmal wiederholt wird
    private SpaceShip raumschiff = null;
    private EnemySpaceShip gegner = new EnemySpaceShip();

    public void fightSequence(SpaceShip[] flotte) {
        boolean kaempfenNoch = true;
        for (int i = 0; kaempfenNoch == true; i++) {
            kampfMenue();
            System.out.print("Was soll gemacht werden? ");

            Scanner scanner = new Scanner(System.in);
            int eingabe = scanner.nextInt();
            System.out.println("==========================");

            switch (eingabe) {
                case 1:

                    if (zähler == 0) {

                        boolean bereit = false;

                        SpacePatrolApp.zeigeRaumschiffFlotte();
                        System.out.print("Welches Raumschiff soll in den Kampf? ");
                        int eingabeSchiff = scanner.nextInt() - 1; // schiff soll ausgewählt werden
                        System.out.println();
                        System.out.println("========================== ");
                        raumschiff = flotte[eingabeSchiff];

                        zähler++;
                    }

                    while (raumschiff.isReadyToFight() == false) {
                        System.out.println("Raumschiff kann nicht verwendet werden (Reparatur oder zerstört worden)");
                        SpacePatrolApp.zeigeRaumschiffFlotte();
                        System.out.print("Welches Raumschiff soll in den Kampf? ");
                        int eingabeSchiff = scanner.nextInt() - 1; // schiff soll ausgewählt werden
                        System.out.println();
                        System.out.println("========================== ");
                        raumschiff = flotte[eingabeSchiff];

                        int anzahlDerNichtKampffähigenSchiffe = 0;
                        for (int j = 0; j < 5; j++) {
                            if (flotte[j] == null || flotte[j].isReadyToFight() == false) {
                                anzahlDerNichtKampffähigenSchiffe++;
                            }
                        }
                        if (anzahlDerNichtKampffähigenSchiffe == 5) {
                            System.out.println(
                                    "Man hat deine zerstörte Flotte im All gefunden und dich zur Basis zurückgebracht. Sei das nächste mal vorsichtiger!");
                            kaempfenNoch = true;
                            SpacePatrolApp.showPatrolMenu();

                        }

                    }

                    if ((raumschiff.isAlive() == true && raumschiff.isReadyToFight() == true)
                            && (gegner.isAlive() == true && gegner.getHealtPointsCurrent() > 0)) {

                        boolean gegnerGeflohen = fight(raumschiff, gegner);
                                if (gegnerGeflohen==true) {
                                    System.out.println("Zurück zur Basis");
                                    kaempfenNoch = false;
                                    break;
                                }
                    } else {
                        if (raumschiff.isAlive() == false && gegner.isAlive() == true) // Falls eigenes Raumschiff tot,
                                                                                       // soll neues Raumschiff
                                                                                       // ausgewählt werden
                        {
                            zähler = 0;
                        } else if (gegner.getHealtPointsCurrent() <= 0) {

                            System.out.println("Gegner vernichtet, wir haben gewonnen! Kehren zur Basis zurück");
                            System.out.println("Wir haben 1 exp bekommen! ");
                            raumschiff.setExperiencePoints(raumschiff.getExperiencePoints() + 1);
                            System.out.println("Du hast aktuell: " + raumschiff.getExperiencePoints()+ " Erfahrungspunkte");
                            raumschiff.checkLevelAndIncrease();
                            kaempfenNoch = false;
                            zähler = 0;
                           
                        }

                    }
                    break;
                    case 2:
                   
                        SpacePatrolApp.zeigeRaumschiffFlotte();
                        System.out.print("Welches Raumschiff soll gesteuert werden? ");
                        int eingabeFluchtRaumschiff = scanner.nextInt()-1;
                        raumschiff = flotte[eingabeFluchtRaumschiff];
                        System.out.println("Wir unternehmen ein Fluchtversuch!");
                        if(raumschiff.flee()==true)
                        {
                            System.out.println("Wir sind erfolgreich geflohen!");
                            kaempfenNoch = false;
                        }
                        else{
                            System.out.println("Wir haben es nicht geschafft zu fliehen!");
                            int gegnerSchaden = gegner.attack();
                            raumschiff.takeDamage(gegnerSchaden);
                            System.out.println("Wir haben vom Gegner "+ gegnerSchaden +" schaden bekommen!");
                        }
                    }
                  
                    
                    

            }
            

        

    }

    public void kampfMenue() {
        System.out.println("(1)    Kämpfen" + "\n" + "(2)    Flucht");

    }

    public static boolean fight(SpaceShip raumschiff, EnemySpaceShip gegner) {
        int gegnerSchaden = gegner.attack();
        int eigenerSchadenAnGegner = raumschiff.attack();
        if (gegnerSchaden==-1)
        {
            return true;
        }
        else{
            if (raumschiff.isAlive() == true && gegner.isAlive() == true) {

                System.out.println("SPACE PATROL 1.0");
    
                System.out.println("Das Raumschiff " + raumschiff.getName() + "  wird gegen den Gegner " + gegner.getName()
                        + " antreten");
    
                raumschiff.takeDamage(gegnerSchaden);
                gegner.takeDamage(eigenerSchadenAnGegner);
    
                System.out.println("Der Gegner greift mit der Superkraft " + gegner.getSuperpower().getName() + " an | -"
                        + gegnerSchaden);
                System.out.println("Wir haben dem Gegner " + eigenerSchadenAnGegner + " schaden mit der Superkraft "
                        + raumschiff.getSuperpower().getName() + " hinzugefügt!");
    
                if (raumschiff.getHealtPointsCurrent() <= 0) {
                    System.out.println("Dein Leben: 0");
                    return false;
                } else {
                    System.out.println("Dein Leben: " + raumschiff.getHealtPointsCurrent());
                    return false;
                }
               
            }
            return false;
        }
       
    }

}