/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesRMI;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author María José
 */
public interface InterfaceCliente {
    
    public void enviar(String mensaje) throws RemoteException;
    public String getNombre() throws RemoteException;
 
}
