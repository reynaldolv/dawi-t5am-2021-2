package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class ProdDemo05 {

	public static void main(String[] args) {
		//obtener la conexion-> segun unidad de persistencia
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
				//CREA DAO USANDO la fabrica
				EntityManager em=fabrica.createEntityManager();
				
				//--proceso--Obtener la informacion de un Usuario
				
				Producto p= em.find(Producto.class,"P0032");//devuelve el obj Usuario segun PK
				
				if(p==null) {
					System.out.println("Código no existe");
				}else {
					System.out.println("Eliminando el Producto!!");
					em.getTransaction().begin();
					em.remove(p); //para eliminar(borrar de la tabla) / cambiar un estado
					em.getTransaction().commit();
					System.out.println("Eliminación OK");
				}
				
				em.close(); 

	}

}
