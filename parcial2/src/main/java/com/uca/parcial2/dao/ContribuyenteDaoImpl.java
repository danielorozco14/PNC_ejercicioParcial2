package com.uca.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.parcial2.domain.Contribuyente;

@Repository
public class ContribuyenteDaoImpl implements ContribuyenteDAO {
	
	@PersistenceContext(unitName="parcial2")
	public EntityManager entityManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		//sb.append("SELECT * FROM PUBLIC.CONTRIBUYENTE;");//SINO FUNCIONA QUITAR ';' A LA QUERY
		//I.s_importancia AS c_importancia
		sb.append("SELECT C.c_contribuyente,C.c_importancia,C.s_nombre,C.s_apellido,C.s_nit,C.f_fecha_ingreso\n" + 
				"FROM contribuyente C INNER JOIN importancia I \n" + 
				"ON C.c_importancia=I.c_importancia;");
		Query query = entityManager.createNativeQuery(sb.toString(),Contribuyente.class);
		List <Contribuyente> result= query.getResultList();
		return result;
	}

	@Override
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		entityManager.persist(contribuyente);
		
	}

}
