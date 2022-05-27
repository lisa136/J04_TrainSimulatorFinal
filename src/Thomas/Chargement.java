package Thomas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFileChooser;

import Bodian.Circuit;
import Guoyu.Aguillage;
import Guoyu.Position;

public class Chargement {
	


	private int nombreDeCircuit;
	private LinkedList<Circuit> circ;
	private LinkedList<Aguillage> listeAiguillage;
	private int tailleX;
	private int tailleY;
	
	public Chargement()
	{
		circ = new LinkedList<>();
		listeAiguillage = new LinkedList<>();
	}
	
	public int getTailleX() {
		return tailleX;
	}

	public void setTailleX(int tailleX) {
		this.tailleX = tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}

	public void setTailleY(int tailleY) {
		this.tailleY = tailleY;
	}
	public LinkedList<Circuit> getCirc(){
		return circ;
	}
	
	public LinkedList<Aguillage> getAig(){
		return listeAiguillage;
	}
	
	public void charger(int levelChoose)
	{
		String file = "Level/Level" + levelChoose + "VF.csv";
		System.out.println(levelChoose);
		System.out.println(file);
		lectureTaille(file);
		lectureCircuit(file);
		lectureAiguillage(file);
		lecturePlateau(file);
	}
	
	public String fichierSelect() {
		String s;
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Choisir un fichier");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(true);
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		   s=chooser.getSelectedFile().toString();
		} else {
		   System.out.println("No Selection ");
		   s="";
		}
		return s;
		}
	
	public void lectureCircuit(String nomfichier) 
	{
	    try
	    {
	        BufferedReader entree = new BufferedReader(new FileReader(nomfichier));
	        String ligne = "";
	        entree.readLine();
	        entree.readLine();
	        int tailleCircuit = this.lectureTaille(nomfichier) ;
	        int idCircuit = 0;
	        LinkedList<Position> pos = new LinkedList<>();
	        Circuit newCircuit;
	        Position newPos;
	        while ((ligne = entree.readLine()) != null) 
	        {
	        	//traitement de la ligne
	        	//System.out.println(ligne);
	        	String[] tab  = ligne.split(";");
	        	
	        	
	        		if(Integer.valueOf(tab[0]) == idCircuit && !tab[0].equals("-1")) 
	        		{
	        			newPos = new Position( Integer.valueOf(tab[1]) , Integer.valueOf(tab[2]) );
	        			pos.add(newPos);
	        		}
	        		
	        		else 
	        		{
	        			if(idCircuit == tailleCircuit-1 && tab[0].equals("-1")) {
	        				newCircuit = new Circuit(idCircuit , pos );
	        				circ.add(newCircuit);
	        				idCircuit += 1;
	        			}
	        			if(!tab[0].equals("-1"))
	        			{
	        				newCircuit = new Circuit(idCircuit , pos );
	        				idCircuit += 1;
	        				pos = new LinkedList<>();
	        				newPos = new Position( Integer.valueOf(tab[1]) , Integer.valueOf(tab[2]) );
	        				pos.add(newPos);
	        				circ.add(newCircuit);
	        			}
	        		
	        		}	
	        }
	        
	        entree.close();
	    } catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	 }
	   
	
	public void lectureAiguillage(String nomfichier) 
	{
	    try
	    {
	        BufferedReader entree = new BufferedReader(new FileReader(nomfichier));
	        String ligne = "";
	        
	        Position newPos;
	        Position initpos = new Position(0 , 0);
	        Aguillage aiguillage;
	        
	        LinkedList<Aguillage> newAguillage = new LinkedList<>();
	        
	        while ((ligne = entree.readLine()) != null) 
	        {
	        	//traitement de la ligne
	        	//System.out.println(ligne);
	        	String[] tab  = ligne.split(";");
	        	if(tab[0].equals("-1")) 
	        	{
	        		newPos = new Position(Integer.valueOf(tab[1]), Integer.valueOf(tab[2]));
	        		aiguillage = new Aguillage(initpos);
        			aiguillage.setPositionAiguillage(newPos);
        			listeAiguillage.add(aiguillage);
	        	}  	
	        }
	        entree.close();
	        
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	 }
	
	public int lectureTaille(String nomfichier) {
	    try{
	    	
	        BufferedReader entree = new BufferedReader(new FileReader(nomfichier));
	        String ligne =  entree.readLine();
	       	int nombreDeLigne = 1;
	        while (ligne != null && nombreDeLigne <= 2) {
	        	if (ligne != null)
	        	{
	        		//traitement de la ligne
	        		String[] tab  = ligne.split(";");
	        		nombreDeCircuit = Integer.valueOf(tab[0]);
	        		nombreDeLigne += 1;
	        	}
	        	ligne = entree.readLine();
	        }
	        entree.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return nombreDeCircuit;
	 }
	
	public void lecturePlateau(String nomfichier)
	{
		try{
	        BufferedReader entree = new BufferedReader(new FileReader(nomfichier));
	        String ligne = "";
	        while ((ligne = entree.readLine()) != null) {
	          //traitement de la ligne
	        	String[] tab  = ligne.split(";");
	        	if( Integer.valueOf(tab[0])>10)
	        	{
	        		setTailleX(Integer.valueOf(tab[0]));
	        		setTailleY(Integer.valueOf(tab[1]));
	        	}	
	        }
	        entree.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	 }	
}
