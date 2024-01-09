import java.io.*;

public class Parc {

    public static void main(String[] args) {
        try {
            Voiture v1 = Voiture.creerVoiture(2023, Carburant.gaz);
            Voiture v2 = Voiture.creerVoiture(2024, Carburant.essence);

            v1.addCarburant(30);
            v1.periodiciteVidange();
            System.out.println(v1.toString());

            v2.addCarburant(50);
            v2.periodiciteVidange();
            System.out.println(v2.toString());
            Camion c1 = Camion.creerCamion(2023,Carburant.gaz,300);
            Camion c2 = Camion.creerCamion(2020,Carburant.essence,400);
            c1.addCarburant(40);
            c1.periodiciteVidange();
            System.out.println(c1.toString());
            c2.addCarburant(55);
            c2.periodiciteVidange();
            System.out.println(c2.toString());



            // Serialization
            FileOutputStream fops = new FileOutputStream("garage");
            ObjectOutputStream oops = new ObjectOutputStream(fops);
            oops.writeObject(v1);
            oops.writeObject(v2);
            oops.close();
            fops.close();

            // Deserialization
            FileInputStream fips = new FileInputStream("garage");
            ObjectInputStream oips = new ObjectInputStream(fips);

            // Lire les objets sérialisés du fichier
            Voiture v3 = (Voiture) oips.readObject();
            System.out.println("Objet désérialisé v3: " + v3.toString());
            Voiture v4 = (Voiture) oips.readObject();
            System.out.println("Objet désérialisé v4: " + v4.toString());

            oips.close();
            fips.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}