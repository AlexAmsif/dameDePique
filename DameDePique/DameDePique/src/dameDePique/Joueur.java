/*
 * Joueur.java										29 avr. 2019
 * Pas de droit, pas de copyright ni copyleft
 */
package dameDePique;

import dameDePique.Carte;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO : Commenter les responsabilit�s de cette classe
 * @author Amsif Alexandre et Bazot L�o
 */
public class Joueur {

	/** nom choisis par le joeur en d�but de partie */
	private String nom;

	/** Points du joueur */
	public int pointJoueur;

	/** Taille de la main d'un joueur en d�but de tour */
	final static int TAILLE_DE_LA_MAIN = 13;

	/** Tableau contenant la main du joueur */
	public List<Carte> mainDuJoueur = new ArrayList<Carte>();


	public Joueur(String nom, List<Carte> mainDuJoueur, int pointJoueur) {
		this.nom = nom;
		this.mainDuJoueur = mainDuJoueur;
		this.pointJoueur = pointJoueur;
	}

	/**
	 * Cr�er un joueur a partir de son pseudo, attribuant une main vide, et des
	 * points nuls a celui-ci
	 * @param nom
	 */
	public Joueur(String nom) {
		this(nom, mainVide(), 0);
	}



	/**
	 * @return nom du joueur en String
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @return mainDuJoueur sous forme List<Carte>
	 */
	public List<Carte> getMainDuJoueur() {
		return mainDuJoueur;
	}


	/**
	 * @return valeur de point
	 */
	public int getPointJoueur() {
		return pointJoueur;
	}



	/**
	 * set le nom du joueur par la valeur pass�e en argument
	 * @param nom nouveau nom du joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @param mainDuJoueur nouvelle valeur de mainDuJoueur
	 */
	public void setMainDuJoueur(List<Carte> mainDuJoueur) {
		this.mainDuJoueur.clear();
		this.mainDuJoueur.addAll(mainDuJoueur);
	}


	/**
	 * @param point nouvelle valeur de point
	 */
	public void setPointJoueur(int pointJoueur) {
		this.pointJoueur = pointJoueur;
	}


	/**
	 * renvoi une chaine de caractere sous la forme :
	 * nomJoueur : points
	 */
	public String toString() {
		return nom +" : " +pointJoueur;
	}

	/**
	 * TODO : Commenter le r�le de la m�thode
	 * @return carteMain, Liste de carte avec la valeur 'N', c'est la main a son �tat
	 * initial
	 */
	public static List<Carte> mainVide() {
		List<Carte> carteMain = new ArrayList<Carte>();

		for(int nombreCarte = 0; nombreCarte < TAILLE_DE_LA_MAIN 
				; nombreCarte ++) {

			carteMain.add(new Carte('N','N',0));
		}
		return carteMain;
	}

	public void triMain() {
		this.getMainDuJoueur().sort(Carte.ordreCroissant);
	}
}
