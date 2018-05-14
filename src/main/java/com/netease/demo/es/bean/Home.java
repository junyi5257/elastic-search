package com.netease.demo.es.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

/**
 * Description:
 *
 * @author goujunyi
 * Date:2018-05-14 11:31
 */
@Document(indexName = Home.INDEX_NAME, type = Home.TYPE, shards = 2, replicas = 1)
public class Home {

    public static final String INDEX_NAME = "productindex";

    public static final String TYPE = "pro";

    @Id
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Field(type = FieldType.keyword)
    private String title;

    @GeoPointField
    private GeoPoint location;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }
}
