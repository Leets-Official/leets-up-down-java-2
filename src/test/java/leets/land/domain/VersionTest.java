package leets.land.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VersionTest {

    @Test
    void 없는_버전를_입력한_경우_예외를_반환한다() {
        assertThrows(Exception.class, () -> {
            Version.versionValidator(0);
        });
    }

    @Test
    void 입력_받은_버전에_맞는_게임을_실행한다() {
        int version = 1;
        Version actual = Version.versionValidator(version);
        assertThat(actual).isEqualTo(Version.NUMBER);
    }
}