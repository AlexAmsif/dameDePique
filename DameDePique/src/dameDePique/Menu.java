/*
 * Menu.java                                    14 mai 2019
 * IUT Rodez Projet Semestre 2
 */

package dameDePique;

import java.util.Scanner;

/**
 * Jeu de la Dame de Pique
 * @author Landry ASSEMAT, Leo BAZOT, Victoria BOUCHET, Alex AMSIF
 */

public class Menu {

	
	public static void Principal() {
		
		
		System.out.println("----------------------------------------------------------------------\n"
				+ "---------------BIENVENUE DANS LE JEU DE LA DAME DE PIQUE--------------\n"
				+ "----------------------------------------------------------------------\n"
				+ "Appuyez sur :\n"
				+ "(1) pour Jouer | (2) pour lire les Règles | (3) pour changer de Nom |\n(4) pour Quitter");
		
		
		int reponse = 0;
		
		Scanner clavier = new Scanner(System.in);
		
		do {
			
		if(clavier.hasNextInt()) { 
			
			reponse = clavier.nextInt();
			if(reponse != 1 && reponse != 2 && reponse != 3 && reponse != 4) {
				
				System.out.println("Veuillez entrer (1) pour Jouer\n(2) pour lire les Règles\n(3) pour changer de Nom\n(4) pour Quitter le jeu");
			}
		} else {
			
			System.out.println("Veuillez entrer (1) pour jouer\n(2) pour lire les règles\n(3) pour changer les Noms\n"
					+ "(4) pour quitter le jeu");
		}
		clavier.nextLine();
		} while(reponse != 1 && reponse != 2 && reponse != 3 && reponse != 4);

	
	/** Si l'utilisateur rentre le chiffre 1, le système lance le jeu**/
	if (reponse == 1) {

		Jeu.initialisationJoueur() ;
		Jeu.distribution() ;
		System.out.println(
		  		  Jeu.joueur1.getMainDuJoueur().toString() + "\n"
		  		  +Jeu.joueur2.getMainDuJoueur().toString() + "\n"
		  		  +Jeu.joueur3.getMainDuJoueur().toString() + "\n"
		  		  +Jeu.joueur4.getMainDuJoueur().toString());
		
		Affichage.afficherMain(Jeu.joueur1);
		
	}
	
	/** Si l'utilsiateur rentre le chiffre 2, le système affiche les règles**/
	if (reponse == 2) {
		//TODO appel des méthodes de la classe règles pour afficher les règles du jeu
	}
	
	/** Si l'utilisateur rentre le chiffre 3, il accède à l'interface pour changer les noms des ordinateurs
	 * ou son nom d'utilisateur
	 */

	if (reponse == 3) {
		
		ChoixNoms.ChangerNom();
		
	}
	
	/** Si l'utilisateur rentre le chiffre 4, le système quitte le jeu**/
	if (reponse == 4) {
		
		System.out.println("Aurevoir!");
		System.exit(0);
	}
}
	
	public static void main(String[] args) {
		
		Principal();

	}
}
