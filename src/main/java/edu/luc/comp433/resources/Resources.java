package edu.luc.comp433.resources;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class Resources {
	@Produces
	@PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "WS")
	private EntityManager em;

	public EntityManager produceEntityManager() {
		return em;
	}

	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass()
				.getName());
	}

}
