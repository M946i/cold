package com.example.system.controller;

import com.example.system.dao.HostHistoryDao;
import com.example.system.dao.MeterHistoryDao;
import com.example.system.entity.CompanyEntity;
import com.example.system.entity.HostEntity;
import com.example.system.entity.MeterEntity;
import com.example.system.entity.WarehouseEntity;
import com.example.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("system")
public class SystemController {
    @Autowired
    CompanyService companyService;
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    HostService hostService;
    @Autowired
    MeterService meterService;
    @Autowired
    HostHistoryService hostHistoryService;
    @Autowired
    MeterHistoryService meterHistoryService;

    @GetMapping("/getAllCompany")
    public List<CompanyEntity> getAllCompany() {
        return companyService.getAllCompany();
    }

    @GetMapping("/getAllWarehouse")
    public List<WarehouseEntity> getAllWarehouse() {
        return warehouseService.getAllWarehouse();
    }

    @GetMapping("/getAllHost")
    public List<HostEntity> getAllHost() {
        return hostService.getAllHost();
    }

    @GetMapping("/getAllMeter")
    public List<MeterEntity> getAllMeter() {
        return meterService.getAllMeter();
    }

    @PostMapping("/addCompany")
    public Map<String, Object> addCompany(@RequestBody CompanyEntity companyEntity) {
        HashMap<String, Object> result = new HashMap<>();
        Object o = companyService
                .insertCompany(
                        companyEntity.getCompany_name(),
                        companyEntity.getCompany_number(),
                        companyEntity.getCompany_manager_name(),
                        companyEntity.getCompany_manager_phone(),
                        companyEntity.getCompany_address(),
                        companyEntity.getCompany_type()

                ) == 1 ? result.put("status", "ok") : result.put("status", "error");
        return result;
    }

    @PostMapping("/addWarehouse")
    public Map<String, Object> addWarehouse(@RequestBody WarehouseEntity warehouseEntity) {
        HashMap<String, Object> result = new HashMap<>();
        Object o = warehouseService
                .insertWarehouse(
                        warehouseEntity.getCompany_number(),
                        warehouseEntity.getWarehouse_name(),
                        warehouseEntity.getWarehouse_number(),
                        warehouseEntity.getWarehouse_manager_name(),
                        warehouseEntity.getWarehouse_manager_phone(),
                        warehouseEntity.getWarehouse_size(),
                        warehouseEntity.getWarehouse_address(),
                        warehouseEntity.getWarehouse_type(),
                        warehouseEntity.getLatitude(),
                        warehouseEntity.getLongitude()

                ) == 1 ? result.put("status", "ok") : result.put("status", "error");
        return result;
    }

    @PostMapping("/addHost")
    public Map<String, Object> addHost(@RequestBody HostEntity hostEntity) {
        HashMap<String, Object> result = new HashMap<>();
        Object o = hostService
                .insertHost(
                        hostEntity.getCompany_number(),
                        hostEntity.getWarehouse_number(),
                        hostEntity.getHost_name(),
                        hostEntity.getHost_number()

                ) == 1 ? result.put("status", "ok") : result.put("status", "error");
        return result;
    }

    @PostMapping("/addMeter")
    public Map<String, Object> addMeter(@RequestBody MeterEntity meterEntity) {
        HashMap<String, Object> result = new HashMap<>();
        Object o = meterService
                .insertMeter(
                        meterEntity.getCompany_number(),
                        meterEntity.getWarehouse_number(),
                        meterEntity.getHost_number(),
                        meterEntity.getMeter_number(),
                        meterEntity.getMin_temperature(),
                        meterEntity.getMax_temperature(),
                        meterEntity.getMin_humidity(),
                        meterEntity.getMax_humidity()

                ) == 1 ? result.put("status", "ok") : result.put("status", "error");

        return result;
    }
}
