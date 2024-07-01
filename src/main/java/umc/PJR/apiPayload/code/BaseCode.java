package umc.PJR.apiPayload.code;

public interface BaseCode { // 이를 구체화 하는 Status에서 두 개의 메소드를 반드시 Override할 것을 강제합니다.

    public ReasonDTO getReason();

    public ReasonDTO getReasonHttpStatus();
}