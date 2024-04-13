package com.example.system.controller;

import com.example.system.entity.*;
import com.example.system.service.*;
import com.example.system.utils.CsvUtils;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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

    @GetMapping("/getCompanyById")
    public CompanyEntity getCompanyById(@Param("id") Integer id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping("/updateCompanyById")
    public Map<String, String> updateCompanyById(@RequestBody CompanyEntity form) {
        CompanyEntity company = getCompanyById(form.getId());
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "error");
        if (company != null) {
            company.setCompany_name(form.getCompany_name());
            company.setCompany_number(form.getCompany_number());
            company.setCompany_manager_name(form.getCompany_manager_name());
            company.setCompany_manager_phone(form.getCompany_manager_phone());
            company.setCompany_type(form.getCompany_type());
            company.setUpdate_time(new Timestamp(new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())).getTime()));
            if (companyService.updateCompanyById(company) == 1) {
                result.replace("status", "ok");
            }
        }
        return result;
    }


    @GetMapping("/getAllWarehouse")
    public List<WarehouseEntity> getAllWarehouse() {
        return warehouseService.getAllWarehouse();
    }

    @GetMapping("/getWarehouseById")
    public WarehouseEntity getWarehouseById(@Param("id") Integer id) {
        return warehouseService.getWarehouseById(id);
    }

    @PostMapping("/updateWarehouseById")
    public Map<String, String> updateWarehouseById(@RequestBody WarehouseEntity form) {
        WarehouseEntity warehouse = warehouseService.getWarehouseById(form.getId());
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "error");
        if (warehouse != null) {
            warehouse.setCompany_number(form.getCompany_number());
            warehouse.setWarehouse_name(form.getWarehouse_name());
            warehouse.setWarehouse_number(form.getWarehouse_number());
            warehouse.setWarehouse_manager_name(form.getWarehouse_manager_name());
            warehouse.setWarehouse_manager_phone(form.getWarehouse_manager_phone());
            warehouse.setWarehouse_size(form.getWarehouse_size());
            warehouse.setWarehouse_address(form.getWarehouse_address());
            warehouse.setWarehouse_type(form.getWarehouse_type());
            warehouse.setWarehouse_status(form.getWarehouse_status());
            warehouse.setLatitude(form.getLatitude());
            warehouse.setLatitude(form.getLongitude());
            warehouse.setUpdate_time(new Timestamp(new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())).getTime()));
            if (warehouseService.updateWarehouseById(warehouse) == 1) {
                result.replace("status", "ok");
            }
        }
        return result;
    }


    @GetMapping("/getAllHost")
    public List<HostEntity> getAllHost() {
        return hostService.getAllHost();
    }

    @GetMapping("/getHostById")
    public HostEntity getHostById(@Param("id") Integer id) {
        return hostService.getHostById(id);
    }

    @PostMapping("updateHostById")
    public Map<String, String> updateHostById(@RequestBody HostEntity form) {
        HostEntity host = hostService.getHostById(form.getId());
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "error");
        if (host != null) {
            host.setCompany_number(form.getCompany_number());
            host.setWarehouse_number(form.getWarehouse_number());
            host.setHost_name(form.getHost_name());
            host.setHost_number(form.getHost_number());
            host.setHost_status(form.getHost_status());
            host.setUpdate_time(new Timestamp(new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())).getTime()));
            if (hostService.updateHostById(host) == 1) {
                result.replace("status", "ok");
            }
        }
        return result;
    }

    @GetMapping("/getAllMeter")
    public List<MeterEntity> getAllMeter() {
        return meterService.getAllMeter();
    }

    @GetMapping("/getMeterById")
    public MeterEntity getMeterById(@Param("id") Integer id) {
        return meterService.getMeterById(id);
    }

    @PostMapping("/updateMeterById")
    public Map<String, String> updateMeterById(@RequestBody MeterEntity form) {
        MeterEntity meter = meterService.getMeterById(form.getId());
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "error");
        if (meter != null) {
            meter.setCompany_number(form.getCompany_number());
            meter.setWarehouse_number(form.getWarehouse_number());
            meter.setHost_number(form.getHost_number());
            meter.setMeter_number(form.getMeter_number());
            meter.setMin_temperature(form.getMin_temperature());
            meter.setMax_temperature(form.getMax_temperature());
            meter.setMin_humidity(form.getMin_humidity());
            meter.setMax_humidity(form.getMax_humidity());
            meter.setMeter_status(form.getMeter_status());
            meter.setUpdate_time(new Timestamp(new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())).getTime()));
            if (meterService.updateMeterById(meter) == 1) {
                result.replace("status", "ok");
            }

        }
        return result;
    }

    @PostMapping("/addCompany")
    public Map<String, Object> addCompany(@RequestBody CompanyEntity companyEntity) {
        HashMap<String, Object> result = new HashMap<>();
        Object o = companyService.insertCompany(companyEntity.getCompany_name(), companyEntity.getCompany_number(), companyEntity.getCompany_manager_name(), companyEntity.getCompany_manager_phone(), companyEntity.getCompany_address(), companyEntity.getCompany_type()

        ) == 1 ? result.put("status", "ok") : result.put("status", "error");
        return result;
    }

    @PostMapping("/addWarehouse")
    public Map<String, Object> addWarehouse(@RequestBody WarehouseEntity warehouseEntity) {
        HashMap<String, Object> result = new HashMap<>();
        Object o = warehouseService.insertWarehouse(warehouseEntity.getCompany_number(), warehouseEntity.getWarehouse_name(), warehouseEntity.getWarehouse_number(), warehouseEntity.getWarehouse_manager_name(), warehouseEntity.getWarehouse_manager_phone(), warehouseEntity.getWarehouse_size(), warehouseEntity.getWarehouse_address(), warehouseEntity.getWarehouse_type(), warehouseEntity.getLatitude(), warehouseEntity.getLongitude()

        ) == 1 ? result.put("status", "ok") : result.put("status", "error");
        return result;
    }

    @PostMapping("/addHost")
    public Map<String, Object> addHost(@RequestBody HostEntity hostEntity) {
        HashMap<String, Object> result = new HashMap<>();
        Object o = hostService.insertHost(hostEntity.getCompany_number(), hostEntity.getWarehouse_number(), hostEntity.getHost_name(), hostEntity.getHost_number()

        ) == 1 ? result.put("status", "ok") : result.put("status", "error");
        result.get("status");
        return result;
    }

    @PostMapping("/addMeter")
    public Map<String, Object> addMeter(@RequestBody MeterEntity meterEntity) {
        HashMap<String, Object> result = new HashMap<>();
        Object o = meterService.insertMeter(meterEntity.getCompany_number(), meterEntity.getWarehouse_number(), meterEntity.getHost_number(), meterEntity.getMeter_number(), meterEntity.getMin_temperature(), meterEntity.getMax_temperature(), meterEntity.getMin_humidity(), meterEntity.getMax_humidity()

        ) == 1 ? result.put("status", "ok") : result.put("status", "error");

        return result;
    }

    @PostMapping("/deleteCompanyByCompanyNumber")
    public Map<String, String> deleteCompanyByCompanyNumber(@Param("company_number") String company_number) {
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "error");
        if (companyService.deleteCompanyByCompany_number(company_number) == 1) {
            result.replace("status", "ok");
        }
        return result;
    }

    @PostMapping("/deleteWarehouseByWarehouseNumber")
    public Map<String, String> deleteWarehouseByWarehouseNumber(@Param("warehouse_number") String warehouse_number) {
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "error");
        if (warehouseService.deleteWarehouseByWarehouse_number(warehouse_number) == 1)
            result.replace("status", "ok");
        return result;
    }

    @PostMapping("/deleteHostByHostNumber")
    public Map<String, String> deleteHostByHostNumber(@Param("host_number") String host_number) {
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "error");
        if (hostService.deleteHostByHost_number(host_number) == 1)
            result.replace("status", "ok");
        return result;
    }

    @PostMapping("/deleteMeterByMeterNumber")
    public Map<String, String> deleteMeterByMeterNumber(@Param("meter_number") String meter_number) {
        HashMap<String, String> result = new HashMap<>();
        result.put("status", "error");
        if (meterService.deleteMeterByMeter_number(meter_number) == 1)
            result.replace("status", "ok");
        return result;
    }

    @GetMapping("/getHostHistoryLastDay")
    public List<HostHistoryEntity> getHostHistoryLastDay(){
        return hostHistoryService.selectLastDayHostHistory();
    }

    @GetMapping("/getMeterHistoryLastDay")
    public List<MeterHistoryEntity> getMeterHistoryLastDay(){
        return meterHistoryService.selectLastDayMeterHistory();
    }

    /*-------------------------------------------------------------------------------*/
    /**
     * @Description 下载CSV
     **/
    @GetMapping("/download/host_history")
    public String downloadAllHostHistoryCSV(HttpServletResponse response) throws IOException {
        String[] head =  hostHistoryService.getHead();
        List<HostHistoryEntity> values = hostHistoryService.getValues();
        ArrayList<String[]> strings = new ArrayList<>();
        for (HostHistoryEntity value : values) {
            strings.add(value.toStrings());
        }

        String fileName = hostHistoryService.getName();

        File file = CsvUtils.makeTempCSV(fileName, head, strings);
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName +".csv");
        CsvUtils.downloadFile(response, file);
        return null;
    }
    @GetMapping("/download/meter_history")
    public String downloadAllMeterHistoryCSV(HttpServletResponse response) throws IOException {
        String[] head =  meterHistoryService.getHead();
        List<MeterHistoryEntity> values = meterHistoryService.getValues();
        ArrayList<String[]> strings = new ArrayList<>();
        for (MeterHistoryEntity value : values) {
            strings.add(value.toStrings());
        }

        String fileName = meterHistoryService.getName();

        File file = CsvUtils.makeTempCSV(fileName, head, strings);
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName +".csv");
        CsvUtils.downloadFile(response, file);
        return null;
    }
    /**
     * @Description 上传CSV
     * @Param file
     **/
    @PostMapping(value = "/upload/host_history")
    public String uploadHostHistory(@RequestParam("file") MultipartFile multipartFile) {
        try {
            //上传内容不能为空
            if (multipartFile.isEmpty()) {
                return "500";
            }
            File file = CsvUtils.uploadFile(multipartFile);
            List<List<String>> host_history = CsvUtils.readCSV(file.getPath(), 8);
            System.out.println(host_history);
            assert host_history != null;
            for (List<String> strings : host_history) {
                HostHistoryEntity hostHistory = new HostHistoryEntity();
                hostHistory.input(strings);
                hostHistoryService.addHostHistory(hostHistory);
            }
            file.delete();
            return "200";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "500";
    }

    @PostMapping(value = "/upload/meter_history")
    public String uploadMeterHistory(@RequestParam("file") MultipartFile multipartFile) {
        try {
            //上传内容不能为空
            if (multipartFile.isEmpty()) {
                return "500";
            }
            File file = CsvUtils.uploadFile(multipartFile);
            List<List<String>> meter_history = CsvUtils.readCSV(file.getPath(), 13);
            assert meter_history != null;
            for (List<String> strings : meter_history) {
                MeterHistoryEntity meterHistory = new MeterHistoryEntity();
                meterHistory.input(strings);
                meterHistoryService.addMeterHistory(meterHistory);
            }
            file.delete();
            return "200";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "500";
    }
    /*-------------------------------------------------------------------------------*/

}