package dk.wortmann.storebox.model;

import lombok.Data;

@Data
public class Card {
    private String userId;
    private String cardId;
    private String name;
    private String truncatedCardNumber;
    private int cardTypeId;
    private ExpiryDate expiry;
    private boolean multipleCardNumbers;
    private String externalCardId;
    private String origin;
}
