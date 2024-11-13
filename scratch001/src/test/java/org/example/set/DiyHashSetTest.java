package org.example.set;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiyHashSetTest {

    @Test
    void testNoDuplicates() {
        String word = "abcdefghijklmnopqrstuvwxyz123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        DiyHashSet set = new DiyHashSet();
        for (char c : word.toCharArray()) {
            System.out.println("char = " + c);
            boolean isNotDuplicate = set.add(c);
            assertThat(isNotDuplicate).isTrue();
        }

        DiyHashSet.Iterator iterator = set.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        System.out.println("sb: " + sb);
        assertThat(sb.length()).isEqualTo(word.length());
        System.out.println("hashset: " + set);
    }

    @Test
    void testWithDuplicates() {
        String word = "aoooobcefgbcdefghijklmnopoooooahbcdeaoo"; // 16 unique chars

        DiyHashSet set = new DiyHashSet();
        for (char c : word.toCharArray()) {
            System.out.println("char = " + c);
            set.add(c);
        }

        DiyHashSet.Iterator iterator = set.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        System.out.println("sb: " + sb);
        assertThat(sb.length()).isEqualTo(16);
        System.out.println("hashset: " + set);
    }


}