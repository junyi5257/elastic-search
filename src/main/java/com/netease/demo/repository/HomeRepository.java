package com.netease.demo.repository;

import com.netease.demo.es.bean.Home;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Description:
 *
 * @author Mail:goujunyi@corp.netease.com
 * Date:2018-05-14 11:34
 */
public interface HomeRepository extends ElasticsearchRepository<Home,String> {
}
