package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();

    @Nested
    public class Empty {
        @Test
        void shouldGetApp() {
            String actual = manager.getApp("html");
            assertEquals(null, actual);
        }

        @Test
        void shouldRemoveApp() {
            manager.removeApp("html");

            Map<String, String> expected = new HashMap<String, String>();
            Map<String, String> actual = manager.getHm();
            assertEquals(expected, actual);
        }

        @Test
        void shouldGetListExt() {
            List<String> expected = new ArrayList<>();
            List<String> actual = manager.getListExt();
            assertEquals(expected, actual);

        }

        @Test
        void shouldGetListApp() {
            List<String> expected = new ArrayList<>();
            List<String> actual = manager.getListApp();
            assertEquals(expected, actual);
        }
    }

    @Nested
    public class SingleItem {

        @BeforeEach
        void setup() {
            manager.registerApp("html", "Chrome");
        }

        @Test
        void shouldGetApp() {
            String actual = manager.getApp("html");
            assertEquals("Chrome", actual);
        }

        @Test
        void shouldRemoveApp() {
            manager.removeApp("html");

            Map<String, String> expected = new HashMap<String, String>();
            Map<String, String> actual = manager.getHm();
            assertEquals(expected, actual);
        }

        @Test
        void shouldGetListExt() {
            List<String> expected = new ArrayList<>(List.of("html"));
            List<String> actual = manager.getListExt();
            assertEquals(expected, actual);

        }

        @Test
        void shouldGetListApp() {
            List<String> expected = new ArrayList<>(List.of("Chrome"));
            List<String> actual = manager.getListApp();
            assertEquals(expected, actual);
        }
    }

    @Nested
    public class MultipleItems {

        @BeforeEach
        void setup() {
            manager.registerApp("html", "Chrome");
            manager.registerApp("jpg", "Paint");
            manager.registerApp("mp4", "PlayerWM");
        }

        @Test
        void shouldGetApp() {
            String actual = manager.getApp("html");
            assertEquals("Chrome", actual);
        }

        @Test
        void shouldGetAppIfNotExist() {
            String actual = manager.getApp("htm");
            assertEquals(null, actual);
        }

        @Test
        void shouldRemoveApp() {
            manager.removeApp("html");

            Map<String, String> expected = new HashMap<String, String>();
            expected.put("jpg", "Paint");
            expected.put("mp4", "PlayerWM");
            Map<String, String> actual = manager.getHm();
            assertEquals(expected, actual);
        }

        @Test
        void shouldRemoveAppIfNotExist() {
            manager.removeApp("htm");

            Map<String, String> expected = new HashMap<String, String>();
            expected.put("html", "Chrome");
            expected.put("jpg", "Paint");
            expected.put("mp4", "PlayerWM");
            Map<String, String> actual = manager.getHm();
            assertEquals(expected, actual);
        }

        @Test
        void shouldGetListExt() {
            List<String> expected = new ArrayList<>(List.of("html", "jpg", "mp4"));
            List<String> actual = manager.getListExt();
            assertEquals(expected, actual);

        }

        @Test
        void shouldGetListApp() {
            List<String> expected = new ArrayList<>(List.of("Chrome", "Paint", "PlayerWM"));
            List<String> actual = manager.getListApp();
            assertEquals(expected, actual);
        }
    }
}