package ru.clevertec.check.utils.validation;

import java.util.regex.Pattern;

public final class FormatValidatorArgs {
    private static final Pattern ID_QUANTITY_PATTERN = Pattern.compile("\\d{1,7}-\\d{1,7}");
    private static final Pattern DISCOUNT_CARD_PATTERN = Pattern.compile("discountCard=\\d{4}");
    private static final Pattern BALANCE_DEBIT_CARD_PATTERN = Pattern.compile("balanceDebitCard=-?\\d{1,7}(\\.\\d{1,2})?");
    private static final int MAX_INTEGER = 9999999; // Максимальное значение для integer (7 цифр)
    private static final double MAX_DOUBLE = 9999999.99; // Максимальное значение для double (7 цифр до точки, 2 после)

    private static boolean hasDiscountCard = false;
    private static boolean hasBalanceDebitCard = false;

    public static boolean validateInput(String input) {
        String[] parts = input.split(" ");
        boolean hasIdQuantity = false;

        // Сброс переменных при каждой проверке
        hasDiscountCard = false;
        hasBalanceDebitCard = false;

        for (String part : parts) {
            if (ID_QUANTITY_PATTERN.matcher(part).matches()) {
                hasIdQuantity = true;
                if (!validateIdQuantity(part)) {
                    return false;
                }
            } else if (DISCOUNT_CARD_PATTERN.matcher(part).matches()) {
                hasDiscountCard = true;
            } else if (BALANCE_DEBIT_CARD_PATTERN.matcher(part).matches()) {
                hasBalanceDebitCard = true;
                if (!validateBalanceDebitCard(part)) {
                    return false;
                }
            } else {
                return false; // Неизвестный формат
            }
        }

        // Убедимся, что у нас есть хотя бы одна пара id-quantity и обязательный баланс карты
        return hasIdQuantity && hasBalanceDebitCard;
    }

    private static boolean validateIdQuantity(String part) {
        String[] values = part.split("-");
        try {
            int id = Integer.parseInt(values[0]);
            int quantity = Integer.parseInt(values[1]);
            return id <= MAX_INTEGER && quantity <= MAX_INTEGER;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean validateBalanceDebitCard(String part) {
        String value = part.split("=")[1];
        try {
            double balance = Double.parseDouble(value);
            return balance <= MAX_DOUBLE && balance >= -MAX_DOUBLE;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean hasDiscountCard() {
        return hasDiscountCard;
    }

    public static boolean hasBalanceDebitCard() {
        return hasBalanceDebitCard;
    }
}