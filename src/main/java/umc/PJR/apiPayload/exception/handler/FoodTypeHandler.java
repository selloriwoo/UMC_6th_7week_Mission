package umc.PJR.apiPayload.exception.handler;

import umc.PJR.apiPayload.code.BaseErrorCode;
import umc.PJR.apiPayload.exception.GeneralException;

public class FoodTypeHandler extends GeneralException {
    public FoodTypeHandler(BaseErrorCode errorCode) { super(errorCode);}
}
