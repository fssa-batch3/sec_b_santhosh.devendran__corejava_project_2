package in.fssa.aviease.interfaces;

import java.util.List;
import in.fssa.aviease.exception.PersistenceException;

public interface Base<T> {

	public abstract List<T> findAll() throws PersistenceException;
	public abstract void create(T t) throws PersistenceException; 
	public abstract void update(int id, T t) throws PersistenceException; 
	public abstract void delete(int id) throws PersistenceException; 
	public abstract T findById(int id) throws PersistenceException;
	 

}