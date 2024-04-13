package com.example.system.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.List;


@Table("host_history")
@Data
@EntityScan
public class HostHistoryEntity {
    @Id("id")
    private Long id;
    @Column("host_id")
    private Integer host_id;
    @Column("company_number")
    private String company_number;
    @Column("warehouse_number")
    private String warehouse_number;
    @Column("host_name")
    private String host_name;
    @Column("host_number")
    private String host_number;
    @Column("host_status")
    private String host_status;
    @Column("create_time")
    private Timestamp create_time;

    public String[] toStrings() {
        return new String[]{
                this.id.toString(),
                this.host_id.toString(),
                this.company_number,
                this.warehouse_number,
                this.host_name,
                this.host_number,
                this.host_status,
                this.create_time.toString()
        };
    }

    public void input(String id, String host_id, String company_number, String warehouse_number, String host_name, String host_number, String host_status, String create_time) {
        this.id = Long.valueOf(id);
        this.host_id = Integer.valueOf(host_id);
        this.company_number = company_number;
        this.warehouse_number = warehouse_number;
        this.host_name = host_name;
        this.host_number = host_number;
        this.host_status = host_status;
        this.create_time = Timestamp.valueOf(create_time);
    }

    public void input(List<String> strings) {
        if (strings == null || strings.size() < 8) {
            throw new IllegalArgumentException("参数列表长度不正确");
        }

        this.id = Long.valueOf(strings.get(0));
        this.host_id = Integer.valueOf(strings.get(1));
        this.company_number = strings.get(2);
        this.warehouse_number = strings.get(3);
        this.host_name = strings.get(4);
        this.host_number = strings.get(5);
        this.host_status = strings.get(6);
        this.create_time = Timestamp.valueOf(strings.get(7));
    }
}
