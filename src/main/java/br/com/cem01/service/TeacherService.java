package br.com.cem01.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.cem01.EntityManager.JpaEntityManager;
import br.com.cem01.model.DisciplineModel;
import br.com.cem01.model.TeacherModel;

@Path("/teacher")
public class TeacherService {

//	private JpaEntityManager JPAEM = new JpaEntityManager();
//	private EntityManager objEM = JPAEM.getEntityManager();
//	
//	
//	@GET
//	@Path("list")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<TeacherModel> getTeacherList() {
//		try {
//			String query = "select c from TeacherModel c";
//			List<TeacherModel> teacherList = objEM.createQuery(query, TeacherModel.class).getResultList();
//			objEM.close();
//			return teacherList;
//		} catch (Exception e) {
//			throw new WebApplicationException(500);
//		}
//	}
//	
//	@POST
//	@Path("add")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response cadastrar(TeacherModel objTeacher) {
//		try {
//			objEM.getTransaction().begin();
//			objEM.persist(objTeacher);
//			objEM.getTransaction().commit();
//			objEM.close();
//			return Response.status(200).entity("cadastro realizado.").build();
//		} catch (Exception e) {
//			throw new WebApplicationException(500);
//		}
//	}
	
}
