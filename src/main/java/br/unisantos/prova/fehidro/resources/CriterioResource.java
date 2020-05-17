package br.unisantos.prova.fehidro.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.unisantos.prova.fehidro.model.Criterio;
import br.unisantos.prova.fehidro.model.dao.DAO;
import br.unisantos.prova.fehidro.util.jpa.JPAEntityManager;

@Path("/criterios")
public class CriterioResource implements ResourcesInterface<Criterio> {

	@Override
	@GET
	@Produces("application/json")
	public Response getAll() {
		DAO<Criterio> dao = new DAO<>(Criterio.class);
		List<Criterio> _criterios = dao.listarGenerico("Criterio.listarTodos");		
		return Response.ok(_criterios).build();
	}

	@Override
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getById(@PathParam("id") Long id) {
		DAO<Criterio> dao = new DAO<>(Criterio.class);
		Criterio _criterio = dao.consultarGenerico("Criterio.consultarPorId", id);
		if (_criterio != null) {
			return Response.ok(_criterio).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/pontuacao")
	@Produces("application/json")
	public Response getPontuacao() {
		EntityManager manager = JPAEntityManager.getEntityManager();
		TypedQuery<Long> _query = manager.createNamedQuery("Criterio.consultarPontuacao", Long.class);
		Long _pontuacao = _query.getSingleResult();
		return Response.ok(_pontuacao).build();
	}
	
	@GET
	@Path("/subcriterios/{id}")
	@Produces("application/json")
	public Response getSubCriterios(@PathParam("id") Long id) {
		DAO<Criterio> dao = new DAO<>(Criterio.class);
		List<Criterio> _criterios = dao.listarGenerico("Criterio.listarSubCriterios", id);		
		return Response.ok(_criterios).build();
	}

	@Override
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response post(Criterio obj) {
		DAO<Criterio> dao = new DAO<>(Criterio.class);
		dao.adicionar(obj);
		return Response.ok(obj).build();
	}

	@Override
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response put(Criterio obj) {
		DAO<Criterio> dao = new DAO<>(Criterio.class);
		dao.alterar(obj);
		return Response.ok(obj).build();
	}

	@Override
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") Long id) {
		DAO<Criterio> dao = new DAO<>(Criterio.class);
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
