package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceM402002001")
public class DeviceM402002001 implements ITask {
    @Override
    public void run(String params) {
        if( params == null || params.isEmpty()){
            params = "M402002001";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
