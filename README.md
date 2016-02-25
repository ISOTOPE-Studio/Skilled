#Skilled
职业插件

##加入职业
命令 `/class` 弹出GUI界面

##技能球
输入 `/cbind <1-4>` ，将职业的技能绑定到自己想绑定的东西上，右键使用

##法力值
法力值初始是两百，当玩家每次使用技能的时候都会消耗法力

每隔5秒法力值恢复

##技能点
玩家刚加入职业的时候，会获得一点的技能点，技能点可以使用指令获得，指令只能有发放技能点的人才能用，职业的技能都是需要技能点来解锁，并且可以使用技能点来升级技能

命令 `/skill` 或者 `/cSkill` 弹出GUI界面

###管理员给予技能点

命令 `/skilled addsp <玩家名字>`

权限：`Skilled.admin`

##职业与技能
###普通职业
####圣谕
技能1：治愈：恢复目标生命值

技能2：活力：恢复目标魔法值

技能3：神圣打击：召唤天雷攻击敌人

技能4：生命源泉：群体恢复
 
####暗影
技能1：影击：瞬移到背后给敌人一击

技能2：影化：隐身

技能3：孤注一掷：血量减少，攻击力上升

技能4：影舞：挥动匕首，使周围敌人受到伤害，并且附带中毒效果

####鹰眼
技能1：警惕：加移动速度和跳跃

技能2：魔法箭：射出的箭附带随机负面效果

技能3：轻语：一定时间增加攻击力

技能4：箭雨：从空中落下一片箭雨

####铁卫
技能1：坚定不移：加抗性与血量

技能2：怒吼：发出一个火球，伤害：50

技能3：不屈：获得再生 II

技能4：坚不可摧：三秒内无视伤害

####血怒
技能1：压制：攻击使目标虚弱

技能2：狂化：自身被点燃，但攻击带生命偷取

技能3：怒火：范围使敌人受到伤害且燃烧

技能4：一夫当关：一定时间内攻击力大幅提升，获得再生效果

###隐藏职业
所有职业的权限：`Skilled.class.*`

####引魂
权限：`Skilled.class.6`

技能1：控魂：使敌人减速

技能2：诱魂：造成单体伤害并使敌人进入负面效果

技能3：破魂：造成范围击退并产生短暂的禁锢

技能4：灭火：单体攻击，有较小几率秒杀敌人，失败则造成少量伤害

####光骑
权限：`Skilled.class.7`
技能1：审判：造成单体伤害并点燃目标

技能2：守护：范围增加抗性

技能3：祈祷：生命吸收，伤害增加

技能4：神临：无敌

####猎刃
权限：`Skilled.class.8`
技能1：影：增加移动速度和攻击力以及生命恢复

技能2：烈：单体伤害，附加点燃和虚弱

技能3：暗：一定时间内攻击附带虚弱和失明

技能4：刃：范围伤害，附带虚弱和凋零
