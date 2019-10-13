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
import javax.ejb.Remote;

/**
 *
 * @author Adhi Baskoro
 */
@Remote
public interface AnimalRepository {

    public void addAnimal(Animal animal) throws Exception;
    
    public Animal searchAnimalById(int id) throws Exception;
    
    public List<Animal> getAllAnimals() throws Exception;
    
    public List<Ranger> getAllRangers() throws Exception;
    
    public void removeAnimal(int animalId) throws Exception;
    
    public void editAnimal(Animal animal) throws Exception;
    
    public Set<Animal> searchAnimalByRanger(Ranger ranger) throws Exception;
    
    public List<Animal> searchAnimalByPopulation(int population) throws Exception;
    
}
