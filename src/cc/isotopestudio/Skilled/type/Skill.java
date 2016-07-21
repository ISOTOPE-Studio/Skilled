/*
 * Copyright (c) 2016. ISOTOPE Studio
 */

package cc.isotopestudio.Skilled.type;

public enum Skill {
    c1s1(1, 1, ""),
    c1s2(1, 2, ""),
    c1s3(1, 3, ""),
    c1s4(1, 4, ""),
    c2s1(2, 1, ""),
    c2s2(2, 2, ""),
    c2s3(2, 3, ""),
    c2s4(2, 4, ""),
    c3s1(3, 1, ""),
    c3s2(3, 2, ""),
    c3s3(3, 3, ""),
    c3s4(3, 4, ""),
    c4s1(4, 1, ""),
    c4s2(4, 2, ""),
    c4s3(4, 3, ""),
    c4s4(4, 4, ""),
    c5s1(5, 1, ""),
    c5s2(5, 2, ""),
    c5s3(5, 3, ""),
    c5s4(5, 4, ""),
    c6s1(6, 1, ""),
    c6s2(6, 2, ""),
    c6s3(6, 3, ""),
    c6s4(6, 4, ""),
    c7s1(7, 1, ""),
    c7s2(7, 2, ""),
    c7s3(7, 3, ""),
    c7s4(7, 4, ""),
    c8s1(8, 1, ""),
    c8s2(8, 2, ""),
    c8s3(8, 3, ""),
    c8s4(8, 4, "");

    private final int job;
    private final int id;
    private final String name;

    Skill(int job, int id, String name) {
        this.job = job;
        this.id = id;
        this.name = name;
    }

    public int getJob() {
        return job;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
