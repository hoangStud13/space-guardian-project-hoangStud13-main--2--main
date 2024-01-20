package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import model.Flotte;

import model.SpaceShip;
import model.Superpower;

/**
 * @author Hoang Nguyen
 * @author Arman Momenzadeh
 */
public class SpacePatrolApp {

	private static Scanner scanner = new Scanner(System.in);
	private static Flotte flottenArray = new Flotte();
	private static Flotte regenerierFlotte = new Flotte();
	/**
	 * @param args mainklasse
	 */
	public static void main(String[] args) {



		while (true) {
			showStandardMenu();
			int choice = readUserInput();
			handle(choice);
			System.out.println("====================");
		}
	}

	/**
 * Reads user input for menu selection.
 * @return The user's menu selection.
 */
	private static int readUserInput() {
		System.out.print("\nBitte, geben Sie die Nummer des gewaehlten Menueeintrags ein:\t");
		int choiceInternal = scanner.nextInt();
		System.out.println();

		return choiceInternal;
	}

	/**
	 * Soll die Benutzereingabe aufnehmen und die entsprechenden Methoden aufrufen
	 * @param choice die Benutzereingabe
	 */
	private static void handle(int choice) 
	{
		switch (choice) 
		{
		case 1:
			createSpaceShip();
			break;
		case 2:
		zeigeEinRaumschiff();
			break;
		case 3:
			 zeigeAlleRaumschiffsdaten();
			break;
		case 4:
		Raumschifflöschen();	
			break;
		case 5:
		showPatrolMenu();
			break;
		case 6:
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("MySpaceShipFile.txt"));
			int i = 0;
			while (i<5) {
			//	writer.write(""+flottenArray.getShipAtIndex(i).showShipData());
			i++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.exit(1);
			break;
		default: {
			System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
			showStandardMenu();
		}
			break;

		}
	}

	/**
 * Displays the standard menu options for the space patrol program.
 */
	private static void showStandardMenu() 
	{
		String menuItems[] = 
		{
			 "", "(1)\t Raumschiff anlegen", "(2)\t Daten eines Raumschiffs anzeigen",
				"(3)\t Daten aller Raumschiffe anzeigen", "(4)\t Raumschiff aus der Flotte nehmen" , "(5)\t Patrouillen-Flug starten", 
				"(6)\t Beenden"
		};

		System.out.println("\nSPACE PATROL 1.0\n");
		for (int i = 1; i < menuItems.length; i++) 
		{
			System.out.println(menuItems[i]);
		}
	}


	/**
 * Displays the patrol menu options for the space patrol program.
 */
	public static void showPatrolMenu() 
	{
		System.out.println("\n" +"==========================");
	String menuItems[] = { "SPACE PATROL 1.0", "(1)\t Patrouillieren", "(2)\t Regenerieren",
	"(3)\t Patrouille beenden"};

	for (String string : menuItems) {
	System.out.println(string);
	}


	System.out.print("Was soll gemacht werden? " );
	
	int eingabe = scanner.nextInt();
    System.out.println("\n" +"==========================");
					switch (eingabe) 
		{
		case 1:
		

			flottenArray.patrouillieren();
			showPatrolMenu() ;
			break;
			
		case 2:
		regenerate();
			break;
		case 3:
		showStandardMenu();
			break;
		default: {
			System.out.println("==========================");
			
		}
			break;

		}


			
		
    
	}

/**
 * Methode regeneriert ein Schiff und packt es in die regenerier Flotte
 */
public static void regenerate(){



    /**
     * Fragt den Benutzer nach der Eingabe des Raumschiffs.
     */
    
	zeigeRaumschiffFlotte();
	System.out.println("Wählen Sie ein Raumschiff aus: ");
    int eingabe = scanner.nextInt()-1;
    System.out.println();
	flottenArray.getShipAtIndex(eingabe).setReadyToFight(false);
   flottenArray.getShipAtIndex(eingabe).regenerate();

	regenerierFlotte.setFlottenArray(eingabe,flottenArray.getShipAtIndex(eingabe));
	
  
}




	/**
 * Creates a new spaceship by collecting user input for spaceship details.
 * Asks the user for the spaceship name, superpower name, and superpower description.
 * Creates a new Superpower and SpaceShip object, then adds the spaceship to the fleet.
 */
	private static void createSpaceShip() 
	{

		System.out.println
		("SPACE PATROL 1.0       " + "\n"+
		"Anzahl der Raumschiffe im Hangar (" +flottenArray.getAnzahlRaumschiffe()+"/5)" );
		
		System.out.print(""); // hier tritt ein merkwürdiger Fehler auf
		String s = scanner.nextLine();


		System.out.println("Wähle einen Namen für dein Raumschiff: ");
		String raumschiffNameString = scanner.nextLine();


		System.out.println("Name deiner Superkraft: ");
		String superkraftNameString = scanner.nextLine();

		System.out.println("Beschreibe deine Superkraft: ");
		String superkraftBeschreibungString = scanner.nextLine();

		Superpower superpower = new Superpower(superkraftNameString,  superkraftBeschreibungString);
		SpaceShip spaceShip = new SpaceShip(raumschiffNameString,superpower);
		
		
		flottenArray.schiffHinzufuegen(spaceShip);
	}


	/**
	 * Die Methode "zeigeEinRaumschiff" iteriert durch das Array und zeigt alle Raumschiffe
	 * in einer geordneten Liste an, anschließend hat der Benutzer die Wahl ein Raumschiff auszusuchen
	 * und dessen Daten zu begutachten
	 */
	public static void zeigeEinRaumschiff() 
    {
       
		zeigeRaumschiffFlotte(); // Zeigt flotte an


    System.out.print("Welches Raumschiff soll angezeigt werden? " );
	int eingabe = scanner.nextInt();
    System.out.println();

	try{
        flottenArray.zeigeDaten(eingabe-1);
        }
        catch(Exception e)
        {
        System.out.println("Ungültige Eingabe. Versuch es nochmal");
        }

	System.out.println();
        
    }




/**
 * Zeigt die Daten aller Raumschiffe an.
 */
public static void zeigeAlleRaumschiffsdaten() {
    
	
    for (int i = 0; i <= flottenArray.getFlottenArrayLaenge(); i++) {
        int zaehler = i + 1;
        String geordneteListe = "(" + zaehler + ") ";

        
        if (flottenArray.getShipAtIndex(i) != null) {
            
            flottenArray.getShipAtIndex(i).showShipData();
            System.out.println("------------------------------");
        } else {
            
            System.out.println();
        }
    }

	;
}




/**
 * Diese Methode gibt die Liste der Raumschiffe aus und ermöglicht das Löschen eines bestimmten Raumschiffs.
 */
public static void Raumschifflöschen() {
    /**
     * Iteriert über das Flottenarray und gibt die geordnete Liste der Raumschiffe aus.
     */
    for (int i = 0; i <= flottenArray.getFlottenArrayLaenge(); i++) {
        int zaehler = i + 1;
        String geordneteListe = "(" + zaehler + ") ";
        if (flottenArray.getShipAtIndex(i) != null) {
            System.out.println(geordneteListe + flottenArray.getShipAtIndex(i).getName());
        } else {
            System.out.println(geordneteListe + "Leer ");
        }
    }

    /**
     * Fragt den Benutzer nach der Eingabe des zu löschenden Raumschiffs.
     */
    System.out.println("Welches Raumschiff soll gelöscht werden? ");
    int eingabe = scanner.nextInt();
    System.out.println();

    /**
     * Überprüft die Eingabe und löscht das entsprechende Raumschiff aus dem Flottenarray.
     */
    if (eingabe > 0 && eingabe <= flottenArray.getFlottenArrayLaenge()) {
        flottenArray.löcheRaumschiff(eingabe - 1);
        System.out.println("Raumschiff gelöscht.");
    } else {
        System.out.println("Ungültige Eingabe. Versuch es nochmal");
    }
}


public  static void  zeigeRaumschiffFlotte()
{
	
	System.out.println("SPACE PATROL 1.0 ");
	for(int i = 0; i<=flottenArray.getFlottenArrayLaenge();i++)
        {
            int zaehler = i+1;
            String geordneteListe = "("+zaehler+") ";
            if(flottenArray.getShipAtIndex(i) != null)
            {
					System.out.println(geordneteListe+ flottenArray.getShipAtIndex(i).getName());
        
            }
			
            else
            {
            System.out.println(geordneteListe+  "Leer ");
            }

        }

}











  
}
