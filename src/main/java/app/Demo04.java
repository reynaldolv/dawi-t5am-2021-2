package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	public static void main(String[] args) {
		//obtener la conexion-> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREA DAO USANDO la fabrica
		EntityManager em=fabrica.createEntityManager();
		
		//--proceso--Obtener la informacion de un Usuario
		
		Usuario u= em.find(Usuario.class,20);//devuelve el obj Usuario segun PK
		
		if(u==null) {
			System.out.println("Código no existe");
		}else {
			System.out.println("Bienvenido: "+u.getNombre());
			System.out.println(u);
		}
		
		em.close(); 
		
		
	}
}
