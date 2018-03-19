package vehicles.interf;

/**
 * Created by kleba on 16.03.2018.
 */
public interface Swim extends  Travel{
    double swim();

    @Override
    default double countSpeed(){ return  swim();};
}
