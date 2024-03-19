package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceM402002002")
public class DeviceM402002002 implements ITask {
    @Override
    public void run(String params) {
        if( params == null || params.isEmpty()){
            params = "M402002002";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
