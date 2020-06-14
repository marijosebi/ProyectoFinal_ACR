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
public interface InterfaceServidor {
        public void registrar(InterfaceCliente cliente) throws RemoteException;
         public void distribucionDeMensaje(String msj) throws RemoteException;
         public void borrarCliente(InterfaceCliente cliente) throws RemoteException;

         //Se utilxara el vector para poner los usuarios que se conecten enel chat
        public Vector obtenerClientes() throws RemoteException;
}
