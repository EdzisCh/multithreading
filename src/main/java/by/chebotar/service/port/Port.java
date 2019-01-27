package by.chebotar.service.port;

import static by.chebotar.util.ApplicationConstants.JETTY_START_SHIPMENT_CAPACITY;
import static by.chebotar.util.ApplicationConstants.PORT_JETTIES_CAPACITY;

import by.chebotar.bean.Jetty;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {

  private final Semaphore SEMAPHORE = new Semaphore(PORT_JETTIES_CAPACITY, true);
  public static volatile Port instance;
  private final Queue<Jetty> jetties;
  private Lock lock = new ReentrantLock();

  private Port(){
    jetties = new ArrayDeque<>(PORT_JETTIES_CAPACITY);
    for (int i = 0; i < PORT_JETTIES_CAPACITY; i++) {
      jetties.add(new Jetty(JETTY_START_SHIPMENT_CAPACITY));
    }
  }

  public static Port getInstance(){
    Port localInstance = instance;
    if (localInstance == null){
      synchronized (Port.class){
        localInstance =instance;
        if (localInstance == null){
          instance = localInstance = new Port();
        }
      }
    }
    return instance;
  }


}
