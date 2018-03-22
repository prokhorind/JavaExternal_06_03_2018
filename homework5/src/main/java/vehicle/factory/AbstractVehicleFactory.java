package vehicle.factory;

import vehicles.interf.interfimpl.transport.Vehicle;

/**
 * Created by kleba on 16.03.2018.
 */
public interface AbstractVehicleFactory {
     Vehicle getVehicle(int n);
     Vehicle randVehicle();
}
