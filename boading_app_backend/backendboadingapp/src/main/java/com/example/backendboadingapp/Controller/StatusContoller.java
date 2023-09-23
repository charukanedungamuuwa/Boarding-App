package com.example.backendboadingapp.Controller;

import com.example.backendboadingapp.Entity.StatusEntity;
import com.example.backendboadingapp.Services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/status")
public class StatusContoller {
@Autowired
    StatusService statusService;
@PostMapping("/save")
public StatusEntity save(@RequestBody StatusEntity statusEntity){
    return statusService.savestatus( statusEntity);
}


@GetMapping("/{userid}")
    public Optional<StatusEntity> getbyid(@PathVariable Integer userid){
    return statusService.getbyid(userid);
}

@DeleteMapping("/{userid}")
    public void delete(@PathVariable int userid){
      statusService.delete(userid);
}
@GetMapping("/all")
    public List<StatusEntity> getall(){
    return statusService.getall();
}

@GetMapping("/key/{keyholder}")
    public List<StatusEntity> getbykeystatus(@PathVariable boolean keyholder){
    return statusService.getbykeystatus(keyholder);
}
    @GetMapping("/available/{intheboarding}")
    public List<StatusEntity> getbyavailablestatus(@PathVariable boolean intheboarding){
        return statusService.getbyavailablestatus(intheboarding);
    }


}
