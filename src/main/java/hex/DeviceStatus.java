package hex;

import hex.cmd.DeviceCmd;
import hex.cmd.DeviceCmdFactory;

/**
 * @author yuweixiong
 * @date 2020/12/30 14:29
 * @description
 */
public class DeviceStatus {
    //当前设备工作模式
    private Integer mode;
    //剩余时间
    private Integer time;
    //设定的速度挡位
    private Integer setSpeed;
    //设定的温度挡位
    private Integer setTemp;
    //实际温度
    private Integer actTemp;
    //温度单位是否为摄氏度
    private Boolean isCelsius;
    //是否反转
    private Boolean reverse;
    //设备盖子是否合上
    private Boolean isCover;
    //设备是否处于启动状态
    private Boolean deviceStartStatus;

    public static DeviceStatus toDeviceStatus(byte[] commandByte) {
        boolean check = checkCommand(commandByte);
        System.out.println("check: " + check);

        DeviceStatus deviceStatus = new DeviceStatus();

        //消息体长度
        byte[] payloadLenByte = new byte[]{commandByte[5], commandByte[6]};
        int payloadLen = ByteUtil.byteToIntForLittleEndian(payloadLenByte);

        //消息体成员数
        int tagNumber = commandByte[7];

        int payloadStart = 8;
        int payloadPos = 0;

        byte[] cmd;
        byte cmdLen;
        byte[] cmdValue;

        while (payloadPos < payloadLen) {
            cmd = new byte[]{commandByte[payloadStart + payloadPos], commandByte[payloadStart + payloadPos + 1]};
            cmdLen = commandByte[payloadStart + payloadPos + 2];
            cmdValue = new byte[cmdLen];
            System.arraycopy(commandByte, payloadStart + payloadPos + 3, cmdValue, 0, cmdLen);

            cmdHandle(cmd, cmdValue, deviceStatus);

            payloadPos = payloadPos + 3 + cmdLen;
        }

        return deviceStatus;
    }

    private static boolean checkCommand(byte[] commandByte) {
        int result = 0;
        for(int i = 3; i < commandByte.length; i++){
            result = result + commandByte[i];
        }

        byte test = (byte) (result & 0xFF);
        return test == commandByte[2];
    }

    private static void cmdHandle(byte[] cmd, byte[] cmdValue, DeviceStatus deviceStatus) {
        DeviceCmd deviceCmd = DeviceCmdFactory.makeDeviceCmd(cmd);
        deviceCmd.handle(cmdValue, deviceStatus);

        System.out.println("cmd: " + ByteUtil.ByteArrToHex(cmd) + ", cmdValue: " + ByteUtil.bytesToHexStr(cmdValue));
    }

    public static void main(String[] args) {

        System.out.println("手动转揉面");
        byte[] b1 = new byte[]{0x5A, (byte) 0xA5, (byte) 0xA1, 0x10, 0x13, 0x0E, 0x00, 0x03, 0x00, 0x02, 0x01, 0x01,
                0x01, 0x02, 0x02, 0x5A, 0x00
                , 0x02, 0x02, 0x02, 0x00, 0x04};
        DeviceStatus status1 = toDeviceStatus(b1);
        System.out.println("status1: " + status1);

        System.out.println("正转1速，温度为0，倒数到一秒时");
        byte[] b2 = new byte[]{0x5A , (byte) 0xA5,0x45 ,0x10 ,0x29 ,0x05 ,0x00  ,0x01  ,0x01 ,0x02 ,0x02 ,0x01 ,0x00};
        DeviceStatus status2 = toDeviceStatus(b2);
        System.out.println("status2: " + status2);

        System.out.println("正转1速，温度为0，倒数结束");
        byte[] b3 = new byte[]{0x5A , (byte) 0xA5,0x5F ,0x10 ,0x2B ,0x0E ,0x00,0x03 ,0x05 ,0x02 ,0x01 ,0x00 ,0x01 ,
                0x02 ,0x02 ,0x00 ,0x00 ,0x02 ,0x02 ,0x02, 0x00, 0x00};
        DeviceStatus status3 = toDeviceStatus(b3);
        System.out.println("status3: " + status3);
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getSetSpeed() {
        return setSpeed;
    }

    public void setSetSpeed(Integer setSpeed) {
        this.setSpeed = setSpeed;
    }

    public Integer getSetTemp() {
        return setTemp;
    }

    public void setSetTemp(Integer setTemp) {
        this.setTemp = setTemp;
    }

    public Integer getActTemp() {
        return actTemp;
    }

    public void setActTemp(Integer actTemp) {
        this.actTemp = actTemp;
    }

    public Boolean getCelsius() {
        return isCelsius;
    }

    public void setCelsius(Boolean celsius) {
        isCelsius = celsius;
    }

    public Boolean getReverse() {
        return reverse;
    }

    public void setReverse(Boolean reverse) {
        this.reverse = reverse;
    }

    public Boolean getCover() {
        return isCover;
    }

    public void setCover(Boolean cover) {
        isCover = cover;
    }

    public Boolean getDeviceStartStatus() {
        return deviceStartStatus;
    }

    public void setDeviceStartStatus(Boolean deviceStartStatus) {
        this.deviceStartStatus = deviceStartStatus;
    }

    @Override
    public String toString() {
        return "DeviceStatus{" +
                "mode=" + mode +
                ", time=" + time +
                ", setSpeed=" + setSpeed +
                ", setTemp=" + setTemp +
                ", actTemp=" + actTemp +
                ", isCelsius=" + isCelsius +
                ", reverse=" + reverse +
                ", isCover=" + isCover +
                ", deviceStartStatus=" + deviceStartStatus +
                '}';
    }
}
