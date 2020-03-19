package fr.formation.inti.repository;

import fr.formation.inti.domain.Cours;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Cours entity.
 */
@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {

    @Query(value = "select distinct cours from Cours cours left join fetch cours.eleves",
        countQuery = "select count(distinct cours) from Cours cours")
    Page<Cours> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct cours from Cours cours left join fetch cours.eleves")
    List<Cours> findAllWithEagerRelationships();

    @Query("select cours from Cours cours left join fetch cours.eleves where cours.id =:id")
    Optional<Cours> findOneWithEagerRelationships(@Param("id") Long id);

}
