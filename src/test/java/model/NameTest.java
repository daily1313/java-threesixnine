package model;

import com.example.exception.NameNotBlankException;
import com.example.model.vo.Name;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class NameTest {

    @ValueSource(strings = {" ", ""})
    @ParameterizedTest
    public void 이름은_공백일_수_없다(String input) {
        // when & then
        assertThatThrownBy(() -> Name.from(input))
                .isInstanceOf(NameNotBlankException.class);
    }
}
