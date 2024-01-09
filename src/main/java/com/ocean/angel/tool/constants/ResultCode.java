package com.ocean.angel.tool.constants;

/**
 * @desc:
 * @author: jaime.yu
 * @time: 2022/4/20 11:29
 */
public enum ResultCode {

    SUCCESS(200, "Success"),

    BAD_REQUEST(400, "Bad Request"),

    Unauthorized(401, "Unauthorized"),

    DATA_PERMISSION_CHECK_FAILED(403, "Data permission verification failed."),

    NOT_FOUND(404, "Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    PARAM_ERROR(50000, "Parameter error."),

    RECORD_NOT_EXIST(500, "Record does not exist"),
    SUPPLIER_IS_EXISTS(500, "Supplier already exists"),

    SUPPLIER_NOT_EXIST(500, "The supplier does not exist"),

    CHANNEL_IS_EXISTS(500, "The channel already exists"),

    CHANNEL_ID_NULL(500, "The channel ID is empty"),

    CHANNEL_NOT_EXIST(500, "The channel does not exist"),

    CHANNEL_CHECKED(500, "The channel has been approved."),

    BUSINESS_IS_EXISTS(500, "The business line already exists"),

    BUSINESS_NOT_EXIST(500, "That business line does not exist"),

    DICTIONARY_IS_EXISTS(500, "Dictionary already exists"),

    PRODUCT_NOT_EXIST(500, "The product does not exist"),

    PRODUCT_NOT_CHECKED(500, "Product not approved"),

    PRODUCT_IS_CHECKED(500, "The product has been approved"),

    PRODUCT_NOT_PUBLISHED(500, "Product not listed"),

    PRODUCT_IS_PUBLISHED(500, "The product has been listed"),

    PRODUCT_CATEGORY_IS_EXISTS(500, "Product category already exists"),

    PRODUCT_CATEGORY_NOT_EXIST(500, "The product category does not exist"),

    PRODUCT_CATEGORY_ATTRIBUTE_IS_EXISTS(500, "Product classification attribute information already exists"),

    PRODUCT_SPECIFICATION_NOT_EXIST(500, "That product specification does not exist"),

    PRODUCT_SPECIFICATION_NOT_MATCH(500, "The product specification does not match the product"),

    CART_ITEM_NOT_EXIST(500, "The shopping cart item does not exist"),

    ORDER_CODE_NULL(500, "The order number is empty."),

    PAY_TYPE_NULL_OR_INCORRECT(500, "The payment method is empty or the value is incorrect."),

    SOURCE_TYPE_NULL_OR_INCORRECT(500, "The order source is empty or the value is incorrect"),

    AUTOMATIC_CONFIRMATION_TIME_NULL(500, "The automatic order confirmation time is empty"),

    ORDER_NOT_EXIST(500, "The order does not exist"),

    ORDER_INVALID(500, "The order is invalid, no product information available."),

    ORDER_ITEM_NULL(500, "The product data for the order items is empty"),

    ORDER_ID_NULL(500, "The order ID is empty"),

    ORDER_ID_NOT_MATCH(500, "The order ID mismatch"),

    ORDER_STATUS_VALIDATION_FAILED(500, "Order status verification failed"),

    ORDER_USER_VALIDATION_FAILED(500, "The order does not belong to this user, no actions can be performed"),

    ORDER_RECEIVER_NULL(500, "The recipient information of the order is empty"),

    ORDER_ITEM_NOT_EXIST(500, "The order item does not exist"),

    ADDRESS_NOT_EXIST(500, "The shipping address does not exist"),

    ;

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
