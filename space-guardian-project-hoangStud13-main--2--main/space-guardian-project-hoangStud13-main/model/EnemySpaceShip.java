package model;
//extends SpaceShip
public class EnemySpaceShip  extends SpaceShip{
    
    private static Superpower gegnerSuperpower1 = new Superpower("Supernova Explosion", "Entfache die Energie der Sterne in deiner Handfläche und löse eine gewaltige Supernova-Explosion aus, die alles in der Umgebung zerstört.");
    private static Superpower gegnerSuperpower2 = new Superpower("Quanten-Verzerrungsschlag", "Nutze die Kraft der Quantenphysik, um einen Schlag zu versetzen, der Raum und Zeit verzerren kann, und erreiche so deinen Feind in Lichtgeschwindigkeit.");
    private static Superpower gegnerSuperpower3 = new Superpower("Astralprojektionswelle", "Löse eine Welle von Energie aus, die es dir ermöglicht, deine astrale Form in den Weltraum zu projizieren, um deine Feinde von einem anderen Ort aus anzugreifen.");
    private static Superpower gegnerSuperpower4 = new Superpower("Galaxienzerstörerstrahl", "Bündle die Energie von ganzen Galaxien und entfessle einen zerstörerischen Strahl, der alles auf seinem Weg vernichtet.");
    private static Superpower gegnerSuperpower5 = new Superpower("Schwarzes-Loch-Vortex", "Erschaffe einen miniaturisierten schwarzen Loch-Vortex, der die Gravitation um dich herum verändert und alles in seiner Nähe in die Dunkelheit zieht");
    private static String[] namensListe = {"Dunkelstern-Zerstörer",
        "Nebelklingen-Fregatte",
        "Phantomrächer-Kreuzer",
       " Schattenzerstörer",
        "Schwarzweltraum-Korvette"};
    
    private static Superpower[] gegnerSuperpowerListe = {gegnerSuperpower1,gegnerSuperpower2,gegnerSuperpower3,gegnerSuperpower4,gegnerSuperpower5};


    public EnemySpaceShip ()
{
    super(namensListe[(int)(Math.random()*5)], gegnerSuperpowerListe[(int)(Math.random()*5)]);
    setHealtPointsCurrent((int)(Math.random()*1000));

}

@Override
public void  takeDamage(int schaden)
{
    setHealtPointsCurrent(getHealtPointsCurrent()-(schaden)); 
    if(getHealtPointsCurrent()<=0)
    {
        setHealtPointsCurrent(0);
        setAlive((false));
    }
   
}

/**
 * FLIEhen und angriff
 */
@Override
public int attack()
{
    if(Math.random()*100>10)
    {
        double schaden = Math.random()*100;
        if ((Math.random()*100)<(this.getExperiencePoints()*2) || (this.getExperiencePoints()*2)>99)
        {
            return (int)schaden*2;
        }
        else
        {
            return (int)schaden;
        }
    }
    else{
        System.out.println("Das Gegnerschiff ist geflohen!");
        return -1;
    }
    
}




}
