package br.com.cem01.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

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
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
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
			throw new WebApplicationException(500);
		}
	}

}
