package com.example.system.service.impl;


import com.example.system.dao.WarehouseDao;
import com.example.system.entity.WarehouseEntity;
import com.example.system.service.WarehouseService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseDao, WarehouseEntity> implements WarehouseService {
    @Autowired
    WarehouseDao warehouseDao;

    @Override
    public List<WarehouseEntity> getAllWarehouse() {
        return warehouseDao.getAllWarehouse();
    }

    @Override
    public int insertWarehouse(String company_number,String warehouse_number, String warehouse_name, String warehouse_manager_name, String warehouse_manager_phone, String warehouse_size, String warehouse_address, String warehouse_type, BigDecimal latitude, BigDecimal longitude) {
        return warehouseDao.insertWarehouse(company_number,warehouse_number, warehouse_name, warehouse_manager_name, warehouse_manager_phone, warehouse_size, warehouse_address, warehouse_type, latitude, longitude);
    }
}
