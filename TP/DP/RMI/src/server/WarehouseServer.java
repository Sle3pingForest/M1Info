package server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.NamingException;


public class WarehouseServer {
	
	public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException{
		
		System.out.print("Construction server implementation...");
		
		WarehouseImpl centralWarehouse = new WarehouseImpl();
		
		System.out.println("Dinding server implementation to registry...");
		Registry registry = LocateRegistry.getRegistry();
		registry.bind("central_warehouse", centralWarehouse);
		
		System.out.println("Waiting for invocations from clients...");
	}

}
