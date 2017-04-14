package me.farhan.springdrop.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "folders", schema = "public")
public class Folder {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "folder_name")
  @NotNull
  private String folderName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(cascade={CascadeType.ALL})
  @JoinColumn(name="parent_id")
  private Folder parent;

  @OneToMany(mappedBy="parent")
  private Set<Folder> ancestors = new HashSet<Folder>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Folder getParent() {
    return parent;
  }

  public void setParent(Folder parent) {
    this.parent = parent;
  }

  public Set<Folder> getAncestors() {
    return ancestors;
  }

  public void setAncestors(Set<Folder> ancestors) {
    this.ancestors = ancestors;
  }

  public String getFolderName() {
    return folderName;
  }

  public void setFolderName(String folderName) {
    this.folderName = folderName;
  }
}
