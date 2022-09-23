package com.kodnito.gamestore1.rest;

import com.kodnito.gamestore1.entity.Games;
import com.kodnito.gamestore1.service.GameService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("games")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GamesStoreEndpoint {
@Inject
  GameService gameService;
  @GET
  public Response getAll() {
  return Response.ok(gameService.getAll()).build();
  }
  @GET
  @Path("{id}")
  public Response getBook(@PathParam("id") Long id) {
  Games games = gameService.findById(id);
  return Response.ok(games).build();
  }
@POST
public Response create(Games games) {
  gameService.create(games);
  return Response.ok().build();
}
@PUT
@Path("{id}")
public Response update(@PathParam("id") Long id, Games games) {
  Games updateGames = gameService.findById(id);
  updateGames.setDescription(games.getDescription());
  updateGames.setPrice(games.getPrice());
  updateGames.setPublisher(games.getPublisher());
  updateGames.setTitle(games.getTitle());
  gameService.update(updateGames);
  return Response.ok().build();
}
@DELETE
@Path("{id}")
public Response delete(@PathParam("id") Long id) {
  Games getGames = gameService.findById(id);
  gameService.delete(getGames);
  return Response.ok().build();
}

}