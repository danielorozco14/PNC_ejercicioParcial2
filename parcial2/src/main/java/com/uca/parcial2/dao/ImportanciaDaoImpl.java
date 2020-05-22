package com.uca.parcial2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.parcial2.domain.Importancia;

@Repository
public class ImportanciaDaoImpl implements ImportanciaDAO {
	
	@PersistenceContext(unitName="parcial2")
	public EntityManager entityManager;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM PUBLIC.IMPORTANCIA;");//SINO FUNCIONA QUITAR ';' A LA QUERY
		Query query = entityManager.createNativeQuery(sb.toString(),Importancia.class);
		List <Importancia> result= query.getResultList();
		return result;
	}

}
