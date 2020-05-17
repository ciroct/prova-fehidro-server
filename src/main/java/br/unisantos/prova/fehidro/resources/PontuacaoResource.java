package br.unisantos.prova.fehidro.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.unisantos.prova.fehidro.model.Pontuacao;
import br.unisantos.prova.fehidro.model.dao.DAO;

@Path("/pontuacoes")
public class PontuacaoResource implements ResourcesInterface<Pontuacao> {

	@Override
	public Response getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getById(@PathParam("id") Long id) {
		DAO<Pontuacao> dao = new DAO<>(Pontuacao.class);
		Pontuacao _pontuacao = dao.consultarGenerico("Pontuacao.consultarPorId", id);
		if (_pontuacao != null) {
			return Response.ok(_pontuacao).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/criterio/{id}")
	@Produces("application/json")
	public Response getByPreComunidade(@PathParam("id") Long id) {
		DAO<Pontuacao> dao = new DAO<>(Pontuacao.class);
		List<Pontuacao> _pontuacao = dao.listarGenerico("Pontuacao.listarPorCriterio", id);		
		return Response.ok(_pontuacao).build();
	}

	
	@Override	
	public Response post(Pontuacao obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response put(Pontuacao obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
