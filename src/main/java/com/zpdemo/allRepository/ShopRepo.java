package com.zpdemo.allRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpdemo.entityModel.ShopBo;

public interface ShopRepo  extends JpaRepository<ShopBo,String>{

}
