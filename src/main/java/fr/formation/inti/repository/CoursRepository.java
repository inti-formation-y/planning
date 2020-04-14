package fr.formation.inti.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.formation.inti.domain.Cours;

/**
 * Spring Data  repository for the Cours entity.
 */
@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {

    @Query(value = "select distinct cours from Cours cours left join fetch cours.users",
        countQuery = "select count(distinct cours) from Cours cours")
    Page<Cours> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct cours from Cours cours left join fetch cours.users")
    List<Cours> findAllWithEagerRelationships();
    
    @Query("select cours from Cours cours join cours.users user where user.login = ?#{principal.username}")
    Page<Cours> findByUserIsCurrentUser(Pageable pageable);

    @Query("select cours from Cours cours left join fetch cours.users where cours.id =:id")
    Optional<Cours> findOneWithEagerRelationships(@Param("id") Long id);
}
