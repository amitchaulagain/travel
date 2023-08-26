package com.travel.model.repostiory;

import com.travel.model.entities.FileDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileDetailsRepository extends JpaRepository<FileDetails, Integer> {

}
