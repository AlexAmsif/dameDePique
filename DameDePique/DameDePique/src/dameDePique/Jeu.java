/*
 * Jeu.java										26 avr. 2019
 * Pas de droit, ni copyright ni copyleft
 */
package dameDePique;

import dameDePique.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * La classe Jeu permet la gestion des mains des joueurs, du paquet, du tapis.
 * Elle contiens toutes les méthodes permetant de jouer.
 * @author alexa
 * 
 */
public class Jeu {
	
	/**
	 * Nombres de tours maximum par manche
	 * et nombre de cartes maximum dans la main d'un joueur
	 */  
	private static final int NB_TOUR_MAX = 13;

	/** Nombre de points à atteindre pour que la partie se termine */
	private static final int NB_POINTS_FIN = 100;

	/** nombre de joueurs */
	private static final int NB_JOUEUR = 4;
	
	/** nombre de cartes dans le paquet */
	public static final int TAILLE_PAQUET = 52;
	
	/** Paquet de Carte servant pour le jeu contenant 52 cartes. */
	public static final List<Carte> paquet = Carte.genererPaquet();
	

	/** numéro de la manche servent à savoir à qui le joueur doit donner 3 cartes */
	public static int nbManche;
	
	/** le numéro de tour sert à determiner les cartes jouables */
	public static int nbTour;
	
	
	public static boolean coeurAEteJouer = false;
		

	/** Déclaration du joueur humain */
	static Joueur  joueur1;

	/** Déclaration de l'ordinateur n°1 */
	static Joueur joueur2;

	/** Déclaration de l'ordinateur n°2 */
	static Joueur joueur3;

	/** Déclaration de l'ordinateur n°3 */
	static Joueur joueur4;


	/** pseudo du joueur humain */
	public static String pseudo;

	
	/**
	 * Valeur du tas de carte permettant de comptabiliser les points dans le
	 * tas ( 1 coeur = 1 point, la dame de pique = 13 points)
	 */
	public static List<Carte> tas = new ArrayList<Carte>();
	

	// gestion des scanner de test TODO à elever par la suite
	public static Scanner entree = new Scanner(System.in);
	
	
	/** 
	 * Methode de gestion de la saisie du nom des joueurs 
	 */
	public static String SaisirNomJoueur() {
		do {
			System.out.println("Entrez votre pseudo : ");
			pseudo = entree.nextLine();
			if (pseudo.length() == 0) {
				System.out.println("Erreur. Le texte entré ne doit pas être vide\n");
			}
		} while (pseudo.length() == 0);
		return pseudo;
	}
	
	
	/**
	 * Créer les joueurs et initialise leurs points et pseudos.
	 */
	public static void initialisationJoueur() {
		
		joueur1 = new Joueur(SaisirNomJoueur());
		
		joueur2 = new Joueur("Ordi1");
		
		joueur3 = new Joueur("Ordi2");
		
		joueur4 = new Joueur("Ordi3");

	}
	
	/**
	 * determine si les cartes de la main sont jouables
	 * @param aDeterminer main du joueur
	 * @return cartesJouables un tableau de booleen indiquant 
	 * 		   quelles cartes sont jouables
	 */
	public static List<Boolean> mainEstJouable(List<Carte> aDeterminer) {

		List<Boolean> cartesJouables = new ArrayList<Boolean>();
		int nbInjouables = 0;
		
		for (int carte = 0; carte < aDeterminer.size(); carte++) {
			
			if (tas.isEmpty()) {
				
				if (nbTour == 1) {
					
					/* si c'est le premier joueur du premier tour seul le 2♣ peut etre joué */
					cartesJouables.add(aDeterminer.get(carte).getFamille() == new Carte('2', 'T', 0).getFamille()
							           && aDeterminer.get(carte).getValeur() == new Carte('2', 'T', 0).getValeur());
					
				} else if (aDeterminer.get(carte).getFamille() == 'O'){
					
					if (coeurAEteJouer) {
						
						cartesJouables.add(true);
					} else {
						
						cartesJouables.add(false);
						nbInjouables++;
						
					}
				} else {
					
					cartesJouables.add(true);
					
				}
			
			/* si ce n'est pas le premier joueur alors il ne peut jouer que des cartes de la même famille que la première carte du tapis*/
			} else if (nbTour == 1) {
				
				if (aDeterminer.get(carte).getFamille() == 'O' || (aDeterminer.get(carte).getFamille() == 'P' && aDeterminer.get(carte).getValeur() == 'D')) {
					
					cartesJouables.add(false);
					nbInjouables++;
					
				} else if (aDeterminer.get(carte).getFamille() == tas.get(0).getFamille()){
					cartesJouables.add(true);
					
				} else {
					
					cartesJouables.add(false);
					nbInjouables++;
				}
				
			} else {
				
				if (aDeterminer.get(carte).getFamille() == tas.get(0).getFamille()) {
					
					cartesJouables.add(true);
					
				} else {
					
					cartesJouables.add(false);
					nbInjouables++;
					
				}
			}
		}
		
		/* si le joueur n'a aucune carte jouable alors il peut tout jouer */
		if (nbInjouables == aDeterminer.size()) {
			
			for (int i = 0; i < aDeterminer.size(); i++) {
				cartesJouables.set(i, true);
				
			}
		}
		
		return cartesJouables;
	}

	
	/**
	 * mélange les cartes aléatoirement
	 * @return un paquet de carte mélanger
	 */
	public static List<Carte> melangerPaquet(List<Carte> aMelanger) {
		
		List<Carte> copiePaquet = new ArrayList<Carte>();
		
		copiePaquet.addAll(paquet);
		
		aMelanger = new ArrayList<Carte>();
		
		int carteTiree = 0;
		
		for (int i = 0; i < TAILLE_PAQUET; i++) {
			
			if (copiePaquet.size() != 0) {
				
				carteTiree = (int) (Math.random()*copiePaquet.size());

			}
			
			aMelanger.add(copiePaquet.get(carteTiree));
			
			copiePaquet.remove(carteTiree);
			
		}
		
		return aMelanger;
	}
	
	
	/**
	 * Distribution des cartes à chaque joueurs de manière aléatoire
	 */
	public static void distribution() {

		
		Joueur numeroJoueur;
		
		numeroJoueur = new Joueur(null);
		
		List<Carte> mainJoueur = new ArrayList<Carte>();
		
		mainJoueur.addAll(Joueur.mainVide());
		
		List<Carte> aDistribuer = melangerPaquet(paquet);
		
		int compteur = 0;
		
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
				mainJoueur.set(distribution, aDistribuer.get(compteur));
				compteur++;
			}
			
			numeroJoueur.setMainDuJoueur(mainJoueur);

		}
		
	}

	
	/**
	 * TODO : Commenter le rôle de la méthode
	 * @param args
	 */
	public static void main (String[] args) {
		// Affichage.cls();
		initialisationJoueur() ;
		distribution() ;
		joueur1.triMain();
		joueur2.triMain();
		joueur3.triMain();
		joueur4.triMain();
		
		System.out.println(
		  		  joueur1.getMainDuJoueur().toString() + "\n"
		  		  +joueur2.getMainDuJoueur().toString() + "\n"
		  		  +joueur3.getMainDuJoueur().toString() + "\n"
		  		  +joueur4.getMainDuJoueur().toString());


		// System.out.println(new Carte('2', 'T', 0).getFamille() == new Carte('2', 'T', 0).getFamille());
		//System.out.println(new Carte('0', 'T', 0).compareTo(new Carte('9', 'T', 0)));
	}





}
