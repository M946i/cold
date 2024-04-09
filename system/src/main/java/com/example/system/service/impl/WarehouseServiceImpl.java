package com.example.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.system.dao.WarehouseDao;
import com.example.system.entity.WarehouseEntity;
import com.example.system.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
    public int insert(String company_number,String warehouse_number, String warehouse_name, String warehouse_manager_name, String warehouse_manager_phone, String warehouse_size, String warehouse_address, String warehouse_type, BigDecimal latitude, BigDecimal longitude) {
        return warehouseDao.insert(company_number,warehouse_number, warehouse_name, warehouse_manager_name, warehouse_manager_phone, warehouse_size, warehouse_address, warehouse_type, latitude, longitude);
    }
}
