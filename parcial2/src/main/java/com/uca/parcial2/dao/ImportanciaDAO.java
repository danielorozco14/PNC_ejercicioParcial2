package com.uca.parcial2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.parcial2.domain.Importancia;

public interface ImportanciaDAO {
	
	public List<Importancia>findAll() throws DataAccessException;
	
	
}
