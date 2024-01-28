package com.Duhov.UserService.services;

import com.Duhov.UserService.Exceptions.CityNotFoundException;
import com.Duhov.UserService.entities.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    City getCityById(Integer cityId) throws CityNotFoundException;

    City createCity(City city);

    City updateCityById(Integer cityId, City city) throws CityNotFoundException;

    String deleteCityById(Integer cityId) throws CityNotFoundException;

    City getCityByName(String name) throws CityNotFoundException;
}
