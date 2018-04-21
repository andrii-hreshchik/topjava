package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaMealRepositoryImpl implements MealRepository {
    private static final Sort SORT_BY_DATE = new Sort(Sort.Direction.DESC, "dateTime");

    @Autowired
    private CrudMealRepository crudRepository;

    @Autowired
    CrudUserRepository crudUserRepository;

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            meal.setUser(crudUserRepository.findById(userId).get());
            return crudRepository.save(meal);
        } else {
            if (get(meal.getId(), userId) == null) {
                return null;
            }
        }
        meal.setUser(crudUserRepository.findById(userId).get());
        return crudRepository.save(meal);
    }


    @Override
    public boolean delete(int id, int userId) {
        return crudRepository.delete(id, userId) != 0;
    }

    @Override
    public Meal get(int id, int userId) {
        return crudRepository.findByIdAndUserId(id, userId).orElse(null);
    }

    @Override
    public List<Meal> getAll(int userId) {
        return crudRepository.findAll(userId);
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return crudRepository.findByDateTimeBetweenAndUser_Id(startDate, endDate, userId, SORT_BY_DATE);
    }
}
