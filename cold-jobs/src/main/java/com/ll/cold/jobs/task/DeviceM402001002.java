package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceM402001002")
public class DeviceM402001002 implements ITask {
    @Override
    public void run(String params) {
        if( params == null || params.isEmpty()){
            params = "M402001002";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
