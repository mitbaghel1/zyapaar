package com.zpdemo.allRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpdemo.entityModel.ImageBo;

public interface ImageRepo extends JpaRepository<ImageBo, String>{

}
