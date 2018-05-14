import com.netease.demo.Application;
import com.netease.demo.es.bean.Home;
import com.netease.demo.repository.HomeRepository;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description:
 *
 * @author goujunyi
 * Mail:goujunyi@corp.netease.com
 * Date:2018-05-08 17:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductSearchTest {

    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    /**
     * init data;
     */
    @Test
    public void testHome() {

        esTemplate.deleteIndex(Home.class);
        esTemplate.createIndex(Home.class);
        esTemplate.refresh(Home.class);
        esTemplate.putMapping(Home.class);

        Home home = new Home();
        home.setId("1");
        home.setTitle("home A");
        home.setLocation(new GeoPoint(22.8334, 108.301));
        homeRepository.save(home);
        System.out.println("===============success--1======");

        Home home2 = new Home();
        home2.setId("2");
        home2.setTitle("home B_sh");
        home2.setLocation(new GeoPoint(31.318, 121.3840));
        homeRepository.save(home2);
        System.out.println("===============success--2======");

        Home home3 = new Home();
        home3.setId("3");
        home3.setTitle("home C");
        home3.setLocation(new GeoPoint(22.7879, 108.301));
        homeRepository.save(home3);
        System.out.println("===============success--1======");

    }

    @Test
    public void getByHomeTitle() {
        double lat = 108.31d;
        double lon = 22.81d;

        //Location  10KM
        GeoDistanceQueryBuilder geoDistanceBuilder = QueryBuilders.geoDistanceQuery("location")
                .point(lat, lon)
                .distance(10, DistanceUnit.KILOMETERS);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.boolQuery().filter(geoDistanceBuilder))
                .withPageable(PageRequest.of(0, 10)).build();
        List<Home> productInfoList = esTemplate.queryForList(searchQuery, Home.class);
        for (Home hm : productInfoList) {
            System.out.println(hm.getId() + "==" + hm.getTitle() + "===");
        }
    }

    @Test
    public void getNealHomeByTitle() {
        QueryBuilder matchAllBuilder = QueryBuilders.matchAllQuery();
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllBuilder)
                .withPageable(PageRequest.of(0, 10)).build();
        List<Home> productInfoList = esTemplate.queryForList(searchQuery, Home.class);
        for (Home hm : productInfoList) {
            System.out.println(hm.getId() + "==" + hm.getTitle() + "===");
        }
    }

}
