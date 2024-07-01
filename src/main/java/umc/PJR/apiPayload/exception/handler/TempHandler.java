package umc.PJR.apiPayload.exception.handler;

import umc.PJR.apiPayload.code.BaseErrorCode;
import umc.PJR.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
