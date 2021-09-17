package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {
	public static void main(String[] args) {
		//obtener conexion
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("mysql");
		//crea los DAO usando fabrica
		EntityManager em=fabrica.createEntityManager();
		
		//Proceso listado de Usuarios
		System.out.println("--Listado de los Usuarios--");
		
		//String sql="select*from tb_usuarios";// <-JDBC
		String sql="select u from Usuario u";//JPA//
		List<Usuario> lstUsuarios=em.createQuery(sql,Usuario.class).getResultList();
		System.out.println("Cantidad de usuarios:"+ lstUsuarios.size());
		for( Usuario u: lstUsuarios) {
			System.out.println(">>>"+ u);
		}

		System.out.println("--Listado de los Usuarios x tipo --");
		
		String sql2="select u from Usuario u where u.tipo= :xtipo";//JPA
		
		TypedQuery<Usuario> query=em.createQuery(sql2,Usuario.class);
		query.setParameter("xtipo", 1);
		
		List<Usuario> lstUsuarios2=query.getResultList();
		
		System.out.println("Cantidad de Usuarios: "+ lstUsuarios2.size());
		for(Usuario u:lstUsuarios2) {
			System.out.println(">>>"+u);
		}
		em.close();
		

	}
}
