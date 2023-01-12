package Day;

public class Case {
    String Coordonnee;
    int Poids;
    String Valeur;

    public Case(String Coordonnee, int Poids, String Valeur) {
        this.Coordonnee = Coordonnee;
        this.Poids = Poids;
        this.Valeur = Valeur;
    }

    public String getCoordonnee() {
        return Coordonnee;
    }
    public void setCoordonnee(String Coordonnee) {
        this.Coordonnee = Coordonnee;
    }
    public int getPoids() {
        return Poids;
    }

    public void setPoids(int Poids) {
        this.Poids = Poids;
    }

    public String getValeur() {
        return Valeur;
    }

    public void setValeur(String Valeur) {
        this.Valeur = Valeur;
    }

    public String toString() {
        return "Day.Case [Coordonnee=" + Coordonnee + ", poids=" + Poids + ", valeur=" + Valeur + "]";
    }
}
