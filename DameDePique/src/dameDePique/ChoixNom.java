/*
 * ChoixNoms.java                                   14 mai 2019
 * IUT Rodez Projet Semestre 2
 */

package dameDePique;

import java.util.Scanner;
import dameDePique.Jeu;
/**
 * Accès à l'interface pour changer les noms des ordinateurs
 * ou son propre nom d'utilisateur
 * @author Landry ASSEMAT, Leo BAZOT, Victoria BOUCHET, Alex AMSIF
 *
 */
public class ChoixNoms {


	/** choix du nouveau nom **/
	
	private static String choix;

	public static void ChangerNom() {
		
		/* reponse de l'utilisateur lorsqu'il choisit l'ordinateur qu'il veut changer le nom */
		int reponse = -1;
		
		Scanner clavier = new Scanner(System.in);
	
		System.out.println("Choisissez l'ordinateur dont vous voulez changer le nom : \n"
				+ "(1) pour changer le nom de l'ordinateur 1\n(2) pour l'ordinateur 2\n(3) pour l'ordinateur 3\n(4) "
				+ "pour Retourner au Menu Principal");
	
		do {
			if(clavier.hasNextInt()) { 
				reponse = clavier.nextInt();
				if(reponse != 1 && reponse != 2 && reponse != 3 && reponse != 4) {
					System.out.println("Veuillez entrer 1 pour changer le nom de l'ordinateur n°1\n"
							+ "(2) pour l'ordinateur n°2\n(3) pour l'ordinateur n°3 \n(4) pour Retourner"
							+ "au Menu Princpal");
				}
			} else {
				System.out.println("Veuillez entrer (1) pour changer le nom de l'ordinateur n°1\n"
						+ "(2) pour l'ordinateur n°2\n(3) pour l'ordinateur n°3 \n"
						+ "(4) pour Retourner au Menu Principal");
			}
			clavier.nextLine();
		} while(reponse != 1 && reponse != 2 && reponse != 3 && reponse != 4);
		
		if (reponse == 1) {
			System.out.println("Veuillez entrer le nouveau nom de l'ordinateur n°1 : ");
			choix = clavier.nextLine();
			Jeu.joueur2.setNom(choix);
			System.out.println("Le nom de l'ordinateur n°1 est à present : " + choix);
			
		}
		
		if (reponse == 2) {
			System.out.println("Veuillez entrer le nouveau nom de l'ordinateur n°2 : ");
			choix = clavier.nextLine();
			Jeu.joueur3.setNom(choix);
			System.out.println("Le nom de l'ordinateur n°2 est à present : " + choix);
			
		}
		
		if (reponse == 3) {
			System.out.println("Veuillez entrer le nouveau nom de l'ordinateur n°3 : ");
			choix = clavier.nextLine();
			Jeu.joueur4.setNom(choix);
			System.out.println("Le nom de l'ordinateur n°3 est à present : " + choix);	
		}
		if (reponse == 4) {
			System.out.println("Retour au Menu Principal...");
			Menu.Principal();
		}
	}	
}