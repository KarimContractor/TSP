package tsp.dijkstra.algo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TSPDijkstraAlgo {

    //Object ArrayList for the Points, Distance Class objects and stack objects
    static List<Points> poin=new ArrayList();
    static List<Dist> distance=new ArrayList();
    static List<Stack> stl=new ArrayList<>();
    
    
    
    public static void main(String[] args) {
    
        
        //Inout file complete location
       long tst= System.nanoTime();
       //enter the complete file path in the paranthesis 
        fetchdatafile("C:\\Users\\contr.DESKTOP-IOJ5N1B\\OneDrive\\Documents\\NetBeansProjects\\TSP dijkstra Algo Main\\src\\tsp\\dijkstra\\algo\\Test 4.txt");
        calcdistance();
        Dijkstrabestfirst();
       
        
        long ted=System.nanoTime();
        //To print the runtime in nano seconds
        System.out.println(ted-tst);
    }
    public static void Dijkstrabestfirst()
    {
        //array for storing the distances
        double[] disarr=new double[poin.size()];
        //try catch for catching exceptions
        try{
            //loop for going through all posible start points
            for(Points pp: poin)
            {
                //stack to store visited cities
                Stack st=new Stack();
                int shortestid = 1;
                double di=10000000;
                double totaldist=0;
                //to get the start point for new solution
                Points p= poin.get(pp.ID-1);
                //adding the first point to stack
                st.add(p.ID);
                //going through all posible next shortest points
                for(int j=0;j<poin.size(); j++)
                {
                    for(Points ps: poin)
                    {
                        //checking if the stack has all the points
                        if(st.size()==poin.size())
                        {
                            break;
                        }
                        else
                        {
                            //checking for last shortest point
                            if(ps.ID==shortestid)
                            {
                                //going through the distance table
                                for(Dist dis: distance)
                                {//checking the distance table 
                                    if(dis.PointID==ps.ID)
                                    {
                                        //checking if the point is already in the stack
                                        if(!st.contains(dis.ConnectsID))
                                        {
                                            //checking if current distance is smaller then the last one
                                            if(dis.Distance<di)
                                            {
                                                //saving distance for later and saving the shortest id
                                                shortestid=dis.ConnectsID;
                                                di= dis.Distance;
                                                
                                            }else{}
                                        }
                                        else
                                        {}
                                    }
                                }
                                //Calculating the total distance
                                totaldist=totaldist+di;
                                //adding the shortest id to the stack
                                st.add(shortestid);
                            }
                        }
                        di=10000000;
                }
            }
                
            for(Dist dst: distance)
            {
                    if(st.get(0).equals(dst.PointID)&& st.get(1).equals(dst.ConnectsID))
                    {
                        totaldist+= dst.Distance;
           
                    }
                if(st.get(st.size()-1).equals(dst.ConnectsID) && dst.PointID==pp.ID)
                {
                    //Adding the distance from last city to first city
                    totaldist+= dst.Distance;
                    
                    
                }
            }
            //adding stack to the stack list
            stl.add(st);
            //inserting the distances to the list for later use
            disarr[pp.ID-1]=totaldist;
            //System.out.println(st.toString());
            //System.out.println(totaldist);
       }
       //Index for the stack
       int index=0;
       //variable for the storing the shortest distance
       double min=disarr[index];
       //going through stack and distance array
       for(int i=0; i<disarr.length; i++)
       {
           //checking for the minimum distance in the distance array
           if(disarr[i]<min)
           {
               min=disarr[i];
               index=i;
           }
       }
       //Printing the final solution which is minimum
        System.out.println(stl.get(index));
        System.out.println(min);
        //catching the exceptions
       }catch(Exception ex){System.out.println(ex);}
    }
    public static void calcdistance()
    {
        try{
        //Loop through all the point in class
            for(Points ps:poin)
            {
                //Loop through all the connections posible
                for(Points ds:poin)
                {
                    //Check to see if main point is same as connecting point to avaoid 0s
                    if(ps.ID==ds.ID)
                    {}
                    else
                    {
                        //Dist class object
                        Dist d= new Dist();
                        //inserting all the points to object
                        d.PointID=ps.ID;
                        d.ConnectsID=ds.ID;
                        //Calculating the distances and inserting to the object
                        d.Distance=Math.sqrt(((ps.X-ds.X)*(ps.X-ds.X))+((ps.Y-ds.Y)*(ps.Y-ds.Y)));
                        //Adding the object of distance class and inserting in the distance object list
                        distance.add(d);
                    }
                }
            }
        }catch(Exception ex){System.out.println(ex);}
    }
    public static void fetchdatafile(String filename)
    {
      //Try catch to catch the exception in the runtime.  
      try{
          //Scanner object to get the file inout of the graph
            Scanner sc=new Scanner(new File(filename));
            //Looping through the file given for the input
            while(sc.hasNextLine())
            {
                //Points class object for the data from the file
                Points p =new Points();
                //Checking the line for data and going through the line being currently read.
                if(sc.hasNext())
                {
                    //Inserting the data into the object.
                    p.ID=Integer.parseInt(sc.next());
                    p.X=Integer.parseInt(sc.next());
                    p.Y=Integer.parseInt(sc.next());
                    //Adding the object to the object's ArrayList.
                    poin.add(p);
                }
                else
                {
                    break;
                }
           }
       }
       catch(Exception ex)//catch Statment after try.
       {
           //Outputing the error from the exception to the Console.
           System.out.println("error"+ex);
       }
    }
    
}
