package com.ll.cold.jobs.task;

        import com.ll.cold.jobs.utils.DeviceClientFactory;
        import org.springframework.stereotype.Component;

@Component("deviceM101001002")
public class DeviceM101001002 implements ITask {
    @Override
    public void run(String params) {
        if( params == null || params.isEmpty()){
            params = "M101001002";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
