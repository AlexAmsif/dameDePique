/**
 * Cartes.java										26 avr. 2019
 * Pas de droit, pas de copyright ni copyleft
 */
package dameDePique;
/**
 * TODO : Commenter les responsabilités de cette classe
 * @author alexa
 * 
 */
public class Carte {
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	switch (famille) {
	case 'O':
	    laFamille = "Coeur";
	    break;
	case 'C':
	    laFamille = "Carreau"; 
	    break;
	case 'P':
	    laFamille = "Pique";
	    break;
	case 'T':
	    laFamille = "Trefle";
	    break;
	}
	
	switch (valeur) {
	case 'V':
	    laValeur = "Valet";
	    break;
	case 'D':
	    laValeur = "Dame"; 
	    break;
	case 'R':
	    laValeur = "Roi";
	    break;
	case 'A':
	    laValeur = "As";
	    break;
	case '0':
            laValeur = "10";
            break;
	default : 
	    laValeur = Character.toString(valeur);
	}
	
	return " Cette carte est le " + laValeur + ", de la famille "+ laFamille;
    }
    /**
     * tableau stockant les valeurs en ordre croissant avec
     * <ul>
     * 	   <li> 'V' pour Valet    </li>
     *     <li> 'D' pour Dame     </li>
     *     <li> 'R' pour Roi      </li> 
     *     <li> 'A' pour As       </li>
     *     <li> '0' pour 10       </li>
     * </ul>
     */
    static public final char TAB_VALEUR[]  = {'2', '3', '4', '5', '6', '7', '8', '9', '0', 'V', 'D', 'R', 'A'};

    /**
     * tableau stockant les valeurs char représentant les familles avec
     * <ul>
     * 	   <li> 'O' pour cOeur    </li>
     *     <li> 'C' pour Carreaux </li>
     *     <li> 'P' pour Pique    </li> 
     *     <li> 'T' pour trèfle   </li>
     * </ul>
     */
    static public final char TAB_FAMILLE[] = {'O', 'C', 'P', 'T'};

    /**
     * Valeur de la carte
     */
    private char valeur;

    /**
     * Famille de la carte
     */
    private char famille;

    /**
     * Correspond au texte entier liée à la famille
     */
    private String laFamille;

    /**
     * Correspond au texte entier liée à la valeur
     */
    private String laValeur;
    
    /**
     * TODO : Commenter le rôle du champ (Attributs,Rôle associatifs)
     */
    private String possesseur ;
    
    /**
     * @return valeur de valeur
     */
    public char getValeur() {
	return valeur;
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
     * @return valeur de famille
     */
    public char getFamille() {
	return famille;
    }
    

    /**
     * TODO : Commenter l'état initial défini
     * @param valeur
     * @param famille
     */
    public Carte(char valeur, char famille, String possesseur) {
	this.valeur = valeur;
	this.famille = famille;
	this.possesseur = possesseur;

    }
    public Carte(char valeur, char famille) {
	this(valeur,famille);

    }
    /**
     * Créer 52 carte differentes : 13 par famille, chacune ayant un possesseur
     * null car non atribué
     * @return Paquet : les 52 cartes differentes du paquet  
     */
    public static Carte[] genererPaquet() {
	Carte []Paquet ; 
	Paquet = new Carte[52]; 
	for (int Famille = 0 ; Famille <TAB_FAMILLE.length; Famille ++){
	    for(int Valeur = 0; Valeur < TAB_VALEUR.length; Valeur ++) {

		Paquet[Valeur+(Famille*13)] = new Carte(TAB_VALEUR[Valeur], TAB_FAMILLE[Famille]);
	    }
	}
	return Paquet; 	 
    }

}
