package Thomas;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;

import Bodian.Circuit;
import Bodian.TrainBis;
import Bodian.Wagon;
import Guoyu.Aguillage;
import Guoyu.Gare;
import Guoyu.Position;

public class SNCF {
	
	//Classe bibliothèque qui initialise toute les variables//
	
	private Chargement chargement = new Chargement();
	private LinkedList<Circuit> listeCircuit;
	private LinkedList<TrainBis> listeTrain;
	private LinkedList<Aguillage> listeAiguillage;
	private LinkedList<Gare> listeGare;
	private Hashtable<Position,Integer> google = new Hashtable<Position,Integer>();
	private int tailleX;
	private int tailleY;
	
	//Constructeur//
	public SNCF(int levelChoose) {
		initSNCF(levelChoose);
	}
	
	//Accesseur//
	public LinkedList<Circuit> getListeCircuit() {
		return listeCircuit;
	}

	public LinkedList<TrainBis> getListeTrain() {
		return listeTrain;
	}

	public LinkedList<Aguillage> getListeAiguillage() {
		return listeAiguillage;
	}

	public LinkedList<Gare> getListeGare() {
		return listeGare;
	}

	public Hashtable<Position, Integer> getGoogle() {
		return google;
	}
	public int getTailleX() {
		return tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}
	
	//Initialisation de la bibliothèque//
	public void initSNCF(int levelChoose)
	{
		chargement.charger(levelChoose);
		listeCircuit = chargement.getCirc();
		listeAiguillage = chargement.getAig();
		listeTrain = new LinkedList<TrainBis>();
		listeGare = new LinkedList<Gare>();
		initTrain();
		initGare();
		initGoogle();
		tailleX = chargement.getTailleX();
		tailleY = chargement.getTailleY();
	}
	
	//Initialisation des Trains//
	public void initTrain()
	{
		for(int i=0; i<listeCircuit.size(); i++)
		{
			Random rd = new Random();
			LinkedList<Wagon> listeWagon = new LinkedList<>();
			
			int tailletrain = rd.nextInt(3)+1;
			
			
			for(int k=0 ; k < tailletrain ; k++ )
			{
				Position posi = listeCircuit.get(i).getposcircuit().get(k);
				Wagon wagon = new Wagon(posi,i);
				listeWagon.add(wagon);
			}
			
			int idTrain = listeCircuit.get(i).getidcircuit();
			
			TrainBis tb = new TrainBis(idTrain, tailletrain, i, listeWagon);
			listeTrain.add(tb);
			
		}
		
	}
	
	public void initGare()
	{
		for(int i=0; i<listeCircuit.size(); i++)
		{
			Position posi = listeCircuit.get(i).getposcircuit().getLast();
			int idGare = listeCircuit.get(i).getidcircuit();
			Gare gare = new Gare(idGare,posi);
			listeGare.add(gare);
		}
	}
	
	public void initGoogle()
	{
		for(int i=0; i < listeCircuit.size();i++)
		{
			for(int k = 0; k < listeCircuit.get(i).getposcircuit().size();k++)
			{
				google.put(listeCircuit.get(i).getposcircuit().get(k), listeCircuit.get(i).getidcircuit());
			}
		}
		for(int j=0; j < listeAiguillage.size();j++)
		{
			Position newPos = listeAiguillage.get(j).getPositionAiguillage();
			google.put(newPos, -1);						
		}
		
	}


	
}
