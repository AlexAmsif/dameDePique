/*
 * Joueur.java										29 avr. 2019
 * Pas de droit, pas de copyright ni copyleft
 */
package dameDePique;

/**
 * TODO : Commenter les responsabilités de cette classe
 * @author alexa
 * 
 */
public class Joueur {
    
    /**
     * TODO : Commenter le rôle du champ (Attributs,Rôle associatifs)
     */
    private String nom;
    
    
    /**
     * TODO : Commenter le rôle du champ (Attributs,Rôle associatifs)
     */
    final static int TAILLE_DE_LA_MAIN = 13;
    
    
    /**
     * TODO : Commenter le rôle du champ (Attributs,Rôle associatifs)
     */
    public Carte[] mainDuJoueur = new Carte[TAILLE_DE_LA_MAIN ];
   
    
    
    /**
     * TODO : Commenter le rôle du champ (Attributs,Rôle associatifs)
     */
    public int point ;
    
    
    /**
     * @return valeur de nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * @param nom nouvelle valeur de nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * @return valeur de mainDuJoueur
     */
    public Carte[] getMainDuJoueur() {
        return mainDuJoueur;
    }
    
    /**
     * @param mainDuJoueur nouvelle valeur de mainDuJoueur
     */
    public void setMainDuJoueur(Carte[] mainDuJoueur) {
        this.mainDuJoueur = mainDuJoueur;
    }
    
    /**
     * @return valeur de point
     */
    public int getPoint() {
        return point;
    }
    
    /**
     * @param point nouvelle valeur de point
     */
    public void setPoint(int point) {
        this.point = point;
    }
    
    /**
     * TODO : Commenter le rôle de la méthode
     * @return carteMain, tableau de carte sans valeur, c'est la main a son état
     * initial
     */
    public static Carte[] mainVide() {
	Carte []carteMain = new Carte[13];
	for(int nombreCarte = 0; nombreCarte < TAILLE_DE_LA_MAIN ; nombreCarte ++) {
	    carteMain[nombreCarte] = new Carte('N','N');
	}
	return carteMain;
    }
    /**
     * Créer un joueur a partir de son pseudo, attribuant une main vide, et des
     * points nuls a celui-ci
     * @param nom
     */
    public Joueur(String nom) {
	super();
	this.nom = nom;
	this.mainDuJoueur = mainVide();
	this.point = 0;
    }
    
}
