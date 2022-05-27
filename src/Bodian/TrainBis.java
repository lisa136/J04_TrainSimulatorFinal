package Bodian;
import java.util.LinkedList;
import java.util.Objects;

public class TrainBis 
{	
		private int idtrain;
		private int taille;
		private int retard;
		private LinkedList<Wagon> wagon;
		private boolean dessinTrain = false;
		
		public TrainBis(int idtrain, int taille, int retard, LinkedList<Wagon> wagonParam) 
		{
			this.idtrain = idtrain;
			this.taille = taille;
			this.retard = retard;
			wagon = wagonParam;
		}
		
		public int getIdtrain() {
			return idtrain;
		}
		public void setIdtrain(int idtrain) {
			this.idtrain = idtrain;
		}
		public int getTaille() {
			return taille;
		}
		public void setTaille(int taille) {
			this.taille = taille;
		}
		public int getRetard() {
			return retard;
		}
		public void setRetard(int retard) {
			this.retard = retard;
		}
		
		public LinkedList<Wagon> getListWagon()
		{
			return this.wagon;
		}
		
		public void setListWagon(LinkedList<Wagon> wagonParam)
		{
			this.wagon = wagonParam;
		}
		public boolean getDessinTrain() {
			return dessinTrain;
		}

		public void setDessinTrain(boolean dessinTrain) {
			this.dessinTrain = dessinTrain;
		}
		 
		@Override
		public String toString() {
			return "TrainBis [idtrain=" + idtrain + ", taille=" + taille + ", retard=" + retard + ", wagon=" + wagon + "]";
		}
		
		@Override
	public int hashCode() {
		return Objects.hash(idtrain, retard, taille, wagon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainBis other = (TrainBis) obj;
		return idtrain == other.idtrain && retard == other.retard && taille == other.taille
				&& Objects.equals(wagon, other.wagon);
	}
		
}
