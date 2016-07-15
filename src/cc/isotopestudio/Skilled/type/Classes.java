package cc.isotopestudio.Skilled.type;

/**
 * Created by Mars on 7/13/2016.
 * Copyright ISOTOPE Studio
 */
public enum Classes {
    c1(1, "", Skill.c1s1, Skill.c1s2, Skill.c1s3, Skill.c1s4),
    c2(2, "", Skill.c2s1, Skill.c2s2, Skill.c2s3, Skill.c2s4),
    c3(3, "", Skill.c3s1, Skill.c3s2, Skill.c3s3, Skill.c3s4),
    c4(4, "", Skill.c4s1, Skill.c4s2, Skill.c4s3, Skill.c4s4),
    c5(5, "", Skill.c5s1, Skill.c5s2, Skill.c5s3, Skill.c5s4),
    c6(6, "", Skill.c6s1, Skill.c6s2, Skill.c6s3, Skill.c6s4),
    c7(7, "", Skill.c7s1, Skill.c7s2, Skill.c7s3, Skill.c7s4),
    c8(8, "", Skill.c8s1, Skill.c8s2, Skill.c8s3, Skill.c8s4);

    private final int id;
    private final String name;
    private final Skill skill1;
    private final Skill skill2;
    private final Skill skill3;
    private final Skill skill4;

    Classes(int id, String name, Skill skill1, Skill skill2, Skill skill3, Skill skill4) {
        this.id = id;
        this.name = name;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Skill getSkill1() {
        return skill1;
    }

    public Skill getSkill2() {
        return skill2;
    }

    public Skill getSkill3() {
        return skill3;
    }

    public Skill getSkill4() {
        return skill4;
    }
}
