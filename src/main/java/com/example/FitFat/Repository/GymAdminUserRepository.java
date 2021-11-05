package com.example.FitFat.Repository;

import com.example.FitFat.Model.GymAdminUser;
import org.springframework.data.repository.CrudRepository;

public interface GymAdminUserRepository extends CrudRepository<GymAdminUser,Integer>  {


    GymAdminUser findByUsername(String username);

}
