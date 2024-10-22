import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
    // moddified code
    float addition(int a, int b) throws RemoteException;
    float subtraction(int a, int b) throws RemoteException;
    float multiplication(int a, int b) throws RemoteException;
    float division(int a, int b) throws RemoteException;
}
