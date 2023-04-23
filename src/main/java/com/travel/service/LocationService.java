package com.travel.service;

import com.travel.model.entities.Location;
import com.travel.model.entities.enums.LocationEnum;

import java.util.List;

public interface LocationService {
    List<Location> initLocations();

    Location getLocationByName(LocationEnum locationEnum);
}
