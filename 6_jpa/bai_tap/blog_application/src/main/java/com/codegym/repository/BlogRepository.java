package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entity;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entity.createQuery("select c from blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        TypedQuery<Blog> query = entity.createQuery("select c from blog c where  c.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Blog model) {
        if (model != null) {
            entity.merge(model);
        } else {
            entity.persist(model);
        }
    }

    @Override
    public void remove(int id) {
        Blog blog = findById(id);
        if (blog != null) {
            entity.remove(blog);
        }
    }
}
