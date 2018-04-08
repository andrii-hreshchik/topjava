package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MealTestData {

    public static final Meal MEAL1 = new Meal(100002, LocalDateTime.of(2018, 3, 22, 8, 30),
            "breakfast", 400);
    public static final Meal MEAL2 = new Meal(100003, LocalDateTime.of(2018, 3, 22, 14, 30),
            "dinner", 800);
    public static final Meal MEAL3 = new Meal(100004, LocalDateTime.of(2018, 3, 22, 19, 30),
            "supper", 400);
    public static final Meal MEAL4 = new Meal(100005, LocalDateTime.of(2018, 3, 23, 7, 30),
            "breakfast", 300);
    public static final Meal MEAL5 = new Meal(100006, LocalDateTime.of(2018, 3, 23, 14, 30),
            "dinner", 1000);
    public static final Meal MEAL6 = new Meal(100007, LocalDateTime.of(2018, 3, 23, 18, 30),
            "supper", 800);

    public static final List<Meal> MEAL_LIST = new ArrayList<>();

    static {

        MEAL_LIST.add(MEAL1);
        MEAL_LIST.add(MEAL2);
        MEAL_LIST.add(MEAL3);
        MEAL_LIST.add(MEAL4);
        MEAL_LIST.add(MEAL5);
        MEAL_LIST.add(MEAL6);
        MEAL_LIST.sort((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()));
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);

    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).isEqualTo(expected);
    }

}



