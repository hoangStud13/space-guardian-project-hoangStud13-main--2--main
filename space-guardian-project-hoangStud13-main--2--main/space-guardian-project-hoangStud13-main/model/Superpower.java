
package model;
import java.util.UUID;
/**
    * Die Klasse Superpower repräsentiert eine Superkraft mit ihrer eindeutigen ID, Aktionsbeschreibung und Namen.
    */
    public class Superpower {

    private String id;
    private String actionDescription;
    private String name;

    /**
        * Erzeugt ein neues Superpower-Objekt mit dem angegebenen Namen, der ID und der Aktionsbeschreibung.
        * Die ID wird mithilfe einer zufälligen UUID generiert.
        * @param name der Name der Superkraft
        * @param id die ID der Superkraft
        * @param actionDescription die Aktionsbeschreibung der Superkraft
        */
        public Superpower(String name,  String actionDescription) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.actionDescription = actionDescription;
        }

    /**
        * Gibt die ID der Superkraft zurück.
        * @return die ID der Superkraft
        */
        public String getId() {
        return id;
        }

    /**
        * Setzt die ID der Superkraft.
        * @param id die ID der Superkraft
        */
        public void setId(String id) {
        this.id = id;
        }

    /**
        * Gibt die Aktionsbeschreibung der Superkraft zurück.
        * @return die Aktionsbeschreibung der Superkraft
        */
        public String getActionDescription() {
        return actionDescription;
        }

    /**
        * Setzt die Aktionsbeschreibung der Superkraft.
        * @param actionDescription die Aktionsbeschreibung der Superkraft
        */
        public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
        }

    /**
        * Gibt den Namen der Superkraft zurück.
        * @return der Name der Superkraft
        */
        public String getName() {
        return name;
        }

    /**
        * Setzt den Namen der Superkraft.
        * @param name der Name der Superkraft
        */
        public void setName(String name) {
        this.name = name;
        }
        }




