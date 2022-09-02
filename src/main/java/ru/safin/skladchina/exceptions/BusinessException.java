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
}
