package com.teamtreehouse.review;

import com.teamtreehouse.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Review extends BaseEntity {

  private int rating;
  private String description;

  protected Review() {
    super();
  }

  public Review(int rating, String description) {
    this();
    this.rating = rating;
    this.description = description;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
