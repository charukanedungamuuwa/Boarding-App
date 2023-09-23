package com.example.backendboadingapp.Services;

import com.example.backendboadingapp.Entity.StatusEntity;
import com.example.backendboadingapp.Repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    StatusRepo statusRepo;
    public StatusEntity savestatus(StatusEntity statusEntity){
       return statusRepo.save(statusEntity);

    }

    public Optional<StatusEntity> getbyid(Integer userid) {
        return statusRepo.findById(userid);
    }

    public void delete(int userid) {
        statusRepo.deleteById(userid);
    }

    public List<StatusEntity> getall() {
        return statusRepo.findAll();
    }

    public List<StatusEntity> getbykeystatus(boolean keyholder) {
        return this.statusRepo.getbykeystatus(keyholder);
    }
    public List<StatusEntity> getbyavailablestatus(boolean intheboarding) {
        return this.statusRepo.getbyavailablestatus(intheboarding);
    }
}
