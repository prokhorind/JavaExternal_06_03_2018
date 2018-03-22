package vehicles.interf;

public interface Move extends  Travel{

   double move();

   @Override
   default double countSpeed(){ return move();}
}
