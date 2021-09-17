package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	public static void main(String[] args) {
		//obtener la conexion-> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREA DAO USANDO la fabrica
		EntityManager em=fabrica.createEntityManager();
		
		//--proceso--Eliminar un Usuario
		
		Usuario u=new Usuario();
		u.setCodigo(20);
		
		
		// para reg, actu, eli-> Transacciones
		
		em.getTransaction().begin();
		em.remove(u);//para eliminar(borrar de la tabla)/cambiar un estado
		em.getTransaction().commit();
		System.out.println("Eliminación Ok");
		
		em.close(); 
		

		
	}
}
