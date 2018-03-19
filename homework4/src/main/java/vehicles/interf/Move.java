package vehicles.interf;

/**
 * Created by kleba on 16.03.2018.
 */
public interface Move extends  Travel{
   double move();

   @Override
   default double countSpeed(){ return move();};
}
