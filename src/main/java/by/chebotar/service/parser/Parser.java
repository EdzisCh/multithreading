package by.chebotar.service.parser;

import java.util.List;

public interface Parser<T>{

  List<T> parse(String path);
}
