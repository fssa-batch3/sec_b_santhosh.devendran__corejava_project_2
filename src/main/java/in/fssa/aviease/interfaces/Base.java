package in.fssa.aviease.interfaces;


import java.util.List;


import in.fssa.aviease.exception.ValidationException;

public interface Base<T> {
	
	public abstract List<T> findAll();
	public abstract void create(T t) throws ValidationException; 
	public abstract void update(int id, T t) throws ValidationException; 
	public abstract void delete(int id) throws ValidationException; 
	public abstract T findById(int id) throws ValidationException; 

}
