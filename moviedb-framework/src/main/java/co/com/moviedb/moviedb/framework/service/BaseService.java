package co.com.moviedb.moviedb.framework.service;

import java.lang.reflect.ParameterizedType;

import co.com.moviedb.moviedb.framework.repository.BaseApiRepository;

public class BaseService <B extends BaseApiRepository> {
	
	private B repository;
	
	
	@SuppressWarnings("unchecked")
	public BaseService() {
		setupRepository(
					(Class<B>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
				);
	}

	private void setupRepository( Class<B> repositoryClass) {
		if( null == repository ) {
			synchronized (BaseService.class) {
				if ( null == repository ) {
					try {
						setRepository(repositoryClass.getDeclaredConstructor().newInstance());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		
	}

	/**
	 * @return the repository
	 */
	public B getRepository() {
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(B repository) {
		this.repository = repository;
	}
	
	

}
