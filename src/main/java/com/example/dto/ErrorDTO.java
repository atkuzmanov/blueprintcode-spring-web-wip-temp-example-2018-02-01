package com.example.dto;

import lombok.NoArgsConstructor;
import lombok.Data;

/**
 * Represents an error which was ecnountered during request handling.
 */
@Data
@NoArgsConstructor
public final class ErrorDTO {
    String message;
    String type;
}
