package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceM401001001")
public class DeviceM401001001 implements ITask {
    @Override
    public void run(String params) {
        if( params == null || params.isEmpty()){
            params = "M401001001";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
