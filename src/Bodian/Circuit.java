package Bodian;
import java.util.LinkedList;

import Guoyu.Position;

public class Circuit {
	
	private int idcircuit;
	private LinkedList<Position> poscircuit;
	
	//Accesseur 
	
	public void setidcircuit(int newidcircuit) {
		idcircuit = newidcircuit;
	}
	
	public void setposcircuit(LinkedList<Position> newposcircuit) {
		poscircuit = newposcircuit;
	}
	
	public int getidcircuit() {
		return idcircuit;
	}
	
	public LinkedList<Position> getposcircuit(){
		return poscircuit;
	}
	
	//Constructeur 
	
	public Circuit(int newidcircuit , LinkedList<Position> newposcircuit) {
		this.idcircuit = newidcircuit;
		this.poscircuit = newposcircuit;
	}

	@Override
	public String toString() {
		return "Circuit [idcircuit=" + idcircuit + ", poscircuit=" + poscircuit + "]";
	}
	
	
                                                                                                                                                
}
