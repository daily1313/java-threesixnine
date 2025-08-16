package util;

import com.example.exception.InvalidGameOptionException;
import com.example.util.GameOptionValidator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class GameOptionValidatorTest {

    @Test
    void 옵션이_1_또는_2면_예외가_발생하지_않는다() {
        // when & then
        assertThatCode(() -> GameOptionValidator.validateGameOption(1)).doesNotThrowAnyException();
        assertThatCode(() -> GameOptionValidator.validateGameOption(2)).doesNotThrowAnyException();
    }

    @Test
    void 옵션이_1_또는_2가_아니면_예외가_발생한다() {
        // when & then
        assertThatThrownBy(() -> GameOptionValidator.validateGameOption(0))
                .isInstanceOf(InvalidGameOptionException.class);
        assertThatThrownBy(() -> GameOptionValidator.validateGameOption(3))
                .isInstanceOf(InvalidGameOptionException.class);
        assertThatThrownBy(() -> GameOptionValidator.validateGameOption(-1))
                .isInstanceOf(InvalidGameOptionException.class);
    }
}
