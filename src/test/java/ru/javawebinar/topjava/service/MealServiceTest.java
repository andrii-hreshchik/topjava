package ru.javawebinar.topjava.service;

import org.assertj.core.condition.Not;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal meal = service.get(100002, USER.getId());
        assertMatch(meal, MEAL1);
    }

    @Test(expected = NotFoundException.class)
    public void wrongUserGet() {
        Meal meal = service.get(100002, 10);
        assertMatch(meal, MEAL1);
    }

    @Test(expected = NotFoundException.class)
    public void delete() {
        service.delete(100002, USER.getId());
        service.get(100002, USER.getId());

    }

    @Test
    public void getBetweenDateTimes() {
    }

    @Test
    public void getAll() {
        List<Meal> all = service.getAll(USER.getId());
        assertMatch(all, MEAL_LIST);
    }

    @Test(expected = NotFoundException.class)
    public void wrongUserGetAll() {
        List<Meal> all = service.getAll(9);
        if (all.isEmpty()) {
            throw new NotFoundException("Meals");
        }
    }

    @Test
    public void update() {
    }

    @Test
    public void create() {
    }
}