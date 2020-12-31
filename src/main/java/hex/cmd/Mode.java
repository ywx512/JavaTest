package hex.cmd;

import hex.DeviceStatus;

/**
 * @author yuweixiong
 * @date 2020/12/30 15:03
 * @description
 */
public class Mode implements DeviceCmd{
    public static final String TYPE = "0002";

    @Override
    public void handle(byte[] cmdValue, DeviceStatus deviceStatus) {
        deviceStatus.setMode(new Integer(cmdValue[0]));
    }
}
