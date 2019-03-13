package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.naming.*;

import download.Warehouse;

import java.util.*;

public class WarehouseClient {

	public static void main(String[] args) throws NamingException, RemoteException, NotBoundException{
		
		
		Registry registry = LocateRegistry.getRegistry();
		
		System.out.println("RMI registry binding");
		String[] e = registry.list();
		
		for(int i = 0; i < e.length;i++){
			System.out.println(e[i]);
		}
		
		String remoteOjectName = "central_warehouse";
		Warehouse centralWarehouse =(Warehouse)registry.lookup(remoteOjectName);
		
	
		String desrc = "BlackWell Toaster";
		double price = centralWarehouse.getPrice(desrc);
		
		System.out.println(desrc+ ":"+price);
		
	}
	
}
