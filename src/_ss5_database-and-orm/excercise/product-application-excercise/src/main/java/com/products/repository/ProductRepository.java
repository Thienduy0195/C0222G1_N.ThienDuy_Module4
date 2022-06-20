package com.products.repository;

import com.products.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        String queryStr = "SELECT p FROM Product AS p";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Long id) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.productId = :id";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(product.getProductId()));
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.productName like :name";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
