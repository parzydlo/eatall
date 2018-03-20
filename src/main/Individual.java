package main;

public class Individual extends Customer{
    private int individualID;

    public Individual(String fn, String ln, int id){
        super(fn, ln, id);
        individualID=id;
    }
    public int getIndividualID(){
        return individualID;
    }
}
