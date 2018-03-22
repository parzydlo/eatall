package main;

public class Individual extends Customer{
    private int individualID;

    public Individual(String fn, String ln, String un, String pw, int id){
        super(fn, ln, un, pw, id);
        individualID=id;
    }
    public int getIndividualID(){
        return individualID;
    }
}
