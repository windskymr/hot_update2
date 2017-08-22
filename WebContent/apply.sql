
create table hot_update_apply (
	id int(10) not null auto_increment,
	submit_user_name varchar(20) not null,			#申请提交者
	project_id int(10) not null,					#项目id
	audit_user_name varchar(20),					#审核者
	audit_state tinyint(1) not null default 0,		#审核状态 0:未审核,1:审核通过,2:审核未通过
	update_state tinyint(1) not null default 0,		#更新状态 0:未更新,1:已更新
	update_time datetime,							#更新时间
	submit_time datetime not null,					#提交时间
	audit_time datetime,							#审核时间
	remark varchar(255),							#备注
	audit_reason varchar(255), 						#审核理由
	cur_ver varchar(50),							#当前版本号
	dest_ver varchar(50),							#更新版本号
	client_charger varchar(20),						#前端责任人
	server_charger varchar(20),						#后端责任人
	wc_charger varchar(20),							#web端责任人
	test_charger varchar(20),						#测试责任人
	ui_charger varchar(20),							#美术责任人
	master_charger varchar(20),						#总责任人
	hope_date date,									#希望更新日期
	primary key (id)
);


create table user_account (
	id int(10) not null auto_increment,
	user_name varchar(20) not null,
	name varchar(120) not null,
	reg_time datetime not null,
	password varchar(100) not null,
	identify_level tinyint(1) not null,				#身份级别1:normal, 2:auditor
	primary key(id)
);

create table project(
	id int(10) not null auto_increment,
	name varchar(100) not null,						#项目名称
	`describe` varchar(255),							#项目描述
	creator_user varchar(20) not null,				#创建者
	create_time datetime not null,					#创建时间
	primary key (id)
);