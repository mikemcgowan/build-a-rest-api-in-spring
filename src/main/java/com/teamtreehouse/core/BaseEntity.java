package com.teamtreehouse.core;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Version
  private Long version;

  protected BaseEntity() {
    id = null;
  }

}
