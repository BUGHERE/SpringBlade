package org.springblade.demo.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author WYH
 * @date 2024/12/09 22:23
 **/
@Data
@TableName("blade_blog")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 标题
	 */
	private String blogTitle;
	/**
	 * 内容
	 */
	private String blogContent;
	/**
	 * 时间
	 */
	private LocalDateTime blogDate;
	/**
	 * 是否已删除
	 */
	@TableLogic
	private Integer isDeleted;

}
