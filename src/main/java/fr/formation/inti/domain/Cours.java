package fr.formation.inti.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Cours.
 */
@Entity
@Table(name = "cours")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    private String titre;

    @NotNull
    @Column(name = "date_ajout", nullable = false)
    private ZonedDateTime dateAjout;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "cours_eleve",
               joinColumns = @JoinColumn(name = "cours_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "eleve_id", referencedColumnName = "id"))
    private Set<Eleve> eleves = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public Cours titre(String titre) {
        this.titre = titre;
        return this;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ZonedDateTime getDateAjout() {
        return dateAjout;
    }

    public Cours dateAjout(ZonedDateTime dateAjout) {
        this.dateAjout = dateAjout;
        return this;
    }

    public void setDateAjout(ZonedDateTime dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Set<Eleve> getEleves() {
        return eleves;
    }

    public Cours eleves(Set<Eleve> eleves) {
        this.eleves = eleves;
        return this;
    }

    public Cours addEleve(Eleve eleve) {
        this.eleves.add(eleve);
        eleve.getCours().add(this);
        return this;
    }

    public Cours removeEleve(Eleve eleve) {
        this.eleves.remove(eleve);
        eleve.getCours().remove(this);
        return this;
    }

    public void setEleves(Set<Eleve> eleves) {
        this.eleves = eleves;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cours)) {
            return false;
        }
        return id != null && id.equals(((Cours) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Cours{" +
            "id=" + getId() +
            ", titre='" + getTitre() + "'" +
            ", dateAjout='" + getDateAjout() + "'" +
            "}";
    }
}
