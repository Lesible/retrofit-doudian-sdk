package io.lesible.model.enumeration;

/**
 * <p> @date: 2021-04-22 16:47</p>
 *
 * @author 何嘉豪
 */
public enum CheckStatus {

    /**
     * 未提审
     */
    NOT_REVIEW("1"),

    /**
     * 审核中
     */
    REVIEWING("2"),

    /**
     * 审核通过
     */
    REVIEW_PASSED("3"),

    /**
     * 审核驳回
     */
    REVIEW_REJECTED("4"),

    /**
     * 封禁
     */
    FORBIDDEN("5"),

    /**
     * 审核通过,待上架
     */
    READY_TAKE_ON_SHELVES("7");

    private final String checkStatus;

    CheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String value() {
        return checkStatus;
    }
}
