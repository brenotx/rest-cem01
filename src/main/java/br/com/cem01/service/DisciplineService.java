package br.com.cem01.service;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
//import javax.validation.ConstraintViolationException;
import javax.persistence.PersistenceException;
import org.hibernate.exception.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.hibernate.QueryException;

import br.com.cem01.EntityManager.JpaEntityManager;
import br.com.cem01.model.DisciplineModel;


@Path("/discipline")
public class DisciplineService {
	
	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();
	
	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	public Response cadastrar(DisciplineModel objDiscipline) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objDiscipline);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro realizado.").build();
		} catch (PersistenceException e) {
			String msgError = e.getCause().getMessage();
			objEM.close();
			return Response.serverError().status(javax.ws.rs.core.Response.Status.NOT_ACCEPTABLE).entity(msgError).build();
		}
	}
	
//	@POST
//	@Path("/cadastrar")
//	@Consumes("application/json")
//	public Response cadastrar(DisciplineModel objDiscipline) {
//		try {
////			String code1 = objDiscipline.getCode();
////			String query = "select p from DisciplineModel p where p.code = " + code1;
////
////			// IllegalArgumentException
////			TypedQuery<DisciplineModel> discipline = objEM.createQuery(query, DisciplineModel.class);
////
////			try {
////				discipline.getSingleResult().getCode();
////				System.out.println("Achou!");
////				return Response.serverError().status(javax.ws.rs.core.Response.Status.BAD_REQUEST).entity("Disciplina ja cadastrada.").build();
////			} catch (NoResultException e) {
//				objEM.getTransaction().begin();
//				objEM.persist(objDiscipline);
//				objEM.getTransaction().commit();
//				objEM.close();
//				
//				System.out.println("N achou!");
//				return Response.status(200).entity("cadastro realizado.").build();
////			}
//			
////			CriteriaBuilder cb = objEM.getCriteriaBuilder();
////			CriteriaQuery<DisciplineModel> cq = cb.createQuery(DisciplineModel.class);
////			Root<DisciplineModel> from = cq.from(DisciplineModel.class);
////			cq.select(DisciplineModel);
////			Predicate eq2 = cb.equal(code, 35628);
////			
//		} catch (PersistenceException e) {
////			throw new ConstraintViolationException(e);
//			String msgError = e.getCause().getMessage();
//			objEM.close();
//			return Response.serverError().status(javax.ws.rs.core.Response.Status.BAD_REQUEST).entity(msgError).build();
//		}
//	}
	
	@GET
	@Path("listar")
	@Produces("application/json")
	public List<DisciplineModel> listar() {
		try {
			String query = "select c from DisciplineModel c";
			List<DisciplineModel> alunos = objEM.createQuery(query, DisciplineModel.class).getResultList();
			objEM.close();
			return alunos;
		} catch (Exception e) {
			throw new QueryException(e);
		}
	}
	
//	@GET
//	@Path("listar2")
//	@Produces("application/json")
//	public Response listar2() {
//		try {
//			String query = "select c from DisciplineModel c";
//			List<DisciplineModel> alunos = objEM.createQuery(query, DisciplineModel.class).getResultList();
//			GenericEntity<List<DisciplineModel>> entity = new GenericEntity<List<DisciplineModel>>(alunos){};
//			objEM.close();
//			return Response.ok(entity).build();
//		} catch (Exception e) {
//			throw new WebApplicationException(500);
//		}
//	}

}
