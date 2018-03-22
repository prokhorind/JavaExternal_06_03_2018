package vehicles.interf;

public interface Fly extends  Travel {
    double fly();
    default double countSpeed(){return  fly();}
}
