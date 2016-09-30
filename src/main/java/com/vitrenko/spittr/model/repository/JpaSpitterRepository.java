package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.Spitter;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Objects;

/**
 * Created by Vitalii_Vitrenko on 30-Sep-16.
 */
@Repository
public class JpaSpitterRepository extends JpaCrudRepository<Spitter, Long> implements SpitterRepository {

    static final String SPITTER_BY_LOGIN_QUERY = "SELECT e FROM Spitter e WHERE e.login = ?1";

    public JpaSpitterRepository() {
        super(Spitter.class);
    }


    @Override
    @Nullable
    public Spitter findByLogin(String login) {
        Objects.requireNonNull(login, "login cannot be null");
        return  getSingleResult(getEntityManager()
                .createQuery(SPITTER_BY_LOGIN_QUERY, getEntityClass())
                .setParameter(1, login)
                .getResultList());
    }
}
