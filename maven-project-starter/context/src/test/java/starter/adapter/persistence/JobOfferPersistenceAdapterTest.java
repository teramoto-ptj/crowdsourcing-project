package starter.adapter.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import starter.domain.*;

import javax.money.Monetary;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = PersistenceTestConfig.class)
@Import(JobOfferPersistenceAdapter.class)
@JooqTest
class JobOfferPersistenceAdapterTest {
    @Autowired
    private JobOfferPersistenceAdapter sut;

    @Test
    void test() {
        JobOffer jobOffer = JobOffer.of(
                new JobOfferID(),
                Title.of("title"),
                Description.of("desc"),
                RequiredSkill.of("skill"),
                Budget.of(new BigDecimal("100000"), Monetary.getCurrency("JPY")),
                ContractHopeNumber.of(1),
                JobOfferType.COMPETITION,
                DueDate.of(LocalDate.now().plusDays(10))
        );
        sut.save(jobOffer);
        Page<JobOffer> jobOffers = sut.getJobOffers("title", PageRequest.of(0, 10));
        assertThat(jobOffers.getTotalElements()).isEqualTo(1);
        assertThat(jobOffers.getContent().get(0))
                .hasFieldOrPropertyWithValue("title", jobOffer.getTitle());
    }
}