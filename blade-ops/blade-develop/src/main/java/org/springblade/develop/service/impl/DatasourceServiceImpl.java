/**
 * Copyright (c) 2018-2099, Chill Zhuang 庄骞 (bladejava@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.develop.service.impl;

import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.develop.entity.Datasource;
import org.springblade.develop.mapper.DatasourceMapper;
import org.springblade.develop.service.IDatasourceService;
import org.springframework.stereotype.Service;

/**
 * 数据源配置表 服务实现类
 *
 * @author Chill
 */
@Service
public class DatasourceServiceImpl extends BaseServiceImpl<DatasourceMapper, Datasource> implements IDatasourceService {

}
