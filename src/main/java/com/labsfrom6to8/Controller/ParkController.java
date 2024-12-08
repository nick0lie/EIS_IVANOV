package com.labsfrom6to8.Controller;

import com.labsfrom6to8.Model.Park;
import com.labsfrom6to8.Service.ParkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parks")
public class ParkController {

    private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @PostMapping
    public void addPark(@RequestBody Park park) {
        parkService.addPark(park);
    }

    @PutMapping
    public void updatePark(@RequestBody Park park) {
        parkService.updatePark(park);
    }

    @GetMapping
    public List<Park> getAllParks() {
        return parkService.getAllParks();
    }

    @DeleteMapping("/{id}")
    public void deletePark(@PathVariable Long id) {
        parkService.deleteParkById(id);
    }
}
