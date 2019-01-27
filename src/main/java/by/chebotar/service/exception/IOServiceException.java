package by.chebotar.service.exception;

import java.io.IOException;

public class IOServiceException extends IOException {

  public IOServiceException(IOException exception){
    super(exception);
  }

}
