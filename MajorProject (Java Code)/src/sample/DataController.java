package sample;


import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortMessageListenerWithExceptions;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.sql.SQLOutput;

public class DataController implements SerialPortMessageListenerWithExceptions {
    // private static byte[] dataValue = new byte[] {'\n'};

    public static double potValue; //declaring the potentiometer value

    private static final byte[] DELIMITER = new byte[]{'\n'};
    private final ObservableList<XYChart.Data<Number, Number>> dataPoints;

    public DataController() {
        this.dataPoints = FXCollections.observableArrayList();
    }

    public ObservableList<XYChart.Data<Number, Number>> getDataPoints() {
        return dataPoints;
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
            byte[] data = new byte[]{'\n'};
            data = serialPortEvent.getReceivedData();
            double dataValue = ByteBuffer.wrap(data).getInt();

            this.potValue = dataValue / 10.23;  //Divided by 10.23, since 1023 is the max value a potentiometer can get to,
                                                // So 10.23 would be the 1/100 of 1023
        }
        else
            {
            return;
            }
    }

    @Override
    public void catchException(Exception e) {
        e.printStackTrace();
    }

    @Override
    public byte[] getMessageDelimiter() {
        return DELIMITER;
    }

    @Override
    public boolean delimiterIndicatesEndOfMessage() {
        return true;
    }
}
