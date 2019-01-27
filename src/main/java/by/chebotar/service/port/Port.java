package by.chebotar.service.port;

import static by.chebotar.util.ApplicationConstants.JETTY_MAX_SHIPMENT_CAPACITY;
import static by.chebotar.util.ApplicationConstants.JETTY_START_SHIPMENT_CAPACITY;
import static by.chebotar.util.ApplicationConstants.PORT_JETTIES_CAPACITY;

import by.chebotar.bean.Jetty;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Port {

  public static volatile Port instance;
  private static final Logger LOGGER = LogManager.getLogger(Port.class);
  private final Semaphore semaphore = new Semaphore(PORT_JETTIES_CAPACITY, true);
  private final Queue<Jetty> jetties;

  private Lock lock = new ReentrantLock();

  private Port(){
    jetties = new ArrayDeque<>(PORT_JETTIES_CAPACITY);
    for (int i = 0; i < PORT_JETTIES_CAPACITY; i++) {
      jetties.add(new Jetty(JETTY_START_SHIPMENT_CAPACITY,JETTY_MAX_SHIPMENT_CAPACITY, i+1));
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

  public Jetty getJetty(){
    try{
      lock.lock();
      semaphore.acquire();
      return jetties.poll();
    } catch (InterruptedException e) {
      LOGGER.error(e);
      Thread.currentThread().interrupt();
    }finally {
      lock.unlock();
    }
    return null;
  }

  public void exemptJetty(Jetty jetty){
    try{
      lock.lock();
      jetties.add(jetty);
    } finally {
      semaphore.release();
      lock.unlock();
    }
  }


}
