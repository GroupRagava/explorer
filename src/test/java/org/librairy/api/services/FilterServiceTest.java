/*
 * Copyright (c) 2016. Universidad Politecnica de Madrid
 *
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 *
 */

package org.librairy.api.services;

import es.cbadenes.lab.test.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.librairy.api.Config;
import org.librairy.api.model.relations.WeightResourceI;
import org.librairy.api.model.resources.SimilarityI;
import org.librairy.api.model.resources.TopicDistributionI;
import org.librairy.model.domain.resources.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * Created on 04/05/16:
 *
 * @author cbadenes
 */
@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@TestPropertySource(properties = {
        "librairy.uri       = drinventor.eu"
})
public class FilterServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(FilterServiceTest.class);

    @Autowired
    FilterService service;

    @Test
    public void createFilter() throws Exception {

        Filter filter = new Filter();
        filter.setContent("Vector art is ideal for printing since the art is made from a series of mathematical curves, " +
                "it will print very crisply even when resized.[4] For instance, one can print a vector logo on a small sheet of copy paper, " +
                "and then enlarge the same vector logo to billboard size and keep the same crisp quality. A low-resolution raster graphic would " +
                "blur or pixelate excessively if it were enlarged from business card size to billboard size. (The precise resolution of a raster " +
                "graphic necessary for high-quality results depends on the viewing distance; e.g., a billboard may still appear to be of high " +
                "quality even at low resolution if the viewing distance is great enough.)");
        Filter aux = service.create(filter);

        LOG.info("Filter created: " + aux);

    }

    @Test
    public void similarDocs() throws IOException, ClassNotFoundException {

        String filterId = "65001b8a8ca40f1b3bcc0580a080b6b4";

        List<WeightResourceI> docs = service.listSimilarDocuments(filterId);

        docs.forEach(doc -> LOG.info("DOC: " + doc));

    }


    @Test
    public void topics() throws IOException, ClassNotFoundException {

        String filterId = "65001b8a8ca40f1b3bcc0580a080b6b4";

        List<TopicDistributionI> topics = service.listTopics(filterId);

        topics.forEach(topic -> LOG.info("TOPIC: " + topic));

    }
}
