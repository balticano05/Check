package ru.clevertec.check.utils.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {
    private static final Pattern ID_QUANTITY_PATTERN = Pattern.compile("\\d+-\\d+");
    private static final Pattern DISCOUNT_CARD_PATTERN = Pattern.compile("discountCard=(\\d{4})");
    private static final Pattern BALANCE_DEBIT_CARD_PATTERN = Pattern.compile("balanceDebitCard=(-?\\d+(\\.\\d{1,2})?)");

    public static ParsedInput parseInput(String input) {
        List<String> idQuantityPairs = new ArrayList<>();
        String discountCard = null;
        double balanceDebitCard = 0;

        Matcher idQuantityMatcher = ID_QUANTITY_PATTERN.matcher(input);
        while (idQuantityMatcher.find()) {
            idQuantityPairs.add(idQuantityMatcher.group());
        }

        Matcher discountCardMatcher = DISCOUNT_CARD_PATTERN.matcher(input);
        if (discountCardMatcher.find()) {
            discountCard = discountCardMatcher.group(1);
        }

        Matcher balanceDebitCardMatcher = BALANCE_DEBIT_CARD_PATTERN.matcher(input);
        if (balanceDebitCardMatcher.find()) {
            balanceDebitCard = Double.parseDouble(balanceDebitCardMatcher.group(1));
        }

        return new ParsedInput(idQuantityPairs, discountCard, balanceDebitCard);
    }
}
