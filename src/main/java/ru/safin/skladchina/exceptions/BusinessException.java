package ru.safin.skladchina.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private String title;
    private String detail;
}
