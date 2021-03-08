package ru.netology.manager;

import java.util.*;

public class FileOpenManager {
    Map<String, String> hm = new HashMap<>();

    public Map<String, String> getHm() {
        return hm;
    }

    public void registerApp(String ext, String app) {
        String ext1 = ext.toLowerCase();
        hm.put(ext1, app);
    }

    public String getApp(String ext) {
        String app = hm.get(ext);
        return app;
    }

    public void removeApp(String ext) {
        hm.remove(ext);
    }

    public List<String> getListExt() {
        List<String> list = new ArrayList<>(hm.keySet());
        list.sort(Comparator.naturalOrder());
        return list;
    }

    public List<String> getListApp() {
        Set<String> set = new HashSet<>(hm.values());
        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
