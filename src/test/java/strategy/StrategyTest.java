package strategy;

import com.example.strategy.GameStrategy;
import com.example.strategy.MultipleClapStrategy;
import com.example.strategy.SingleClapStrategy;
import fixture.StrategyFixture;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class StrategyTest {

    @ValueSource(ints = {1, 2})
    @ParameterizedTest
    void option_값에_따라_전략을_생성한다(int option) {
        // given
        GameStrategy gameStrategy = StrategyFixture.from(option);

        // when & then
        if(option == 1) {
            assertThat(gameStrategy).isInstanceOf(SingleClapStrategy.class);
        }
        if(option == 2) {
            assertThat(gameStrategy).isInstanceOf(MultipleClapStrategy.class);
        }
    }

    @Test
    void single_전략에서는_369_숫자에서_clap_한번만_반환한다() {
        // given
        GameStrategy gameStrategy = StrategyFixture.from(1);

        // when
        String answer = gameStrategy.getAnswer(33);

        // then
        assertThat(answer).isEqualTo("clap");
    }

    @CsvSource({
            "3, clap",
            "33, clapclap",
            "333, clapclapclap",
            "3333, clapclapclapclap"
    })
    @ParameterizedTest(name = "{0} 입력 시, {1} 반환")
    void multiple_전략에서는_369_숫자에서_clap_개수별로_반환한다(int input, String expected) {
        // given
        GameStrategy gameStrategy = StrategyFixture.from(2);

        // when
        String answer = gameStrategy.getAnswer(input);

        // then
        assertSoftly(softly -> softly.assertThat(answer).isEqualTo(expected));
    }
}
