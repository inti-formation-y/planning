package fr.formation.inti.config;

import java.time.Duration;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.hibernate.cache.jcache.ConfigSettings;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.jhipster.config.JHipsterProperties;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, fr.formation.inti.repository.UserRepository.USERS_BY_LOGIN_CACHE);
            createCache(cm, fr.formation.inti.repository.UserRepository.USERS_BY_EMAIL_CACHE);
            createCache(cm, fr.formation.inti.domain.User.class.getName());
            createCache(cm, fr.formation.inti.domain.Authority.class.getName());
            createCache(cm, fr.formation.inti.domain.User.class.getName() + ".authorities");
            createCache(cm, fr.formation.inti.domain.Cours.class.getName());
            createCache(cm, fr.formation.inti.domain.Cours.class.getName() + ".videos");
            createCache(cm, fr.formation.inti.domain.Video.class.getName());
            createCache(cm, fr.formation.inti.domain.Eleve.class.getName());
            createCache(cm, fr.formation.inti.domain.Eleve.class.getName() + ".cours");
            createCache(cm, fr.formation.inti.domain.Cours.class.getName() + ".eleves");
            createCache(cm, fr.formation.inti.domain.Cours.class.getName() + ".users");
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache == null) {
            cm.createCache(cacheName, jcacheConfiguration);
        }
    }

}
