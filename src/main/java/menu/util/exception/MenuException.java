package menu.util.exception;

public enum MenuException {
    DUPLICATE_MENU("중복된 메뉴입니다."),
    CANNOT_EAT_MENU("코치가 먹을 수 없는 메뉴입니다.");

    private final String exceptionMessage;

    MenuException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
