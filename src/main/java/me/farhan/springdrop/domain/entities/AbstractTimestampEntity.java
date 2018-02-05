package me.farhan.springdrop.domain.entities;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractTimestampEntity {

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "creatd_at", nullable = false)
  private Date created;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false)
  private Date updated;

  @PrePersist
  protected void onCreate() {
    updated = created = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updated = new Date();
  }
}
