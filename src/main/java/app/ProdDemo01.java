package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;


public class ProdDemo01 {
	public static void main(String[] args) {
		//obtener la conexion-> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREA DAO USANDO la fabrica
		EntityManager em=fabrica.createEntityManager();
		
		//--proceso--registar Usuario
		
		Producto p=new Producto();
		p.setIdprod("P0032");
		p.setDescripcion("Prueba");
		p.setStock(10);
		p.setPrecio(2.50);
		p.setIdcategoria(4);
		p.setEstado(1);
		
		// para reg, actu, eli-> Transacciones
		
		em.getTransaction().begin();
		em.persist(p);//para registrar
		em.getTransaction().commit();
		System.out.println("Registro Ok");
		
		em.close(); 
		
		
		
		
		
		
		
		
		
	}


}
