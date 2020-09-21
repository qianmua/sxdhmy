
-- 产品表
create table ITEMS_C
(
    ITEMS_ID varchar(40) primary key,-- ITEMS_ID(主键)
    ITEM_NO varchar(40) not null,-- 编号
    ITEM_IMAGE varchar(200) not null ,-- 照片
    DESCRIPTION varchar(200) not null,-- 描述
    FACTORY_ID varchar(40), -- FACTORY_ID（外键）
    FOREIGN key(FACTORY_ID) REFERENCES factory_c(FACTORY_ID),
    FACTORY varchar(250) not null ,-- 厂家简称
    PRICE float not null,-- 市场价
    SIZE_LENGHT float not null, -- 尺寸长
    SIZE_WIDTH float not null,-- 尺寸宽
    SIZE_HEIGHT float not null,-- 尺寸高
    COLOR varchar(200) not null,-- 颜色
    PACKING varchar(20) not null,  -- 包装
    PACKING_UNIT varchar(10) not null,-- 包装单位
    TYPE20 float not null, -- 集装箱类别20
    TYPE40 float not null,-- 集装箱类别40
    TYPE40HC float not null,-- 集装箱类别40HC
    QTY int not null,-- 数量
    CBM float not null,-- 体积
    MPSIZE_LENGHT float not null,-- 大箱尺寸长
    MPSIZE_WIDTH float not null,-- 大箱尺寸宽
    MPSIZE_HEIGHT float not null,-- 大箱尺寸高
    CNOTE varchar(500) not null,  -- 备注
    INPUT_TIME datetime not null,-- 录入时间
    CREATE_BY varchar(40) not null,-- 创建人
    CREATE_DEPT varchar(40) not null,-- 创建部门
    CREATE_TIME datetime not null-- 创建日期
);
# insert into ITEMS_C(ITEM_NO,ITEM_IMAGE,DESCRIPTION,FACTORY_ID,FACTORY,PRICE,SIZE_LENGHT,SIZE_WIDTH,SIZE_HEIGHT,COLOR,PACKING,PACKING_UNIT,TYPE20,TYPE40,TYPE40HC,QTY,CBM,MPSIZE_LENGHT,MPSIZE_WIDTH,MPSIZE_HEIGHT,CNOTE,INPUT_TIME,CREATE_BY,CREATE_DEPT,CREATE_TIME) values(1,'1.png','一个很美的动漫图片',1,'有限公司','100','10','8','5','红色黄色','纸箱包装','陕西康达彩印厂','1','1','1','1','5','10','8','5','没有备注','2020-9-20','韩立亮','产品部','2020-9-20');

-- 合同商品附件
create table EXT_CPRODUCT_C
(
    EXT_CPRODUCT_ID varchar(40) primary key ,-- EXT_CPRODUCT_ID(主键)
    FACTORY_ID int not null, -- FACTORY_ID
    CONTRACT_PRODUCT_ID varchar(40) not null,-- CONTRACT_PRODUCT_ID
    CTYPE int not null,-- 类型[系统下拉列表]
    PRODUCT_NAME varchar(200) not null,-- 产品名称
    PRODUCT_NO varchar(50) not null,-- 货号
    PRODUCT_IMAGE varchar(200) not null,-- 货物照片
    PRODUCT_DESC varchar(600) not null,-- 货物描述
    LOADING_RATE varchar(30) not null,-- 装率
    PACKING_UNIT varchar(10) not null,-- 包装单位
    CNUMBER int not null,-- 数量
    OUT_NUMBER int not null,-- 实际出货数量
    FINISHED int not null,-- 是否出货完毕(0/1)
    GROSS_WEIGH float not null,-- 毛重
    NET_WEIGHT float not null,-- 净重
    SIZE_LENGHT float not null,-- 尺寸长
    SIZE_WIDTH float not null,-- 尺寸宽
    SIZE_HEIGHT float not null,-- 尺寸高
    PRODUCT_REQUEST varchar(2000) not null,-- 要求
    FACTORY varchar(200) not null,-- 厂家
    PRICE float not null,-- 单价
    AMOUNT float not null,-- 总金额
    CUNIT varchar(10) not null,-- EL单位
    BOX_NUM int not null,-- 件数
    EX_PRICE float not null,-- 出口单价
    EX_UNIT varchar(10) not null,-- 价格单位
    NO_TAX float not null,-- 不含税
    TAX float not null,-- 含税
    COST_PRICE float not null,-- 收购成本金额
    COST_TAX float not null,-- 收购成本税金
    ACCESSORIES int not null,-- 是否是附件(0/1)
    ORDER_NO int not null-- 排序号
);
-- 购销合同
create table CONTRACT_C
(
    CONTRACT_ID varchar(40) primary key ,-- CONTRACT_ID(主键)
    OFFEROR varchar(200) not null,-- 收购方
    CONTRACT_NO varchar(20) not null,-- 合同号
    SIGNING_DATE datetime not null,-- 签单日期
    INPUT_BY varchar(30) not null,-- 制单人
    CHECK_BY varchar(30) not null,-- 审单人
    INSPECTOR varchar(30) not null,-- 验货员
    TOTAL_AMOUNT float not null,-- 总金额
    REQUEST varchar(200) not null,-- 要求
    CUSTOM_NAME varchar(200) not null,-- 客户名称
    SHIP_TIME datetime not null,-- 船期
    IMPORT_NUM int not null,-- 重要程度
    DELIVERY_PERIOD datetime not null,-- 交货期限
    REMARK varchar(600) not null,-- 说明
    PRINT_STYLE int not null,-- 打印版式(0/1)
    OLD_STATE int not null,-- 归档前状态(0/1)
    STATE int not null,-- 状态 0归档 1草稿 2待报运
    OUT_STATE int not null,-- 走货状态 0未走货 1部分 2全部
    CREATE_BY varchar(40) not null,-- 创建人
    CREATE_DEPT varchar(40) not null,-- 创建部门
    CREATE_TIME datetime not null-- 创建日期
);
# insert into CONTRACT_C(OFFEROR,CONTRACT_NO,SIGNING_DATE,INPUT_BY,CHECK_BY,INSPECTOR,TOTAL_AMOUNT,REQUEST,CUSTOM_NAME,SHIP_TIME,IMPORT_NUM,DELIVERY_PERIOD,REMARK,PRINT_STYLE,OLD_STATE,STATE,OUT_STATE,CREATE_BY,CREATE_DEPT,CREATE_TIME) values('后溥有限公司','后溥','2020-9-20','张乐','张乐','张乐','10000','还敢要要求！','后溥方','2050-9-20',1,'2020-10-20','没有说明',1,1,2,2,'韩立亮','商品部','2020-9-20');

-- 合同商品明细
create table CONTRACT_PRODUCT_C
(
    CONTRACT_PRODUCT_ID varchar(40) primary key ,-- CONTRACT_PRODUCT_ID(主键)
    CONTRACT_ID varchar(40) not null,-- CONTRACT_ID
    FOREIGN key (CONTRACT_PRODUCT_ID) REFERENCES CONTRACT_C(CONTRACT_ID),
    FACTORY_ID varchar(40) not null,-- FACTORY_ID
    PRODUCT_NAME varchar(200) not null,-- 产品名称
    PRODUCT_NO varchar(50) not null,-- 货号
    PRODUCT_IMAGE varchar(200) not null,-- 货物照片
    PRODUCT_DESC varchar(600) not null, -- 货物描述
    LOADING_RATE varchar(30) not null,-- 装率
    PACKING_UNIT varchar(10) not null,-- 包装单位
    CNUMBER int not null,-- 数量
    OUT_NUMBER int not null,-- 实际出货数量
    FINISHED int not null, -- 是否出货完毕(0或1)
    GROSS_WEIGHT float not null,-- 毛重
    NET_WEIGHT float not null,-- 净重
    SIZE_LENGHT float not null,-- 尺寸长
    SIZE_WIDTH float not null,-- 尺寸宽
    SIZE_HEIGHT float not null,-- 尺寸高
    PRODUCT_REQUEST varchar(2000) not null,-- 要求
    FACTORY varchar(200) not null,-- 厂家
    PRICE float not null,-- 单价
    AMOUNT float not null,-- 总金额
    CUNIT varchar(10) not null,-- EL单位
    BOX_NUM int not null,-- 箱数
    EX_PRICE float not null,-- 出口单价
    EX_UNIT varchar(10) not null,-- 价格单位
    NO_TAX float not null,-- 不含税
    TAX float not null,-- 含税
    COST_PRICE float not null,-- 收购成本金额
    COST_TAX float not null,-- 收购成本税金
    ACCESSORIES int not null,-- 是否是附件(0或1)
    ORDER_NO int not null-- 排序号
);
-- 表格用户模板表
create table USER_TEMP_B
(
    USER_TEMP_ID varchar(40) primary key ,-- USER_TEMP_ID
    KEY_CLASS varchar(30) not null,-- 分类
    KEY_NAME varchar(30) not null,-- 关键字
    KEY_CONTENT varchar(3000) not null,-- 内容
    STATE int not null,-- 状态(0/1)
    ORDER_NO int not null, -- 排序号
    CNOTE varchar(50) not null,-- 说明
    UPDATE_BY varchar(40) not null,-- 修改人
    UPDATE_TIME datetime not null-- 修改日期
);

-- 表格意见反馈的列清单

create table FEEDBACK_C
(
    FEEDBACK_ID varchar(40) primary key,-- FEEDBACK_ID
    INPUT_BY varchar(20) not null,-- 提出人
    INPUT_TIME timestamp not null,-- 提出时间
    TITLE varchar(200) not null,-- 标题
    CONTENT varchar(2000) not null,-- 内容
    CLASS_TYPE char(1) not null,-- 1管理2安全3建议4其他  分类
    TEL varchar(20) not null, -- 联系电话
    ANSWER_BY varchar(20) not null,-- 解决人
    ANSWER_TIME  timestamp not null,-- 解决时间
    SOLVE_METHOD  varchar(2000) not null,-- 解决办法
    RESOLUTION char(1) not null,-- 解决方式 1已修改2无需修改3重复问题4描述不完整5无法再现6其他
    DIFFICULTY char(1) not null,--  解决难度 1极难2比较难3有难度4一般
    IS_SHARE char(1) not null,-- 是否公开 0不公开1公开
    STATE int not null, -- 状态0未处理1已处理
    CREATE_BY varchar(40) not null,-- 创建人
    CREATE_DEPT varchar(40) not null,-- 创建部门
    CREATE_TIME timestamp -- 创建日期
);

-- I.1.7报运单
create table EXPORT_C
(
    EXPORT_ID varchar(40) primary key ,-- EXPORT_ID
    INPUT_DATE timestamp not null,-- 制单日期
    CONTRACT_IDS varchar(200) not null,-- 合同编号集合
    CUSTOMER_CONTRACT varchar(200) not null,-- 合同或确认书号
    LCNO varchar(10) not null,-- L/C NO
    CONSIGNEE varchar(100) not null,-- 收货人及地址
    MARKS varchar(1000)not null,-- 唛头
    SHIPMENT_PORT varchar(100) not null,-- 装运港
    DESTINATION_POR varchar(100) not null,-- 目的港
    TRANSPORT_MODE varchar(10) not null,-- 运输方式
    PRICE_CONDITION varchar(10) not null, -- 价格条件
    REMARK varchar(100) not null,-- 备注
    BOX_NUM int not null,-- 件数
    CNUMBER int not null,-- 数量
    PACKING_UNIT varchar(10) not null,-- 包装单位
    GROSS_WEIGHT float not null,-- 毛重
    NET_WEIGHT float not null,-- 净重
    SIZE_LENGHT float not null,-- 尺寸长
    SIZE_WIDTH float not null,-- 尺寸宽
    SIZE_HEIGHT float not null,--  尺寸高
    CSIZE float not null,-- 尺寸
    AMOUNT float not null, -- 总金额
    NO_TAX float not null,-- 不含税
    TAX float not null,-- 含税
    COST_TAX float not null,-- 收购成本税金
    STATE int not null,-- 状态
    CREATE_BY varchar(40) not null,-- 创建人
    CREATE_DEPT varchar(40) not null,-- 创建部门
    CREATE_TIME timestamp not null-- 创建日期
);
-- I.1.8报运商品明细
create table EXPORT_PRODUCT_C
(
    EXPORT_PRODUCT_ID varchar(40) primary key,-- EXPORT_PRODUCT_ID
    CONTRACT_PRODUCT_ID varchar(40) not null,-- CONTRACT_PRODUCT_ID
    EXPORT_ID varchar(40) not null,-- EXPORT_ID
    FACTORY_ID varchar(40) not null ,-- FACTORY_ID
    CONTRACT_ID varchar(40) not null,-- CONTRACT_ID
    CONTRACT_NO varchar(20) not null,-- 合同号
    PRODUCT_NAME varchar(200) not null,-- 产品名称
    PRODUCT_NO varchar(50) not null,-- 货号
    PRODUCT_IMAGE varchar(200) not null,-- 货物照片
    PRODUCT_DESC varchar(600) not null,-- 货物描述
    LOADING_RATE varchar(30) not null,-- 装率
    PACKING_UNIT varchar(10) not null,-- 包装单位
    CNUMBER int not null,-- 数量
    OUT_NUMBER int not null,-- 实际出货数量
    FINISHED int not null,-- 是否出货完毕(0/1)
    GROSS_WEIGHT float not null,-- 毛重
    NET_WEIGHT float not null,-- 尺寸长
    SIZE_WIDTH  float not null,-- 尺寸宽
    SIZE_HEIGHT float not null,-- 尺寸高
    PRODUCT_REQUEST varchar(2000) not null,-- 要求
    FACTORY varchar(200) not null,-- 厂家
    PRICE float not null,-- 单价
    AMOUNT float not null,-- 总金额
    CUNIT varchar(10) not null,-- EL单位
    BOX_NUM int not null,-- 件数
    EX_PRICE float not null,-- 出口单价
    EX_UNIT varchar(10) not null,-- 价格单位
    NO_TAX 	float not null,-- 不含税
    TAX 	float not null,-- 含税
    COST_PRICE float not null,-- 收购成本金额
    COST_TAX float not null,-- 收购成本税金
    ACCESSORIES int not null,-- 是否是附件
    ORDER_NO int not null -- 排序号
);
-- 表格HOME装箱单
create table HOME_PACKING_LIST_C
(
    HOME_PACKING_LIST_ID varchar(40),
    EXPORT_ID varchar(40) not null,-- EXPORT_ID
    SELLER varchar(200) not null,-- 卖方
    BUYER varchar(200) not null,-- 买方
    MARKS varchar(200) not null,-- 唛头
    DESCRIPTIONS varchar(200) not null,-- 描述
    CREATE_BY varchar(40) not null,-- 创建人
    CREATE_DEPT varchar(40) not null,-- 创建部门
    CREATE_TIME TIMESTAMP not null-- 创建日期
);
-- 装箱单
create table PACKING_LIST_C
(
    PACKING_LIST_ID varchar(40) primary key,-- PACKING_LIST_ID
    EXPORT_ID varchar(40) not null ,-- EXPORT_ID
    SELLER varchar(200) not null,-- 卖方
    BUYER varchar(200) not null,-- 买方
    INVOICE_NO varchar(30) not null,-- 发票号
    INVOICE_DATE TIMESTAMP not null,-- 发票日期
    MARKS varchar(200) not null,-- 唛头
    DESCRIPTIONS varchar(200) not null,-- 描述
    CREATE_BY varchar(40) not null,-- 创建人
    CREATE_DEPT varchar(40) not null,-- 创建部门
    CREATE_TIME TIMESTAMP not null-- 创建日期
);
-- I.1.12表格委托单
create table SHIPPING_ORDER_C
(
    SHIPPING_ORDER_ID varchar(40) primary key,-- SHIPPING_ORDER_ID
    PACKING_LIST_ID varchar(40),-- PACKING_LIST_ID
    ORDER_TYPE char(1) not null,-- 0海运/1空运 海运/空运
    SHIPPER varchar(200)not null,-- 货主
    CONSIGNEE varchar(200)not null,-- 提单抬头
    NOTIFY_PARTY varchar(200)not null,-- 正本通知人
    LC_NO varchar(30)not null, -- 信用证
    PORT_OF_LOADING varchar(30)not null,-- 装运港
    PORT_OF_TRANS varchar(30)not null,-- 转船港
    PORT_OF_DISCHARGE varchar(30)not null,-- 卸货港
    LOADING_DATE TIMESTAMP not null,-- 装期
    LIMIT_DATE TIMESTAMP not null,-- 效期
    IS_BATCH char(1) not null,-- 是否分批 1是0否
    IS_TRANS char(1) not null,-- 是否转船 1是0否
    COPY_NUM varchar(20) not null,-- 份数
    CNOTE varchar(200) not null,-- 扼要说明
    SPECIAL_CONDITION varchar(200) not null,-- 运输要求
    FREIGHT varchar(200) not null,-- 运费
    CHECK_BY varchar(30) not null,-- 复核人
    CREATE_BY varchar(40) not null,-- 创建人
    CREATE_DEPT varchar(40) not null,-- 创建部门
    CREATE_TIME TIMESTAMP not null -- 创建日期
);
-- I.1.13表格发票
create table INVOICE_C
(
    INVOICE_ID varchar(40) primary key,-- INVOICE_ID
    PACKING_LIST_ID varchar(40) not null,-- PACKING_LIST_ID
    SC_NO varchar(30) not null,-- SC_NO
    BL_NO varchar(30) not null,-- BL_NO
    TRADE_TERMS varchar(30) not null,-- 贸易条款
    DESCRIPTIONS varchar(200) not null,-- 描述
    CREATE_BY varchar(40) not null,-- 创建人
    CREATE_DEPT varchar(40) not null,-- 创建部门
    CREATE_TIME TIMESTAMP not null-- 创建日期
);
-- I.1.14表格财务报运单
create table FINANCE_C
(
    FINANCE_ID  varchar(40) primary key,-- FINANCE_ID
    PACKING_LIST_ID varchar(40) not null,-- PACKING_LIST_ID
    INPUT_DATE TIMESTAMP not null,-- 制单日期
    INPUT_BY varchar(30) not null,-- 制单人
    CREATE_BY varchar(40) not null,-- 创建人
    CREATE_DEPT varchar(40) not null,-- 创建部门
    CREATE_TIME TIMESTAMP not null-- 创建日期
);
-- 表格报运商品附件
create table EXT_EPRODUCT_C
(
    EXT_EPRODUCT_ID varchar(40) primary key,-- EXT_EPRODUCT_ID
    FACTORY_ID varchar(40) not null,-- FACTORY_ID
    EXPORT_PRODUCT_ID varchar(40) not null,-- EXPORT_PRODUCT_ID
    CONTRACT_PRODUCT_ID varchar(40) not null,-- CONTRACT_PRODUCT_ID
    CTYPE int not null,-- 类型[系统下拉列表]
    PRODUCT_NAME varchar(200) not null,-- 产品名称
    PRODUCT_NO varchar(50) not null,-- 货号
    PRODUCT_IMAGE varchar(200) not null,-- 货物照片
    PRODUCT_DESC varchar(600) not null,-- 货物描述
    LOADING_RATE varchar(30) not null,-- 装率
    PACKING_UNIT varchar(10) not null,-- 包装单位
    CNUMBER int not null,-- 数量
    OUT_NUMBER int not null,-- 实际出货数量
    FINISHED int not null,-- 是否出货完毕
    GROSS_WEIGHT float not null,-- 毛重
    NET_WEIGHT float not null, -- 净重
    SIZE_LENGHT float not null, -- 尺寸长
    SIZE_WIDTH float not null,-- 尺寸宽
    SIZE_HEIGHT float not null,-- 尺寸高
    PRODUCT_REQUEST varchar(2000) not null,-- 要求
    FACTORY varchar(200) not null,-- 厂家
    PRICE float not null,-- 单价
    AMOUNT float not null,-- 总金额
    CUNIT float not null,-- EL单位
    BOX_NUM int not null,-- 件数
    EX_PRICE float not null,-- 出口单价
    EX_UNIT varchar(10) not null,-- 价格单位
    NO_TAX float not null,-- 不含税
    TAX float not null,-- 含税
    COST_PRICE float not null,-- 收购成本金额
    COST_TAX float not null,-- 收购成本税金
    ACCESSORIES int not null,-- 是否是附件
    ORDER_NO int not null-- 排序号
);




