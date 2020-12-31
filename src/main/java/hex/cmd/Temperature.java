package hex.cmd;

import hex.DeviceStatus;

/**
 * @author yuweixiong
 * @date 2020/12/30 16:15
 * @description
 */
class Temperature implements DeviceCmd {
    public static final String TYPE = "0302";

    @Override
    public void handle(byte[] cmdValue, DeviceStatus deviceStatus) {
        if(cmdValue[0] == 0x01){
            deviceStatus.setCelsius(true);
        }else{
            deviceStatus.setCelsius(false);
        }

        deviceStatus.setSetTemp(new Integer(cmdValue[1]));
    }
}
