package by.chebotar.service.validation;

import by.chebotar.service.exception.ShipValidationServiceException;
import java.util.List;

public interface Validator<T> {
  void isValid(List<T> objectsToValidate) throws ShipValidationServiceException;
}
