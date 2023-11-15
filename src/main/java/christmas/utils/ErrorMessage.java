package christmas.utils;

public enum ErrorMessage {
    날짜,
    주문;

    @Override
    public String toString() {
        return "[ERROR] 유효하지 않은 " + name() + "입니. 다시 입력해 주세요\n";
    }
}
