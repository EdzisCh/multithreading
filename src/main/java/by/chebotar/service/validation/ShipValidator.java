package by.chebotar.service.validation;

import by.chebotar.bean.Ship;
import by.chebotar.service.exception.ShipValidationServiceException;
import java.util.List;

public class ShipValidator implements Validator<Ship>{

  @Override
  public void isValid(List<Ship> ships) throws ShipValidationServiceException {
    for (Ship ship : ships) {
      if (ship.getMaxCapacity() < 0 || ship.getShipment() < 0) {
        throw new ShipValidationServiceException("maxCapacity parameter cannot be negative");
      } else if (ship.getMaxCapacity() < ship.getShipment()){
        throw new ShipValidationServiceException("Shipment cannot be greater then maxCapacity of ship");
      }
    }
  }
}
