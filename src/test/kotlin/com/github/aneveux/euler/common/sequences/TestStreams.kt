package com.github.aneveux.euler.common.sequences

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestStreams {
    @Test
    fun testReplicate() {
        assertThat("toto".replicate(4)).containsExactly("toto", "toto", "toto", "toto")
        assertThat(1.replicate(0)).isEmpty()
        assertThat(true.replicate(1)).containsOnly(true)
    }
}