/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kodnito.gamestore1.entity;

/**
 *
 * @author diego
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "games")
@NamedQueries({
  @NamedQuery(name = "Games.findAll", query = "SELECT b FROM Games b")
})
public class Games implements Serializable{
    private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String description;
  private String publisher;
  private String developer;
  private float price;
    
  public Long getId() {
  return id;
  }
  public void setId(Long id) {
  this.id = id;
  }
  public String getTitle() {
  return title;
  }
  public void setTitle(String title) {
  this.title = title;
  }
  public String getDescription() {
  return description;
  }
public void setDescription(String description) {
  this.description = description;
  }
public String getPublisher() {
  return publisher;
  }
  public void setPublisher(String publisher) {
  this.publisher = publisher;
  }
  public String getDeveloper() {
  return developer;
  }
  public float getPrice() {
  return price;
  }
  public void setPrice(float price) {
  this.price = price;
  }

}
