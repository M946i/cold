package com.example.system.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Table("meter_history")
@Data
@EntityScan
public class MeterHistoryEntity {
    @Id("id")
    private Long id;
    @Column("meter_id")
    private Integer meter_id;
    @Column("company_number")
    private String company_number;
    @Column("warehouse_number")
    private String warehouse_number;
    @Column("host_number")
    private String host_number;
    @Column("min_temperature")
    private Double min_temperature;
    @Column("max_temperature")
    private Double max_temperature;
    @Column("current_temperature")
    private Double current_temperature;
    @Column("min_humidity")
    private Double min_humidity;
    @Column("min_humidity")
    private Double max_humidity;
    @Column("current_humidity")
    private Double current_humidity;
    @Column("meter_status")
    private String meter_status;
    @Column("create_time")
    private Timestamp create_time;

    public String[] toStrings() {
        return new String[]{
                this.id.toString(),
                this.meter_id.toString(),
                this.company_number,
                this.warehouse_number,
                this.host_number,
                this.min_temperature.toString(),
                this.max_temperature.toString(),
                this.current_temperature.toString(),
                this.min_humidity.toString(),
                this.max_humidity.toString(),
                this.current_humidity.toString(),
                this.meter_status,
                this.create_time.toString()
        };
    }

    public void input(String id, String meter_id, String company_number, String warehouse_number, String host_number, String min_temperature, String max_temperature, String current_temperature, String min_humidity, String max_humidity, String current_humidity, String meter_status, String create_time) {
        this.id = Long.valueOf(id);
        this.meter_id = Integer.valueOf(meter_id);
        this.company_number = company_number;
        this.warehouse_number = warehouse_number;
        this.host_number = host_number;
        this.min_temperature = Double.valueOf(min_temperature);
        this.max_temperature = Double.valueOf(max_temperature);
        this.current_temperature = Double.valueOf(current_temperature);
        this.min_humidity = Double.valueOf(min_humidity);
        this.max_humidity = Double.valueOf(max_humidity);
        this.current_humidity = Double.valueOf(current_humidity);
        this.meter_status = meter_status;
        this.create_time = Timestamp.valueOf(create_time);
    }

    public void input(List<String> strings) throws ParseException {
        if (strings == null || strings.size() < 8) {
            throw new IllegalArgumentException("参数列表长度不正确");
        }
        this.id = Long.valueOf(strings.get(0));
        this.meter_id = Integer.valueOf(strings.get(1));
        this.company_number = strings.get(2);
        this.warehouse_number = strings.get(3);
        this.host_number = strings.get(4);
        this.min_temperature = Double.valueOf(strings.get(5));
        this.max_temperature = Double.valueOf(strings.get(6));
        this.current_temperature = Double.valueOf(strings.get(7));
        this.min_humidity = Double.valueOf(strings.get(8));
        this.max_humidity = Double.valueOf(strings.get(9));
        this.current_humidity = Double.valueOf(strings.get(10));
        this.meter_status = strings.get(11);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = dateFormat.parse(strings.get(12));
        this.create_time = new Timestamp(date.getTime());
    }
}
