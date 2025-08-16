package util;

import com.example.util.NameParser;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class NameParserTest {

    @Test
    void 콤마를_기준으로_이름을_파싱한다() {
        // given
        String input = " Jay, Tong , Kim , Park ";

        // when
        List<String> names = NameParser.parseInputToPlayerNames(input);

        // then
        assertThat(names).containsExactly("Jay", "Tong", "Kim", "Park");
    }
}
