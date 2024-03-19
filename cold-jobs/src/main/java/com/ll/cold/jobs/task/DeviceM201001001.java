package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceM201001001")
public class DeviceM201001001 implements ITask {
    @Override
    public void run(String params) {
        if( params == null ){
            params = "M201001001";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
