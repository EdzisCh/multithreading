package by.chebotar.service.parser;

import by.chebotar.service.exception.ShipValidationServiceException;
import java.util.List;

public interface Parser<T>{

  List<T> parse(String path) throws ShipValidationServiceException;
}
