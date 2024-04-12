package com.example.system.service;


import com.example.system.entity.WarehouseEntity;
import com.mybatisflex.core.service.IService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface WarehouseService extends IService<WarehouseEntity> {
    List<WarehouseEntity> getAllWarehouse();

    int insertWarehouse(String company_number, String warehouse_number, String warehouse_name, String warehouse_manager_name, String warehouse_manager_phone, String warehouse_size, String warehouse_address, String warehouse_type, BigDecimal latitude, BigDecimal longitude);

    WarehouseEntity getWarehouseById(Integer id);

    int updateWarehouseById(WarehouseEntity warehouseEntity);

    int deleteWarehouseByWarehouse_number(String warehouse_number);
}
