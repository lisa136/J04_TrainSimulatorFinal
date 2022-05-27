package Bodian;

import java.util.LinkedList;
import java.util.Objects;

import Guoyu.Position;

public class Wagon 
{



	private Position posWagon;
	private Position posWagonAvant;
	private int idCircuitCorrespondant;

	
	public Wagon(Position posWagon, int idCircuitCorrespondant) 
	{
		this.posWagon = posWagon;
		this.idCircuitCorrespondant = idCircuitCorrespondant;
	}

	public Position getPosWagon() {
		return posWagon;
	}

	public void setPosWagon(Position posWagon) {
		this.posWagon = posWagon;
	}
	
	public Position getPosWagonAvant() 
	{
		return posWagonAvant;
	}

	public void setPosWagonAvant(Position posWagon) 
	{
		this.posWagonAvant = posWagon;
	}

	public int getIdCircuitCorrespondant() {
		return idCircuitCorrespondant;
	}

	public void setIdCircuitCorrespondant(int idCircuitCorrespondant) {
		this.idCircuitCorrespondant = idCircuitCorrespondant;
	}	
	
	@Override
	public int hashCode() {
		return Objects.hash(idCircuitCorrespondant, posWagon, posWagonAvant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wagon other = (Wagon) obj;
		return idCircuitCorrespondant == other.idCircuitCorrespondant && Objects.equals(posWagon, other.posWagon)
				&& Objects.equals(posWagonAvant, other.posWagonAvant);
	}

	@Override
	public String toString() {
		return "Wagon [posWagon=" + posWagon + ", posWagonAvant=" + posWagonAvant + ", idCircuitCorrespondant="
				+ idCircuitCorrespondant + "]";
	}
	
}
