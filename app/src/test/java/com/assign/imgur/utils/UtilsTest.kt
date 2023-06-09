package com.assign.imgur.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UtilsTest {

    @Test
    fun `similarity between two strings must be in between 0 and 1`() {
        val result = Utils.findSimilarity("abc","xyz")
        assertThat(result).isAtLeast(0.0)
        assertThat(result).isAtMost(1.0)
    }

    @Test
    fun `levenshtein distance between any two strings is greater than or equal to zero`() {
        val result = Utils.getLevenshteinDistance("abc","xyz")
        assertThat(result).isAtLeast(0)
    }
}