-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('句子', '2000', '1', 'sentences', 'mars/sentences/index', 1, 0, 'C', '0', '0', 'mars:sentences:list', '#', 'admin', sysdate(), '', null, '句子菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('句子查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'mars:sentences:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('句子新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'mars:sentences:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('句子修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'mars:sentences:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('句子删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'mars:sentences:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('句子导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'mars:sentences:export',       '#', 'admin', sysdate(), '', null, '');