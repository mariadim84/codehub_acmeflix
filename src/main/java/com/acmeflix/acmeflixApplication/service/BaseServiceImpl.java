package com.acmeflix.acmeflixApplication.service;

import com.acmeflix.acmeflixApplication.base.BaseComponent;
import com.acmeflix.acmeflixApplication.domain.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long> {
    public abstract JpaRepository<T, Long> getRepository();

    @Override
    public T create(final T item) {
        T savedItem = getRepository().save(item);
        logger.debug("Created item with id:{}.", savedItem.getId());
        return savedItem;
    }

    @Override
    public List<T> createAll(final T... items) {
        return createAll(Arrays.asList(items));
    }

    @Override
    public List<T> createAll(final List<T> items) {
        final List<T> updatedItems = new ArrayList<>();
        for (final T item : items) {
            updatedItems.add(create(item));
        }
        return updatedItems;
    }

    @Override
    public void update(final T item) {
        getRepository().save(item);
    }

    @Override
    public void delete(final T item) {
        getRepository().delete(item);
    }

    @Override
    public void deleteById(final Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public boolean exists(final T item) {
        boolean exists = getRepository().existsById(item.getId());
        logger.trace("Item {}.", exists ? "exists" : "does not exist");
        return exists;
    }

    @Override
    @Transactional(readOnly = true)
    public T get(final Long id) {
        T item = getRepository().getReferenceById(id);
        logger.trace("Item found matching id:{}.", id);
        return item;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        List<T> itemsFound = getRepository().findAll();
        logger.trace("Returned {} items.", itemsFound.size());
        return itemsFound;
    }
}
