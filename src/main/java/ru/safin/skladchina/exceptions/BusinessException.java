package ru.safin.skladchina.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor()
public class BusinessException extends RuntimeException {

    @NonNull
    private String title;

    private String detail;

    public static BusinessException create(String title) {
        return build(title, null);
    }

    public static BusinessException create(String title, String detail) {
        return build(title, detail);
    }
    private static BusinessException build(String title, String detail) {
        return new BusinessException(title, detail);
    }
}
