import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    protected HelloImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello, world, good morning you all!";
    }

    // modified code
    @Override
    public float addition(int a, int b) throws RemoteException {
        return a + b;
    }
    @Override
    public float subtraction(int a, int b) throws RemoteException {
        return a - b;
    }
    @Override
    public float multiplication(int a, int b) throws RemoteException {
        return a * b;
    }
    @Override
    public float division(int a, int b) throws RemoteException {
        return a / b;
    }
}
