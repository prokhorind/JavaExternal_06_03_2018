package vehicles.interf;

/**
 * Created by kleba on 16.03.2018.
 */
public interface Fly extends  Travel {
     double fly();

    default double countSpeed(){return  fly();};
}
