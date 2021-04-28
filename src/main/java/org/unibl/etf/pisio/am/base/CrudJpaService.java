package org.unibl.etf.pisio.am.base;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.pisio.am.exceptions.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Getter
public class CrudJpaService<E extends BaseEntity<ID>, ID extends Serializable> implements CrudService<ID> {


    private final JpaRepository<E, ID> repository;
    private final Class<E> entityClass;
    private final ModelMapper modelMapper;
    @PersistenceContext
    private EntityManager entityManager;

    public CrudJpaService(JpaRepository<E, ID> repository, ModelMapper modelMapper, Class<E> entityClass) {

        this.repository = repository;
        this.entityClass = entityClass;
        this.modelMapper = modelMapper;
    }


    @Override
    public <T> List<T> findAll(Class<T> resultDtoClass) {
        return repository.findAll().stream().map(e -> modelMapper.map(e, resultDtoClass)).collect(Collectors.toList());
    }

    public <T> Page<T> findAll(Pageable page, Class<T> resultDtoClass) {
        return repository.findAll(page).map(e -> modelMapper.map(e, resultDtoClass));
    }

    @Override
    public <T> T findById(ID id, Class<T> resultDtoClass) {
        return modelMapper.map(findEntityById(id), resultDtoClass);
    }

    @Override
    public <T, U> T insert(U object, Class<T> resultDtoClass) {
        E entity = modelMapper.map(object, entityClass);
        entity.setId(null);
        entity = repository.saveAndFlush(entity);
        entityManager.refresh(entity);
        return modelMapper.map(entity, resultDtoClass);
    }

    @Override
    public <T, U> T update(ID id, U object, Class<T> resultDtoClass) {
        if (!repository.existsById(id))
            throw new NotFoundException();
        E entity = modelMapper.map(object, entityClass);
        entity.setId(id);
        entity = repository.saveAndFlush(entity);
        entityManager.refresh(entity);
        return modelMapper.map(entity, resultDtoClass);
    }

    public E findEntityById(ID id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void delete(ID id) {
        if (!repository.existsById(id))
            throw new NotFoundException();
        repository.deleteById(id);
    }
}
