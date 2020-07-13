package br.gabrielsmartins.smartpayment.messaging.adapters.persistence.repository.payments;

import br.gabrielsmartins.smartpayment.messaging.adapters.persistence.PersistenceAdapterTest;
import br.gabrielsmartins.smartpayment.messaging.adapters.persistence.entity.payments.PaymentEntity;
import br.gabrielsmartins.smartpayment.messaging.adapters.persistence.entity.payments.PaymentEntity.PaymentMethodEntity;
import br.gabrielsmartins.smartpayment.messaging.application.domain.enums.PaymentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {PersistenceAdapterTest.class})
@ActiveProfiles("test")
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository repository;


    @Test
    @DisplayName("Given Payment When Save Then Return Saved Payment")
    public void givenPaymentWhenSaveThenReturnSavedPayment(){
        PaymentMethodEntity paymentMethod = PaymentMethodEntity.builder()
                .withDiscount(new BigDecimal(100.00))
                .withTotalAmountPaid(new BigDecimal(1400.00))
                .withPaymentType(PaymentType.CREDIT_CARD)
                .build();

        PaymentEntity paymentEntity = PaymentEntity.builder()
                .withId(UUID.randomUUID().toString())
                .withPaymentNumberIdentifier(UUID.randomUUID().toString())
                .withDueDate(LocalDate.now())
                .withPaymentDate(LocalDate.now())
                .withTotalAmount(new BigDecimal(1500.00))
                .withTotalAmountPaid(new BigDecimal(1400.00))
                .build();

        paymentEntity.addPaymentMethod(paymentMethod);


        PaymentEntity savedPayment = this.repository.save(paymentEntity);
        assertThat(savedPayment).isNotNull();
    }
}
