package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class ProdDemo03 {

	public static void main(String[] args) {
		//obtener la conexion-> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREA DAO USANDO la fabrica
		EntityManager em=fabrica.createEntityManager();
		
		//--proceso--Eliminar un Produto
		
		Producto p=new Producto();
		p.setIdprod("P0032");
		
		
		// para reg, actu, eli-> Transacciones
		
		em.getTransaction().begin();
		em.remove(p);//para eliminar(borrar de la tabla)/cambiar un estado
		em.getTransaction().commit();
		System.out.println("Eliminación Ok");
		
		em.close(); 

	}

}
