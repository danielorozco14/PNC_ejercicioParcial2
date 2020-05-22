package com.uca.parcial2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;

import com.uca.parcial2.domain.Contribuyente;

public interface ContribuyenteDAO {

	public List<Contribuyente> findAll() throws DataAccessException;
	
	@Transactional
	public void insert(Contribuyente contribuyente) throws DataAccessException;
	
}
