package by.chebotar.service.parser;

import by.chebotar.bean.Ship;
import java.util.ArrayList;
import java.util.List;

public class ShipParserFromJSON implements Parser<Ship> {

  @Override
  public List<Ship> parse(String path) {
    return new ArrayList<>();
  }
}
