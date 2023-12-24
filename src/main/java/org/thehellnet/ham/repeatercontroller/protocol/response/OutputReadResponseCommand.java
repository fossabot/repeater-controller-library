package org.thehellnet.ham.repeatercontroller.protocol.response;

import org.thehellnet.ham.repeatercontroller.protocol.CommandType;
import org.thehellnet.ham.repeatercontroller.protocol.ResponseType;

import java.util.Objects;

public class OutputReadResponseCommand extends AbstractResponseCommand {

    protected int outputNumber;
    protected boolean status;

    public OutputReadResponseCommand(ResponseType responseType) {
        super(CommandType.OutputRead, responseType);
    }

    protected OutputReadResponseCommand(CommandType commandType, ResponseType responseType) {
        super(commandType, responseType);
    }

    public int getOutputNumber() {
        return outputNumber;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public void parseArgs(byte[] args) {
        outputNumber = args[0];
        status = args[1] > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutputReadResponseCommand that = (OutputReadResponseCommand) o;
        return outputNumber == that.outputNumber && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), outputNumber, status);
    }
}
