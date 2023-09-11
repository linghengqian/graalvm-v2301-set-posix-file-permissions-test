package com.lingh;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ContestTest {

    @Test
    @EnabledOnOs({OS.LINUX})
    void test() throws IOException {
        String pathInClasspath;
        Path result = Paths.get(Objects.requireNonNull(getClass().getResource("/script/demo.sh")).getPath());
        Files.setPosixFilePermissions(result, Set.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE,
                PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE,
                PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_EXECUTE
        ));
        pathInClasspath = result.toString();
        assertThat(pathInClasspath).isNotNull();
    }
}
