package util;

import com.example.exception.DuplicatedPlayerNameException;
import com.example.exception.NameNotBlankException;
import com.example.exception.NotEnoughNameSizeException;
import com.example.util.NameValidator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class NameValidatorTest {

    @Test
    void 입력이_공백이거나_null_이면_예외가_발생한다() {
        // when & then
        assertThatThrownBy(() -> NameValidator.validateInput(null))
                .isInstanceOf(NameNotBlankException.class);

        assertThatThrownBy(() -> NameValidator.validateInput(""))
                .isInstanceOf(NameNotBlankException.class);
    }

    @Test
    void 플레이어가_한명이면_예외가_발생한다() {
        // given
        List<String> oneName = List.of("Alice");

        // when & then
        assertThatThrownBy(() -> NameValidator.validateNameSize(oneName))
                .isInstanceOf(NotEnoughNameSizeException.class);
    }

    @Test
    void 플레이어의_이름이_중복되면_예외가_발생한다() {
        // given
        List<String> names = List.of("Alice", "Bob", "Alice");

        // when & then
        assertThatThrownBy(() -> NameValidator.validateDuplicatedPlayerNames(names))
                .isInstanceOf(DuplicatedPlayerNameException.class);
    }
}
