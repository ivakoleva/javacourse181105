package bg.clearcode181105homework;

public class Company implements Numarable {

    private int registrationNumber;

    @Override

    public int getNumber() {
        return registrationNumber;
    }

    @Override
    public void setNumber(int number){
        this.registrationNumber = number;}
}