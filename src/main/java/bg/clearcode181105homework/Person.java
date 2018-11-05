package bg.clearcode181105homework;

public class Person implements Numarable {


    private int socialNumber;


    @Override
   public int getNumber(){
        return socialNumber;
    };

    @Override
    public void setNumber( int number){
        this.socialNumber=number;
    }
}
