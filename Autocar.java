class Autocar extends Vehicule {
    private static int nbMaxAutocars = 20; // Nombre maximum d'autocars
    private static int nbAutocars = 0; // Nombre d'autocars actuellement créés
    private Carburant carburant;
    private int capacitePassagers;

    private Autocar(int modele, Carburant carburant, int capacitePassagers) {
        super(modele);
        this.setMatricule(this.getClass().getName() + ":" + ++nbAutocars);
        this.carburant = carburant;
        this.capacitePassagers = capacitePassagers;
    }

    public static Autocar creerAutocar(int modele, Carburant carburant, int capacitePassagers) {
        if (nbAutocars < nbMaxAutocars)
            return new Autocar(modele, carburant, capacitePassagers);
        else
            System.out.println("Nombre max d'autocars atteint, le parc est complet");
        return null;
    }

    public void setCapacitePassagers(int capacitePassagers) {
        this.capacitePassagers = capacitePassagers;
    }

    public int getCapacitePassagers() {
        return capacitePassagers;
    }

    
   public void addCarburant(double carburant) { 
        if ((getCarburant()+carburant)<= capacite) 
setCarburant(getCarburant()+carburant); 
        else {  
            double max_carburant_ajout = capacite - getCarburant(); 
            this.setCarburant(capacite); 
            System.out.println("la quantite :"+(carburant-max_carburant_ajout)+" 
a deborder"); 
        } 
    } 

    
    public Carburant typeCarburant() {
        return carburant;
    }

    
    public void periodiciteVidange(){ 
        switch (carburant) { 
            case diesel : periodiciteVidange = 10; break; 
            case essence: periodiciteVidange = 12; break; 
            case gaz:     periodiciteVidange = 18; break; 
            default:      periodiciteVidange = 12; break; 
        } 
    } 
     public int getPeriodiciteeVidange() {return periodiciteVidange;}
     

    
    public String toString() {
        return "Autocar " + super.toString() + ", type du carburant: " + carburant + ", capacité de passagers: " + capacitePassagers;
    }
}