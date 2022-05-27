package Lisa;

import java.util.Objects;

public class PositionGraphique {
	
	private double posX;
	private double posY;
	
	public PositionGraphique(double posX, double posY) 
	{
		this.posX = posX;
		this.posY = posY;
	}
	
	public double getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public String toString() {
		return "Position [posX=" + posX + ", posY=" + posY + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(posX, posY);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PositionGraphique other = (PositionGraphique) obj;
		return posX == other.posX && posY == other.posY;
	}
	
	
	
}
