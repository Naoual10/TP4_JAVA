import java.io.Serializable;

class Camion extends Vehicule {
    private static int nbMaxCamions = 50;
    private static int nbCamions = 0;
    private static int capacite = 200;
    private Carburant carburant;
    private int capaciteCharge;
    private int periodiciteVidange; 
    private boolean toitReplie; 

    private Camion(int modele, Carburant carburant, int capaciteCharge) {
        super(modele);
        this.setMatricule(this.getClass().getName() + ":" + ++nbCamions);
        this.carburant = carburant;
        this.capaciteCharge = capaciteCharge;
    }

    public static Camion creerCamion(int modele, Carburant carburant, int capaciteCharge) {
        if (nbCamions < nbMaxCamions)
            return new Camion(modele, carburant, capaciteCharge);
        else
            System.out.println("Nombre max de camions est atteint et le parc est fermé");
        return null;
    }

    public void setCapaciteCharge(int capaciteCharge) {
        this.capaciteCharge = capaciteCharge;
    }

    public int getCapaciteCharge() {
        return capaciteCharge;
    }

    public void addCarburant(double carburant) { 
       if ((getCarburant()+carburant)<= capacite) 
       setCarburant(getCarburant()+carburant); 
       else { 
       double max_c_ajout = capacite - getCarburant(); 
       this.setCarburant(capacite); 
       System.out.println("la quantite :"+(carburant-max_c_ajout)+" a deborder"); 
    } 
  } 

    public Carburant typeCarburant() { 
      return carburant; 
 }

     public void periodiciteVidange(){ 
       switch (carburant) { 
           case diesel : periodiciteVidange = 10; break; 
           case essence: periodiciteVidange = 12; break; 
           case gaz: periodiciteVidange = 18; break; 
           default: periodiciteVidange = 12; break; 
        } 
    } 
     public void replieLeToit() {
        toitReplie = true;
    } 
    public int getPeriodiciteeVidange() {
        return periodiciteVidange;
    } 

   
    public String toString() {
        return "Camion " + super.toString() + ", type du carburant: " + carburant + ", capacité de charge: " + capaciteCharge + " kg";
    }
}