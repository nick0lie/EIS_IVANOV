package com.labsfrom6to8.Service;

import com.labsfrom6to8.Mapper.ParkMapper;
import com.labsfrom6to8.Model.Park;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkService {

    private final ParkMapper parkMapper;

    public ParkService(ParkMapper parkMapper) {
        this.parkMapper = parkMapper;
    }

    public void addPark(Park park) {
        parkMapper.insertPark(park);
    }

    public void updatePark(Park park) {
        parkMapper.updatePark(park);
    }

    public List<Park> getAllParks() {
        return parkMapper.selectAllParks();
    }

    public void deleteParkById(Long id) {
        parkMapper.deletePark(id);
    }
}
