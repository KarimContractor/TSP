/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.dijkstra.algo;

/**
 *
 * @author contr
 */
public class Points {
    public int ID;
    public  double X;
    public  double Y;

    Points() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getID(){return ID;}
    public void setID(int id){ID=id;}
    
    public double getX(){return X;}
    public void setX(int x){X=x;}
    
    public double getY(){return Y;}
    public void setY(int y){Y=y;}

    
}
