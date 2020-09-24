create table SYS_CODE_B
(
    SYS_CODE_ID VARCHAR(40) primary key,
    NAME         VARCHAR(100),
    PARENT_ID    VARCHAR(40),
    PARENT_NAME  VARCHAR(100),
    LAYER_NUM    INT,
    IS_LEAF      INT,
    QUOTE_NUM    INT,
    CNOTE        VARCHAR(100),
    ICO          VARCHAR(20),
    ORDER_NO     INT,
    STATE        CHAR(1),
    CREATED_BY   VARCHAR(40),
    CREATED_TIME DATETIME,
    UPDATED_BY   VARCHAR(40),
    UPDATED_TIME DATETIME
);

insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('01', '系统代码', '-1', 'root', 0, 0, 1, null, null, 0, '1', null, NOW(), null, NOW());
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('0101', '人员级别', '01', '系统代码', 1, 0, 0, null, null, 1, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010102', '管理员', '0101', '人员级别', 2, 1, 0, null, null, 1, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010103', '总经理', '0101', '人员级别', 2, 1, 0, null, null, 2, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010104', '部门经理', '0101', '人员级别', 2, 1, 0, null, null, 3, null, '001', NOW(), '001', NOW());
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010105', '组长', '0101', '人员级别', 2, 1, 0, null, null, 4, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010106', '员工', '0101', '人员级别', 2, 1, 0, null, null, 5, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('0102', '栏目', '01', '系统代码', 1, 0, 0, null, null, 2, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010202', '新闻报道', '0102', '栏目', 2, 1, 0, null, null, 1, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010203', '通知公告', '0102', '栏目', 2, 1, 0, null, null, 2, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010204', '公司制度', '0102', '栏目', 2, 1, 0, null, null, 3, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010205', '行业报道', '0102', '栏目', 2, 1, 0, null, null, 4, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010206', '大事记', '0102', '栏目', 2, 1, 0, null, null, 5, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('0103', '厂家类型', '01', '系统代码', 1, 0, 1, null, null, 3, null, '001', NOW(), '001', NOW());
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010302', '玻璃', '0103', '厂家类型', 2, 1, 1, null, null, 1, null, '001', NOW(), '001', NOW());
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010303', '彩盒', '0103', '厂家类型', 2, 1, 1, null, null, 2, null, '001', NOW(), '001', NOW());
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010304', 'PVC', '0103', '厂家类型', 2, 1, 1, null, null, 3, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010305', '花纸', '0103', '厂家类型', 2, 1, 1, null, null, 4, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010306', '保丽龙', '0103', '厂家类型', 2, 1, 1, null, null, 5, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010307', '电镀', '0103', '厂家类型', 2, 1, 1, null, null, 6, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010308', '水龙头', '0103', '厂家类型', 2, 1, 1, null, null, 7, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010309', '蜡', '0103', '厂家类型', 2, 1, 1, null, null, 8, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('0104', '附件类型', '01', '系统代码', 1, 0, 1, null, null, 4, null, '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010402', '彩盒', '0104', '附件类型', 2, 1, 1, null, null, 1, '1', '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010403', '花纸', '0104', '附件类型', 2, 1, 1, null, null, 2, '1', '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010404', '保丽龙', '0104', '附件类型', 2, 1, 1, null, null, 3, '1', '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010405', '电镀', '0104', '附件类型', 2, 1, 1, null, null, 4, '1', '001', NOW(), null, NOW());
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010407', 'PVC', '0104', '附件类型', 2, 1, 0, null, null, 6, '1', '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010408', '喷头', '0104', '附件类型', 2, 1, 0, null, null, 7, '1', '001', NOW(), null, null);
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('010409', '不锈钢勺子', '0104', '附件类型', 2, 1, 0, null, null, 8, '1', '001', NOW(), null, NOW());
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('a', '系统代码', '-1', 'root', 0, 0, 1, null, null, 0, '1', null, NOW(), null, NOW());
insert into SYS_CODE_B (SYS_CODE_ID, NAME, PARENT_ID, PARENT_NAME, LAYER_NUM, IS_LEAF, QUOTE_NUM, CNOTE, ICO, ORDER_NO, STATE, CREATED_BY, CREATED_TIME, UPDATED_BY, UPDATED_TIME)
values ('b', '人员级别', '01', '系统代码', 1, 0, 0, null, null, 1, null, '001', NOW(), null, null);
