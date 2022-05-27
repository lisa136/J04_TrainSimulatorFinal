package Guoyu;

public class Gare{
    private int idGare;
    private Position posGare;

public Gare (int idGare, Position posGare){
    this.idGare=idGare;
    this.posGare=posGare;
 }

public int getIdGare() {
    return idGare;
 }

public void setGare(int idGare) {
    this.idGare=idGare;
 }

public Position getPosGare() {
    return posGare;
 }

public void setPosGare(Position posGare) {
    this.posGare = posGare;
 }
}