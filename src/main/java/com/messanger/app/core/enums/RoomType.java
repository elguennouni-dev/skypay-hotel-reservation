package com.messanger.app.core.enums;

public enum RoomType {
    SUITE,
    JUNIOR,
    STANDARD;

    public String toString() {
        return switch (this) {
            case SUITE -> "suite";
            case JUNIOR -> "junior";
            case STANDARD -> "standard";
        };
    }
}
