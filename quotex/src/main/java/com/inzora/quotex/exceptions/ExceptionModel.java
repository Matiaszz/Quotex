package com.inzora.quotex.exceptions;

public record ExceptionModel(int code, String exception, String reason, String details) {
}