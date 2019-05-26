/*
 * Affichage.java				18 May 2019
 * TODO specify rights 
 */
package dameDePique;

import java.util.ArrayList;
import java.util.List;
import dameDePique.*;

/**
 * Classe permetant l'affichage necessaire pour le joueur humain
 * @author Maxoft
 */
public class Affichage {
	
	
	/**
	 * 
	 * @param joueurConcerne
	 */
	public static void afficherMain(Joueur joueurConcerne) {
		
		List<Carte> aAfficher = new ArrayList<Carte>();
		
		List<Boolean> cartesJouables = new ArrayList<Boolean>();
	
		aAfficher.addAll(joueurConcerne.getMainDuJoueur());
		
		cartesJouables.addAll(Jeu.mainEstJouable(aAfficher));
		
		for (int carte = 0; carte < aAfficher.size(); carte++) {
			if (cartesJouables.get(carte) == true) {
				System.out.println("  " +carte +") " +aAfficher.get(carte).toString());
			} else {
				System.out.println("* " +carte +") " +aAfficher.get(carte).toString());
			}
		}
	}
	
    /**
     * Effectue le nettoyage de la console texte.
     * Une exception est propagee dans le cas d'un mauvaise execution.
     */
    public static void cls() {
        try {
            final String OS = System.getProperty("os.name");

            if (OS.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("cmd", "/c", "clear").inheritIO().start().waitFor();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

}
