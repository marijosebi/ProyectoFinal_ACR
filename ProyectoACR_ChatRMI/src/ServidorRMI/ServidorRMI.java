/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorRMI;

import InterfacesRMI.InterfaceCliente;
import InterfacesRMI.InterfaceServidor;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 *
 * @author María José
 */
public class ServidorRMI extends UnicastRemoteObject implements InterfaceServidor {
    private Vector clientes;

    public ServidorRMI() throws RemoteException {
        super();
        this.clientes= new Vector();
    }
    

   
    @Override
    public void registrar(InterfaceCliente ct) throws RemoteException {
        if(ct != null) {
            this.clientes.add(ct);
            distribucionDeMensaje("El usuario " + ct.getNombre() + " se entro en el chat.");
        }
    }

    
    
     public void eliminarUsuario(InterfaceCliente cliente) throws RemoteException {
        String nombre = cliente.getNombre();
        if(this.clientes.remove(cliente)) {
            distribucionDeMensaje(nombre + " ha salido del chat.");
        }
    }
     
    // Aqui se reciben los mensajes y son enviados  tambien a el resto de los usuarios que se encuentren activos
   
    @Override
    public void distribucionDeMensaje(String menssaje) throws RemoteException {
        for (int i = 0; i < this.clientes.size(); i++) {
            InterfaceCliente cliente = (InterfaceCliente) this.clientes.get(i);
            cliente.enviar(menssaje);
        }
    }

     @Override
    public Vector obtenerClientes() throws RemoteException {
        return this.clientes;
    }
    
    
    
    
    public static void main(String args[]) {
        try {
            ServidorRMI servidor = new ServidorRMI();
            Registry rg = LocateRegistry.createRegistry(1099);
            ///Tiene que ser ifual a lo que hay en la interface
            rg.bind("servidor", servidor);
            System.out.println("EL SERVIDDOR HA SIDO ACTIVADO");
        }
        catch (AlreadyBoundException | RemoteException e) {
        }
    }

    @Override
    public void borrarCliente(InterfaceCliente cl) throws RemoteException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      String nombre = cl.getNombre();
        if(this.clientes.remove(cl)) {
            distribucionDeMensaje(nombre + " ha salido.");
        }
       
    }
    
}
