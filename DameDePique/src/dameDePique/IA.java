package dameDePique;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import dameDePique.Jeu;
import dameDePique.Joueur;
import dameDePique.Carte;

public class IA {
	public static int EchangeDeCarte(List<Carte> mainIA){
		
		return (int)(Math.random()*mainIA.size());
	}
}
