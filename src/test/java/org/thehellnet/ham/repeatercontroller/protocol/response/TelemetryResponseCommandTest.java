package org.thehellnet.ham.repeatercontroller.protocol.response;

import org.junit.jupiter.api.Test;
import org.thehellnet.ham.repeatercontroller.protocol.ResponseType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TelemetryResponseCommandTest {

    @Test
    void parseArgs() {
        byte[] input = new byte[]{
                (byte) 0x65, (byte) 0x7d, (byte) 0xd3, (byte) 0x29,
                (byte) 0x41, (byte) 0x69, (byte) 0x99, (byte) 0x9a,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x41, (byte) 0x48, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00
        };

        TelemetryResponseCommand responseCommand = new TelemetryResponseCommand(ResponseType.Ack);
        responseCommand.parseArgs(input);

        assertEquals(LocalDateTime.of(2023, 12, 16, 16, 41, 13, 0), responseCommand.getTimestamp());
        assertEquals(12.5f, responseCommand.getBatteryVoltage());
        assertEquals(0.0f, responseCommand.getBatteryChargeCurrent());
        assertEquals(14.6f, responseCommand.getPanelVoltage());
        assertEquals(0.0f, responseCommand.getPanelCurrent());
    }
}