package hex.cmd;

import hex.DeviceStatus;

/**
 * @author yuweixiong
 * @date 2020/12/30 15:31
 * @description
 */
public class DeviceStartStatus implements DeviceCmd {
    public static final String TYPE = "0502";

    @Override
    public void handle(byte[] cmdValue, DeviceStatus deviceStatus) {
        if (cmdValue[0] == 0) {
            deviceStatus.setDeviceStartStatus(false);
        } else {
            deviceStatus.setDeviceStartStatus(true);
        }
    }
}
