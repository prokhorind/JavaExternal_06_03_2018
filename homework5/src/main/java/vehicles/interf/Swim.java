package vehicles.interf;

public interface Swim extends Travel{
    double swim();

    @Override
    default double countSpeed(){ return swim();}
}
