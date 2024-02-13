package potato.nsfServer.DataCenter.exception;

import potato.nsfServer.Global.error.ErrorCode;
import potato.nsfServer.Global.error.exception.InvalidValueException;

public class NoMoreDataException extends InvalidValueException {
    public NoMoreDataException(){
        super(ErrorCode.DATA_IS_NOT_EXIST);
    }
}
