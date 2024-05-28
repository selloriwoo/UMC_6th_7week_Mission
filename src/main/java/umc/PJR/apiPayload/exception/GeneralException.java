package umc.PJR.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.PJR.apiPayload.code.BaseErrorCode;
import umc.PJR.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
