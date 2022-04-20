package starter.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import java.math.BigDecimal;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuotationAmount {
    MonetaryAmount value;

    public static QuotationAmount of(BigDecimal value, CurrencyUnit currencyUnit) {
        return new QuotationAmount(Money.of(value, currencyUnit));
    }
}
