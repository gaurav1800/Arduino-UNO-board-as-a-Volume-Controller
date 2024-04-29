package sample;


import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;

public class SetSystemVolume {

    public static void setVolume(double volume) {
        double finalVolume = 655.35 * volume; // multiplying by 655.35, because that is the 1/100 of the max value of volume
                                              // from the nircmd library

        Runtime runtime = Runtime.getRuntime();
        Process process;

        try
        {
            process = runtime.exec("cmd /c D:\\Desktop\\nircmd-x64\\nircmd.exe setsysvolume " + finalVolume);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
