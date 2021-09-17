package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Usuario;

public class Demo09 {
	public static void main(String[] args) {
		//obtener la conexion-> segun unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//CREA DAO USANDO la fabrica
		EntityManager em=fabrica.createEntityManager();
		
		//Validar un Usuario según usuario y clave-> usando procedimiento almacenados
		
		//String sql2= "{call usp_validaAcceso(:xusr, :xcla)}";//JPA
		String sql2= "{call usp_validaAcceso(?, ?)}";
		
		//TypedQuery<Usuario> query=em.createQuery(sql2,Usuario.class); JPA
		Query query=em.createNativeQuery(sql2,Usuario.class); //Object
		//query.setParameter("xusr", "U002@gmail.com");
		//query.setParameter("xcla", "10002");
		
		query.setParameter(1, "U002@gmail.com");
		query.setParameter(2, "10002");
		
		Usuario u=null;
		try {
			u =(Usuario) query.getSingleResult();
		} catch (Exception e) {
			
		}
		
		if(u==null) {
			System.out.println("Código no existe");
		}else {
			System.out.println("Bienvenido: "+u.getNombre());
			System.out.println(u);
		}
		
		em.close(); 
		
		
	}
}
