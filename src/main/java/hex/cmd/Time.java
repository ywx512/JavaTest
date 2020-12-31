package hex.cmd;

import hex.ByteUtil;
import hex.DeviceStatus;

/**
 * @author yuweixiong
 * @date 2020/12/30 15:04
 * @description
 */
public class Time implements DeviceCmd {
    public static final String TYPE = "0102";

    @Override
    public void handle(byte[] cmdValue, DeviceStatus deviceStatus) {
        int time = ByteUtil.byteToIntForLittleEndian(cmdValue);
        deviceStatus.setTime(time);
    }
}
