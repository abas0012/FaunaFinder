/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.repository;

import fit5042.assign.repository.entity.Animal;
import fit5042.assign.repository.entity.Ranger;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Adhi Baskoro
 */
@Stateless //Stateless EJB
public class JPAAnimalRepositoryImpl implements AnimalRepository{
    
    @PersistenceContext(unitName = "FaunaFinder-ejbPU")//@PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAnimal(Animal animal) throws Exception {
        List<Animal> animals = entityManager.createNamedQuery(Animal.GET_ALL_QUERY_NAME).getResultList();
        animal.setAnimalId(animals.get(0).getAnimalId() + 1);
        entityManager.persist(animal);
    }

    @Override
    public Animal searchAnimalById(int id) throws Exception {
        Animal animal = entityManager.find(Animal.class, id);
        animal.getTags();
        return animal;
    }

    @Override
    public List<Animal> getAllAnimals() throws Exception {
        return entityManager.createNamedQuery(Animal.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public List<Ranger> getAllRangers() throws Exception {
        return entityManager.createNamedQuery(Ranger.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeAnimal(int animalId) throws Exception {
        Animal a = searchAnimalById(animalId); //where a is a local variable for Animal class
        entityManager.remove(a);
    }

    @Override
    public void editAnimal(Animal animal) throws Exception {
        try {
            entityManager.merge(animal);
        }
        catch (Exception ex){
            
        }
    }

    @Override
    public Set<Animal> searchAnimalByRanger(Ranger ranger) throws Exception {
        ranger = entityManager.find(Ranger.class,  ranger.getRangerId());
        ranger.getAnimal().size();
        entityManager.refresh(ranger);
        return ranger.getAnimal();
    }

    @Override
    public List<Animal> searchAnimalByPopulation(int population) throws Exception {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Animal> q = cb.createQuery(Animal.class);
        Root<Animal> r = q.from(Animal.class);
        Predicate condition = cb.equal(r.get("population"), population);
        q.where(condition);
        TypedQuery<Animal> tq = entityManager.createQuery(q);
        List<Animal> result = tq.getResultList();
        return result;
    }
    
}
