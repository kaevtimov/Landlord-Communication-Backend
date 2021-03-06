
package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.Rent;

import java.util.List;

public interface RentRepository {

    Rent addRent(Rent rent);

    Rent updateRentRemaining(int rentId, Rent rent);

    Rent updateRentIsPaidStatus(int rentId);

    List<Rent> getRentByPlaceId(int placeId);

    Rent editRent(Rent rent, int rentId);
}