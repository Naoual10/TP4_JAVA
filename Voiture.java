import java.io.Serializable; 

class Voiture extends Vehicule implements Decapotable { 

 private static int nbMaxVoitures = 100; 
 private static int capacite = 200; 
 private static int nbVoitures = 0; 
 private Carburant carburant; 
 private int periodiciteVidange; 
 private boolean toitReplie; 
  
   private Voiture (int modele, Carburant carburant){ 
     super(modele); 
     this.setMatricule(this.getClass().getName()+":"+ ++nbVoitures); 
      this.carburant = carburant; 
    } 
 public static Voiture creerVoiture(int modele, Carburant carburant){ 
   if (nbVoitures < nbMaxVoitures)
      return new Voiture(modele,carburant); 
   else System.out.println("Nombre max de voiture est atteint et le parc est fermé"); 
         return null; 
    } 
 public void addCarburant(double carburant){ 
    if ((getCarburant()+carburant)<= capacite) 
       setCarburant(getCarburant()+carburant); 
    else { 
     double max_c_ajout = capacite - getCarburant(); 
       this.setCarburant(capacite); 
       System.out.println("la quantite :"+(carburant-max_c_ajout)+" a deborder"); 
    } 
  } 
    public Carburant typeCarburant(){ 
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
    public void replieLeToit(){
        toitReplie = true;
    } 
    public int getPeriodiciteeVidange(){
        return periodiciteVidange;
    } 
    public String toString(){ 
         return "Voiture " + super.toString() +  ", type du carburant: "+carburant+", periodicite de vidange: "+periodiciteVidange +" mois"; 
    } 
}