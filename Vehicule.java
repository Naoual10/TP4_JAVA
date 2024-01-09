import java.io.Serializable; 
 
public abstract class Vehicule implements Motorisation, Serializable { 
     
    //attributs 
    private String matricule; 
    private int modele; 
    private double carburant; 
    private double prix;  
 
    // constructeur 
    public Vehicule(int _modele){ modele = _modele; } 
 
    public void setCarburant(double _carburant){carburant=_carburant;} 
    public double getCarburant(){return carburant;  } 
    public void setMatricule(String _matricule){matricule=_matricule;} 
    public String getMatricule(){return matricule;} 
    public void setModele(int _modele){modele=_modele;} 
    public int getModele(){return modele;} 
    public void setPrix(double _prix) {prix=_prix;} 
    public double getPrix() {return prix;} 
 
    public String toString() {return "matricule: "+matricule+", modele: "+modele;} 
     
} 