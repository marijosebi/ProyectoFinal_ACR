/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteRMI;

import InterfacesRMI.InterfaceCliente;
import java.rmi.RemoteException;

/**
 *
 * @author María José
 */
public class ClienteRMI implements InterfaceCliente {
    private Cliente GUI;
    private String nombre;
    

    public ClienteRMI(String name) throws RemoteException {
       // super();
        this.nombre = name;
    }
    
    
    public void enviar(String msj) throws RemoteException {
        this.GUI.verMensajes(msj);
    }
    
    public String getNombre() throws RemoteException {
        return this.nombre;
    }
    
    public void setInterfaceGrafica(Cliente cliente) {
        this.GUI = cliente;
    }
    
    

   

}
