package Guoyu;

import java.util.Objects;

public class Position {
	
	private int posX;
	private int posY;
	
	public Position(int posX, int posY) 
	{
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
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
		Position other = (Position) obj;
		return posX == other.posX && posY == other.posY;
	}
	
	
	
}
