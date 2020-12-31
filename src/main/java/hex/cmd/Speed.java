package hex.cmd;

import hex.DeviceStatus;

/**
 * @author yuweixiong
 * @date 2020/12/30 15:04
 * @description
 */
public class Speed implements DeviceCmd {
    public static final String TYPE = "0202";

    @Override
    public void handle(byte[] cmdValue, DeviceStatus deviceStatus) {
        if(cmdValue[0] == 0){
            deviceStatus.setReverse(false);
        }else {
            deviceStatus.setReverse(true);
        }

        deviceStatus.setSetSpeed(new Integer(cmdValue[1]));
    }
}
