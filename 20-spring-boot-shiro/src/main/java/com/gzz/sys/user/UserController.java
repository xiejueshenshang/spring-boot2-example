package com.gzz.sys.user;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.base.Page;

/**
 * @类说明 [用户]控制器
 * @author 高振中
 * @date 2018-12-24 21:36:34
 **/
@RestController
@RequestMapping("user")
public class UserController {

	@SuppressWarnings("unused")
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private UserService service; // 注入用户数据逻辑层

	/**
	 * @方法说明 新增[用户]记录
	 */
	@RequestMapping("save")
	@RequiresPermissions("user:save")
	public int save( User user) {
		return service.save(user);
	}

	/**
	 * @方法说明 删除用户记录(多条)
	 */
	@PostMapping("delete")
	@RequiresPermissions("user:delete")
	public int delete(@RequestParam("ids[]") Long ids[]) {
		return service.delete(ids);
	}

	/**
	 * @方法说明 修改用户记录
	 */
	@PostMapping("update")
	@RequiresPermissions("user:update")
	public int update(@RequestBody User user) {
		return service.update(user);
	}

	/**
	 * @方法说明 按条件查询分页用户列表
	 */
	@PostMapping("queryPage")
	public Page<User> queryPage(@RequestBody UserCond cond) {
		return service.queryPage(cond);
	}

	/**
	 * @方法说明 按条件查询不分页用户列表
	 */
	@PostMapping("queryList")
	public List<User> queryList(@RequestBody UserCond cond) {
		return service.queryList(cond);
	}

	/**
	 * @方法说明 按主键查单个用户记录
	 */
	@PostMapping("findById")
	public User findById(@RequestParam("id") Long id) {
		return service.findById(id);
	}

	/**
	 * @方法说明 按条件查询用户记录个数
	 */
	@PostMapping("queryCount")
	public long queryCount(@RequestBody UserCond cond) {
		return service.queryCount(cond);
	}
}