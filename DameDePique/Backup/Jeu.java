/*
 * Jeu.java										26 avr. 2019
 * Pas de droit, pas de copyright ni copyleft
 */
package dameDePique;
import dameDePique.Carte;
import java.util.Scanner ;
/**
 * TODO : Commenter les responsabilit�s de cette classe
 * @author alexa
 * 
 */
public class Jeu {

    /**
     * Servant a l'�change de carte au d�but d'une manche, � l'aide d'un modulo
     * 4 on d�termine si les joueurs �changent � droite, � gauche, devant ou 
     * n'en font pas
     */
    public static int nbManche ; 

    /**
     * @return valeur de nbManche
     */
    public static int getNbManche() {
	return nbManche;
    }

    /**
     * @param nbManche nouvelle valeur de nbManche
     */
    public static void setNbManche(int nbManche) {
	Jeu.nbManche = nbManche;
    }


    /**
     * Paquet de Carte servant pour le jeu contenant 52 cartes.
     */
    public static Carte[] paquet = Carte.genererPaquet();

    /**
     * 	Valeur du tas de carte permettant de comptabiliser les points dans le
     * tas ( 1 coeur = 1 point, la dame de pique = 13 points)
     */
    public Carte[] tas = new Carte[13];

    /**
     * @return valeur de tas
     */
    public Carte[] getTas() {
	return tas;
    }

    /**
     * @param tas nouvelle valeur de tas
     */
    public void setTas(Carte[] tas) {
	this.tas = tas;
    }
    /**
     * D�claration du joueur humain
     */
    static Joueur  joueur1;

    /**
     * D�claration de l'ordinateur n�1
     */
    static Joueur joueur2;

    /**
     * D�claration de l'ordinateur n�2
     */
    static Joueur joueur3;

    /**
     * D�claration de l'ordinateur n�3
     */
    static Joueur joueur4;
    /**
     * Valeur permettant de v�rifier que le programme fonctionne conform�ment
     * aux attentes (Nombre de tours possible limit� par le fonctionnement du jeu)
     */  
    private static final int NB_POINTS_TOUR_MAX = 13 ;

    /**
     * Valeur fix� qui quand elle est d�pass�e mets fin � la partie
     */
    private static final int NB_POINTS_FIN = 100;

    /**
     * TODO : Commenter le r�le du champ (Attributs,R�le associatifs)
     */
    private static final int NB_JOUEUR = 4;

    /**
     * TODO : Commenter le r�le du champ (Attributs,R�le associatifs)
     */
    public static String pseudo; //pseudo choisi par l'utilisateur

    /**
     * Cr�er les joueurs et initialise leurs points et pseudos.
     */
    public static void initialisationJoueur() {

	Scanner entree = new Scanner(System.in);
	do {
	    System.out.println("Entrez votre pseudo : ");
	    pseudo = entree.nextLine();
	    if (pseudo.length() == 0) {
		System.out.println("Erreur. Le texte entr� ne doit pas �tre vide\n");
	    }
	} while (pseudo.length() == 0);
	joueur1 = new Joueur(pseudo);
	joueur2 = new Joueur("Ordi1");
	joueur3 = new Joueur("Ordi2");
	joueur4 = new Joueur("Ordi3");

    }

    /**
     * TODO : Commenter le r�le de la m�thode
     */
    public static void distribution() {
	int compteurDistribution;
	compteurDistribution = 0 ;
	Joueur numeroJoueur;
	numeroJoueur = new Joueur(null);
	Carte[] mainJoueur = new Carte[13];
	for (int chaqueJoueur = 0 ; chaqueJoueur < NB_JOUEUR; chaqueJoueur ++) {
	    switch (chaqueJoueur) {
	    case 0 :
		numeroJoueur = joueur1 ;
		break;
	    case 1 :
		numeroJoueur = joueur2 ;
		break;
	    case 2 :
		numeroJoueur = joueur3 ;
		break;
	    case 3 : 
		numeroJoueur = joueur4 ;
		break;
	    }
	    for (int distribution = 0 ; distribution < 13 ; distribution ++) {
		mainJoueur[distribution] = paquet[compteurDistribution] ;
		compteurDistribution ++;
	    }
	    numeroJoueur.setMainDuJoueur(mainJoueur);
	}
	for(int carte = 0 ; carte < 13; carte ++) {
	    System.out.printf("Joueur 1 , carte n�%d : %s \n"
		    		+"Joueur 2 : %s \n"
		    		+"Joueur 3 : %s \n"
		    		+"Joueur 4 : %s \n \n"
		    		,carte,joueur1.getMainDuJoueur()[carte].toString()
		    		,carte,joueur2.getMainDuJoueur()[carte].toString()
		    		,carte,joueur3.getMainDuJoueur()[carte].toString()
		    		,carte,joueur4.getMainDuJoueur()[carte].toString());
	}
    }

    /**
     * TODO : Commenter le r�le de la m�thode
     * @param args
     */
    public static void main (String[] args) {
	//initialisationJoueur() ;
	//distribution() ;
	for(int nbCarte = 0 ; nbCarte < 52 ; nbCarte ++) {
	    System.out.println(paquet[nbCarte].toString()); 
	}
    }





}
