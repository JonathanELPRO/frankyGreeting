package com.ucb.franky;

public record TranslateRequestDto(
        String message,
        Language source,
        Language target
) {
}
