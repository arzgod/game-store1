/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kodnito.gamestore1.service;

/**
 *
 * @author diego
 */
import com.kodnito.gamestore1.entity.Games;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class GameService {
    @PersistenceContext(unitName = "restapi_PU")
  EntityManager em;
    public List getAll() {
  List<Games> games = em.createNamedQuery("Games.findAll", Games.class)
.getResultList();
  return games != null ? games : new ArrayList<>();
  }
    public Games findById(Long id) {
  return em.find(Games.class, id);
  }
  @Transactional
  public void update(Games games) {
  em.merge(games);
  }
  @Transactional
  public void create(Games games) {
  em.persist(games);
  }
  @Transactional
  public void delete(Games games) {
  if (!em.contains(games)) {
  games = em.merge(games);
  }
  em.remove(games);
  }

}
