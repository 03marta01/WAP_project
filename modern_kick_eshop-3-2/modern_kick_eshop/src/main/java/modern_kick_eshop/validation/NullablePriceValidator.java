package modern_kick_eshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NullablePriceValidator implements ConstraintValidator<NullablePrice, Double> {

    @Override
    public boolean isValid(Double price, ConstraintValidatorContext context) {
        return (price == null) ? true : (price > 0);
    }
}
