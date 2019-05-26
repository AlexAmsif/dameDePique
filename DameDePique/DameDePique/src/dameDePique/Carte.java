/*
 * Cartes.java										26 avr. 2019
 * Pas de droit, pas de copyright ni copyleft
 */
package dameDePique;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;;

/**
 * TODO : Commenter les responsabilités de cette classe
 * @author Amsif Alexandre et Bazot Léo
 * 
 */
public class Carte {
	
	/**
	 * tableau stockant les valeurs en ordre croissant avec
	 * <ul>
	 *     <li> '0' pour 10       </li>
	 * 	   <li> 'V' pour Valet    </li>
	 *     <li> 'D' pour Dame     </li>
	 *     <li> 'R' pour Roi      </li> 
	 *     <li> 'A' pour As       </li>
	 * </ul>
	 */
	static public final char[] TAB_VALEUR  = {'2', '3', '4', '5', '6', '7', '8', '9', '0', 'V', 'D', 'R', 'A'};

	
	/**
	 * tableau stockant les valeurs char représentant les familles avec
	 * <ul>
	 * 	   <li> 'O' pour cOeur    </li>
	 *     <li> 'C' pour Carreaux </li>
	 *     <li> 'P' pour Pique    </li> 
	 *     <li> 'T' pour Trèfle   </li>
	 * </ul>
	 */
	static public final char[] TAB_FAMILLE = {'T', 'O', 'P', 'C'};

	
	/* Valeur de la carte */
	private char valeur;

	/* Famille de la carte */
	private char famille;
	
	private int points;

	/* Correspond au texte entier liée à la famille */
	private String laFamille;

	/* Correspond au texte entier liée à la valeur */
	private String laValeur;

	

	/**
	 * Crée une carte en fonction de sa valeur, sa famille 
	 * et le nombre de points quelle donne
	 * @param valeur valeur de la carte (2,3,4,5,6,7,8,9,0,V,D,R ou A)
	 * @param famille famille de la carte (C(carreau) ,O(coeur) ,P(piques) ,
	 * 									   T(trèfles))
	 * @param points que vaut la carte (coueur = 1, dame de pique = 13,
	 * 				 les autres = 0)
	 * @param possesseur id/nom du joueur qui à la carte en main
	 */
	public Carte(char valeur, char famille, int points) {
		this.valeur = valeur;
		this.famille = famille;
		this.points = points;
	}
	
	
	/**
	 * getter de la valeur de la carte
	 * @return valeur de valeur
	 */
	public char getValeur() {
		return valeur;
	}

	
	/**
	 * getter de la famille de la carte
	 * @return valeur de famille
	 */
	public char getFamille() {
		return famille;
	}
	
	
	/**
	 * getter de la valeur des points de la carte
	 */
	public int getPoints() {
		return points;
	}
	
	
	
	/**
	 * @param valeur nouvelle valeur de valeur
	 */
	public void setValeur(char valeur) {
		this.valeur = valeur;
	}
	

	/**
	 * @param famille nouvelle valeur de famille
	 */
	public void setFamille(char famille) {
		this.famille = famille;
	}
	

	/**
	 * 
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
	/**
	 * Affichage des cartes sous la forme : ValeurSymbole ex : 
	 * <ul>
	 *     <li>A♥</li>
	 *     <li>2♠</li>
	 *     <li>10♦</li>
	 * </ul>
	 */
	@Override
	public String toString() {
		
		switch (famille) {
		case 'O':
			laFamille = "Coeur"; // caractere ♥ en fourmat UTF-8
			break;
		case 'C':
			laFamille = "Carreau"; // caractere ♦ en fourmat UTF-8
			break;
		case 'P':
			laFamille = "Pique"; // caractere ♠ en fourmat UTF-8
			break;
		case 'T':
			laFamille = "Trefle"; // caractere ♣ en fourmat UTF-8
			break;
		}

		switch (valeur) {
		case '0':
			laValeur = "10";
			break;
		case 'V':
			laValeur = "V"; // Valet
			break;
		case 'D':
			laValeur = "D"; // Dame
			break;
		case 'R':
			laValeur = "R"; // Roi
			break;
		case 'A':
			laValeur = "A"; // As
			break;
		default : 
			laValeur = Character.toString(valeur);
		}

		return laValeur +' ' +laFamille;
	}
	
	
	
	/**
	 * Créer 52 carte differentes : 13 par famille, chacune ayant un possesseur
	 * null car non atribué
	 * @return Paquet : les 52 cartes differentes du paquet  
	 */
	public static List<Carte> genererPaquet() {
		ArrayList<Carte> Paquet = new ArrayList<Carte>();
		int pointsCarte;
		
		for (int Famille = 0 ; Famille <TAB_FAMILLE.length; Famille ++) {
			for(int Valeur = 0; Valeur < TAB_VALEUR.length; Valeur ++) {
				
				if (TAB_FAMILLE[Famille] == 'O') {
					pointsCarte = 1;
				} else if (TAB_FAMILLE[Famille] == 'P' && TAB_VALEUR[Valeur] == 'D') {
					pointsCarte = 13;
				} else {
					pointsCarte = 0;
				}
				
				Paquet.add(new Carte(TAB_VALEUR[Valeur], TAB_FAMILLE[Famille], pointsCarte));
			}
		}
		return Paquet;
	}
	
	/**
	 * Comparaison de la famille de 2 cartes
	 * @param aComparer carte à comparer avec "this" carte
	 * @return 1 si "this" est à placer au dessus,
	 * 		   0 si les familles sont identiques,
	 * 		  -1 si "this" est à placer en dessous
	 */
	public int compareFamilleTo(Carte familleAComparer) {
		
		char famille1 = this.getFamille();
		char famille2 = familleAComparer.getFamille();
		
		
		if (famille1 == famille2) {
			return 0;
			
		}
		
		
		switch (famille1) {
		case 'T':
			return 1;
			
		case 'O':
			if (famille2 == 'T') {
				return -1;
			} else {
				return 1;
			}
			
		case 'P' :
			if (famille2 == 'C') {
				return 1;
			} else {
				return -1;
			}
		/* cas ou la famille est Carreau*/
		default:
			return -1;
		}
	}
	
	/**
	 * Comparaison des valeurs et familles de deux cartes
	 * @param aComparer
	 * @return 1 si carte1 est à placer au dessus,
	 * 		   0 si les cartes sont les mêmes (cas d'erreur),
	 * 		  -1 si carte1 est à placer en dessous
	 */
	public static Comparator<Carte> ordreCroissant = new Comparator<>() {
        
	    public int compare(Carte carte1, Carte carte2) {
	            
	        Character carte1Famille = carte1.getFamille();
	            
	        Character carte2Famille = carte2.getFamille();
	            
	        Character carte1Valeur = carte1.getValeur();
	            
	        Character carte2Valeur = carte2.getValeur();
	        
	        int symboleDiff = carte1Famille.compareTo(carte2Famille);
	        
	        int valeurDiff = carte1Valeur.compareTo(carte2Valeur);
	        
	        
	        if ( ( carte1Valeur == 'A' && carte2Valeur>carte1Valeur )
	        	|| ( carte1Valeur == 'R' && ( carte2Valeur == 'A'
	        								|| carte2Valeur == 'V') ) 
	        	|| ( carte1Valeur == 'D' && ( carte2Valeur == 'V' 
	        								|| carte2Valeur == 'A') ) 
	        	|| ( carte1Valeur == 'V' && ( carte2Valeur == 'A' 
	        								|| carte2Valeur == 'R'
	        								|| carte2Valeur == 'D' ) ) 
	        	|| (carte1Valeur == '0' && ( carte2Valeur != 'A' 
	        								&& carte2Valeur != 'R'
	        								&& carte2Valeur != 'D' 
	        								&& carte2Valeur != 'V' ) )
	        	|| (carte2Valeur == '0' && ( carte1Valeur != 'A' 
											&& carte1Valeur != 'R'
											&& carte1Valeur != 'D' 
											&& carte1Valeur != 'V' ) )
	        	) {
				valeurDiff = -valeurDiff;
			}

	        
	        return symboleDiff < 0 
	                 || (symboleDiff == 0 && valeurDiff > 0) ? 1 : -1;
	            
	    }
	        
	};

}
