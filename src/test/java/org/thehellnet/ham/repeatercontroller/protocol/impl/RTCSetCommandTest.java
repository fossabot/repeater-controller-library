package org.thehellnet.ham.repeatercontroller.protocol.impl;

import org.junit.jupiter.api.Test;
import org.thehellnet.ham.repeatercontroller.protocol.CommandType;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RTCSetCommandTest {

    @Test
    void serializeArgs() {
        RTCSetCommand input = new RTCSetCommand(CommandType.Request);
        input.setTimestamp(LocalDateTime.of(2023, 12, 16, 17, 47, 30, 0));

        byte[] expected = new byte[]{(byte) 0x65, (byte) 0x7d, (byte) 0xe2, (byte) 0xb2};
        byte[] actual = input.serializeArgs();
        assertArrayEquals(expected, actual);
    }

    @Test
    void parseArgs() {
        byte[] input = new byte[]{(byte) 0x65, (byte) 0x7d, (byte) 0xe2, (byte) 0xb2};
        RTCSetCommand expected = new RTCSetCommand(CommandType.Response);
        expected.setTimestamp(LocalDateTime.of(2023, 12, 16, 17, 47, 30, 0));

        RTCSetCommand actual = new RTCSetCommand(CommandType.Response);
        actual.parseArgs(input);

        assertEquals(expected, actual);
    }
}